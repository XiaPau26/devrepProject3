package model.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ManageAdminController {
	
	@GetMapping("/manageadmin")
	public String showManageAdmin(Model model) {
		return "manageadmin";
	}
	
	@RequestMapping(value = "/manageadmin", method = RequestMethod.POST)
	public String handleButton(@RequestParam("action") String submitValue) {
		if (submitValue.equalsIgnoreCase("addAdmin")) {
			return "redirect:/addadmin";
		} else if (submitValue.equalsIgnoreCase("chooseAdmin")) {
			return "redirect:/chooseadmin";
		} else {
			return "/";
		}
	}
}
