package mvc;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.io.IOException;

public class AWT_NoteRecette extends Panel implements ActionListener {
	Button b;
	Modele m;
	ItemListener l;
	
	public AWT_NoteRecette(ItemListener l, Modele m) throws IOException {
		super();
		this.b = new Button("Notes");
		this.b.setBounds(50,50, 150,20);
		this.m = m;
		this.l = l;
		this.add(b);
		b.addActionListener(this);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			AWT_NoteRecetteFenetre pop = new AWT_NoteRecetteFenetre(this.l,this.m);
			//AWT_SupprimerRecetteFenetre pop1 = new AWT_SupprimerRecetteFenetre();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
