package mvc;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AWT_EtapePrecedente extends JPanel implements ActionListener{
	
	Modele m;

	public AWT_EtapePrecedente(Modele m) {
		super();
		JButton b = new JButton("Etape Precedente");
		this.add(b);
		this.m = m;
		
		b.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.m.etapePrec();
		
	}

}
