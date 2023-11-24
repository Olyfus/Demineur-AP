package com.doranco.ap.demineur.tools;

//import java.util.Random;

// Singleton Dice
public class Dice {
	private static Dice instance = null;
	//private Random random;
	
	private Dice() {
		// String seed = System.getenv("SEED");
		// random = new Random();
	}
	
	public boolean random() {
		return Math.random() < 0.5;
	}
	
	public int random(int range) {
		return (int)(Math.random()*range);
	}
	
	public int random1To(int range) {
		return 1 + random(range);
	}
	
	public int random(int min, int max) {
		return min + (int)(Math.random()*(max-min+1));
	}
	
    public float pct() {
        return (float) Math.random()*100f;
    }
    

    // Singleton init
    public static Dice getInstance() {
    	if (instance == null) {
    		instance = new Dice();
    	}
    	return instance;
    }
}
