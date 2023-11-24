package com.doranco.ap.demineur;

import java.awt.Canvas;
import java.awt.Container;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.doranco.ap.demineur.domain.World;

@SpringBootApplication
public class Application extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public World world = new World();
	
	public Application() {
		//Simulation simulation = new Simulation();
		//simulation.fill(world);
		
		setTitle("Démineur A.Plasse");
		Container body = getContentPane();
		JButton btn = new JButton("Next");
		Canvas canvas = new Canvas();
		
		body.setLayout(new BoxLayout(body, BoxLayout.Y_AXIS));
		body.add(canvas);
		body.add(Box.createVerticalStrut(10));
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		//TODO Body
		//TODO Layout
		
		//TODO les cases
		//TODO 
		
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
