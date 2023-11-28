package controller;

import java.util.ArrayList;
import java.util.Collections;

import controller.planetsdata.BugsPerQuadrant;
import controller.planetsdata.DevelopersPerQuadrant;
import controller.planetsdata.PlanetsData;

public class OutputFileGetInfo {

	private char lineBreaker=(char) 13;
	
	public String getMostFrequentStudent(ArrayList<Student> studentArrayList){
		String nameAndReg="";
		int freq=0;
		
		for (Student student : studentArrayList) {
			if((Collections.frequency(studentArrayList, student)>freq)) {
				freq=(Collections.frequency(studentArrayList, student));
				nameAndReg="";
				nameAndReg+="The student with the most moments was: " + student.getName() + " - " + student.getRegistration() + lineBreaker;
				nameAndReg+="With: " + freq + " moments registered" + lineBreaker + lineBreaker;
			}
		}
		return nameAndReg;
	}
	
	public String getMostExplodedAndMoreLifePlanet(ArrayList<ArrayList<PlanetsData>> planetsArrayList) {
		String planetsEA="";
		int python=0;
		int javaScript=0;
		int rubyOnRails=0;
		int php=0;
		int csharp=0;
		int cpp=0;
		int c=0;
		
		for (ArrayList<PlanetsData> planetsArray : planetsArrayList) {
			for (PlanetsData planets : planetsArray) {
				if(planets.getName().equals("Python")) {
					python+=planets.isAlive();
				}else if(planets.getName().equals("JavaScript")) {
					javaScript+=planets.isAlive();
				}else if(planets.getName().equals("RubyOnRails")) {
					rubyOnRails+=planets.isAlive();
				}else if(planets.getName().equals("PHP")) {
					php+=planets.isAlive();
				}else if(planets.getName().equals("C#")) {
					csharp+=planets.isAlive();
				}else if(planets.getName().equals("C++")) {
					cpp+=planets.isAlive();
				}else if(planets.getName().equals("C")) {
					c+=planets.isAlive();
				}
			}
		}
		
//		System.out.println(python + " " + javaScript + " " + rubyOnRails + " " + php+ " " + csharp + " "+cpp + " "+ c);
		
		planetsEA+="The planet that exploded the most: ";
		if(python>javaScript && python>rubyOnRails && python>php && python>csharp && python>cpp && python>c) {
			planetsEA+="Python";
		}else if(javaScript>rubyOnRails && javaScript>php && javaScript>csharp && javaScript>cpp && javaScript>c) {
			planetsEA+="JavaScript";
		}else if(rubyOnRails>php && rubyOnRails>csharp && rubyOnRails>cpp && rubyOnRails>c) {
			planetsEA+="RubyOnRails";
		}else if(php>csharp && php>cpp && php>c) {
			planetsEA+="PHP";
		}else if(csharp>cpp && csharp>c) {
			planetsEA+="C#";
		}else if(cpp>c) {
			planetsEA+="C++";
		}else {
			planetsEA+="C";
		}
		
		planetsEA+=lineBreaker + "And the planet that rested with more life was: ";
		if(python<javaScript && python<rubyOnRails && python<php && python<csharp && python<cpp && python<c) {
			planetsEA+="Python";
		}else if(javaScript<rubyOnRails && javaScript<php && javaScript<csharp && javaScript<cpp && javaScript<c) {
			planetsEA+="JavaScript";
		}else if(rubyOnRails<php && rubyOnRails<csharp && rubyOnRails<cpp && rubyOnRails<c) {
			planetsEA+="RubyOnRails";
		}else if(php<csharp && php<cpp && php<c) {
			planetsEA+="PHP";
		}else if(csharp<cpp && csharp<c) {
			planetsEA+="C#";
		}else if(cpp<c) {
			planetsEA+="C++";
		}else {
			planetsEA+="C";
		}
		
		planetsEA+="" + lineBreaker + lineBreaker;
		return planetsEA;
	}
	
