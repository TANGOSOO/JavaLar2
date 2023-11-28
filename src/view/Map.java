package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Map extends JPanel{
	
	private ArrayList<Cell> arrayCells=new ArrayList<Cell>();
	
	public Map() {
		setMaximumSize(new Dimension(896, 896));
		setBackground(Color.DARK_GRAY);
		Organizador();
		CellCreator();
	}
	
	private void Organizador() {
		GridLayout grid=new GridLayout(15,15);
		grid.setVgap(2);
		grid.setHgap(2);
		setLayout(grid);
	}
	
	private void CellCreator() {
		int x=1;
		int y=15;
		for(int i=0; i<225; i++) {
			Cell c=new Cell(x, y);
			arrayCells.add(c);
			add(c);
			x++;
			if(x==16) {
				x=1;
				y--;
			}
		}
	}

	public ArrayList<Cell> getArrayCells() {
		return arrayCells;
	}

	public void setArrayCells(ArrayList<Cell> arrayCells) {
		this.arrayCells = arrayCells;
	}

}
