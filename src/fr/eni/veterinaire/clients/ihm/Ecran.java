package fr.eni.veterinaire.clients.ihm;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

	public class Ecran {

		public static void main(String[] args) {

			SwingUtilities.invokeLater(new Runnable(){

				@Override
				public void run() {
					//Lancer l'application
					//JFrame frame = new EcranTousLesArticles();
					JFrame frame = new EcranAjouterUnClient();
					frame.setVisible(true);

				}

			});

		}

	}


