package ua.edu.rd.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ua.edu.rd.domain.Question;
import ua.edu.rd.domain.Variant;

@Controller
@RequestMapping(value = "variant")
public class VariantController extends AbstractController {

	@RequestMapping(value = "/add")
	public String viewAddVariantForm(
			@RequestParam("questionId") Question question, Model model) {
		return viewCreateForm(question, new Variant(), model);
	}

	private String viewCreateForm(Question question, Variant variant,
			Model model) {
		model.addAttribute("question", question);
		model.addAttribute("variant", variant);
		return "admin/addVariant";
	}

	@RequestMapping(value = "/create")
	public String createVariant(@RequestParam("questionId") Question question,
			@ModelAttribute("variant") @Valid Variant variant,
			BindingResult bindResult, Model model,
			RedirectAttributes redirectAttributes) {
		if (bindResult.hasErrors()) {
			return viewCreateForm(question, variant, model);
		}
		variant.setQuestion(question);
		variantService.save(variant);
		redirectAttributes.addAttribute("succesMessage", "VariantCreated");
		redirectAttributes.addAttribute("questionId", variant.getQuestion()
				.getId());
		return "redirect:../question/editForm";
	}

	@RequestMapping(value = "/remove")
	public String removeVariant(@RequestParam("variantId") Variant variant,
			Model model, RedirectAttributes redirectAttributes) {
		if (!variant.getRightAnswer()
				|| checkIfRightVariantPresent(variant.getQuestion()
						.getVariants(), variant)) {
			variantService.remove(variant.getId());
			redirectAttributes.addAttribute("succesMessage", "VariantRemoved");
		} else {
			redirectAttributes.addAttribute("succesMessage",
					"ErrorRemoveVariant");
		}
		redirectAttributes.addAttribute("questionId", variant.getQuestion()
				.getId());
		return "redirect:../question/editForm";
	}

	private boolean checkIfRightVariantPresent(List<Variant> variants,
			Variant exlusiveVariant) {
		for (Variant variant : variants) {
			if (variant.getRightAnswer() && !variant.equals(exlusiveVariant)) {
				return true;
			}
		}
		return false;
	}

}
