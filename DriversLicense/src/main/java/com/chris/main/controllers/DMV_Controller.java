package com.chris.main.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.chris.main.models.License;
import com.chris.main.models.Person;
import com.chris.main.services.LicenseService;
import com.chris.main.services.PersonService;

@Controller
public class DMV_Controller {
	
	private final PersonService personService;
	private final LicenseService licenseService;
	
	public DMV_Controller(PersonService personService, LicenseService licenseService) {
		this.personService = personService;
		this.licenseService = licenseService;
	}
	
	@GetMapping("/person/new")
	public String newPerson(@ModelAttribute("person") Person person) {
		return "newPerson.jsp";
	}
	
	@PostMapping("/person/new")
	public String createP(@Valid @ModelAttribute("person") Person person, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "newPerson.jsp";
		} else {
			personService.createPerson(person);
			model.addAttribute("person", person);
			return "redirect:/person/" + Long.toString(person.getId());
		}
	}
	
	@GetMapping("/person/{id}")
	public String profile(@PathVariable("id") Long id, Model model) {
		model.addAttribute("person", personService.findPerson(id));
		model.addAttribute("license", personService.findPerson(id).getLicense());
		return "profile.jsp";
	}
	
	@GetMapping("/license/new")
	public String newLicense(@ModelAttribute("license") License license, Model model) {
		List<Person> people = personService.allPeople();
		model.addAttribute("people", people);
		return "newLicense.jsp";
	}
	
	@PostMapping("/license/new")
	public String createL(@Valid @ModelAttribute("license") License license, BindingResult result, Model model
			) {
		if (result.hasErrors()) {
			List<Person> people = personService.allPeople();
			model.addAttribute("people", people);
			return "newLicense.jsp";
		} else {
			licenseService.createLicense(license);
			return "redirect:/person/" + Long.toString(license.getPerson().getId());
		}
	}
	
}
