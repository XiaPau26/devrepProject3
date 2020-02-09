package model.data;

import model.Formulaire;
import model.PaiementAndReceipt;

public interface FormulairePayeRepository {
	Formulaire addFormulairePayed(Formulaire form, PaiementAndReceipt par);
	Iterable<PaiementAndReceipt> findAllNoSendFacture();
	Iterable<PaiementAndReceipt> findAllNoSendFacture(Long idConference);
	void validatedSendReceipt(Long idreceip);

}
