package zs.frontline.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import zs.frontline.repositories.AuthorRepository;

@Controller
public class AuthorController {

	private AuthorRepository authorRepository;

	public AuthorController(AuthorRepository authorRepository) {

		this.authorRepository = authorRepository;
	}

	@RequestMapping(path = "/authors")
	public String getAuthors(Model model) {

		model.addAttribute("authors", authorRepository.findAll());

		return "authors";
	}
}
