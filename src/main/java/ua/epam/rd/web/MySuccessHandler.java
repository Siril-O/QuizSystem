package ua.epam.rd.web;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class MySuccessHandler implements AuthenticationSuccessHandler  {

	private static final String CUSTOMER_REDIRECT_URL = "/QuizSystem/jsp/quiz/avaliable";
	private static final String ADMIN_REDIRECT_URL = "/QuizSystem/jsp/quiz/";
	private static final String ROLE_ADMIN = "ROLE_ADMIN";

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication) throws IOException,
			ServletException {
		Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());

        if (roles.contains(ROLE_ADMIN)){
        	response.sendRedirect(response.encodeRedirectURL(ADMIN_REDIRECT_URL));
            return;
        }
    	response.sendRedirect(response.encodeRedirectURL(CUSTOMER_REDIRECT_URL));
	}

}
