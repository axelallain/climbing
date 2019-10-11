package fr.axelallain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.axelallain.service.SpotService;

@Controller
public class RechercheController {
	
	@Autowired
	private SpotService spotService;
	
	@GetMapping("/recherche")
	public String recherche(Model model, @RequestParam(defaultValue="") String name) {
		model.addAttribute("spots", spotService.findByNameLike("%"+name+"%"));
		
		return "recherche";
	}

}