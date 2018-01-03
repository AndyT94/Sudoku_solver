package sudoku;

import java.awt.FlowLayout;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {

	/**
	 * Skapar en panel med knappar i anv�ndargr�nssnittet frame.
	 * 
	 * @param frame
	 *            anv�ndargr�nssnittet
	 */
	public ButtonPanel(Frame frame) {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(new ClearButton(frame));
		add(new SolveButton(frame));
	}
}
