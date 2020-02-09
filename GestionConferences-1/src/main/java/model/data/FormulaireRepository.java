package model.data;

import model.Formulaire;
import model.TypeInscription;

public interface FormulaireRepository {
	void save(Formulaire form);
	Iterable<Formulaire> findAllNoValidated();
	Iterable<Formulaire> findAllNoValidatedOfConference(Long idConference);
	Iterable<TypeInscription> findAllTypeInscription();
	Iterable<Formulaire> findAll();
	Formulaire findOneFormulaire(long idFormulaire);
	TypeInscription findOneTypeInscription(long idtype);
	void delete(Formulaire form);
	void delete(long id);
	void validatedForm(int idform);
}