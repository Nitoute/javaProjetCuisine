package mvc;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

public class AWT_AfficheurEtapes extends Canvas implements Observer{
	
	RecetteModele etp;
	int numEtp;

	public AWT_AfficheurEtapes(Modele m) {
		super();
		//this.etape = m.etapIngr.get("flan de courgette");
		
		this.etp = m.recettes.get("flan de courgette");
		m.addObserver(this);
	}
	
	public void paint(Graphics g) {
		int taillestr= " Liste Etape ".length();
		g.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,30));
		g.drawRect(120, 19, 19*taillestr, 40);
		g.setColor(Color.gray);
		g.fillRect(120, 19, 19*taillestr, 40);
		g.setColor(Color.BLACK);
		
		g.drawString(" Liste Etapes ", 150, 50);
		
		g.setFont(new java.awt.Font(Font.DIALOG,Font.BOLD,20));
		int x=50;
		int y=100;
		g.drawString("Etape n°"+(this.numEtp+1), x, y);
		y+=20;
		g.drawString(". " + etp.etapes.get(this.numEtp), x, y);
		y+=20;
			
	}
	
	public void changerEtp(String p) {
		if (p=="Etape Suivante") {
			if(this.numEtp<etp.etapes.size()-1) {
				this.numEtp+=1;
				repaint();
			}
		}
		
		if (p=="Etape Precedente") {
			if (this.numEtp!=0) {
				this.numEtp-=1;
				repaint();
			}
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if (arg1 instanceof RecetteModele) {
			RecetteModele et = (RecetteModele) arg1;
			this.etp=et;
			this.numEtp=0;
			repaint();
		}
		
		if (arg1 instanceof String) {
			this.changerEtp((String) arg1);
		}
		
	}

}
