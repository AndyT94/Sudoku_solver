package sudoku;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class GridPanel extends JPanel {

	/**
	 * Skapar en panel i användargränssnittet frame och sedan skapar 9x9 textrutor i
	 * panelen.
	 * 
	 * @param frame
	 *            användargränssnittet
	 */
	public GridPanel(Frame frame) {
		setLayout(new GridLayout(9, 9));
		OneNumberBox[][] nbrField = frame.getNumberBox();
		for (int j = 0; j < 9; j++) {
			for (int i = 0; i < 9; i++) {
				Color col;
				int tempI = i % 6;
				int tempJ = j % 6;
				if (tempI < 3 && tempJ % 6 < 3 || tempJ > 2 && tempI > 2) {
					col = new Color(200, 200, 200);
				} else {
					col = Color.WHITE;
				}
				OneNumberBox temp = new OneNumberBox(col);
				add(temp);
				nbrField[i][j] = temp;
			}
		}
	}
}