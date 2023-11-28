package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.FileReaded;
import controller.JavaLarSystemController;
import controller.Planets;
import controller.Student;
import controller.planetsdata.*;

public class JavaLarDAO {
	
	public void insertData(JavaLarSystemController javalar) {
		try {
			Connection con=new Conn().getConnection();
			PreparedStatement insert= con.prepareStatement("insert into javalar "
					+ "(nome, matricula, nome_arquivo, bug_python, bug_javascript, bug_ruby, bug_php, bug_csharp, "
					+ "bug_cmais, bug_c, dev_python, dev_javascript, dev_ruby, dev_php, dev_csharp,"
					+ "dev_cmais, dev_c, v_python, v_javascript, v_ruby, v_php, v_csharp, v_cmais, v_c, "
					+ "d_python, d_javascript, d_ruby, d_php, d_csharp, d_cmais, d_c, "
					+ "a_python, a_javascript, a_ruby, a_php, a_csharp, a_cmais, a_c, "
					+ "bug_q1, bug_q2, bug_q3, bug_q4, dev_q1, dev_q2, dev_q3, dev_q4) "
					+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			insert.setString(1, javalar.getMemory().getStudent().getName());
			insert.setString(2, javalar.getMemory().getStudent().getRegistration() + "");
			insert.setString(3, javalar.getMemory().getFileWithData().getName());
			int i=4;
			for (Planets plan : javalar.getMemory().getPlanets()) {
				if(plan.getName().equals("Java")==false) {
					insert.setInt(i, plan.getBugsCollided());
					i++;
				}
			}
			for (Planets plan : javalar.getMemory().getPlanets()) {
				if(plan.getName().equals("Java")==false) {
					insert.setInt(i, plan.getDevelopersCollided());
					i++;
				}
			}
			for (Planets plan : javalar.getMemory().getPlanets()) {
				if(plan.getName().equals("Java")==false) {
					insert.setInt(i, (int) plan.getTranslationSpeed());
					i++;
				}
			}
			for (Planets plan : javalar.getMemory().getPlanets()) {
				if(plan.getName().equals("Java")==false) {
					insert.setInt(i, (int) plan.getTotalRotation());
					i++;
				}
			}
			for (Planets plan : javalar.getMemory().getPlanets()) {
				if(plan.getName().equals("Java")==false) {
					insert.setInt(i, plan.getTotalYears());
					i++;
				}
			}
			insert.setInt(39, javalar.getMemory().getBugsOnFirstQuadrant());
			insert.setInt(40, javalar.getMemory().getBugsOnSecondQuadrant());
			insert.setInt(41, javalar.getMemory().getBugsOnThirdQuadrant());
			insert.setInt(42, javalar.getMemory().getBugsOnFourthQuadrant());
			insert.setInt(43, javalar.getMemory().getDevelopersOnFirstQuadrant());
			insert.setInt(44, javalar.getMemory().getDevelopersOnSecondQuadrant());
			insert.setInt(45, javalar.getMemory().getDevelopersOnThirdQuadrant());
			insert.setInt(46, javalar.getMemory().getDevelopersOnFourthQuadrant());
			
			insert.executeUpdate();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public DatabaseData getDatabaseData() {
		DatabaseData databaseData=new DatabaseData();
		try {
			Connection con=new Conn().getConnection();
			ResultSet data= con.prepareStatement("select * from javalar").executeQuery();
			
			while(data.next()) {
				Student student=new Student(data.getString("nome"), data.getInt("matricula"));
				databaseData.getStudentsData().add(student);
				FileReaded fileReaded=new FileReaded(data.getString("nome_arquivo"));
				databaseData.getFileReadedData().add(fileReaded);
				ArrayList<PlanetsData> planets=new ArrayList<PlanetsData>();
				PlanetsData python=new PlanetsData("Python", data.getInt("bug_python"), data.getInt("dev_python"), data.getInt("v_python"), data.getInt("d_python"), data.getInt("a_python"));
				PlanetsData javaScript=new PlanetsData("JavaScript", data.getInt("bug_javascript"), data.getInt("dev_javascript"), data.getInt("v_javascript"), data.getInt("d_javascript"), data.getInt("a_javascript"));
				PlanetsData rubyOnRails=new PlanetsData("RubyOnRails", data.getInt("bug_ruby"), data.getInt("dev_ruby"), data.getInt("v_ruby"), data.getInt("d_ruby"), data.getInt("a_ruby"));
				PlanetsData php=new PlanetsData("PHP", data.getInt("bug_php"), data.getInt("dev_php"), data.getInt("v_php"), data.getInt("d_php"), data.getInt("a_php"));
				PlanetsData cSharp=new PlanetsData("C#", data.getInt("bug_csharp"), data.getInt("dev_csharp"), data.getInt("v_csharp"), data.getInt("d_csharp"), data.getInt("a_csharp"));
				PlanetsData cpp=new PlanetsData("C++", data.getInt("bug_cmais"), data.getInt("dev_cmais"), data.getInt("v_cmais"), data.getInt("d_cmais"), data.getInt("a_cmais"));
				PlanetsData c=new PlanetsData("C", data.getInt("bug_c"), data.getInt("dev_c"), data.getInt("v_c"), data.getInt("d_c"), data.getInt("a_c"));
				planets.add(python);
				planets.add(javaScript);
				planets.add(rubyOnRails);
				planets.add(php);
				planets.add(cSharp);
				planets.add(cpp);
				planets.add(c);
				databaseData.getPlanetsData().add(planets);
				BugsPerQuadrant bugsQuadrant=new BugsPerQuadrant(data.getInt("bug_q1"), data.getInt("bug_q2"), data.getInt("bug_q3"), data.getInt("bug_q4"));
				DevelopersPerQuadrant developersQuadrant=new DevelopersPerQuadrant(data.getInt("dev_q1"), data.getInt("dev_q2"), data.getInt("dev_q3"), data.getInt("dev_q4"));
				databaseData.getBugsPerQuadrant().add(bugsQuadrant);
				databaseData.getDevelopersPerQuadrant().add(developersQuadrant);
			}
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return databaseData;
	}
}
