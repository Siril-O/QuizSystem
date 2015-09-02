package ua.epam.rd.web;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import ua.epam.rd.domain.Question;
import ua.epam.rd.domain.Quiz;
import ua.epam.rd.domain.Subject;
import ua.epam.rd.domain.Variant;
import ua.epam.rd.service.QuestionService;
import ua.epam.rd.service.QuizService;
import ua.epam.rd.service.SubjectService;
import ua.epam.rd.service.VariantService;

public abstract class AbstractController {

	@Autowired
	protected QuizService quizService;
	@Autowired
	protected QuestionService questionService;
	@Autowired
	protected VariantService variantService;
	@Autowired
	protected SubjectService subjectService;

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
		binder.registerCustomEditor(Subject.class,
				new PropertyEditorSupport() {

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

}
