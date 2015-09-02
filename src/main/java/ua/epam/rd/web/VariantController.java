package ua.epam.rd.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.epam.rd.domain.Question;
import ua.epam.rd.domain.Variant;

@Controller
@RequestMapping(value = "variant")
public class VariantController extends AbstractController {

	@RequestMapping(value = "/add")
	public String viewAddVariantForm(
			@RequestParam("questionId") Question question, Model model) {
		model.addAttribute("question", question);
		return "addVariant";
	}

	@RequestMapping(value = "/edit")
	public String editVariant(@RequestParam("questionId") Question question,
			Model model, @ModelAttribute Variant variant) {
		variant.setQuestion(question);
		variantService.updateVariant(variant);
		return "redirect:" + "../quiz/edit?quizId="
				+ question.getQuiz().getId();
	}

	@RequestMapping(value = "/create")
	public String createVariant(@RequestParam("questionId") Question question,
			@ModelAttribute Variant variant, Model model) {
		variant.setQuestion(question);
		variantService.save(variant);
		return "redirect:" + "../quiz/edit?quizId="
				+ question.getQuiz().getId();
	}

	@RequestMapping(value = "/remove")
	public String removeVariant(@RequestParam("variantId") Variant variant,
			Model model) {
		variantService.remove(variant.getId());
		return "redirect:" + "../quiz/edit?quizId="
				+ variant.getQuestion().getQuiz().getId();
	}

}
