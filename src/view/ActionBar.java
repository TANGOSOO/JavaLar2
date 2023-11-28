package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

import controller.JavaLarSystemController;

public class ActionBar extends JPanel implements ActionListener{
	
	private Map map;
	private JavaLarSystemController system;
	private int cheatCode=0;
	private boolean insertedFile=false;
	private boolean dataReaded=false;
	private boolean endGame=false;
	private Clip music;
	private ImageIcon icon1=new ImageIcon(getClass().getResource("/images/button1.jpg"));
	private ImageIcon icon2=new ImageIcon(getClass().getResource("/images/button2.jpg"));
	private ImageIcon icon3=new ImageIcon(getClass().getResource("/images/button3.jpg"));
	private ImageIcon icon4=new ImageIcon(getClass().getResource("/images/button4.jpg"));
	private ImageIcon icon5=new ImageIcon(getClass().getResource("/images/button5.jpg"));
	
	public ActionBar(Map mapa) {
		this.map=mapa;
		this.system=new JavaLarSystemController();
		music=musicPlayer();
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(1980, 180));
		add(createButton(icon1, "PROCESS NEXT INSTANT", 1));
		add(createButton(icon2,"READ NEW INPUT FILE", 2));
		add(createButton(icon3,"RECORD REPORT", 3));
		add(createButton(icon4,"<html>READ OTHERS PARTICIPANTS<br/DATA</html>", 4));
		add(createButton(icon5,"WRITE OUTPUT FILE", 5));
		organizer();
	}
	
	private void organizer() {
		
		FlowLayout flow=new FlowLayout();
		flow.setHgap(25);
		flow.setVgap(25);
		setLayout(flow);
	}
	
	private JButton createButton(ImageIcon icon, String nome, int id) {
		
		BottomButtons button=new BottomButtons(icon, nome, id);
		button.addActionListener(this);
		return button;
	}
	
	private void buttonSound() {
		File musicPath=new File("C://Users//gabri//OneDrive//Área de Trabalho//JavaLar 2 arquivos//Musica//ButtonSound3.wav");
		try {
			AudioInputStream audio=AudioSystem.getAudioInputStream(musicPath);
			Clip clip=AudioSystem.getClip();
			clip.open(audio);
			clip.start();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private Clip musicPlayer() {      

		File musicPath=new File("C://Users//gabri//OneDrive//Área de Trabalho//JavaLar 2 arquivos//Musica//Hino2.wav");
		try {
			AudioInputStream audio=AudioSystem.getAudioInputStream(musicPath);
			Clip clip=AudioSystem.getClip();
			clip.open(audio);
			clip.start();
			clip.loop(100);
			return clip;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		BottomButtons b=(BottomButtons) e.getSource();
		buttonSound();
		
		if(b.getId()!=1) {
			cheatCode=0;
		}
		
		if(b.getId()==1) {
			if(insertedFile==true) {
				if(system.getMemory().getAtualLine()<=system.getMemory().getFileWithData().getNumberOfLines() && endGame==false) {
					ArrayList<Cell> ac=map.getArrayCells();
					system.translatePlanets();
					system.rotatePlanets();
					system.generateBugsAndDevs();
					system.verifyColision();
					for (Cell celula : ac) {
						celula.UpdateCell(system);
					}
					endGame=system.verifyEndGame();
					if(endGame==true) {
						JLabel l=new JLabel("All planets exploded! End of the game!");
						l.setForeground(Color.white);
						JOptionPane.showMessageDialog(null, l, null, JOptionPane.WARNING_MESSAGE);
					}
				}else {
					JLabel l=new JLabel("End of the game");
					l.setForeground(Color.white);
					JOptionPane.showMessageDialog(null, l, null, JOptionPane.WARNING_MESSAGE);
				}
			}else {
				cheatCode++;
				JLabel l=new JLabel("No file inserted");
				l.setForeground(Color.WHITE);
				JOptionPane.showMessageDialog(null, l, null, JOptionPane.WARNING_MESSAGE);
			}
		}else if(b.getId()==2) {
			system=new JavaLarSystemController();
			endGame=false;
			for (Cell cell : map.getArrayCells()) {
				cell.UpdateCell(system);
			}
			FileDialog fd = new FileDialog(new JFrame());
			fd.setVisible(true);
			File[] f = fd.getFiles();
			if(f.length > 0){
			    String filePath=fd.getFiles()[0].getAbsolutePath();
			    insertedFile=true;
				system.readNewFile(filePath);
			}
		}else if(b.getId()==3) {
			JLabel l=new JLabel("Report Recorded successfully");
			l.setForeground(Color.white);
			system.updateBugsAndDevelopersPerQuadrant();
			system.recordReport();
			JOptionPane.showMessageDialog(null, l);
		}else if(b.getId()==4) {
			JLabel l=new JLabel("Data read successfully");
			l.setForeground(Color.white);
			system.getDatabaseData();
			JOptionPane.showMessageDialog(null, l);
			dataReaded=true;
		}else if(b.getId()==5) {
			if(dataReaded==true) {
				JLabel l=new JLabel("Output file generated successfully");
				l.setForeground(Color.white);
				system.writeOutputFile();
				JOptionPane.showMessageDialog(null, l);
			}else {
				JLabel l=new JLabel("Without data in the Memory");
				l.setForeground(Color.white);
				JOptionPane.showMessageDialog(null, l, null, JOptionPane.WARNING_MESSAGE);
			}
		}
		
		if(cheatCode==3) {
			music.stop();
			cheat();
			music=musicPlayer();
		}
	}

	private void cheat() {
		JLabel l=new JLabel("Quantos pontos adicionar ao Cruzeiro?");
		l.setForeground(Color.white);
		JOptionPane.showInputDialog(l, l, null, JOptionPane.WARNING_MESSAGE);
		
	}
}
