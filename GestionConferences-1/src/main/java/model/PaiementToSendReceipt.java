package model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Size;

public class PaiementToSendReceipt {
	
	@Size(min = 1, message = "You must choose at least 1 formulaire to validate")
	private List<PaiementAndReceipt> paiements = new ArrayList<PaiementAndReceipt>();

	public List<PaiementAndReceipt> getPaiements() {
		return paiements;
	}

	public void setPaiements(List<PaiementAndReceipt> paiements) {
		this.paiements = paiements;
	}
}
