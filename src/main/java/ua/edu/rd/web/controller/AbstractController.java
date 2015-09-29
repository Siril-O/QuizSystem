package ua.edu.rd.web.controller;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import ua.edu.rd.domain.Question;
import ua.edu.rd.domain.Quiz;
import ua.edu.rd.domain.Subject;
import ua.edu.rd.domain.User;
import ua.edu.rd.domain.Variant;
import ua.edu.rd.service.QuestionService;
import ua.edu.rd.service.QuizResultService;
import ua.edu.rd.service.QuizService;
import ua.edu.rd.service.SubjectService;
import ua.edu.rd.service.UserService;
import ua.edu.rd.service.VariantService;

public abstract class AbstractController {

	@Autowired
	protected QuizService quizService;
	@Autowired
	protected QuestionService questionService;
	@Autowired
	protected VariantService variantService;
	@Autowired
	protected SubjectService subjectService;
	@Autowired
	protected UserService userService;
	@Autowired
	protected QuizResultService quizResultService;

	@ModelAttribute("user")
	public User addUser(Model model) {
		Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();
		User user = null;
		if (!authentication.getAuthorities().contains(
				new SimpleGrantedAuthority("ROLE_ANONYMOUS"))) {
			user = userService.getByEmail(authentication.getName());
		}
		return user;
	}

	protected Subject getSubjectById(Long id) {
		Subject subject = subjectService.findById(id);
		if (id <= 0)
			throw new IllegalArgumentException("ID<0");
		if (subject == null) {
			throw new RuntimeException("Subject with Id: " + id + " not found");
		}
		return subject;
	}

	@InitBinder
	public void subjectBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Subject.class, new PropertyEditorSupport() {

			@Override
			public void setAsText(String subjectId) {
				Subject subject = null;
				if (subjectId != null && !subjectId.trim().isEmpty()) {
					Long id = Long.valueOf(subjectId);
					subject = getSubjectById(id);
				}
				setValue(subject);
			}
		});
	}

	protected Question getQuestionById(Long id) {
		Question question = questionService.findById(id);
		if (id <= 0)
			throw new IllegalArgumentException("ID<0");
		if (question == null) {
			throw new RuntimeException("Question with Id: " + id + " not found");
		}
		return question;
	}

	@InitBinder
	public void questionBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Question.class,
				new PropertyEditorSupport() {

					@Override
					public void setAsText(String questionId) {
						Question question = null;
						if (questionId != null && !questionId.trim().isEmpty()) {
							Long id = Long.valueOf(questionId);
							question = getQuestionById(id);
						}
						setValue(question);
					}
				});
	}

	protected Quiz getQuizById(Long id) {
		Quiz quiz = quizService.findById(id);
		if (id <= 0)
			throw new IllegalArgumentException("ID<0");
		if (quiz == null) {
			throw new RuntimeException("Quiz with Id: " + id + " not found");
		}
		return quiz;
	}

	@InitBinder
	public void variantBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Variant.class, new PropertyEditorSupport() {

			@Override
			public void setAsText(String variantId) {
				Variant variant = null;
				if (variantId != null && !variantId.trim().isEmpty()) {
					Long id = Long.valueOf(variantId);
					variant = getVariantById(id);
				}
				setValue(variant);
			}
		});
	}

	protected Variant getVariantById(Long id) {
		Variant variant = variantService.findVariantById(id);
		if (id <= 0)
			throw new IllegalArgumentException("ID<0");
		if (variant == null) {
			throw new RuntimeException("Variant with Id: " + id + " not found");
		}
		return variant;
	}

	@InitBinder
	public void quizBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Quiz.class, new PropertyEditorSupport() {

			@Override
			public void setAsText(String quizId) {
				Quiz quiz = null;
				if (quizId != null && !quizId.trim().isEmpty()) {
					Long id = Long.valueOf(quizId);
					quiz = getQuizById(id);
				}
				setValue(quiz);
			}
		});
	}

	protected User getUserById(Long id) {
		User user = userService.findByid(id);
		if (id <= 0)
			throw new IllegalArgumentException("ID<0");
		if (user == null) {
			throw new RuntimeException("User with Id: " + id + " not found");
		}
		return user;
	}

	@InitBinder
	public void userBinder(WebDataBinder binder) {
		binder.registerCustomEditor(User.class, new PropertyEditorSupport() {

			@Override
			public void setAsText(String userId) {
				User user = null;
				if (userId != null && !userId.trim().isEmpty()) {
					Long id = Long.valueOf(userId);
					user = getUserById(id);
				}
				setValue(user);
			}
		});
	}

}
