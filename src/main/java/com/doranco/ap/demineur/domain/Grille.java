package com.doranco.ap.demineur.domain;

import java.util.Random;

public class Grille {
	private static Grille instance;

    private static int taille;
    private int nombreMines;
    private boolean[][] mines;
    private Cellule[][] grille;
    private static boolean[][] revealedCells;
	
	private Grille(int taille, int nombreMines) {
		this.setTaille(taille);
		this.nombreMines = nombreMines;
		this.mines = new boolean[taille][taille];
        this.revealedCells = new boolean[taille][taille];
		generate();
	}
	
	public static Grille getInstance(int taille, int nbBombe) {
		if (instance == null ) {
			instance = new Grille(taille,nbBombe);
		}
		return instance;
	}
	
	public void setNombreMines(int nbM) {
		this.nombreMines = nbM;
		generate();
	}
	
	public int getNombreMines() {
		return nombreMines;
	}
	
	public void setTaille(int t) {
		taille = t;
	}
	
	public static int getTaille() {
		return taille;
	}
	
	private void generate() {

        for (int row = 0; row < taille; row++) {
            for (int col = 0; col < taille; col++) {
                grille[row][col] = new Cellule();
            }
        }
		
		Random random = new Random();
	
	    int minesPlaced = 0;
	    while (minesPlaced < nombreMines) {
	        int row = random.nextInt(taille);
	        int col = random.nextInt(taille);
	
	        // Placez une mine dans la cellule s'il n'y en a pas déjà une
	        if (!grille[row][col].hasMine()) {
	            grille[row][col].setMine(true);
	            minesPlaced++;
	        }
	    }
	}
	
	
	
	public void revealCell(int x, int y) {
        grille[x][y].setRevealed(true);
	}
	
	public static boolean isCellRevealed(int x, int y) {
        return revealedCells[x][y];
	}
	
	

	public static int getCellInfo(int row, int col) {
		// TODO Auto-generated method stub
		return 0;
	}
}
