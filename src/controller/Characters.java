package controller;

import javax.swing.ImageIcon;

public abstract class Characters {

	protected int positionX;
	protected int positionY;
	protected int initialPositionX;
	protected int initialPositionY;
	protected ImageIcon icon;

	public Characters(int positionX, int positionY, ImageIcon icon) {
		super();
		this.positionX = positionX;
		this.positionY = positionY;
		this.initialPositionX = positionX;
		this.initialPositionY = positionY;
		this.icon = icon;
	}

	public int getPosicaox() {
		return positionX;
	}

	public void setPosicaox(int posicaox) {
		this.positionX = posicaox;
	}

	public int getPosicaoy() {
		return positionY;
	}

	public void setPosicaoy(int posicaoy) {
		this.positionY = posicaoy;
	}

	public int getPosicaoxinicial() {
		return initialPositionX;
	}

	public void setPosicaoxinicial(int posicaoxinicial) {
		this.initialPositionX = posicaoxinicial;
	}

	public int getPosicaoyinicial() {
		return initialPositionY;
	}

	public void setPosicaoyinicial(int posicaoyinicial) {
		this.initialPositionY = posicaoyinicial;
	}

	public ImageIcon getIcon() {
		return icon;
	}

	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}
}