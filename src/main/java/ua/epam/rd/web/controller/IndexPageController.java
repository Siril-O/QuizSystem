package ua.epam.rd.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.epam.rd.domain.User;

@Controller
public class IndexPageController extends AbstractController{

	private static final String STUDENT_PAGE = "quiz/avaliable";
	private static final String ADMIN_PAGE = "user/all";
	private static final String TUTOR_PAGE = "quiz/";
	private static final String DEFAULT_PAGE = "user/login";

	@RequestMapping("/")
	public String viewIndexPage(@ModelAttribute("user") User user) {
		switch (user.getRole()) {
		case ROLE_ADMIN:
			return "redirect:" + ADMIN_PAGE;
		case ROLE_STUDENT:
			return "redirect:" + STUDENT_PAGE;
		case ROLE_TUTOR:
			return "redirect:" + TUTOR_PAGE;
		default:
			return "redirect:" + DEFAULT_PAGE;
		}
	}
}
