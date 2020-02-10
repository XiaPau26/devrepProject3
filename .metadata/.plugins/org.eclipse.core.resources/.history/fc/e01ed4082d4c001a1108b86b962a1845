package model.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class SuperAdminController {

	@GetMapping("/superadmin")
	public String showSuperAdmin(Model model) {
		return "superadmin";
	}
	
	@RequestMapping(value = "/superadmin", method = RequestMethod.POST)
	public String handleButton(@RequestParam("action") String submitValue) {
		if (submitValue.equalsIgnoreCase("ValidateFormulaire")) {
			return "redirect:/adminvalidate";
		} else if (submitValue.equalsIgnoreCase("ManageAdmin")) {
			return "redirect:/manageadmin";
		} else {
			return "/";
		}
	}
}
