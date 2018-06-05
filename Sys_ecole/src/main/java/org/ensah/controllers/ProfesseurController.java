package org.ensah.controllers;

import java.security.Principal;

import javax.validation.Valid;

import org.ensah.domains.Absence;
import org.ensah.domains.Compte;
import org.ensah.domains.Etudiant;
import org.ensah.service.AdminAbsenceService;
import org.ensah.service.AdminEtudiantService;
import org.ensah.service.GuestService;
import org.ensah.service.ProfesseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProfesseurController {
	@Autowired
	private AdminEtudiantService adminEtudiantService;
	@Autowired
	private AdminAbsenceService adminAbsenceService;
	 @Autowired
	 private GuestService guestService;
	 @Autowired
	 private ProfesseurService professeurService;
	@RequestMapping(value="/professeur/addAbsence",method=RequestMethod.GET)
	public String addAbsence(Model model,Principal principal){
		Compte compte=guestService.signin(principal.getName());
		System.out.println("Test Index");
		model.addAttribute("title", "Saisie Absence");
		 model.addAttribute("Select", "--Select Item--");
	     model.addAttribute("absence", new Absence());
	     model.addAttribute("Elements",adminAbsenceService.getElementByidProf(compte.getIduser()));
		return "AbsenceForm";
	}
	@RequestMapping(value="/professeur/addAbsence",method=RequestMethod.POST)
	public String addAbsence(Model model,@Valid Absence absence,BindingResult bindingResult,@RequestParam Long idElement,
			@RequestParam String CNE,Principal principal){
		model.addAttribute("title", "Saisie Absence");
		 Compte compte=guestService.signin(principal.getName());
		 Etudiant etudiant=adminEtudiantService.getEtudiantbyCne(CNE);
		 if(bindingResult.hasErrors()){
			 model.addAttribute("Select", "--Select Item--");
			 model.addAttribute("Elements",adminAbsenceService.getElementByidProf(compte.getIduser()));
			 return "AbsenceForm";
		 }
		if (idElement == null){
//             model.addAttribute("erreurRole", true);
			model.addAttribute("Select", "--Select Item--");
			model.addAttribute("erreurelement", true);
			 model.addAttribute("Elements",adminAbsenceService.getElementByidProf(compte.getIduser()));
         	return "AbsenceForm";
         	}
		 if(CNE==""){
			 model.addAttribute("erreurCne", true);
			 model.addAttribute("Select", "--Select Item--");
			 model.addAttribute("Elements",adminAbsenceService.getElementByidProf(compte.getIduser()));
			 return "AbsenceForm";
		 }
		 if(etudiant==null){
			 model.addAttribute("Erreuretd",true);
			 model.addAttribute("Select", "--Select Item--");
			 model.addAttribute("Elements",adminAbsenceService.getElementByidProf(compte.getIduser()));
			 return "AbsenceForm";
		 }
			 
		 adminAbsenceService.addAbsence(absence,compte.getIduser(), etudiant.getId(), idElement);
		return "redirect:/professeur/ProfesseurAbsenceList";
	}
	@RequestMapping(value="/professeur/ProfesseurAbsenceList")
	public String showAbsences(Model model,@RequestParam(name="motCle",defaultValue="")String motCle,
			Principal principal){
		 Compte compte=guestService.signin(principal.getName());
		model.addAttribute("Professeur", professeurService.getProfesseur(compte.getIduser()));
		return "ProfesseurAbsenceList";
	}
	@RequestMapping(value="/professeur/delete")
	public String deleteAbsence(Long id){
		adminAbsenceService.deleteAbsence(id);
		return "redirect:/professeur/ProfesseurAbsenceList";
	}
}
