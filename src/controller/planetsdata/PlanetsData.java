package controller.planetsdata;

public class PlanetsData {

	private String name;
	private int bugsColided=0;
	private int developersColided=0;
	private int speed=0;
	private int days=0;
	private int years=0;
	
	public PlanetsData(String name, int bugsColided, int developersColided, int speed, int days, int years) {
		super();
		this.name=name;
		this.bugsColided = bugsColided;
		this.developersColided = developersColided;
		this.speed = speed;
		this.days = days;
		this.years = years;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBugsColided() {
		return bugsColided;
	}
	public int getDevelopersColided() {
		return developersColided;
	}
	public int getSpeed() {
		return speed;
	}
	public int getDays() {
		return days;
	}
	public int getYears() {
		return years;
	}
	public void setBugsColided(int bugsColided) {
		this.bugsColided = bugsColided;
	}
	public void setDevelopersColided(int developersColided) {
		this.developersColided = developersColided;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public void setYears(int years) {
		this.years = years;
	}
	
	public int isAlive() {
		if(speed==0) {
			return 1;
		}else {
			return 0;
		}
	}
}
