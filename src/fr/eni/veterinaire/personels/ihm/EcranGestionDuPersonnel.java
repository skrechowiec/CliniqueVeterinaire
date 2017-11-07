package fr.eni.veterinaire.personels.ihm;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class EcranGestionDuPersonnel {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				//Lancer l'application
				//JFrame frame = new EcranTousLesArticles();
				JFrame frame = new EcranListeDuPersonnel();
				frame.setVisible(true);

			}

		});

	}

}

