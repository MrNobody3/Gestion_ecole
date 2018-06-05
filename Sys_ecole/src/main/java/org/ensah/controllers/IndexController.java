package org.ensah.controllers;

import java.security.Principal;

import org.ensah.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
	@Autowired
	GuestService guestService;
	@RequestMapping(value="/")
	public String index(Model model){
		model.addAttribute("title","index");
		return "index";
	}
	@RequestMapping(value = "signin", method = RequestMethod.GET)
    public String signinGet(Model model) {
        model.addAttribute("title", "Sign in");
        return "signin";
	}
	@RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model,Principal principal) {
		 model.addAttribute("title", "Home");
//        model.addAttribute("role_User", authorities);
        model.addAttribute("compte", guestService.signin(principal.getName()));
        return "home";
	}
}
