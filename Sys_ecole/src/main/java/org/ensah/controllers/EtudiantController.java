package org.ensah.controllers;

import org.ensah.service.AdminEtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EtudiantController {
	@Autowired
	AdminEtudiantService adminEtudiantService;
	
	@RequestMapping(value="/etudiant/AbsenceEtudiant")
	public String AbsenceEtudiant(Model model){
		model.addAttribute("Etudiant", adminEtudiantService.getEtudiant(1L));
		return "ListAbsenceEtudiant";
	}
}
