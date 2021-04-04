package mvc;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.Observable;

public class AWT_SupprimerRecetteFenetre extends Frame implements WindowListener, ActionListener{
	
	
	Button b;
	
	public AWT_SupprimerRecetteFenetre() throws IOException {
		super();
		this.addWindowListener(this);
		
		Modele modl = new Modele();
		Controleur ctrl = new Controleur(modl);
		
		this.setLayout(new BorderLayout());
		
		Dialog d = new Dialog(this); 
	    d.setTitle("Supprimer une recette");
       
        
        //insertion de la liste pour selectionner la recette à supprimer
        AWT_ListeRecette liste = new AWT_ListeRecette(ctrl, modl);
        d.add(liste,BorderLayout.WEST);
        
        d.setSize(500,600);    
        d.setVisible(true);
        
        this.b = new Button("Supprimer");
		this.add(b,BorderLayout.SOUTH);
		b.addActionListener(this);
         
       
		d.addWindowListener(new WindowAdapter()
		{
			public void windowClosed(WindowEvent e)
	  {
	    //je laisse cette partie au cas ou
	    
	  }

			public void windowClosing(WindowEvent e)
	  {
	    
	    dispose();
	  }
		});
		
        this.pack();
		
        //System.out.println(modl.recettes);
        //System.out.println(modl.recettes.get(modl.nomRecetteSelec));
        
        
        
        
	}
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
