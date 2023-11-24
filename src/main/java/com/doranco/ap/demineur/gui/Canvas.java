package com.doranco.ap.demineur.gui;

import javax.swing.JPanel;

import com.doranco.ap.demineur.domain.World;

public class Canvas extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public static final int DIM = 129;
	public static final int CELL = 4;
	public static final int MARGIN = 10;
	
	private long seed;
	
	public Canvas(World world) {
		int size = world.SIZE * CELL * + 2 * MARGIN;
	}
	
}
