package mvc;

import java.awt.Button;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.io.IOException;

public class AWT_SupprimerRecette extends Panel implements ActionListener{
	
	Button b;
	
	public AWT_SupprimerRecette(ItemListener l, Modele m) {
		super();
		this.b = new Button("Supprimer recette");
		this.b.setBounds(50,50, 150,20);
		this.add(b);
		
		
		b.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			AWT_SupprimerRecetteFenetre pop1 = new AWT_SupprimerRecetteFenetre();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		//System.out.println("Bouton Appuyer dans AWT_AjouterRecette");
		
	}

}
