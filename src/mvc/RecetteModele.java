package mvc;

import java.util.List;

public class RecetteModele {

	public String id;
	public String categorie;
	public List<String> ingredients;

	public RecetteModele() {}
		
	public RecetteModele(String id, String p, List<String> r) {
		this.id = id;
		this.categorie = p;
		this.ingredients = r;
	}
	
	public String toString() {
		String out = this.id + " ";
		for (int i=0; i<=3; i++) out += "*";
		return out;
	}

}
