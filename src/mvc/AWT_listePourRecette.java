package mvc;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;


public class AWT_listePourRecette extends JPanel implements ActionListener{
	
	JButton b= new JButton("Quelle Recette?");
	Modele m;
	ItemListener l;
	
	public AWT_listePourRecette (ItemListener l, Modele m) {
		super();

		this.b.setBounds(50,50, 150,20);
//		this.b.setBackground(Color.lightGray);
		this.m = m;
		this.l = l;
		this.add(b);
		
		
		b.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			AWT_listePourRecetteFenetre pop = new AWT_listePourRecetteFenetre(this.l,this.m);
			//AWT_SupprimerRecetteFenetre pop1 = new AWT_SupprimerRecetteFenetre();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
