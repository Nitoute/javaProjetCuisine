package mvc;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

public class AWT_SupprimerRecetteFenetre extends Frame implements WindowListener{

	
	public AWT_SupprimerRecetteFenetre() throws IOException {
		super();
		this.addWindowListener(this);
		
		this.setLayout(new BorderLayout());
		
		Dialog d = new Dialog(this , "Supprimer une recette", true); 
        d.setLayout( new FlowLayout() );
        
        /*
         * A completer
         */
        d.setSize(500,600);    
        d.setVisible(true);
         
       
        this.addWindowListener(this);
		
		
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

}
