package mvc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;

public class Modele extends Observable { 
	
	RecetteModele recet;
	
	public HashMap<String, RecetteModele> recettes;
	public HashMap<String, RecetteModele> categorEntree;
	public HashMap<String, RecetteModele> categorPlat;
	public HashMap<String, RecetteModele> categorDessert;
	public HashMap<String, RecetteModele> etapIngr;
	
	FileReader fr;
	BufferedReader br;
	String nomRecetteSelec = "flan de courgette";
	int categor = 3;

	public Modele() throws IOException {
		
		
		this.fr = new FileReader(new File("donnees.csv"));
        this.br = new BufferedReader(fr);
		this.recettes = new HashMap<String, RecetteModele>();
		this.categorEntree = new HashMap<String, RecetteModele>();
		this.categorPlat = new HashMap<String, RecetteModele>();
		this.categorDessert = new HashMap<String, RecetteModele>();
		this.etapIngr = new HashMap<String, RecetteModele>();
		
		for (String line = br.readLine(); line != null; line = br.readLine()) {
			try {
				String[] parts = line.split(";");
				String id = parts[0];
	            String categorie = parts[1];
	            String[] ingredients = parts[2].split(",");
	            String[] etapes = parts[3].split(",");
	            ArrayList<String> listeIngredients = new ArrayList<>();
	            ArrayList<String> listeEtapes = new ArrayList<>();
	            for (String i : ingredients) {
	            	listeIngredients.add(i);
	            }
	            for (String j : etapes) {
	            	listeEtapes.add(j);
	            }
	            RecetteModele re = new RecetteModele(listeIngredients,listeEtapes,categorie,id);
	            recettes.put(id, re);
	            etapIngr.put(id, re);
	            
	            if (categorie.equals("entree")) {
	            	categorEntree.put(id, re);
	            }
	            
	            if (categorie.equals("plat")) {
	            	categorPlat.put(id, re);
	            }
	            if (categorie.equals("dessert")) {
	            	categorDessert.put(id, re);
	            }
			} catch (ArrayIndexOutOfBoundsException e) {
				//Rien
			}
		}
	}

	public void selection(int item) {
		int i = 0;
		if(this.categor==0) {
			for ( String nomR : categorEntree.keySet() ) {
				if(i==item) {
					this.nomRecetteSelec = nomR;
		    	
				}
				i+=1;
			}
		}
		else if(this.categor==1) {
			for ( String nomR : categorPlat.keySet() ) {
				if(i==item) {
					this.nomRecetteSelec = nomR;
		    	
				}
				i+=1;
			}
		}
		else if(this.categor==-1) {
			for ( String nomR : categorDessert.keySet() ) {
				if(i==item) {
					this.nomRecetteSelec = nomR;
		    	
				}
				i+=1;
			}
		}
		else if(this.categor==3) {
			for ( String nomR : recettes.keySet() ) {
				if(i==item) {
					this.nomRecetteSelec = nomR;
		    	
				}
				i+=1;
			}
		}
		
		else {
			for ( String nomR : recettes.keySet() ) {
				if(i==item) {
					this.nomRecetteSelec = nomR;
		    	
				}
				i+=1;
			}
		}
		
		
		//System.out.println(this.recettes);
		this.setChanged();
		this.notifyObservers(this.recettes.get(this.nomRecetteSelec));
		//this.notifyObservers(this.etapIngr.get(this.nomRecetteSelec));
		
	}
	
	

	
	public void changeListe(int numCategorie) {
		this.categor = numCategorie;
		this.setChanged();
		this.notifyObservers(numCategorie);
	}
	
	
	public void supprimerRecette() throws IOException {
		this.recettes.remove(this.nomRecetteSelec);
		
		//System.out.print(this.categor);
		if(this.categorEntree.containsKey(this.nomRecetteSelec)) {
			this.categorEntree.remove(this.nomRecetteSelec);
		}
		
		
		else if(this.categorPlat.containsKey(this.nomRecetteSelec)) {
			this.categorPlat.remove(this.nomRecetteSelec);
		}	
		
		
		else if(this.categorDessert.containsKey(this.nomRecetteSelec)) {
			this.categorDessert.remove(this.nomRecetteSelec);
		}
		
		
		this.changeListe(this.categor);
		
		
	}
	
	public void ajouterRecette(RecetteModele m) {
		//System.out.println(nomI);
		//System.out.println(categorie);
		
		this.recettes.put(m.nomRecette, m);
		
		
		if (m.categorie == "entree") {
			this.categorEntree.put(m.nomRecette, m);
		}
		
		if (m.categorie == "plat") {
			this.categorPlat.put(m.nomRecette, m);
		}
		
		if (m.categorie == "dessert") {
			this.categorDessert.put(m.nomRecette, m);
		}
		
		this.setChanged();
		this.notifyObservers(this.categor);
	}
	 
}
