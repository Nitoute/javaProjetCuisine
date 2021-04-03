package mvc;

import java.awt.Button;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

public class AWT_ValidationAjoutRecette extends Panel implements ActionListener{
	
	Button b;

	public AWT_ValidationAjoutRecette(ItemListener l, Modele m) {
		super();
		this.b = new Button("Valider");
		this.b.setBounds(50,50, 150,20);
		this.add(b);
		
		b.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
