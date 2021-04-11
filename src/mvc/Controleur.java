package mvc;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;


public class Controleur implements ItemListener {
	
	Modele modl;
	
	public Controleur(Modele m) {
		this.modl = m;
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		
		if (e.getSource() instanceof java.awt.List) {
			this.modl.selection((Integer)e.getItem());	
		} 
		else if (e.getSource() instanceof java.awt.Checkbox) {
			int index = Arrays.binarySearch(AWT_Categories.libelles, e.getItem());
			//System.out.println(index);
			this.modl.changeListe(index);
		}
		
		/*
		else if (e.getSource() instanceof java.awt.Button) {
			System.out.print("Bouton appuyer");
		}
		*/
		
	}
	
}