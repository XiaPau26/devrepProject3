package model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Size;

public class FormulaireValidate {

	@Size(min = 1, message = "You must choose at least 1 formulaire to validate")
	private List<String> idFormulaires = new ArrayList<String>();

	public List<String> getIdFormulaires() {
		return idFormulaires;
	}

	public void setIdFormulaires(List<String> idFormulaires) {
		this.idFormulaires = idFormulaires;
	}
}
