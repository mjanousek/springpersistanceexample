package cz.janousek.web;

import cz.janousek.data.BookRepository;
import cz.janousek.data.SetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/set")
public class SpecialSetController {


	@Autowired
	private SetRepository setRepository;
	@Autowired
	private BookRepository bookRepository;

	public SpecialSetController() {
	}

	@RequestMapping(value="/add", method = GET)
	public String showNewForm(Model model) {
		model.addAttribute("set", new SpecialSet());
		model.addAttribute("books", bookRepository.findAll());
		return "setForm";
	}

	@RequestMapping(value="/{setId}", method = GET)
	public String showBook(@PathVariable Long setId, Model model) {
		SpecialSet set = setRepository.findOne(setId);
		model.addAttribute("set", set);
		return "set";
	}

	@RequestMapping(value="/add", method = POST)
	public String processRegistration(@Valid SpecialSet specialSet, Errors errors, Model model) {
		if (errors.hasErrors()) {
			return "setForm";
		}

		SpecialSet s = setRepository.save(specialSet);
		return "redirect:/set/" + s.getId();
	}
}

