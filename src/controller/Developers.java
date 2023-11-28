package controller;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

public class Developers extends Comets {

	private Random rand;

	public Developers(int positionX, int positionY, ImageIcon icon) {
		super(positionX, positionY, icon);
		rand = new Random();
	}
	
	public void generateDevelopers(int numberOfDevelopers, ArrayList<Bugs> bugs,
			ArrayList<Developers> developers, ArrayList<Planets> planets) {
		int cordX, cordY = 0;
		ImageIcon icon=new ImageIcon(getClass().getResource("/Images/Devsicon.png"));
		for (int i = 0; i < numberOfDevelopers; i++) {
			boolean selector = true;
			do {
				selector = true;
				cordX = rand.nextInt(15) + 1;
				cordY = rand.nextInt(15) + 1;
				for (Characters posicoes : planets) {
					if (cordX == posicoes.getPosicaox() && cordY == posicoes.getPosicaoy()) {
						selector = false;
					}
				}
				for (Bugs posicoes : bugs) {
					if (cordX == posicoes.getPosicaox() && cordY == posicoes.getPosicaoy()) {
						selector = false;
					}
				}
				for (Developers posicoes : developers) {
					if (cordX == posicoes.getPosicaox() && cordY == posicoes.getPosicaoy()) {
						selector = false;
					}
				}
			} while (selector == false);
			Developers dev = new Developers(cordX, cordY, icon);
			developers.add(dev);
		}
	}
}
