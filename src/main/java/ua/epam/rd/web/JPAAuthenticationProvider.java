package ua.epam.rd.web;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;

import ua.epam.rd.domain.User;
import ua.epam.rd.service.UserService;

public class JPAAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserService userService;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Authentication authenticate(Authentication authentication)

	throws AuthenticationException {
		String email = authentication.getName();
		String password = authentication.getCredentials().toString();
		User user = null;
		try {
			user = userService.getByEmail(email);
			if (!passwordEncoder.matches(password, user.getPassword())) {
				return null;
			}
			List<GrantedAuthority> grantedAuths = new ArrayList<>();
			grantedAuths.add(new SimpleGrantedAuthority(user.getRole()
					.toString()));
			Authentication auth = new UsernamePasswordAuthenticationToken(
					email, password, grantedAuths);
			return auth;
		} catch (NoResultException ex) {
			return null;
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
