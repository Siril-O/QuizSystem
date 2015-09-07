package ua.epam.rd;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.epam.rd.domain.Question;
import ua.epam.rd.domain.Quiz;
import ua.epam.rd.domain.Role;
import ua.epam.rd.domain.Subject;
import ua.epam.rd.domain.User;
import ua.epam.rd.domain.Variant;
import ua.epam.rd.service.QuestionService;
import ua.epam.rd.service.QuizService;
import ua.epam.rd.service.SubjectService;
import ua.epam.rd.service.UserService;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		ConfigurableApplicationContext repositoryContext = new ClassPathXmlApplicationContext(
				"repositoryContext.xml");

		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "appContext.xml" }, repositoryContext);

		QuizService quizService = context.getBean(QuizService.class);
		SubjectService subjectService = context.getBean(SubjectService.class);
		QuestionService questionService = context
				.getBean(QuestionService.class);
		// subjectService.save(new Subject("JavaScript"));
		UserService userService = context.getBean(UserService.class);

		userService.save(new User("John", "Malkovich", "malkovich@gmail.com",
				"123", Role.ROLE_USER));

		// quizService.save(new Quiz("Java core junion v1.0",
		// subjectService.findById(1l)));
		// System.out.println(subjectService.getAllSubjects());
		// Quiz quiz = quizService.findById(2l);
		// Question question = initQuestion();
		// Question question = questionService.findById(2l);
		// questionService.save(question);
		// quiz.getQuestions().add(question);
		// quizService.update(quiz);
		// System.out.println(quiz);
		// System.out.println(quizService.findAllQuizes());

	}

	private static Question initQuestion() {
		Question question = new Question(
				"Скомпилируется ли следующий код и если да, то что будет выведено на экран?"
						+ "public class Test{\npublic static void main(String[] args){ \nchar c1 = '1';\nchar c2 = '\u0031';\n"
						+ "char c3 = 49;\n System.out.println(c1 + c2 + c3);\n  }\n} ",
				null);
		Set<Variant> variants = new HashSet<>();
		variants.add(new Variant(question, "111", false));
		variants.add(new Variant(question, "147", true));
		variants.add(new Variant(question, "81", false));
		variants.add(new Variant(question, "Ошибка компиляции", false));
		question.setVariants(variants);
		return question;
	}
}
