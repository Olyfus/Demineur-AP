package com.doranco.ap.demineur.domain;

import com.doranco.ap.demineur.tools.Dice;

public class World {
	public static final int SIZE = 129;
	
	public final Cellules[][] map = new Cellules[SIZE][SIZE];
	public static final int BOMB = 32;
	public final Dice dice;
	
	public World() {
		this.dice = Dice.getInstance();
		generate();
	}
	
	
	private void generate() {
		
	}
	
}
