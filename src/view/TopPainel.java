package view;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

public class TopPainel extends JPanel{

	ImageIcon backgroundImage = new ImageIcon(getClass().getResource("/images/Background.png"));
	Map map;
	
	public TopPainel() {
		JLabel background=new JLabel(backgroundImage);
		background.setAlignmentX(CENTER_ALIGNMENT);
		
		map=new Map();
		
		setPreferredSize(new Dimension(1980, 900));
		setLayout(new OverlayLayout(this));
		add(map);
		add(background);
	}

	public Map getMap() {
		return map;
	}
	
	public void setMap(Map mapa) {
		this.map = mapa;
	}
}
