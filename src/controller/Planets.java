package controller;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public abstract class Planets extends Characters {

	private String name;
	private double rotationSpeed;
	private double totalRotation = 0;
	private double averageSpeed = 0;
	private boolean alive = true;
	private int totalMoments=0;
	private int maxMoviment;
	private int translationSpeed;
	private int momentsAtTheExplosion = 0;
	private int totalYears = -1;
	private int yearsPerMoment = 0;
	private int bugsCollided = 0;
	private int developersCollided = 0;

	public Planets(String name, int initialXPosition, int initialYPosition, int translationSpeed,
			double rotationSpeed, int maxMoviment, ImageIcon icon) {
		super(initialXPosition, initialYPosition, icon);
		this.name = name;
		this.translationSpeed = translationSpeed;
		this.rotationSpeed = rotationSpeed;
		this.maxMoviment = maxMoviment;
		if (this.name.equals("Java")) {
			totalYears++;
		}
	}

	public String getName() {
		return name;
	}


	public double getRotationSpeed() {
		return rotationSpeed;
	}


	public double getTotalRotation() {
		return totalRotation;
	}


	public double getAverageSpeed() {
		return averageSpeed;
	}


	public boolean isAlive() {
		return alive;
	}


	public int getMaxMoviment() {
		return maxMoviment;
	}


	public int getTranslationSpeed() {
		return translationSpeed;
	}


	public int getMomentsAtTheExplosion() {
		return momentsAtTheExplosion;
	}


	public int getTotalYears() {
		return totalYears;
	}


	public int getYearsPerMoment() {
		int x=yearsPerMoment;
		this.yearsPerMoment=0;
		return x;
	}


	public int getBugsCollided() {
		return bugsCollided;
	}


	public int getDevelopersCollided() {
		return developersCollided;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setRotationSpeed(double rotationSpeed) {
		this.rotationSpeed = rotationSpeed;
	}


	public void setTotalRotation(double totalRotation) {
		this.totalRotation = totalRotation;
	}


	public void setAverageSpeed(double averageSpeed) {
		this.averageSpeed = averageSpeed;
	}


	public void setAlive(boolean alive) {
		this.alive = alive;
	}


	public void setMaxMoviment(int maxMoviment) {
		this.maxMoviment = maxMoviment;
	}


	public void setTranslationSpeed(int translationSpeed) {
		this.translationSpeed = translationSpeed;
	}


	public void setMomentsAtTheExplosion(int momentsAtTheExplosion) {
		this.momentsAtTheExplosion = momentsAtTheExplosion;
	}


	public void setTotalYears(int totalYears) {
		this.totalYears = totalYears;
	}


	public void setYearsPerMoment(int yearsPerMoment) {
		this.yearsPerMoment = yearsPerMoment;
	}


	public void setBugsCollided(int bugsCollided) {
		this.bugsCollided = bugsCollided;
	}


	public void setDevelopersCollided(int developersCollided) {
		this.developersCollided = developersCollided;
	}

	public int getTotalMoments() {
		return totalMoments;
	}

	public void setTotalMoments(int totalMoments) {
		this.totalMoments = totalMoments;
	}

	public void translate(int moments) {
		this.totalMoments+=moments;
		int totalMoviment = moments * this.translationSpeed;
		int xmax = this.initialPositionX + this.maxMoviment;
		int ymax = 8 + this.maxMoviment;
		int xmin = this.initialPositionX - this.maxMoviment;
		int ymin = 8 - this.maxMoviment;
//		System.out.println(momentos);
		if (this.alive == true) {
			while (totalMoviment > 0) {
				for (int i = 0; i < this.translationSpeed; i++) {
					if (this.positionY == this.initialPositionY && this.positionX == this.initialPositionX) {
						this.totalYears++;
						this.yearsPerMoment++;
					}
					if (this.positionY == ymax && this.positionX != xmin) {
						this.positionX--;
					} else if (this.positionY == ymin && this.positionX != xmax) {
						this.positionX++;
					} else if (this.positionX == xmin) {
						this.positionY--;
					} else if (this.positionX == xmax) {
						this.positionY++;
					}
				}
				totalMoviment -= this.translationSpeed;
			}
		}
		this.averageSpeed+=moments*this.translationSpeed;
	}

	public double rotate(int moments) {
		double rotationPerMoment=0;
		if (this.alive == true) {
			this.totalRotation += moments * this.rotationSpeed;
			rotationPerMoment = moments * this.rotationSpeed;
			return rotationPerMoment;
		} else {
			return 0;
		}
	}

	public void verifyColision(ArrayList<Bugs> bugs, ArrayList<Developers> developers, int moments) {
		for (int i = 0; i < developers.size(); i++) {
			if (this.positionX == developers.get(i).positionX && this.positionY == developers.get(i).positionY) {
				this.translationSpeed++;
				developers.remove(i);
				this.developersCollided++;
			}
		}
		for (int i = 0; i < bugs.size(); i++) {
			if (this.positionX == bugs.get(i).positionX && this.positionY == bugs.get(i).positionY) {
				this.translationSpeed--;
				if (this.translationSpeed == 0) {
					this.alive = false;
					this.momentsAtTheExplosion=moments;
				}
				bugs.remove(i);
				this.bugsCollided++;
			}
		}
	}
}
