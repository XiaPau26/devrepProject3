package model.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.AdminConf;
import model.Conference;
import model.PaiementAndReceipt;
import model.PaiementToSendReceipt;
import model.TypeInscription;
import model.data.AdminConfRepository;
import model.data.ConferenceRepository;
import model.data.FormulairePayeRepository;
import model.data.FormulaireRepository;

@Controller
public class GererRecuPaiementController {
	private final ConferenceRepository confrepo;
	private final AdminConfRepository adminconfrepo;
	private final FormulairePayeRepository payerepo;
	private final FormulaireRepository formrepo;

	@Autowired
	public GererRecuPaiementController(AdminConfRepository adminconfrepo, ConferenceRepository confrepo, FormulairePayeRepository payerepo, FormulaireRepository formrepo) {
		this.payerepo = payerepo;
		this.confrepo = confrepo;
		this.adminconfrepo = adminconfrepo;
		this.formrepo = formrepo;
	}

	@GetMapping("/gererRecuPaiement")
	public String showRecuPaiement(Model model) {
		return "";
//		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		List<PaiementAndReceipt> paiements = new ArrayList<>();
//		
//		if (principal instanceof UserDetails) {
//			String username = ((UserDetails) principal).getUsername();
//
//			if (username.equals("superadmin")) {
//				Iterable<PaiementAndReceipt> par = payerepo.findAllNoSendFacture();
//				par.forEach(p -> paiements.add(p));
//			} else {
//				Iterable<AdminConf> adminOfConf = adminconfrepo.findConfByAdmin(username);
//				adminOfConf.forEach(adconf -> {
//					Iterable<PaiementAndReceipt> par = payerepo
//							.findAllNoSendFacture(((AdminConf) adconf).getConfenrece());
//					par.forEach(p -> paiements.add(p));
//				});
//			}
//			model.addAttribute("paiements", paiements);
//		} else {
//			return "erreur";
//		}
//		
//		Map<String, TypeInscription> typeinscriptions = new HashMap<>();
//		Map<String, Conference> conferences = new HashMap<>();
//
//		for (PaiementAndReceipt f : paiements) {
//			TypeInscription ti = formrepo.findOneTypeInscription(Long.parseLong(f.getIdType()));
//			typeinscriptions.put(f.getIdType(), ti);
//
//			Conference conf = confrepo.findOneConference(Long.parseLong(f.getIdConference()));
//			conferences.put(f.getIdConference(), conf);
//		}
//		model.addAttribute("listtype", typeinscriptions);
//		model.addAttribute("allconference", conferences);
//		
//		model.addAttribute("validate", new PaiementToSendReceipt());
//
//		return "gererRecuPaiement";
	}
	
	@RequestMapping(value = "/gererRecuPaiement", method = RequestMethod.POST)
	public String handleButton(PaiementToSendReceipt paiements) {
		for(PaiementAndReceipt p : paiements.getPaiements()) {
			payerepo.validatedSendReceipt(p.getId());
		}
		// a envoyer un mail avec le recu
		return "home";
	}
}
