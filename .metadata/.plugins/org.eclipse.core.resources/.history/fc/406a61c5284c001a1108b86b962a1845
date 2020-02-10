package model.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String handleButton(@RequestParam("action") String submitValue) {
		if (submitValue.equalsIgnoreCase("Admin")) {
			return "redirect:/login";
		} else if (submitValue.equalsIgnoreCase("Participant")) {
			return "redirect:/formulaire";
		} else {
			return "/";
		}
	}
}
