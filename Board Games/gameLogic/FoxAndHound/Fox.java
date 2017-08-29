package gameLogic.FoxAndHound;

public class Fox {
	private final char symbol = 'F';
	private int currentRow = 0;
	private int currentCol = 0;
	
	public Fox() {}
	
	public char getSymbol() {
		return symbol;
	}
	public int getCurrentRow() {
		return currentRow;
	}
	public void setCurrentRow(int currentRow) {
		this.currentRow = currentRow;
	}
	public int getCurrentCol() {
		return currentCol;
	}
	public void setCurrentCol(int currentCol) {
		this.currentCol = currentCol;
	}
}
