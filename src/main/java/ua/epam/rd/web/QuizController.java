package ua.epam.rd.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.epam.rd.domain.Question;
import ua.epam.rd.domain.Quiz;
import ua.epam.rd.domain.Subject;

@Controller
@RequestMapping(value = "quiz")
public class QuizController extends AbstractController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showQuizes(Model model) {
		List<Quiz> quizes = quizService.findAllQuizes();
		model.addAttribute("quizList", quizes);
		return "quiz";
	}

	@RequestMapping(value = "add")
	public String viewAddQuizForm(Model model) {
		model.addAttribute("subjects", subjectService.getAllSubjects());
		return "addQuiz";
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String createQuiz(@RequestParam("subjectId") Subject subject,
			@ModelAttribute Quiz quiz, Model model) {
		quiz.setSubject(subject);
		System.out.println(quiz);
		quizService.save(quiz);
		return "redirect:";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String showEditForm(@RequestParam("quizId") Quiz quiz, Model model) {
		model.addAttribute("quiz", quiz);
		model.addAttribute("subjects", subjectService.getAllSubjects());
		return "editQuiz";
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String removeQuiz(
			@RequestParam("quizId") Long quizId,
			@RequestParam(value = "confirm", defaultValue = "false") boolean confirm) {
		if (confirm) {
			quizService.remove(quizId);
		}
		return "redirect:";
	}

	@RequestMapping(value = "/changeName", method = RequestMethod.POST)
	public String editQuiz(@RequestParam("name") String name,
			@RequestParam("quizId") Quiz quiz) {
		quiz.setName(name);
		quizService.update(quiz);
		return "redirect:" + "edit?quizId=" + quiz.getId();
	}

	@RequestMapping(value = "/changeSubject", method = RequestMethod.POST)
	public String editQuiz(@RequestParam("subjectId") Subject subject,
			@RequestParam("quizId") Quiz quiz) {
		quiz.setSubject(subject);
		quizService.update(quiz);
		return "redirect:" + "edit?quizId=" + quiz.getId();
	}

	@RequestMapping("/avaliable")
	public String viewAvaliableQuizes(Model model) {
		addUserToModel(model);
		return "user/quizes";
	}
	
	@RequestMapping("/question")
	public String viewPassingQuizForm(Model model, @RequestParam("questionId")Question question){
		addUserToModel(model);
		model.addAttribute(attributeValue)
		return "user/question";
	}
}
