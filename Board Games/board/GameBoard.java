package board;

public abstract class GameBoard {
	private char[][] board;

	public abstract void printBoard();

	public char[][] getBoard() {
		return board;
	}

	public void setBoard(char[][] board) {
		this.board = board;
	}

	public char getField(int row, int col) {
		return this.board[row][col];
	}

	public void setField(int row, int col, char symbol) {
		int len = this.board.length;
		if ((row >= 0 && row < len) && (col >= 0 && col < this.board[row].length)) {
			this.board[row][col] = symbol;
		}
	}
	
	public void clearBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				this.board[i][j] = ' ';
			}
		}
	}
}
