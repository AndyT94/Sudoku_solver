package sudoku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class ClearButton extends JButton implements ActionListener {
	private Frame frame;

	/**
	 * Skapar en knapp med texten "Clear".
	 * 
	 * @param frame
	 *            användargränssnittet
	 */
	public ClearButton(Frame frame) {
		super("Clear");
		this.frame = frame;
		addActionListener(this);
	}

	/**
	 * Går igenom matrisen med textrutor och nollställer dem.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		OneNumberBox[][] nbrField = frame.getNumberBox();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				nbrField[i][j].setText("");
			}
		}
	}
}
