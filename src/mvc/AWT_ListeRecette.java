package mvc;

import java.awt.List;
import java.awt.Panel;
import java.awt.event.ItemListener;
import java.io.IOException;
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

	@Override
	public void update(Observable arg0, Object arg1) {
		int nomR = this.listeRecette.getSelectedIndex();
		//this.listeRecette.replaceItem(arg1.toString(), nomR);
		this.listeRecette.select(nomR);
	}
}
