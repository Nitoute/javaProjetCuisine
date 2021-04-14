package mvc;

import java.awt.BorderLayout;
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

		Panel centre = new Panel(new GridLayout(3,1));
		Panel bout2 = new Panel(new GridLayout(1,2));
		AWT_AfficheurRecette panneauDroite = new AWT_AfficheurRecette(modl);
		AWT_AfficheurEtapes panneauDroite2 = new AWT_AfficheurEtapes(modl);
		AWT_EtapeSuivante panneauDroite3 = new AWT_EtapeSuivante(modl);
		AWT_EtapePrecedente panneauDroite4 = new AWT_EtapePrecedente(modl);
		centre.add(panneauDroite);
		centre.add(panneauDroite2);
		bout2.add(panneauDroite4);
		bout2.add(panneauDroite3);
		centre.add(bout2);
		this.add(centre, BorderLayout.EAST);

		AWT_Categories panneauBas = new AWT_Categories(ctrl, modl);
		this.add(panneauBas,BorderLayout.SOUTH);
		
		
		//cdivision en grille de BorderLayout.NORTH => permet de mettre les bouttons cote � cote
		Panel pan = new Panel(new GridLayout(1,4));
		this.add(pan,BorderLayout.NORTH);
		
		AWT_AfficherImage boutonAfficherImage = new AWT_AfficherImage(ctrl, modl);
		pan.add(boutonAfficherImage);
		
		AWT_AjouterRecette panneauBasDroite = new AWT_AjouterRecette(modl);
		pan.add(panneauBasDroite);
		
		AWT_SupprimerRecette boutonSupprimerRecette = new AWT_SupprimerRecette(ctrl, modl);
		pan.add(boutonSupprimerRecette);
		
		AWT_listePourRecette boutonListePourRecette = new AWT_listePourRecette (ctrl, modl);
		pan.add(boutonListePourRecette);
		
		AWT_ListeCourse boutonListeCourse= new AWT_ListeCourse (ctrl, modl);
		pan.add(boutonListeCourse);
		
		AWT_NoteRecette notes = new AWT_NoteRecette(ctrl, modl);
		pan.add(notes);
		
		 
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