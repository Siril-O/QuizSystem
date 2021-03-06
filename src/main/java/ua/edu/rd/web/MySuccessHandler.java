package ua.edu.rd.web;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import ua.edu.rd.domain.Role;

public class MySuccessHandler implements AuthenticationSuccessHandler {

	private static final String CUSTOMER_REDIRECT_URL = "/QuizSystem/jsp/quiz/avaliable";
	private static final String TUTOR_REDIRECT_URL = "/QuizSystem/jsp/quiz/";
	private static final String ADMIN_REDIRECT_URL = "/QuizSystem/jsp/user/all";

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		Set<String> roles = AuthorityUtils.authorityListToSet(authentication
				.getAuthorities());

		if (roles.contains(Role.ROLE_TUTOR.toString())) {
			response.sendRedirect(response
					.encodeRedirectURL(TUTOR_REDIRECT_URL));
			return;
		}
		if (roles.contains(Role.ROLE_ADMIN.toString())) {
			response.sendRedirect(response
					.encodeRedirectURL(ADMIN_REDIRECT_URL));
			return;
		}
		response.sendRedirect(response.encodeRedirectURL(CUSTOMER_REDIRECT_URL));
	}

}
