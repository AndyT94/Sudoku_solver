package sudoku;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class OneNumberBox extends JTextField {

	/**
	 * Skapar en textruta med färgen col.
	 * 
	 * @param col
	 *            färgen
	 */
	public OneNumberBox(Color col) {
		super("");
		setBackground(col);
		setHorizontalAlignment(JTextField.CENTER);
		((AbstractDocument) this.getDocument())
				.setDocumentFilter(new OneNumberFilter());
	}

	private class OneNumberFilter extends DocumentFilter {

		private OneNumberFilter() {
			super();
		}

		public void insertString(FilterBypass fb, int offset, String nbr,
				AttributeSet attr) throws BadLocationException {
			if ((fb.getDocument().getLength() + nbr.length() > 1)) {
				return;
			}
			if (!nbr.isEmpty() && !Character.isDigit(nbr.charAt(0))) {
				return;
			}
			super.insertString(fb, offset, nbr, attr);
		}

		public void replace(FilterBypass fb, int offset, int length,
				String nbr, AttributeSet attr) throws BadLocationException {
			if ((fb.getDocument().getLength() + nbr.length() - length) > 1) {
				return;
			}

			if (!nbr.isEmpty() && !Character.isDigit(nbr.charAt(0))) {
				return;
			}
			super.replace(fb, offset, length, nbr, attr);
		}
	}
}
