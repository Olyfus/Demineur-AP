package com.doranco.ap.demineur;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.doranco.ap.demineur.domain.Grille;

@SpringBootApplication
public class Application extends JFrame {
	private Logger LOGGER = LoggerFactory.getLogger(Application.class);
	private static final long serialVersionUID = 1L;
	public final static int DIM = 16;	

    private Grille grille;
    private JButton[][] buttons;
	
	public Application(int taille, int nbMines) {
        this.grille = Grille.getInstance(taille, nbMines);
        generate(taille);
	}
	
	 private void generate(int taille) {
		setTitle("Démineur A.Plasse");
		Container body = getContentPane();
		body.setLayout(new GridLayout(DIM,DIM));
		buttons = new JButton[Grille.getTaille()][Grille.getTaille()];
		for (int i=1; i<DIM; i++)
			for (int j=1; j<DIM; j++)
			{
				final int lig = i;
				final int col = j;
				JButton btn = addButton(i,j);
				btn.setPreferredSize(new Dimension(taille, taille));
				btn.setAlignmentX(JButton.CENTER_ALIGNMENT);
				btn.addActionListener((x) -> onClick(lig,col));
				btn.setContentAreaFilled(false);
				btn.setFocusPainted(false);
				body.add(btn);				
			}

		
		body.add(Box.createVerticalStrut(10));
		pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        // Initialiser le tableau de boutons
        buttons = new JButton[Grille.getTaille()][Grille.getTaille()];
        
        for (int row = 0; row < Grille.getTaille(); row++) {
            for (int col = 0; col < Grille.getTaille(); col++) {
                addButton(row, col);
            }
        }
        
        // Autres composants et configurations...

    }
	 
	
	public void onClick(int i, int j)
	{
		LOGGER.info("Clic %d,%d".formatted(i,j));
	}
	
    private JButton addButton(int row, int col) {
        JButton button = new JButton();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleButtonClick(row, col);
            }
        });
        buttons[row][col] = button;
        return button;
    }
    
    
    private void update() {
        for (int row = 0; row < Grille.getTaille(); row++) {
            for (int col = 0; col < Grille.getTaille(); col++) {
                JButton button = buttons[row][col];
                if (Grille.isCellRevealed(row, col)) {
                    button.setText(Integer.toString(Grille.getCellInfo(row, col)));
                } else {
                    button.setText("");
                }
                button.setEnabled(!Grille.isCellRevealed(row, col)); 
            }
        }
    }
    
    private void handleButtonClick(int row, int col) {
        grille.revealCell(row, col);
        update();

    }
    
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
