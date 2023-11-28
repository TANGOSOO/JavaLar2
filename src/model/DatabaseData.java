package model;

import java.util.ArrayList;

import controller.FileReaded;
import controller.Student;
import controller.planetsdata.BugsPerQuadrant;
import controller.planetsdata.DevelopersPerQuadrant;
import controller.planetsdata.PlanetsData;

public class DatabaseData {

	ArrayList<Student> studentsData=new ArrayList<Student>();
	ArrayList<FileReaded> fileReadedData=new ArrayList<FileReaded>();
	ArrayList<ArrayList<PlanetsData>> planetsData=new ArrayList<ArrayList<PlanetsData>>();
	ArrayList<BugsPerQuadrant> bugsPerQuadrant=new ArrayList<BugsPerQuadrant>();
	ArrayList<DevelopersPerQuadrant> developersPerQuadrant=new ArrayList<DevelopersPerQuadrant>();
	
	public ArrayList<Student> getStudentsData() {
		return studentsData;
	}
	public ArrayList<FileReaded> getFileReadedData() {
		return fileReadedData;
	}
	public void setStudentsData(ArrayList<Student> studentsData) {
		this.studentsData = studentsData;
	}
	public void setFileReadedData(ArrayList<FileReaded> fileReadedData) {
		this.fileReadedData = fileReadedData;
	}
	public ArrayList<ArrayList<PlanetsData>> getPlanetsData() {
		return planetsData;
	}
	public void setPlanetsData(ArrayList<ArrayList<PlanetsData>> planetsData) {
		this.planetsData = planetsData;
	}
	public ArrayList<BugsPerQuadrant> getBugsPerQuadrant() {
		return bugsPerQuadrant;
	}
	public ArrayList<DevelopersPerQuadrant> getDevelopersPerQuadrant() {
		return developersPerQuadrant;
	}
	public void setBugsPerQuadrant(ArrayList<BugsPerQuadrant> bugsPerQuadrant) {
		this.bugsPerQuadrant = bugsPerQuadrant;
	}
	public void setDevelopersPerQuadrant(ArrayList<DevelopersPerQuadrant> developersPerQuadrant) {
		this.developersPerQuadrant = developersPerQuadrant;
	}
}
