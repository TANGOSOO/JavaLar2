package model;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import controller.Student;
import controller.planets.C;
import controller.planets.CPlusPlus;
import controller.planets.CSharp;
import controller.planets.Java;
import controller.planets.JavaScript;
import controller.planets.Php;
import controller.planets.Python;
import controller.planets.RubyOnRails;
import controller.Bugs;
import controller.Developers;
import controller.FileReaded;
import controller.Planets;

public class Memory {

	private int atualLine=1;
	private int developersOnFirstQuadrant=0;
	private int developersOnSecondQuadrant=0;
	private int developersOnThirdQuadrant=0;
	private int developersOnFourthQuadrant=0;
	private int bugsOnFirstQuadrant=0;
	private int bugsOnSecondQuadrant=0;
	private int bugsOnThirdQuadrant=0;
	private int bugsOnFourthQuadrant=0;
	private Student student;
	private FileReaded fileWithData;
	private DatabaseData databaseData;
	private LocalFileReader localRead;
	private Bugs bug;
	private Developers dev;
	private ArrayList<Bugs> bugs;
	private ArrayList<Developers> developers;
	private ArrayList<Planets> planets;
	private Planets java;
	private Planets python;
	private Planets javascript;
	private Planets rubyonrails;
	private Planets php;
	private Planets csharp;
	private Planets cpp;
	private Planets c;
	
	public Memory() {
		student=new Student("Carlos André", 553908);
		bugs=new ArrayList<Bugs>();
		developers=new ArrayList<Developers>();
		planets=new ArrayList<Planets>();
		databaseData=new DatabaseData();
		localRead=new LocalFileReader();
		bug=new Bugs(-1, -1, new ImageIcon (getClass().getResource("/Images/Bugsicon.png")));
		dev=new Developers(-1, -1, new ImageIcon (getClass().getResource("/Images/Devsicon.png")));
		java=new Java("Java", 8, 8, 0, 0, 0, new ImageIcon (getClass().getResource("/Images/Javaicon.png")));
		python=new Python("Python", 8, 9, 4, 24, 1, new ImageIcon (getClass().getResource("/Images/Pythonicon.png")));
		javascript=new JavaScript("JavaScript", 8, 10, 3, 10, 2, new ImageIcon (getClass().getResource("/Images/JavaScripticon.png")));
		rubyonrails=new RubyOnRails("RubyOnRails", 8, 11, 2, 48, 3, new ImageIcon (getClass().getResource("/Images/RubyOnRailsicon.png")));
		php=new Php("PHP", 8, 12, 2, 60, 4, new ImageIcon (getClass().getResource("/Images/PHPicon.png")));
		csharp=new CSharp("C#", 8, 13, 1, 4, 5, new ImageIcon (getClass().getResource("/Images/C#icon.png")));
		cpp=new CPlusPlus("C++", 8, 14, 2, 0.5, 6, new ImageIcon (getClass().getResource("/Images/C++icon.png")));
		c=new C("C", 8, 15, 10, 0.1, 7, new ImageIcon (getClass().getResource("/Images/Cicon.png")));
		planets.add(java);
		planets.add(python);
		planets.add(javascript);
		planets.add(rubyonrails);
		planets.add(php);
		planets.add(csharp);
		planets.add(cpp);
		planets.add(c);
	}
	
	public void setAllCometsToZero() {
		this.bugsOnFirstQuadrant=0;
		this.bugsOnSecondQuadrant=0;
		this.bugsOnThirdQuadrant=0;
		this.bugsOnFourthQuadrant=0;
		this.developersOnFirstQuadrant=0;
		this.developersOnSecondQuadrant=0;
		this.developersOnThirdQuadrant=0;
		this.developersOnFourthQuadrant=0;
	}

	public DatabaseData getDatabaseData() {
		return databaseData;
	}
	
	public void setDatabaseData(DatabaseData databaseData) {
		this.databaseData = databaseData;
	}

	public int getAtualLine() {
		return atualLine;
	}

	public FileReaded getFileWithData() {
		return fileWithData;
	}

	public LocalFileReader getLocalRead() {
		return localRead;
	}

	public Bugs getBug() {
		return bug;
	}

	public Developers getDev() {
		return dev;
	}

	public ArrayList<Bugs> getBugs() {
		return bugs;
	}

	public ArrayList<Developers> getDevelopers() {
		return developers;
	}

	public ArrayList<Planets> getPlanets() {
		return planets;
	}

	public void setAtualLine(int atualLine) {
		this.atualLine = atualLine;
	}

	public void setFileWithData(FileReaded fileWithData) {
		this.fileWithData = fileWithData;
	}

	public void setLocalRead(LocalFileReader localRead) {
		this.localRead = localRead;
	}

	public void setBug(Bugs bug) {
		this.bug = bug;
	}

	public void setDev(Developers dev) {
		this.dev = dev;
	}

	public void setBugs(ArrayList<Bugs> bugs) {
		this.bugs = bugs;
	}

	public void setDevelopers(ArrayList<Developers> developers) {
		this.developers = developers;
	}

	public void setPlanets(ArrayList<Planets> planets) {
		this.planets = planets;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student aluno) {
		this.student = aluno;
	}

	public int getDevelopersOnFirstQuadrant() {
		return developersOnFirstQuadrant;
	}

	public int getDevelopersOnSecondQuadrant() {
		return developersOnSecondQuadrant;
	}

	public int getDevelopersOnThirdQuadrant() {
		return developersOnThirdQuadrant;
	}

	public int getDevelopersOnFourthQuadrant() {
		return developersOnFourthQuadrant;
	}

	public int getBugsOnFirstQuadrant() {
		return bugsOnFirstQuadrant;
	}

	public int getBugsOnSecondQuadrant() {
		return bugsOnSecondQuadrant;
	}

	public int getBugsOnThirdQuadrant() {
		return bugsOnThirdQuadrant;
	}

	public int getBugsOnFourthQuadrant() {
		return bugsOnFourthQuadrant;
	}

	public void setDevelopersOnFirstQuadrant(int developersOnFirstQuadrant) {
		this.developersOnFirstQuadrant = developersOnFirstQuadrant;
	}

	public void setDevelopersOnSecondQuadrant(int developersOnSecondQuadrant) {
		this.developersOnSecondQuadrant = developersOnSecondQuadrant;
	}

	public void setDevelopersOnThirdQuadrant(int developersOnThirdQuadrant) {
		this.developersOnThirdQuadrant = developersOnThirdQuadrant;
	}

	public void setDevelopersOnFourthQuadrant(int developersOnFourthQuadrant) {
		this.developersOnFourthQuadrant = developersOnFourthQuadrant;
	}

	public void setBugsOnFirstQuadrant(int bugsOnFirstQuadrant) {
		this.bugsOnFirstQuadrant = bugsOnFirstQuadrant;
	}

	public void setBugsOnSecondQuadrant(int bugsOnSecondQuadrant) {
		this.bugsOnSecondQuadrant = bugsOnSecondQuadrant;
	}

	public void setBugsOnThirdQuadrant(int bugsOnThirdQuadrant) {
		this.bugsOnThirdQuadrant = bugsOnThirdQuadrant;
	}

	public void setBugsOnFourthQuadrant(int bugsOnFourthQuadrant) {
		this.bugsOnFourthQuadrant = bugsOnFourthQuadrant;
	}
}
