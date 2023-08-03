package com.example.ThymeleafPagination.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.ThymeleafPagination.model.Country;
import com.example.ThymeleafPagination.repositories.CountryRepository;

@Controller
public class CountryController {

	@Autowired
	private CountryRepository countryRepo;
	
	@GetMapping("/")
	public String showPage(Model model, @RequestParam(defaultValue="0") int page) {
		model.addAttribute("data",countryRepo.findAll(PageRequest.of(page, 2)));
		model.addAttribute("currentPage",page);
		return "index";
	}
	
	@GetMapping("/showNewCountryForm")
	public String showNewEmployeeForm(Model model) {
		Country newCountry = new Country();
		model.addAttribute("country",newCountry);//attribute name same as model attribute
		return "new_employee";
	}
	@PostMapping("/saveCountry")
	public String saveEmployee(@ModelAttribute("country") Country country ) {
		countryRepo.save(country);
		return "redirect:/";
	}
	@GetMapping("/showFormforUpdate/{id}")
	public String updateEmployee(@PathVariable int id,Model model) {
		Country country = countryRepo.findById(id).get();
		model.addAttribute("country",country);
		return "update_employee";
	}
	@GetMapping("/deleteCountry/{id}")
	public String deleteCountryById(@PathVariable int id) {
		countryRepo.deleteById(id);
		return "redirect:/";
	}

}