	public String concentrationOfBugsAndDevelopers(ArrayList<BugsPerQuadrant> bugsQuadrant, ArrayList<DevelopersPerQuadrant> developersQuadrant){
		String concentration="";
		int bq1=0;
		int bq2=0;
		int bq3=0;
		int bq4=0;
		int dq1=0;
		int dq2=0;
		int dq3=0;
		int dq4=0;
		
		for (BugsPerQuadrant bugs : bugsQuadrant) {
			if(bugs.getQ1()>bugs.getQ2() && bugs.getQ1()>bugs.getQ3() && bugs.getQ1()>bugs.getQ4()) {
				bq1++;
			}else if(bugs.getQ2()>bugs.getQ3() && bugs.getQ2()>bugs.getQ4()) {
				bq2++;
			}else if(bugs.getQ3()>bugs.getQ4()) {
				bq3++;
			}else {
				bq4++;
			}
		}
		
		for (DevelopersPerQuadrant devs : developersQuadrant) {
			if(devs.getQ1()>devs.getQ2() && devs.getQ1()>devs.getQ3() && devs.getQ1()>devs.getQ4()) {
				dq1++;
			}else if(devs.getQ2()>devs.getQ3() && devs.getQ2()>devs.getQ4()) {
				dq2++;
			}else if(devs.getQ3()>devs.getQ4()) {
				dq3++;
			}else {
				dq4++;
			}
		}
		
		concentration+="The quadrant with more bugs was: ";
		if(bq1>bq2 && bq1>bq3 && bq1>bq4) {
			concentration+="q1";
		}else if(bq2>bq3 && bq3>bq4) {
			concentration+="q2";
		}else if(bq3>bq4) {
			concentration+="q3";
		}else {
			concentration+="q4";
		}
		
		concentration+=lineBreaker + "And the most number of developers was: ";
		if(dq1>dq2 && dq1>dq3 && dq1>dq4) {
			concentration+="q1";
		}else if(dq2>dq3 && dq3>dq4) {
			concentration+="q2";
		}else if(dq3>dq4) {
			concentration+="q3";
		}else {
			concentration+="q4";
		}
		
		concentration+="" + lineBreaker + lineBreaker;
		return concentration;
	}
	
	public String totalMoments(ArrayList<Student> students) {
		return "In total were recorded: " + students.size() + " moments" + lineBreaker + lineBreaker;
	}
	
	public String planetSpeed(ArrayList<ArrayList<PlanetsData>> planetsArrayList, int i) {
		String planetsSpeed="";
		double python=0;
		double javaScript=0;
		double php=0;
		double rubyOnRails=0;
		double csharp=0;
		double cpp=0;
		double c=0;
		
		for (ArrayList<PlanetsData> planetsArray : planetsArrayList) {
			for (PlanetsData planets : planetsArray) {
				if(planets.getName().equals("Python")) {
					python+=planets.getSpeed();
				}else if(planets.getName().equals("JavaScript")) {
					javaScript+=planets.getSpeed();
				}else if(planets.getName().equals("RubyOnRails")) {
					rubyOnRails+=planets.getSpeed();
				}else if(planets.getName().equals("PHP")) {
					php+=planets.getSpeed();
				}else if(planets.getName().equals("C#")) {
					csharp+=planets.getSpeed();
				}else if(planets.getName().equals("C++")) {
					cpp+=planets.getSpeed();
				}else if(planets.getName().equals("C")) {
					c+=planets.getSpeed();
				}
			}
		}
		
		planetsSpeed+="Avarege speed of the planets:" + lineBreaker + "Python: " + python/i + lineBreaker + "JavaScript: " + javaScript/i + 
				lineBreaker + "RubyOnRails: " + rubyOnRails/i + lineBreaker + "PHP: " + php/i + 
				lineBreaker + "C#: " + csharp/i + lineBreaker + "C++: " + cpp/i + lineBreaker + "C: " + c/i + lineBreaker + lineBreaker;
		return planetsSpeed;
	}

	public String bugsAndDevelopersOccurred(ArrayList<BugsPerQuadrant> bugsPerQuadrant,
			ArrayList<DevelopersPerQuadrant> developersPerQuadrant) {
		String bugsAndDevs="";
		int bugs=0;
		int devs=0;
		
		for (BugsPerQuadrant bugsQuadrant : bugsPerQuadrant) {
			bugs+=bugsQuadrant.getQ1();
			bugs+=bugsQuadrant.getQ2();
			bugs+=bugsQuadrant.getQ3();
			bugs+=bugsQuadrant.getQ4();
		}
		
		for (DevelopersPerQuadrant devsQuadrant : developersPerQuadrant) {
			devs+=devsQuadrant.getQ1();
			devs+=devsQuadrant.getQ2();
			devs+=devsQuadrant.getQ3();
			devs+=devsQuadrant.getQ4();
		}
		bugsAndDevs+="Total number of bugs: " + bugs + lineBreaker + "Total number of Developers: " + devs + lineBreaker + lineBreaker;
		
		return bugsAndDevs;
	}

	public String totalHoursAndYears(ArrayList<ArrayList<PlanetsData>> planetsArrayList) {
		String hoursAndDays="";
		int hours=0;
		int years=0;
		for (ArrayList<PlanetsData> planetsArray : planetsArrayList) {
			for (PlanetsData planets : planetsArray) {
				hours+=planets.getDays();
				years+=planets.getYears();
			}
		}
		hoursAndDays+="Total hours spent on all planets: " + hours + lineBreaker + "Total years spent on all planets: " + years;
		return hoursAndDays;
	}
}














