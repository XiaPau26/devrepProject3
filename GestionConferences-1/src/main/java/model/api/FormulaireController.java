package model.api;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import lombok.extern.slf4j.Slf4j;
import model.Conference;
import model.Formulaire;
import model.TypeInscription;
import model.data.ConferenceRepository;
import model.data.FormulaireRepository;
import model.mail.SendMail;

@RestController
@RequestMapping(path = "/api/formulaire", produces = { "application/json", "text/xml" })
@CrossOrigin(origins = "*")
public class FormulaireController {
	private final FormulaireRepository formrepo;
	private final ConferenceRepository confrepo;

	@Autowired
	public FormulaireController(FormulaireRepository formrepo, ConferenceRepository confrepo) {
		this.formrepo = formrepo;
		this.confrepo = confrepo;
	}

	@GetMapping("/formConf")
	public Iterable<Conference> getConferences() {
		Iterable<Conference> conferences = confrepo.findAllConference();
		return conferences;
	}

	@GetMapping("/formType")
	public Iterable<TypeInscription> getTypes() {
		Iterable<TypeInscription> types = formrepo.findAllTypeInscription();
		return types;
	}

	@PostMapping
	public void registerFormulaire(@RequestBody Formulaire form, BindingResult bindingResult) {
		System.out.println("Hereeee");
		if (bindingResult.hasErrors()) {
			throw new ValidationException("Register Formulaire has errors");
		}
		formrepo.save(form);
	}

//	@GetMapping
//	public String showFormulaireForm(Model model) {
//		Iterable<TypeInscription> types = formrepo.findAllTypeInscription();
//		model.addAttribute("types", types);
//
//		Iterable<Conference> conferences = confrepo.findAllConference();
//		model.addAttribute("conferences", conferences);
//
//		model.addAttribute("formulaire", new Formulaire(null));
//		return "formulaire";
//	}
//
//	@PostMapping
//	public String processFormulaire(@Valid Formulaire form, Errors errors) {
//		if (errors.hasErrors()) {
//			return "redirect:/formulaire";
//		}
//		formrepo.save(form);
//
////		try {
////			SendMail.sendEmailToAdmin();
////		} catch (MessagingException | IOException e) {
////			e.printStackTrace();
////		}
//
//		return "successregistration";
//	}

}
