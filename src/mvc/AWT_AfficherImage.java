package mvc;


import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import javax.swing.JButton;


public class AWT_AfficherImage extends JPanel implements ActionListener{

	
	Modele m;
	ItemListener l;
	JButton b;
	

	public AWT_AfficherImage(ItemListener l, Modele m) {
		super();

		this.b = new JButton("Afficher Image");
		this.b.setBounds(50,50, 150,20);
		this.m=m;
		this.l=l;
		this.add(b);
		
		b.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		AWT_AfficherImageFenetre pop = new AWT_AfficherImageFenetre(this.l,this.m);
		
	}

}
