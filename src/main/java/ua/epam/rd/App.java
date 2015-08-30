package ua.epam.rd;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.epam.rd.domain.Quiz;
import ua.epam.rd.domain.Subject;
import ua.epam.rd.service.QuizService;
import ua.epam.rd.service.SubjectService;

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
		subjectService.save(new Subject("Java Core"));
		System.out.println(subjectService.getAllSubjects());
	}
}
