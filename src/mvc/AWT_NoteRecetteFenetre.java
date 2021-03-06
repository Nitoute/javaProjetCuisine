package mvc;

import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.BoxLayout;

public class AWT_NoteRecetteFenetre extends JFrame implements ActionListener{
	
	String nouvNote;
	Modele m;
	JTextArea zoneTexte;
	
	public AWT_NoteRecetteFenetre(ItemListener l, Modele m) throws IOException {
		super();
		
		this.m=m;
		BufferedReader br = null;
		String line ="";
		String csvSplit = ";";
		String defaultNote = "Entrez vos notes ici: 'J'ai utilisé 4 oeufs au lieu de 6'";
		
		
	    JDialog d = new JDialog(this); 
	    d.setTitle("Notifier la recette");
	    
	    d.setLayout(new GridLayout(2,1));
	    
	    br = new BufferedReader(new FileReader("note.csv")); //on parcour le csv affin de charger les note
		for (line = br.readLine(); line != null; line = br.readLine()) {
			String[] TabNote = new String[2];
			TabNote=line.split(csvSplit);
			if(TabNote[0].equals(this.m.nomRecetteSelec)) {
				String[] str = TabNote[1].split(",");
				defaultNote = "";
				for (int i=0; i<str.length; i++) {
					defaultNote = defaultNote +"\n"+str[i];
				}
			}
				
		}
		br.close();
	    
	    this.zoneTexte=new JTextArea(defaultNote); 
	    zoneTexte.setPreferredSize(new Dimension(200,40));
	    
	    JButton envoy = new JButton("Sauvegarder");
        envoy.setPreferredSize(new Dimension(200,40));
        envoy.addActionListener(this);
		d.add(this.zoneTexte);
		d.add(envoy);
		
		d.setSize(500,600);    
        d.setVisible(true);
        
        d.addWindowListener(new WindowAdapter()
		{
        	public void windowClosed(WindowEvent e)
        		{
        		//je laisse cette partie au cas ou
	    
        		}

        	public void windowClosing(WindowEvent e)
        		{
	    
        		dispose();
        		}
			});
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.nouvNote = this.zoneTexte.getText();
		this.nouvNote = this.nouvNote.replace("\n", ",");
		System.out.println(this.nouvNote);
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("note.csv", true));
			//writer.newLine();
			writer.append(this.m.nomRecetteSelec);
			writer.append(";");
			writer.append(this.nouvNote);
			writer.newLine();
			writer.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		dispose();
	}

}
