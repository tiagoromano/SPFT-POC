package oauth;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.web.filter.OncePerRequestFilter;

public class UpdateSavedRequestFilter extends OncePerRequestFilter {
    private RequestCache requestCache = new HttpSessionRequestCache();

    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String queryString = request.getQueryString();
        if(!StringUtils.contains(queryString, "code") && authentication == null) {
            requestCache.saveRequest(request, response);
        }
        filterChain.doFilter(request, response);
    }
}