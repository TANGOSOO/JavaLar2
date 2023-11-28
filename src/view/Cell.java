package view;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import controller.Characters;
import controller.JavaLarSystemController;

public class Cell extends JLabel{
	
	private int cordX;
	private int cordY;
	private ImageIcon backgroundImage;

	public Cell(int x, int y) {
		this.cordX=x;
		this.cordY=y;
		
		setIcon(backgroundImage=BackgroundImageGenerator());
	}
	
	private ImageIcon BackgroundImageGenerator() {
		Random rand=new Random();
		int numero=rand.nextInt(6) + 1;
		ImageIcon imagem=new ImageIcon(getClass().getResource("/Images/EmptyCell" + numero + ".png"));
		
		return imagem;
	}
	
	public void UpdateCell(JavaLarSystemController system) {
		Characters character=system.verifyCell(this);
		if(character!=null) {
			setIcon(character.getIcon());
		}else {
			setIcon(backgroundImage);
		}
	}

	public int getCordX() {
		return cordX;
	}

	public void setCordX(int cordX) {
		this.cordX = cordX;
	}

	public int getCordY() {
		return cordY;
	}

	public void setCordY(int cordY) {
		this.cordY = cordY;
	}

}
