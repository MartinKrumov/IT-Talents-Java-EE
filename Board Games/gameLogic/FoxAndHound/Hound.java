package gameLogic.FoxAndHound;

public class Hound {
	private final char symbol = 'H';
	private int currentRow = 0;
	private int currentCol = 0;
	
	public Hound() { }
	
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
