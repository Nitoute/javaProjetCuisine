package mvc;

import java.awt.Canvas;
import java.awt.Font;
import java.awt.Graphics;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class AWT_AfficheurEtapes extends Canvas implements Observer{
	
	List<String> etape;

	public AWT_AfficheurEtapes(Modele m) {
		super();
		//this.etape = m.etapIngr.get("flan de courgette");
		
		m.addObserver(this);
	}
	
	public void paint(Graphics g) {
		g.setFont(new java.awt.Font(Font.DIALOG,Font.BOLD,20));
		int x=50;
		int y=100;
		for (String etapeDefaut : etape) {
			g.drawString(". " + etapeDefaut, x, y);
			y+=20;
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

}
