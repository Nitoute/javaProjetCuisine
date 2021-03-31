package mvc;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Panel;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.FlowLayout;
import java.awt.Choice;
import java.awt.Label;




public class AWT_AjouterRecette extends Panel implements ActionListener{
	
	Button b;

	public AWT_AjouterRecette(ItemListener l, Modele m) {
		super();
		this.b = new Button("Ajouter recette");
		this.b.setBounds(50,50, 150,20);
		this.add(b);
		
		b.addActionListener(this);
		
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		AWT_AjouterRecetteFenetre pop = new AWT_AjouterRecetteFenetre();
        
		System.out.println("Bouton Appuyer dans AWT_AjouterRecette");
		
		
	}
	
}


