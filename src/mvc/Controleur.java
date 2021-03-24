package mvc;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


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
			//int index = Arrays.binarySearch(AWT_NoteImage.libelles, e.getItem());
			//this.modl.changeNote(index);
		}
	}
	
}
