package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BottomButtons extends JButton implements MouseListener{
	
	private int id;
	
	public BottomButtons(ImageIcon icon, String name, int id) {
		this.id=id;
		setName(name);
		setText(name);
		setIcon(icon);
		setHorizontalTextPosition(SwingConstants.CENTER);
		setFocusable(false);
		setPreferredSize(new Dimension(350, 100));
		setOpaque(true);
		setForeground(Color.WHITE);
		setFont(new Font("arial", Font.BOLD, 20));
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		addMouseListener(this);
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
		setSize(365, 115);
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
		setSize(350, 100);
	}
}
