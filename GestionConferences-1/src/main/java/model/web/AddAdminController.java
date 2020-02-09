package model.web;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import model.AdminConf;
import model.Conference;
import model.User;
import model.data.AdminConfRepository;
import model.data.ConferenceRepository;
import model.data.UserRepository;

@Controller
@RequestMapping("/addadmin")
public class AddAdminController {

	private final UserRepository loggingRepo;
	private final ConferenceRepository confRepo;
	private final AdminConfRepository acRepo;

	@Autowired
	public AddAdminController(UserRepository loggingRepo, ConferenceRepository confRepo, AdminConfRepository acRepo) {
		this.loggingRepo = loggingRepo;
		this.confRepo = confRepo;
		this.acRepo = acRepo;
	}

	@GetMapping
	public String addAdmin(Model model) {
		model.addAttribute("newadmin", new User());
		Iterable<Conference> conferences = confRepo.findAllConference();
		model.addAttribute("conferences", conferences);
		return "addadmin";
	}

	@PostMapping
	public String handleAddAdmin(@Valid User admin, Errors errors) {
		if (errors.hasErrors())
			return "redirect:/addadmin";
		
		loggingRepo.save(admin);
		List<AdminConf> ac = new ArrayList<AdminConf>();
		for(Long idConf : admin.getConf()) 
			ac.add(new AdminConf(admin.getUsername(), idConf));
		acRepo.save(ac);		
		return "successmodif";
	}
}
