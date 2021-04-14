package mvc;

import java.awt.Button;
import java.awt.Panel;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.*;

public class AWT_ListeCourse extends Panel implements ActionListener {
	
	
	JButton b= new JButton("liste de courses");
	Modele m;
	ItemListener l;
	public AWT_ListeCourse (ItemListener l, Modele m) {
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
			AWT_ListeCourseFenetre pop = new AWT_ListeCourseFenetre(this.l,this.m);
			//AWT_SupprimerRecetteFenetre pop1 = new AWT_SupprimerRecetteFenetre();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
