package com.spring.form01.service;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.spring.form01.domain.Person;

@Controller
public class PersonService {

	@GetMapping("/person")
	public String personForm(Model model) {
		model.addAttribute("person", new Person());
		return "personF";
	}

	@PostMapping("/person")
	public String personSubmit(@Valid @ModelAttribute Person person, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "personF";
		}
		return "result";
	}

}
