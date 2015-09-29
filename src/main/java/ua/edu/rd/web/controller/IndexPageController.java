package ua.edu.rd.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.edu.rd.domain.User;

@Controller
public class IndexPageController extends AbstractController {

	private static final String STUDENT_PAGE = "quiz/avaliable";
	private static final String ADMIN_PAGE = "user/all";
	private static final String TUTOR_PAGE = "quiz/";
	private static final String DEFAULT_PAGE = "user/login";

	@RequestMapping(value = { "/" })
	public String viewIndexPage(@ModelAttribute("user") User user,
			HttpServletRequest request) {
		switch (user.getRole()) {
		case ROLE_ADMIN:
			System.out.println("redirect:" + ADMIN_PAGE);
			return "redirect:" + ADMIN_PAGE;
		case ROLE_STUDENT:
			System.out.println("redirect:" + STUDENT_PAGE);
			return "redirect:" + STUDENT_PAGE;
		case ROLE_TUTOR:
			System.out.println("redirect:" + TUTOR_PAGE);

			return "redirect:" + TUTOR_PAGE;
		default:
			return "redirect:" + DEFAULT_PAGE;
		}
	}
}
