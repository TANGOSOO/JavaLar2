package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import controller.FileReaded;

public class LocalFileReader {
	
	public FileReaded readFile(String filePath) {
		try {
			FileReader file = new FileReader(filePath);
			BufferedReader reader = new BufferedReader(file);
			ArrayList<String> lines=new ArrayList<String>();
			int numberOfLines=-1;
			try {
				while (reader.ready()) {
					lines.add(reader.readLine());
					numberOfLines++;
				}
				if(numberOfLines==49) {
					numberOfLines++;
				}
				reader.close();
				FileReaded fileReaded=new FileReaded(numberOfLines, "AE_" + numberOfLines +".csv", lines);
				return fileReaded;
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		FileReaded fileReaded=new FileReaded();
		return fileReaded;
	}
	
	public void writeOutputFile(String fileString) {
		DateTimeFormatter format=DateTimeFormatter.ofPattern("yyyy.MM.dd HH.mm.ss"); 
		LocalDateTime now=LocalDateTime.now();
		String filePath="C://Users//gabri//OneDrive//Área de Trabalho//JavaLar 2 arquivos//Output File//" + format.format(now) + ".txt";
		try {
			FileWriter writer=new FileWriter(filePath);
			writer.write(fileString);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
