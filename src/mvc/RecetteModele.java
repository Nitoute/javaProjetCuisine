package mvc;

import java.util.List;

public class RecetteModele {
	
	List<String> ingredients;
	List<String> etapes;
	String categorie;
	String nomRecette;

	public RecetteModele(List<String> ing , List<String> etp, String ctgr, String nomR) {
		this.ingredients=ing;
		this.etapes=etp;
		this.categorie = ctgr;
		this.nomRecette = nomR;
	}

}
