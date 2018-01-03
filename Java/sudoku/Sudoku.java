package sudoku;

public class Sudoku {
	protected int[][] grid;

	/**
	 * Skapar ett sudoku d�r en 9x9 matris representerar pusslet.
	 */
	public Sudoku() {
		grid = new int[9][9];
	}

	/**
	 * �ndrar v�rdet i matrisen i raden row och kolumnen column till siffran
	 * number.
	 * 
	 * @param number
	 *            siffran som ska l�ggas in
	 * @param row
	 *            raden i matrisen
	 * @param column
	 *            kolumnen i matrisen
	 */
	public void setNumber(int number, int row, int column) {
		grid[row][column] = number;
	}

	/**
	 * Returner v�rdet i matrisen som finns i raden row och kolumnen column.
	 * 
	 * @param row
	 *            raden i matrisen
	 * @param column
	 *            kolumnen i matrisen
	 * @return v�rdet i matrisen som finns i raden row och kolumnen column
	 */
	public int getNumber(int row, int column) {
		return grid[row][column];
	}

	/**
	 * Unders�ker om indatan f�ljer reglerna f�r ett sudoku, om sant s� g�rs
	 * anropet till den rekursiva metoden solve som l�ser pusslet.
	 * 
	 * @return true om pusslet blir l�st annars false
	 */
	public boolean solve() {
		if (validateInput()) {
			return solve(0, 0);
		} else {
			return false;
		}
	}

	private boolean solve(int i, int j) {
		if (j > 8) {
			j = 0;
			i++;
		}
		if (i > 8) {
			return true;
		}
		if (grid[i][j] != 0) {
			return solve(i, j + 1);
		} else {
			for (int k = 1; k < 10; k++) {
				if (validateNumber(i, j, k)) {
					grid[i][j] = k;
					if (!solve(i, j + 1)) {
						grid[i][j] = 0;
					} else {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * Returnerar true om indatan f�ljer reglerna f�r ett sudoku, annars false.
	 * 
	 * @return true om indatan f�ljer reglerna i ett sudoku annars false
	 */
	private boolean validateInput() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (grid[i][j] != 0 && !validateNumber(i, j, grid[i][j])) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Returnerar true om siffran i raden i och kolumnen j f�ljer reglerna f�r
	 * ett sudoku, annars false.
	 * 
	 * @param i
	 *            raden att unders�ka
	 * @param j
	 *            kolumnen att unders�ka
	 * @param number
	 *            siffran att unders�ka
	 * @return true om siffran f�ljer regler i ett sudoku, annars false
	 */
	private boolean validateNumber(int i, int j, int number) {
		for (int k = 0; k < 9; k++) {
			if (k != i && grid[k][j] == number) {
				return false;
			}
			if (k != j && grid[i][k] == number) {
				return false;
			}
		}
		int row = (i / 3) * 3;
		int column = (j / 3) * 3;
		int newI = i % 3;
		int newJ = j % 3;
		for (int k = 0; k < 3; k++) {
			for (int l = 0; l < 3; l++) {
				if (k != newJ && l != newI
						&& grid[row + l][column + k] == number) {
					return false;
				}
			}
		}
		return true;
	}
}
