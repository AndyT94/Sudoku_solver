package sudoku;

import java.awt.*;
import javax.swing.*;

public class Frame {
	private ButtonPanel buttonPanel;
	private GridPanel gridPanel;
	private OneNumberBox[][] nbrField;
	private Sudoku sud;

	/**
	 * Skapar ett JFrame-objekt som innehåller en panel för knappar och en panel
	 * för textrutor.
	 */
	public Frame() {
		nbrField = new OneNumberBox[9][9];
		sud = new Sudoku();

		JFrame frame = new JFrame("Sudoku");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		buttonPanel = new ButtonPanel(this);
		frame.add(buttonPanel, BorderLayout.SOUTH);

		gridPanel = new GridPanel(this);
		frame.add(gridPanel, BorderLayout.CENTER);

		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Returnerar matrisen som innehåller textrutorna.
	 * 
	 * @return matrisen med textrutor
	 */
	public OneNumberBox[][] getNumberBox() {
		return nbrField;
	}

	/**
	 * Returnerar sudokut.
	 * 
	 * @return sudokut
	 */
	public Sudoku getSudoku() {
		return sud;
	}

	public static void main(String[] args) {
		new Frame();
	}
}
