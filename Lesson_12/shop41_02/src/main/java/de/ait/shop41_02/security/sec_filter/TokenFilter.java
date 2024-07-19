package de.ait.shop41_02.security.sec_filter;

import de.ait.shop41_02.security.AuthInfo;
import de.ait.shop41_02.security.sec_service.TokenService;
import de.ait.shop41_02.users.service.UserService;
import io.jsonwebtoken.Claims;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
@RequiredArgsConstructor
public class TokenFilter extends GenericFilter {
    private final TokenService tokenService;


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        String token = getTokenFromRequest((HttpServletRequest) request);

        if (token != null && tokenService.validateAccessToken(token)) {

            Claims claims = tokenService.getAccessClaims(token);
            AuthInfo authInfo = tokenService.mapClaimsToAuthInfo(claims);
            authInfo.setAuthenticated(true);
            SecurityContextHolder.getContext().setAuthentication(authInfo);
        }

        filterChain.doFilter(request, response);


    }

    private String getTokenFromRequest(HttpServletRequest request) {

        String token = request.getHeader("Authorization");
        if (token != null && token.startsWith("Bearer ")) {
            return token.substring(7);
        }
        return null;
    }


}
