package mvc;

import java.awt.List;
import java.awt.Panel;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;

public class AWT_ListeRecette extends Panel implements Observer {
	
	List listeRecette;
	Modele modl;
	
	public AWT_ListeRecette(ItemListener l, Modele m) throws IOException {
		
		this.modl = m;
		listeRecette = new List(20);
		for (String nomRecettes : m.recettes.keySet()) {
				listeRecette.add(nomRecettes);
		}
		this.add(listeRecette);
		listeRecette.addItemListener(l);
		listeRecette.select(0);
		
		m.addObserver(this);
	}
	
	
	public void changerListe(int numNouvL) {
		this.listeRecette.removeAll();
		if (numNouvL==0) {
			
			
			for (String nomRecettes : this.modl.categorEntree.keySet()) {
				listeRecette.add(nomRecettes);
			}
			this.add(listeRecette);
		}
		else if (numNouvL==1) {
			
			
			for (String nomRecettes : this.modl.categorPlat.keySet()) {
				listeRecette.add(nomRecettes);
			}
			this.add(listeRecette);
		}
		else if (numNouvL==-1) {
			
			
			for (String nomRecettes : this.modl.categorDessert.keySet()) {
				listeRecette.add(nomRecettes);
			}
			this.add(listeRecette);
		}

		else if (numNouvL==3) {
			
			
			for (String nomRecettes : this.modl.recettes.keySet()) {
				listeRecette.add(nomRecettes);
			}
			this.add(listeRecette);
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if (arg1 instanceof Integer) {
			//System.out.println("appui sur recette");
			this.changerListe((int)arg1);
			this.modl.categor = ((int)arg1);
		}
		
		else {
			int nomR = this.listeRecette.getSelectedIndex();
			//this.listeRecette.replaceItem(arg1.toString(), nomR);
			this.listeRecette.select(nomR);
		}
	}
}
