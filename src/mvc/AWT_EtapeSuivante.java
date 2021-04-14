package mvc;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AWT_EtapeSuivante extends JPanel implements ActionListener {

	Modele m;
	
	public AWT_EtapeSuivante(Modele m) {
		super();
		JButton b = new JButton("Etape Suivante");
		this.add(b);
		this.m = m;
		
		b.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.m.etapeSuiv();
		
	}

	

}
