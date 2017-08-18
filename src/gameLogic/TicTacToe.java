package gameLogic;

import board.TicTacToeBoard;

public class TicTacToe {
	private TicTacToeBoard board;
	private char sign;
	private int boardSize;
//	private int moveCount;

	public int getBoardSize() {
		return boardSize;
	}

	public TicTacToe(TicTacToeBoard board, char sign) {
		this.board = board;
		this.boardSize = board.getBoard().length;
		this.sign = sign;
	}

	public void makeMove(int x, int y) {
		if (board.getField(x, y) == ' ') {
			board.setField(x, y, this.sign);
		} else {
			System.out.println("Invalid move.");
		}
			
	}

	public boolean checkForWin(int x, int y) {
		// check col
		for (int i = 0; i < boardSize; i++) {
			if (board.getField(x, i) != this.sign)
				break;
			if (i == boardSize - 1) {
				return true;
			}
		}

		// check row
		for (int i = 0; i < boardSize; i++) {
			if (board.getField(i, y) != this.sign)
				break;
			if (i == boardSize - 1) {
				return true;
			}
		}

		// check main diagonal
		if (x == y) {
			// we're on a diagonal
			for (int i = 0; i < boardSize; i++) {
				if (board.getField(i, i) != this.sign)
					break;
				if (i == boardSize - 1) {
					return true;
				}
			}
		}

		// check anti diag (thanks rampion)
		if (x + y == boardSize - 1) {
			for (int i = 0; i < boardSize; i++) {
				if (board.getField(i, (boardSize - 1) - i) != this.sign)
					break;
				if (i == boardSize - 1) {
					return true;
				}
			}
		}

		return false;
	}

	public boolean checkForDraw() {
		for (int row = 0; row < boardSize; ++row) {
			for (int col = 0; col < boardSize; ++col) {
				if (board.getField(row, col) == ' ') {
					return false;
				}
			}
		}
		return true;
	}
}
