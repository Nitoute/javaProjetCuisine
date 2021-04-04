package mvc;

import java.awt.Button;
import java.awt.Panel;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public class AWT_AjouterRecette extends Panel implements ActionListener{
	
	Button b;
	Modele m;
	ItemListener l;
	//Button bouton;

	public AWT_AjouterRecette(ItemListener l, Modele m) {
		super();
		this.b = new Button("Ajouter recette");
		this.b.setBounds(50,50, 150,20);
		this.m = m;
		this.l = l;
		this.add(b);
		
		/*
		this.bouton = new Button("suprimer recette");
		this.bouton.setBounds(150,50, 150,20);
		this.add(bouton);
		*/
		//bouton.addActionListener(this);
		b.addActionListener(this);
		
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			AWT_AjouterRecetteFenetre pop = new AWT_AjouterRecetteFenetre(this.l,this.m);
			//AWT_SupprimerRecetteFenetre pop1 = new AWT_SupprimerRecetteFenetre();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		//System.out.println("Bouton Appuyer dans AWT_AjouterRecette");
		
		
	}
	
}


