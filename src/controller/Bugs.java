package controller;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

public class Bugs extends Comets {

	private Random rand;
	
	public Bugs(int positionX, int positionY, ImageIcon icon) {
		super(positionX, positionY, icon);
		rand=new Random();
	}
	
	public void generateBugs(int numberOfBugs, ArrayList<Bugs> bugs, ArrayList<Developers> developers, ArrayList<Planets> planets) {
		int cordX, cordY=0;
		ImageIcon icon=new ImageIcon(getClass().getResource("/Images/Bugsicon.png"));
		for(int i=0; i<numberOfBugs; i++) {
			boolean verificador=true;
			do {
				verificador=true;
				cordX=rand.nextInt(15)+1;
				cordY=rand.nextInt(15)+1;
				for (Planets posicoes : planets) {
					if(cordX==posicoes.getPosicaox() && cordY==posicoes.getPosicaoy()) {
						verificador=false;
					}
				}
				for (Bugs posicoes : bugs) {
					if(cordX==posicoes.getPosicaox() && cordY==posicoes.getPosicaoy()) {
						verificador=false;
					}
				}
				for (Developers posicoes : developers) {
					if(cordX==posicoes.getPosicaox() && cordY==posicoes.getPosicaoy()) {
						verificador=false;
					}
				}
			}while(verificador==false);
			Bugs bug=new Bugs(cordX, cordY, icon);
			bugs.add(bug);
		}
	}
}
