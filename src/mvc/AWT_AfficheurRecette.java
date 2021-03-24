package mvc;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;
import java.util.Observable;
import java.util.Observer;


public class AWT_AfficheurRecette extends Canvas implements Observer {


	List<String> ing;

	public AWT_AfficheurRecette(Modele m) {
		super();
		this.setPreferredSize(new Dimension(640,360));
		this.ing = m.recettes.get("flan de courgette");
		
		m.addObserver(this);
	}

	public void paint(Graphics g) {
		g.drawString("Liste d'ingrédients : ", 50, 35);
		int x=50;
		int y=50;
		for (String ingrDefaut : ing) {
			g.drawString("-" + ingrDefaut, x, y);
			y+=15;
		}
		
		
		 
		
	}

	@Override
	public void update(Observable o, Object arg) {
		
		List<String>in = (List<String>) arg;
		this.ing=in;
		
		repaint();
	
	}

}
