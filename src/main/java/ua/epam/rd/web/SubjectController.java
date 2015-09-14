package ua.epam.rd.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.epam.rd.domain.Subject;

@Controller
@RequestMapping("subject")
public class SubjectController extends AbstractController {

	@RequestMapping(value = "/")
	public String viewAllSubjects(Model model) {
		model.addAttribute("subjectList", subjectService.getAllSubjects());
		return "admin/subject";
	}

	@RequestMapping(value = "/add")
	public String viewSubjectAddForm(Model model) {
		return "admin/addSubject";
	}

	@RequestMapping(value = "/create")
	public String createSubject(@ModelAttribute Subject subject) {
		subjectService.save(subject);
		return "redirect:";
	}

	@RequestMapping(value = "/edit")
	public String viewSubjectEditForm(
			@RequestParam("subjectId") Subject subject, Model model) {
		model.addAttribute("subject", subject);
		return "admineditSubject";
	}

	@RequestMapping(value = "/update")
	public String updateSubject(@ModelAttribute Subject subject) {
		subjectService.update(subject);
		return "redirect:";
	}

	@RequestMapping(value = "/remove")
	public String removeSubject(@RequestParam("subjectId") Long id) {
		subjectService.remove(id);
		return "redirect:";
	}

}
