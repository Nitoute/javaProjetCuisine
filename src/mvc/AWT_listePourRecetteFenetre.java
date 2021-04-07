package mvc;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.BoxLayout;

import java.awt.*;
import java.awt.event.*;

public class AWT_listePourRecetteFenetre extends Frame implements ActionListener {
	Modele m;
	TextArea ingredients;
	
	public AWT_listePourRecetteFenetre(ItemListener l, Modele m) throws IOException {
		super();
		
		this.m=m;
		
		Dialog d = new Dialog(this); 
	    d.setTitle("ingrédients à acheter");
	    
	    d.setLayout( new BoxLayout(d ,BoxLayout.Y_AXIS ) );
	    
	    this.ingredients=new TextArea("Entrer les ingredients a votre dsposition"); 
        ingredients.setPreferredSize(new Dimension(200,40));
        
        Button envoy = new Button("calcul ingredients a acheter");
        envoy.setPreferredSize(new Dimension(200,40));
        envoy.addActionListener(this);
        
        d.add( new Label ("Veuillez entrer les ingredients a votre dsposition"));
        d.setSize(500,600);
        d.setVisible(true);
        d.add(envoy);
        d.addWindowListener(new WindowAdapter()
		{
	public void windowClosed(WindowEvent e)
	  {
	    
	  }

	  public void windowClosing(WindowEvent e)
	  {
	    
	    dispose();
	  }
		});
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
	}

}
