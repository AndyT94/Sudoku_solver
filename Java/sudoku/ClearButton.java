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
	 *            anv�ndargr�nssnittet
	 */
	public ClearButton(Frame frame) {
		super("Clear");
		this.frame = frame;
		addActionListener(this);
	}

	/**
	 * G�r igenom matrisen med textrutor och nollst�ller dem.
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
