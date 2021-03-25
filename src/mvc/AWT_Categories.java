package mvc;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ItemListener;
import java.util.Observable;
import java.util.Observer;

public class AWT_Categories extends Panel implements Observer{
	Checkbox[] categories = new Checkbox[3];
	
	public static String[] libelles = {"Entree", "Plat", "Dessert"};
	
	public AWT_Categories(ItemListener l, Modele m) {
		
		this.setFont(new java.awt.Font(Font.SERIF,Font.ITALIC,20));
		this.setLayout(new FlowLayout());
		
		CheckboxGroup cg=new CheckboxGroup();
		
		for (int i=0; i<3; i++) {
			this.categories[i] = new Checkbox(libelles[i], false, cg);
			this.categories[i].addItemListener(l);
			this.add(this.categories[i]);
			
		}
		m.addObserver(this);
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
