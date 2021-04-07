package mvc;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;


public class GestionRecette extends Frame implements WindowListener {

	public static void main(String[] args) throws IOException {
		new GestionRecette();
	}

	public GestionRecette() throws IOException {

		Modele modl = new Modele();
		Controleur ctrl = new Controleur(modl);
		
	    this.setLayout(new BorderLayout());

		AWT_ListeRecette panneauGauche = new AWT_ListeRecette(ctrl, modl);
		this.add(panneauGauche, BorderLayout.WEST);

		AWT_AfficheurRecette panneauDroite = new AWT_AfficheurRecette(modl);
		this.add(panneauDroite, BorderLayout.EAST);

		AWT_Categories panneauBas = new AWT_Categories(ctrl, modl);
		this.add(panneauBas,BorderLayout.SOUTH);
		
		
<<<<<<< HEAD
		//cdivision en grille de BorderLayout.NORTH => permet de mettre les bouttons cote � cote
		Panel pan = new Panel(new GridLayout(1,2));
=======
		
		
		//cdivision en grille de BorderLayout.NORTH => permet de mettre les bouttons cote � cote
		Panel pan = new Panel(new GridLayout(1,3));
>>>>>>> d9dce93acc5c2369852d7c47e8a76dfca17d4873
		this.add(pan,BorderLayout.NORTH);
		
		AWT_AjouterRecette panneauBasDroite = new AWT_AjouterRecette(ctrl, modl);
		pan.add(panneauBasDroite);
		
		AWT_SupprimerRecette boutonSupprimerRecette = new AWT_SupprimerRecette(ctrl, modl);
		pan.add(boutonSupprimerRecette);
		
<<<<<<< HEAD
		AWT_listePourRecette boutonListePourRecette = new AWT_listePourRecette (ctrl, modl);
		pan.add(boutonListePourRecette);
=======
		AWT_NoteRecette notes = new AWT_NoteRecette(ctrl, modl);
		pan.add(notes);
		
>>>>>>> d9dce93acc5c2369852d7c47e8a76dfca17d4873
		
		 
		this.addWindowListener(this);
		this.setTitle("Application de gestion de recettes");
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void windowOpened(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) { 
		System.exit(0); 
	}

	@Override
	public void windowClosed(WindowEvent e) {}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowDeactivated(WindowEvent e) {}


}