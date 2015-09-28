package ua.edu.rd.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.edu.rd.domain.Quiz;
import ua.edu.rd.domain.Subject;

@Controller
@RequestMapping("subject")
public class SubjectController extends AbstractController {

	@RequestMapping(value = "/")
	public String viewAllSubjects(Model model) {
		return viewAllSubjectsForm(model);
	}

	private String viewAllSubjectsForm(Model model) {
		model.addAttribute("subjectList", subjectService.getAllSubjects());
		return "admin/subject";
	}

	@RequestMapping(value = "/add")
	public String viewSubjectAddForm(Model model) {
		return viewCreateSubjectForm(model, new Subject());
	}

	private String viewCreateSubjectForm(Model model, Subject subject) {
		model.addAttribute("subject", subject);
		return "admin/addSubject";
	}

	@RequestMapping(value = "/create")
	public String createSubject(
			@ModelAttribute("subject") @Valid Subject subject,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return viewCreateSubjectForm(model, subject);
		}
		subjectService.save(subject);
		model.addAttribute("succesMessage", "NewSubjectCreated");
		return viewAllSubjectsForm(model);
	}

	@RequestMapping(value = "/edit")
	public String viewSubjectEdit(@RequestParam("subjectId") Subject subject,
			Model model) {
		return viewSubjectEditForm(subject, model);
	}

	private String viewSubjectEditForm(Subject subject, Model model) {
		model.addAttribute("subject", subject);
		return "admin/editSubject";
	}

	@RequestMapping(value = "/update")
	public String updateSubject(
			@ModelAttribute("subject") @Valid Subject subject,
			BindingResult bindResult, Model model) {
		if (bindResult.hasErrors()) {
			return viewSubjectEditForm(subject, model);
		}
		subjectService.update(subject);
		model.addAttribute("succesMessage", "SubjectUpdated");
		return viewAllSubjectsForm(model);
	}

	@RequestMapping(value = "/remove")
	public String removeSubject(@RequestParam("subjectId") Subject subject,
			Model model) {
		List<Quiz> quizes = quizService.findQuizesBySubject(subject);
		if (!quizes.isEmpty()) {
			model.addAttribute("noticeMessage", "SubjectRemoveError");
			return viewAllSubjectsForm(model);
		}
		subjectService.remove(subject.getId());
		model.addAttribute("succesMessage", "SubjectRemoved");
		return viewAllSubjectsForm(model);
	}

}
