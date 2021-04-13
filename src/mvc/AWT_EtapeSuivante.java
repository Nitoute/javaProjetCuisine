package mvc;

import java.awt.Button;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AWT_EtapeSuivante extends Panel implements ActionListener {

	Modele m;
	
	public AWT_EtapeSuivante(Modele m) {
		super();
		Button b = new Button("Etape Suivante");
		this.add(b);
		this.m = m;
		
		b.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.m.etapeSuiv();
		
	}

	

}
