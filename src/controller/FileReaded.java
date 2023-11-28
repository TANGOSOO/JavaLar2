package controller;

import java.util.ArrayList;

public class FileReaded {
	
	int numberOfLines;
	String name;
	ArrayList<String> lines;
	
	public FileReaded(int numberOfLines, String name, ArrayList<String> string) {
		this.numberOfLines=numberOfLines;
		this.name=name;
		this.lines=string;
	}
	
	public FileReaded(String name) {
		this.name=name;
	}
	
	public FileReaded() {
		
	}

	public int getNumberOfLines() {
		return numberOfLines;
	}

	public String getName() {
		return name;
	}

	public ArrayList<String> getLines() {
		return lines;
	}

	public void setNumberOfLines(int numberOfLines) {
		this.numberOfLines = numberOfLines;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLines(ArrayList<String> lines) {
		this.lines = lines;
	}
	
	 
}
