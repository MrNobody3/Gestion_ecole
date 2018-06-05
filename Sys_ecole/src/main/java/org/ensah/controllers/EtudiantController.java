package org.ensah.controllers;



import java.security.Principal;

import org.ensah.domains.Compte;
import org.ensah.service.AdminEtudiantService;
import org.ensah.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EtudiantController {
	@Autowired
	private AdminEtudiantService adminEtudiantService;
	@Autowired
	private GuestService guestService;
	
	@RequestMapping(value="/etudiant/AbsenceEtudiant")
	public String AbsenceEtudiant(Model model,Principal principal){
		Compte compte=guestService.signin(principal.getName());
		model.addAttribute("Etudiant", adminEtudiantService.getEtudiant(compte.getIduser()));
		return "ListAbsenceEtudiant";
	}
}
