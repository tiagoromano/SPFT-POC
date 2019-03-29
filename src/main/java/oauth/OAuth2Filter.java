package oauth;

import java.io.IOException;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

public class OAuth2Filter extends AbstractAuthenticationProcessingFilter {

    public OAuth2RestOperations restTemplate;

    private UserInfoTokenServices tokenServices;

    public OAuth2Filter(String defaultFilterProcessesUrl) {
        super(defaultFilterProcessesUrl);
        setAuthenticationManager(new NoopAuthenticationManager());
        SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
        setAuthenticationSuccessHandler(successHandler);
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        if (requiresAuthentication(req)) {
            super.doFilter(req, res, chain);
        } else {
            chain.doFilter(req, res);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException{
        OAuth2AccessToken accessToken;

        try {
            accessToken = restTemplate.getAccessToken();
        } catch (OAuth2Exception e) {
            e.printStackTrace();
            throw new BadCredentialsException("Could not obtain access token", e);
        }

        try {
            OAuth2Authentication result = tokenServices.loadAuthentication(accessToken.getValue());

            Map<String, String> details = (Map<String, String>) result.getUserAuthentication().getDetails();

            request.getSession().setAttribute("#OPENID#", true);
            request.getSession().setAttribute("#OPENID#USER", details.get("sub"));

            return result;
        } catch (Exception e) {
            throw new BadCredentialsException("Could not obtain user details from token", e);
        }
    }

    private boolean requiresAuthentication(ServletRequest request) {
		if (request instanceof HttpServletRequest && !requiresAuthentication((HttpServletRequest) request, null)) {
			return false;
		}

        Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();

        if (currentUser == null) {
            return true;
        }

        OAuth2AccessToken accessToken = restTemplate.getAccessToken();

        if (accessToken == null) {
            return true;
        }
        
        return accessToken.isExpired();
    }

    public void setRestTemplate(OAuth2RestOperations restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void setTokenServices(UserInfoTokenServices tokenServices) {
        this.tokenServices = tokenServices;
    }

	private static class NoopAuthenticationManager implements AuthenticationManager {
        @Override
        public Authentication authenticate(Authentication authentication) throws AuthenticationException {
            throw new UnsupportedOperationException("No authentication should be done with this AuthenticationManager");
        }
    }
}