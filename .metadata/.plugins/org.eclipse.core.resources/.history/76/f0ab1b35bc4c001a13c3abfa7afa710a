package model.api;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.AdminConf;
import model.Conference;
import model.User;
import model.data.AdminConfRepository;
import model.data.ConferenceRepository;
import model.data.UserRepository;

@RestController
@RequestMapping(path="/api/addadmin", produces = { "application/json", "text/xml" })
@CrossOrigin(origins = "*")
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
	public Iterable<Conference> addAdmin() {
		Iterable<Conference> conferences = confRepo.findAllConference();
		return conferences;
	}

	@PostMapping
	public void handleAddAdmin(@RequestBody User admin, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new ValidationException("Register Formulaire has errors");
		}
		
		loggingRepo.save(admin);
		List<AdminConf> ac = new ArrayList<AdminConf>();
		for(Long idConf : admin.getConf()) 
			ac.add(new AdminConf(admin.getUsername(), idConf));
		acRepo.save(ac);		
	}
}
