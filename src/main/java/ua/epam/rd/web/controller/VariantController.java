package ua.epam.rd.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ua.epam.rd.domain.Question;
import ua.epam.rd.domain.Variant;

@Controller
@RequestMapping(value = "variant")
public class VariantController extends AbstractController {

	@RequestMapping(value = "/add")
	public String viewAddVariantForm(
			@RequestParam("questionId") Question question, Model model) {
		model.addAttribute("question", question);
		return "admin/addVariant";
	}

	@RequestMapping(value = "/edit")
	public String editVariant(@RequestParam("questionId") Question question,
			Model model, @ModelAttribute Variant variant,
			RedirectAttributes redirectAttributes) {
		variant.setQuestion(question);
		variantService.updateVariant(variant);
		redirectAttributes.addAttribute("quizId", question.getQuiz().getId());
		return "redirect:../quiz/edit";
	}

	@RequestMapping(value = "/create")
	public String createVariant(@RequestParam("questionId") Question question,
			@ModelAttribute Variant variant, Model model,
			RedirectAttributes redirectAttributes) {
		variant.setQuestion(question);
		variantService.save(variant);
		redirectAttributes.addAttribute("quizId", question.getQuiz().getId());
		return "redirect:../quiz/edit";
	}

	@RequestMapping(value = "/remove")
	public String removeVariant(@RequestParam("variantId") Variant variant,
			Model model, RedirectAttributes redirectAttributes) {
		variantService.remove(variant.getId());
		redirectAttributes.addAttribute("quizId", variant.getQuestion()
				.getQuiz().getId());
		return "redirect:../quiz/edit";
	}

}
