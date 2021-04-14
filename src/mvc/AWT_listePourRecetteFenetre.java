package mvc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.BoxLayout;

import javax.swing.JFrame;
import java.awt.TextArea;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import java.awt.event.*;

public class AWT_listePourRecetteFenetre extends JFrame implements ActionListener {
	Modele m;
	TextArea ingredients;
	TextArea recettesPossible;
	public HashMap<String, RecetteModele> recettes;
	
	public AWT_listePourRecetteFenetre(ItemListener l, Modele m) throws IOException {
		super();
		
		this.m=m;
		
		Dialog d = new Dialog(this); 
	    d.setTitle("Quelle recette");
	    
	    d.setLayout( new GridLayout(3, 1) );
	   
	    
	    
	    this.ingredients=new TextArea("Entrer les ingredients a votre dsposition"); 
        ingredients.setPreferredSize(new Dimension(200,40));
      
        d.add(this.ingredients);
        
        
       
        
        this.recettesPossible=new TextArea("Liste des recettes possibles"); 
        recettesPossible.setPreferredSize(new Dimension(200,40));
        
        
        d.add(this.recettesPossible);
        

        JButton envoy = new JButton("Envoyer");
        envoy.setPreferredSize(new Dimension(200,40));

        envoy.addActionListener(this);  
        d.add(envoy);
        
        
        d.setSize(500,600);
        d.setVisible(true);
       
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
		String[] ingUtilisateur = (this.ingredients.getText()).split(",");//ingredients que possede l'utilisateur
		this.recettes=this.m.recettes;
		ArrayList<String> recettePossible = new ArrayList<String>();//on initalise un tableau de string de taille maximale
		ArrayList rPos;
		
		for ( String nomR : this.recettes.keySet() ) {

			

			rPos = new ArrayList();

			//cl� => nomR
			//System.out.println("cl�: "+nomR);
			RecetteModele r = this.recettes.get(nomR);
			//valeur => r (c'est une recette modele)
			List<String> ingRecette = r.ingredients;//liste des ingredients de la recette
			//System.out.println(ing);
			
			//on veut savoir si l'utilisateur a une liste d'ingredients qlcqque pour fair ene recette
			//on elimine le plus de cas en testant la taille de la liste de L'utilisateur et la liste d'ingredient d ela recette
			
			/*
			if(ingUtilisateur.length<ingRecette.size()) {
				rPos = false;
			}
			*/
			
			for (int i=0; i<ingRecette.size(); i++) {
				for (int j=0; j<ingUtilisateur.length; j++) {
					if((ingUtilisateur[j].split(" ")).length==1) {
						String[] s = ingRecette.get(i).split(" ");
						for(int k=0; k<(ingRecette.get(i).split(" ")).length; k++) {
							if(s[k].equals(ingUtilisateur[j])) {
								rPos.add(true);
							}
						}
					}
				
				}
				
			}
			if (rPos.size()==ingRecette.size()) {
				System.out.println(nomR);
				recettePossible.add(nomR);
				
			}
			String s ="";
			for(int i=0; i<recettePossible.size(); i++) {
				s = s + recettePossible.get(i)+"\n";
			}
			recettesPossible.setText(s);
	    	
			}
	
		
	}

}
