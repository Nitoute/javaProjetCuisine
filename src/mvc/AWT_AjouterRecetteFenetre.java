package mvc;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BoxLayout;

import javax.swing.JTextArea;
import java.awt.Choice;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Button;
import javax.swing.JLabel;
import javax.swing.JFrame;
import java.awt.event.*;


public class AWT_AjouterRecetteFenetre extends JFrame implements ActionListener{
	
	Modele m;
	
	String nouvNomR;
	String nouvCatgr;
	String[] nouvIngr;
	String[] nouvEtape;
	
	JTextArea nomR;
	JTextArea ingrd;
	JTextArea etapIngr;
	Choice c;

	public AWT_AjouterRecetteFenetre(Modele m) throws IOException {
		super();
		
		this.m=m;
		
		
	    Dialog d = new Dialog(this); 
	    d.setTitle("Ajouter une nouvelle recette");
	   
	   
	    
        d.setLayout( new BoxLayout(d ,BoxLayout.Y_AXIS ) );
        
        this.c=new Choice();
        c.setBounds(100,100, 75,50);  
        c.add("entree");  
        c.add("plat");  
        c.add("dessert");
        
        this.nomR=new JTextArea("Entree le nom de votre recette"); 
        nomR.setPreferredSize(new Dimension(200,40));
        
        this.ingrd=new JTextArea("Entree la liste de vos ingredients"); 
        ingrd.setPreferredSize(new Dimension(200,40));
        
        this.etapIngr=new JTextArea("Entree la liste de vos etapes"); 
        etapIngr.setPreferredSize(new Dimension(200,40));;
        
        Button envoy = new Button("Envoyer");
        envoy.setPreferredSize(new Dimension(200,40));
        envoy.addActionListener(this);  
       
        d.add( new JLabel ("Veuillez choisir une categorie :"));  
        d.add(c);
        d.add(new JLabel ("Indiquez le nom de votre recette :"));
        d.add(nomR);
        d.add(new JLabel ("Ajouter les ingredients de votre recettes :"));
        d.add(ingrd);
        d.add(new JLabel ("Ajouter les etapes de votre recettes :"));
        d.add(etapIngr);
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
		this.nouvEtape = this.etapIngr.getText().split(",");
		ArrayList<String> listeIngredients = new ArrayList<>();
		ArrayList<String> listeEtapes= new ArrayList<>();
		for (String i : this.nouvIngr) {
			listeIngredients.add(i);
		}
		for (String j : this.nouvEtape) {
			listeEtapes.add(j);
		}
		RecetteModele nouvRecette = new RecetteModele(listeIngredients,listeEtapes,this.nouvCatgr,this.nouvNomR);
		this.m.ajouterRecette(nouvRecette);
		String nouvRecetteAj= this.nouvNomR+";"+this.nouvCatgr+";"+this.ingrd.getText()+";"+this.etapIngr.getText();
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("donnees.csv", true));
			//writer.newLine();
			writer.append(nouvRecetteAj);
			writer.newLine();
			writer.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		dispose();
		
		
	}

	

}