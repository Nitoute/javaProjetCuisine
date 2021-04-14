package mvc;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.BoxLayout;

import java.awt.*;
import java.awt.event.*;

public class AWT_ListeCourseFenetre extends Frame implements ActionListener {
	Modele m;
	TextArea ingredients;
	String nomRecette;
//	String ingRecette ;
	public HashMap<String, RecetteModele> recettes;
	public List<String>  listeIngrRecette;

	RecetteModele recetteMod;
	
	public AWT_ListeCourseFenetre(ItemListener l, Modele m) throws IOException {
		super();
		
		this.m=m;
		
		Dialog d = new Dialog(this); 
	    d.setTitle("liste de course");
	    
	    d.setLayout( new BoxLayout(d ,BoxLayout.Y_AXIS ) );
	    
	    this.ingredients=new TextArea("Entrer les ingredients a votre dsposition"); 
        ingredients.setPreferredSize(new Dimension(200,40));
      
        d.add(this.ingredients);
	    
	    
	    
	    
      
        
	    Button envoy = new Button("Envoyer");
        envoy.setPreferredSize(new Dimension(200,40));
        envoy.addActionListener(this);  
        d.add(envoy);
        
        
        d.setSize(500,600);
        d.setVisible(true);
        this.recettes=this.m.recettes;
		this.nomRecette=this.m.nomRecetteSelec;
       
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
		String[] tabingUtilisateur = (this.ingredients.getText()).split(",");
		ArrayList<String> tabStrIngredient ;
		this.recettes=this.m.recettes;
		this.nomRecette=this.m.nomRecetteSelec;
		this.recetteMod=recettes.get(nomRecette);
		this.listeIngrRecette=recetteMod.ingredients;
		for ( int i=0;i<listeIngrRecette.size();i++) {
			tabStrIngredient.add(this.listeIngrRecette[i].getText()).split(" ");
			if (tabStrIngredient.contains(ingRecette)) {
			}
		
				

	}
}
}
