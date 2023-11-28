package controller;

import model.JavaLarDAO;
import model.Memory;
import view.Cell;

public class JavaLarSystemController extends Thread{

	private Memory memory;

	public JavaLarSystemController() {
		memory=new Memory();
	}
	
	public void verifyColision() {
		for (Planets planets : memory.getPlanets()) {
			planets.verifyColision(memory.getBugs(), memory.getDevelopers(), 0);
		}
		memory.setAtualLine(memory.getAtualLine()+1);
	}
	
	public Characters verifyCell(Cell celula) {
		for (Planets planets : memory.getPlanets()) {
			if(planets.getPosicaox()==celula.getCordX() && planets.getPosicaoy()==celula.getCordY()) {
				return planets;
			}
		}
		
		for (Bugs bugs : memory.getBugs()) {
			if(bugs.getPosicaox()==celula.getCordX() && bugs.getPosicaoy()==celula.getCordY()) {
				return bugs;
			}
		}
		
		for (Developers dev : memory.getDevelopers()) {
			if(dev.getPosicaox()==celula.getCordX() && dev.getPosicaoy()==celula.getCordY()) {
				return dev;
			}
		}
		return null;
	}
	
	public void translatePlanets() {
		int i=1;
		String s[]=splitMoments();
		for (Planets planets : memory.getPlanets()) {
			if(planets.getName().equals("Java")==false) {
//				System.out.println(planets.getName() + " " + s[i]);
				planets.translate(Integer.valueOf(s[i]));
				i++;
			}
		}
	}
	
	public void rotatePlanets() {
		int i=1;
		String s[]=splitMoments();
		for (Planets planets : memory.getPlanets()) {
			if(planets.getName().equals("Java")==false) {
				planets.rotate(Integer.valueOf(s[i]));
				i++;
			}
		}
	}
	
	public void generateBugsAndDevs() {
		String s[]=splitMoments();
		if(memory.getBugs().size()+memory.getDevelopers().size()+Integer.valueOf(s[8])+Integer.valueOf(s[9])<=217) {
			memory.getBug().generateBugs(Integer.valueOf(s[8]), memory.getBugs(), memory.getDevelopers(), memory.getPlanets());
			memory.getDev().generateDevelopers(Integer.valueOf(s[9]), memory.getBugs(), memory.getDevelopers(), memory.getPlanets());
		}
	}
	
	public void readNewFile(String filePath) {
		memory.setFileWithData(memory.getLocalRead().readFile(filePath));
		memory.setAtualLine(1);
	}
	
	private String[] splitMoments() {
		String n=memory.getFileWithData().getLines().get(memory.getAtualLine());
		return n.split(",");
	}
	
	public void updateBugsAndDevelopersPerQuadrant() {
		for (Bugs bugs : memory.getBugs()) {
			if(bugs.getPosicaox()>8 && bugs.getPosicaoy()>8) {
				memory.setBugsOnFirstQuadrant(memory.getBugsOnFirstQuadrant()+1);
			}else if(bugs.getPosicaox()<8 && bugs.getPosicaoy()>8) {
				memory.setBugsOnSecondQuadrant(memory.getBugsOnSecondQuadrant()+1);
			}else if(bugs.getPosicaox()<8 && bugs.getPosicaoy()<8) {
				memory.setBugsOnThirdQuadrant(memory.getBugsOnThirdQuadrant()+1);
			}else if(bugs.getPosicaox()>8 && bugs.getPosicaoy()<8) {
				memory.setBugsOnFourthQuadrant(memory.getBugsOnFourthQuadrant()+1);
			}
		}
		
		for (Developers devs : memory.getDevelopers()) {
			if(devs.getPosicaox()>8 && devs.getPosicaoy()>8) {
				memory.setDevelopersOnFirstQuadrant(memory.getDevelopersOnFirstQuadrant()+1);
			}else if(devs.getPosicaox()<8 && devs.getPosicaoy()>8) {
				memory.setDevelopersOnSecondQuadrant(memory.getDevelopersOnSecondQuadrant()+1);
			}else if(devs.getPosicaox()<8 && devs.getPosicaoy()<8) {
				memory.setDevelopersOnThirdQuadrant(memory.getDevelopersOnThirdQuadrant()+1);
			}else if(devs.getPosicaox()>8 && devs.getPosicaoy()<8) {
				memory.setDevelopersOnFourthQuadrant(memory.getDevelopersOnFourthQuadrant()+1);
			}
		}
	}
	
	public void recordReport() {
		JavaLarDAO database=new JavaLarDAO();
		database.insertData(this);
		memory.setAllCometsToZero();
	}
	
	public void getDatabaseData() {
		JavaLarDAO database=new JavaLarDAO();
		memory.setDatabaseData(database.getDatabaseData());
	}
	
	public void writeOutputFile() {
		OutputFileGetInfo getInfo=new OutputFileGetInfo();
		String outputFileString="";
		outputFileString+=getInfo.getMostFrequentStudent(memory.getDatabaseData().getStudentsData());
		outputFileString+=getInfo.getMostExplodedAndMoreLifePlanet(memory.getDatabaseData().getPlanetsData());
		outputFileString+=getInfo.concentrationOfBugsAndDevelopers(memory.getDatabaseData().getBugsPerQuadrant(), memory.getDatabaseData().getDevelopersPerQuadrant());
		outputFileString+=getInfo.totalMoments(memory.getDatabaseData().getStudentsData());
		outputFileString+=getInfo.planetSpeed(memory.getDatabaseData().getPlanetsData(), memory.getDatabaseData().getStudentsData().size());
		outputFileString+=getInfo.bugsAndDevelopersOccurred(memory.getDatabaseData().getBugsPerQuadrant(), memory.getDatabaseData().getDevelopersPerQuadrant());
		outputFileString+=getInfo.totalHoursAndYears(memory.getDatabaseData().getPlanetsData());
		memory.getLocalRead().writeOutputFile(outputFileString);
	}
	
	public Memory getMemory() {
		return memory;
	}

	public void setMemory(Memory memory) {
		this.memory = memory;
	}

	public boolean verifyEndGame() {
		int con=0;
		for (Planets planets : memory.getPlanets()) {
			if(planets.getName().equals("Java")==false && planets.isAlive()==false) {
				con++;
			}
		}
		if(con==7) {
			return true;
		}else {
			return false;
		}
	}
}
