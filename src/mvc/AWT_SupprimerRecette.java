package mvc;

import java.awt.Button;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;

import java.awt.Color;

public class AWT_SupprimerRecette extends Panel implements ActionListener{
	
	JButton b= new JButton("Supprimer recette");
	Modele m;
	ItemListener l;
	
	public AWT_SupprimerRecette(ItemListener l, Modele m) {
		super();
		
//		this.b = new Button("Supprimer recette");
		this.b.setBounds(50,50, 150,20);
		 
		this.b.setBackground(Color.lightGray);
		this.add(b);
		this.l = l;
		this.m = m;
		
		b.addActionListener(this);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		BufferedReader br = null;
		String line ="";
		String csvSplit = ";";
		String[] recettes = new String[3];
		ArrayList<String> listeNomRecette = new ArrayList<String>();
		ArrayList<String> listeCategor = new ArrayList<String>();
		ArrayList<String> listeIngr = new ArrayList<String>();
		
		try {
			this.m.supprimerRecette();//suppression de la recette dans la partie graphique
			
			br = new BufferedReader(new FileReader("donnees.csv")); //on parcour le csv affin de copier les valeur dans une liste
			//int i =0;
			for (line = br.readLine(); line != null; line = br.readLine()) {
				recettes = line.split(csvSplit);
				//System.out.println(listeNomRecette[0]);
				listeNomRecette.add(recettes[0]);
				listeCategor.add(recettes[1]);
				listeIngr.add(recettes[2]);
					
			}
			
			//System.out.println(listeNomRecette);
			int index = listeNomRecette.indexOf(this.m.nomRecetteSelec);//on supprime la recette dans la liste
			listeNomRecette.remove(this.m.nomRecetteSelec);
			listeCategor.remove(index);
			listeIngr.remove(index);
			//System.out.println(listeNomRecette);
			
			//on supprime le csv
			 //File monCSV = new File("donnees.csv");
			 //System.out.println(monCSV.delete());
			
			//on cree le nouveau csv
			//File nouveauCSV = new File("donnees1.csv");
			//nouveauCSV.createNewFile();
			
			
			//System.out.println(listeNomRecette.get(1));
			//ajout des lignes
			
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter("donnees.csv"));
				
				for(int i = 0;i<listeNomRecette.size(); i++) {
					writer.append(listeNomRecette.get(i));
					writer.append(";");
					writer.append(listeCategor.get(i));
					writer.append(";");
					writer.append(listeIngr.get(i));
					if (i!=listeNomRecette.size()-1) {
						writer.newLine();
					}
				}
				writer.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("Bouton Appuyer dans AWT_AjouterRecette");
	}

}
