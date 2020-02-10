package model.api;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.mail.MessagingException;
import javax.validation.Valid;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Conference;
import model.Formulaire;
import model.PaiementAndReceipt;
import model.TypeInscription;
import model.URL;
import model.data.ConferenceRepository;
import model.data.FormulairePayeRepository;
import model.data.FormulaireRepository;
import model.data.UrlRepository;
import model.mail.SendMail;

@RestController
@RequestMapping(path = "/api/paiement", produces = { "application/json", "text/xml" })
@CrossOrigin(origins = "*")
public class PaiementController {

	private final FormulairePayeRepository formpayerepo;
	private final FormulaireRepository formrepo;
	private final UrlRepository urlrepo;
	private final ConferenceRepository confrepo;

	@Autowired
	public PaiementController(FormulairePayeRepository formpaye, FormulaireRepository form, UrlRepository urlrepo,
			ConferenceRepository confrepo) {
		this.formpayerepo = formpaye;
		this.formrepo = form;
		this.urlrepo = urlrepo;
		this.confrepo = confrepo;
	}

	@GetMapping
	public ResponseEntity<Formulaire> paiement(@RequestParam("id") Integer id) {
		Formulaire formulaire;
		try {
			formulaire = formrepo.findOneFormulaire(id);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);		
		}

		if (formulaire.getValidated() == 0)
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);		

		URL url = urlrepo.findOneUrl("http://localhost:8080/api/paiement?id=" + id);
		String exp = url.getDateExpiration();
		Date dateExp;
		try {
			dateExp = new SimpleDateFormat("dd-MM-yy HH:mm:ss").parse(exp);
		} catch (ParseException e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);		
		}
		Date dateCurr = new Date(Calendar.getInstance().getTime().getTime());
		// System.out.println(dateCurr);
		// System.out.println(dateExp);

		if (dateCurr.compareTo(dateExp) < 0) {

			TypeInscription ti = formrepo.findOneTypeInscription(Long.parseLong(formulaire.getIdType()));
			Conference conf = confrepo.findOneConference(Long.parseLong(formulaire.getIdConference()));

			PaiementAndReceipt pa = new PaiementAndReceipt();
			pa.setIdFormulaire(new Long(id));
//			pa.setTitle(formulaire.getTitle());
//			pa.setFirstName(formulaire.getFirstName());
//			pa.setLastName(formulaire.getLastName());
//			pa.setInstitution(formulaire.getInstitution());
//			pa.setAddress(formulaire.getAddress());
//			pa.setZip(formulaire.getZip());
//			pa.setCity(formulaire.getCity());
//			pa.setEmail(formulaire.getEmail());
//			pa.setPhone(formulaire.getPhone());
//			pa.setIdConference(formulaire.getIdConference());
//			pa.setIdType(formulaire.getIdType());
			formulaire.setTypeTarif(ti.getLibelle() + " tarif " + ti.getTarif() + "€");
			formulaire.setTitleConf(conf.getName());
			return new ResponseEntity<>(formulaire, HttpStatus.OK);		
		} else {
			// expiration
			formrepo.delete(id);
			urlrepo.delete(id);
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);		
		}
	}

	@PostMapping
	public void handlePaiement(@RequestBody PaiementAndReceipt paiement, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new ValidationException("Register Formulaire has errors");
		}
		Formulaire f = formrepo.findOneFormulaire(paiement.getIdFormulaire());
		formpayerepo.addFormulairePayed(f, paiement);
		formrepo.delete(f);
//		try {
//			SendMail.sendEmailConfirmationPaiement("ziyu.ye97@gmail.com");
//		} catch (MessagingException | IOException e) {
//			e.printStackTrace();
//		}
	}

}
