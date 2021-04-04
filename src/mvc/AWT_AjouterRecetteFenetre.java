package mvc;

import java.io.IOException;
import java.awt.*;
import java.awt.event.*;


public class AWT_AjouterRecetteFenetre extends Frame implements ActionListener{
	
	Modele m;
	
	String nouvNomR;
	String nouvCatgr;
	String[] nouvIngr;
	
	TextArea nomR;
	TextArea ingrd;
	Choice c;

	public AWT_AjouterRecetteFenetre(ItemListener l, Modele m) throws IOException {
		super();
		
		this.m=m;
		this.setLayout(new BorderLayout());
		
		
	    Dialog d = new Dialog(this); 
	    d.setTitle("Ajouter une nouvelle recette");
	   
	   
	    
        d.setLayout( new FlowLayout() );
        
        this.c=new Choice();
        c.setBounds(100,100, 75,50);  
        c.add("Entree");  
        c.add("Plat");  
        c.add("Dessert");
        
        this.nomR=new TextArea("Entree le nom de votre recette"); 
        nomR.setBounds(10,10,10,10);
        nomR.setPreferredSize(new Dimension(450,50));
        
        this.ingrd=new TextArea("Entree la liste de vos ingredients"); 
        ingrd.setBounds(10,10,10,10);
        
        Button envoy = new Button("Envoyer");
        envoy.addActionListener(this);  
       
        d.add( new Label ("Veuillez choisir une categorie"));  
        d.add(c);
        d.add(new Label ("Indiquez le nom de votre recette"));
        d.add(nomR);
        d.add(new Label ("Ajouter les ingredients de vos recettes"));
        d.add(ingrd);
        d.add(envoy);
        d.setSize(500,600);    
        d.setVisible(true);
         
       
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
        
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		this.nouvNomR = this.nomR.getText();
		this.nouvCatgr = this.c.getSelectedItem();
		this.nouvIngr = this.ingrd.getText().split(",");
		this.m.ajouterRecette(this.nouvNomR, this.nouvCatgr, this.nouvIngr);
		
	}

	

}
