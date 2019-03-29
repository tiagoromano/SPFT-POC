package oauth;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.DeviceResolver;
import org.springframework.mobile.device.LiteDeviceResolver;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cronapp.framework.authentication.normal.AuthenticationConfigurer;
import cronapp.framework.authentication.token.AuthenticationController;
import cronapp.framework.authentication.token.AuthenticationResponse;

@Controller
@RequestMapping("/oauth") 
public class OAuthController {

	private static final String ADMIN = "admin";

	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private HttpServletResponse response;

	@Autowired(required = false)
	private AuthenticationConfigurer authenticationConfigurer;
	
	@Autowired(required = false)
	private AuthenticationController authenticationController;

	@GetMapping("/authorize")
	public void authorize() throws Exception {
		Object openid = request.getSession().getAttribute("#OPENID#");
		String username = (String) request.getSession().getAttribute("#OPENID#USER");

		if (openid == null || username == null) {
			throw new InsufficientAuthenticationException("");
		}

		request.getSession().removeAttribute("#OPENID#");
		request.getSession().removeAttribute("#OPENID#USER");

		JsonObject details = new JsonObject();
		details.addProperty("name", username);
		
		UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(username, "cronapp",
				Arrays.asList(new SimpleGrantedAuthority("#OAUTH#")));
		auth.setDetails(details);
		
		String redirect = request.getContextPath() + "/#/openid";
		
		if (authenticationConfigurer != null) {
			authenticationConfigurer.authenticate(auth);
			
			SecurityContextHolder.getContext().setAuthentication(auth);
			
			try {
				request.getSession().setAttribute("#OAUTH#USER", username);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else {
			DeviceResolver deviceResolver = new LiteDeviceResolver();
			
			ResponseEntity<AuthenticationResponse> authenticationRequest = authenticationController.auth(username, "cronapp",
					deviceResolver.resolveDevice(request), "cronapp", null, details);
			
			redirect = request.getContextPath() + "/#/openid?_ctk=" + authenticationRequest.getBody().getToken();
		}
    
		response.setStatus(HttpServletResponse.SC_OK);

    	response.sendRedirect(redirect);
	}
}