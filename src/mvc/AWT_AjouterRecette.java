package mvc;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class AWT_AjouterRecette extends JPanel implements ActionListener{
	
	JButton b;
	Modele m;
	

	public AWT_AjouterRecette(Modele m) {
		super();
		this.b = new JButton("Ajouter recette");
		this.b.setBounds(50,50, 150,20);
//		this.b.setBackground(Color.lightGray);
		this.m = m;
		this.add(b);
		
		
		b.addActionListener(this);
		
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			AWT_AjouterRecetteFenetre pop = new AWT_AjouterRecetteFenetre(this.m);
			//AWT_SupprimerRecetteFenetre pop1 = new AWT_SupprimerRecetteFenetre();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		//System.out.println("Bouton Appuyer dans AWT_AjouterRecette");
		
		
	}
	
}


