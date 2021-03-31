package mvc;

import java.awt.Button;
import java.awt.Panel;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AWT_SupprimerRecette extends Panel implements ActionListener{
	Button bouton;
	
	public AWT_SupprimerRecette(ItemListener l, Modele m) {
		
		super();
		
		this.bouton = new Button("suprimer recette");
		this.bouton.setBounds(150,50, 150,20);
		this.add(bouton);
		
		bouton.addActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Bouton Appuyer sur supprimer recette");
		
	}

}
