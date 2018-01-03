package sudoku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class SolveButton extends JButton implements ActionListener {
	private Frame frame;

	/**
	 * Skapar en knapp med texten "Solve".
	 * 
	 * @param frame
	 *            användargränssnittet
	 */
	public SolveButton(Frame frame) {
		super("Solve");
		this.frame = frame;
		addActionListener(this);
	}

	/**
	 * Konverterar String-elementen i matrisen med textrutorna till Integer,
	 * lägger in de i sudoku-objektet, löser pusslet (om möjligt) och sedan
	 * konverterar Integer-objekten i sudokut till String-element och lägger
	 * tillbaks de i textrutorna.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Sudoku sud = frame.getSudoku();
		OneNumberBox[][] nbrField = frame.getNumberBox();

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				try {
					sud.setNumber(Integer.valueOf(nbrField[i][j].getText()), i,
							j);
				} catch (NumberFormatException ex) {
					sud.setNumber(0, i, j);
				}
			}
		}
		if (sud.solve()) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					nbrField[i][j]
							.setText(Integer.toString(sud.getNumber(i, j)));
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "No Solution", "Wrong Input",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
