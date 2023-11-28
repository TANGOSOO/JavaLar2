package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.TargetDataLine;
import javax.swing.JFrame;
import javax.swing.UIManager;

public class MainWindow extends JFrame {

	static {
		try {
			String str = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
			UIManager.setLookAndFeel(str);
			UIManager.put("nimbusBase", Color.BLACK);
			UIManager.put("control", Color.BLACK);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public MainWindow() {

		Organizer();
		setSize(1920, 1080);
		setUndecorated(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void Organizer() {
		setLayout(new BorderLayout());

		TopPainel panel = new TopPainel();
		ActionBar bottomBar = new ActionBar(panel.getMap());

		add(panel, BorderLayout.NORTH);
		add(bottomBar, BorderLayout.SOUTH);
	}
}
