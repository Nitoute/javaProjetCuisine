package mvc;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.awt.font.*;


public class AWT_AfficheurRecette extends Canvas implements Observer {


	List<String> ing;
	

	public AWT_AfficheurRecette(Modele m) {
		super();
		this.setPreferredSize(new Dimension(640,360));
		this.ing = m.recettes.get("flan de courgette");
		
		m.addObserver(this);
	}

	public void paint(Graphics g) {
		
		g.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,30));
		g.drawRect(120, 15, 300, 50);
		g.setColor(Color.gray);
		g.fillRect(120, 15, 300, 50);
		g.setColor(Color.BLACK);
		g.drawString("Liste d'ingredients ", 150, 50);
		
		g.setFont(new java.awt.Font(Font.DIALOG,Font.BOLD,20));
		int x=50;
		int y=100;
		for (String ingrDefaut : ing) {
			g.drawString(". " + ingrDefaut, x, y);
			y+=20;
		}
		
		
		 
		
	}

	@Override
	public void update(Observable o, Object arg) {
		if (!(arg instanceof Integer)) {
		List<String>in = (List<String>) arg;
		this.ing=in;
		
		repaint();
	}
	}

}
