package controller.planets;

import javax.swing.ImageIcon;

import controller.Planets;

public class Java extends Planets {
	
	public Java(String name, int initialPositionX, int initialPositionY, int translationSpeed, double rotationSpeed, int maxMovement, ImageIcon icon) {
		super(name, initialPositionX, initialPositionY, translationSpeed, rotationSpeed, maxMovement, icon);
	}
}
