package mvc;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.*;
import java.awt.event.*;


public class AWT_AjouterRecetteFenetre extends Frame implements WindowListener{

	public AWT_AjouterRecetteFenetre() throws IOException {
		super();
		this.addWindowListener(this);
		
		
		
		
		this.setLayout(new BorderLayout());
		
		Dialog d = new Dialog(this , "Ajouter une nouvelle recette", true); 
        d.setLayout( new FlowLayout() );
        
        Choice c=new Choice();
        c.setBounds(100,100, 75,50);  
        c.add("Entrée");  
        c.add("Plat");  
        c.add("Dessert");
        
        TextArea nomR=new TextArea("Entrée le nom de votre recette"); 
        nomR.setBounds(10,10,10,10);
        nomR.setPreferredSize(new Dimension(450,50));
        
        TextArea ingrd=new TextArea("Entrée la liste de vos ingrédients"); 
        ingrd.setBounds(10,10,10,10);
       
        d.add( new Label ("Veuillez choisir une catégorie"));  
        d.add(c);
        d.add(new Label ("Indiquez le nom de votre recette"));
        d.add(nomR);
        d.add(new Label ("Ajouter les ingrédients de vos recettes"));
        d.add(ingrd);
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
		
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
	
		
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
