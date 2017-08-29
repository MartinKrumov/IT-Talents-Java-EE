package gameLogic;

import java.util.Scanner;

import board.GameBoard;
import board.TicTacToeBoard;

public class TicTacToe {
	private TicTacToeBoard board;
	private char sign;
	private int boardSize;
	// private int moveCount;

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
			for (int i = 0; i < boardSize; i++) {
				if (board.getField(i, i) != this.sign)
					break;
				if (i == boardSize - 1) {
					return true;
				}
			}
		}

		// check anti diag
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

	public static void startTicTacToeGame(GameBoard board, TicTacToe playerX, TicTacToe playerO) {
		while (true) { 
			System.out.println("\nPlayer 1: ");
			int[] cordinates = checkForValidMove(board);
			playerX.makeMove(cordinates[0], cordinates[1]);

			if (playerX.checkForWin(cordinates[0], cordinates[1])) {
				System.out.println("Player 1 has won!");
				board.printBoard();
				break;
			}
			if (playerX.checkForDraw()) {
				System.out.println("Draw!");
				board.printBoard();
				break;
			}

			board.printBoard();
			
			System.out.println("\nPlayer 2: ");
			cordinates = checkForValidMove(board);
			playerO.makeMove(cordinates[0], cordinates[1]);

			if (playerO.checkForWin(cordinates[0], cordinates[1])) {
				System.out.println("Player 2 has won!");
				board.printBoard();
				break;
			}

			board.printBoard();
		}
	}

	 static int[] checkForValidMove(GameBoard board) {
		Scanner sc = new Scanner(System.in);
		
		int x, y;
		int boardSize = ((TicTacToeBoard) board).getBoard().length;
		while (true) {
			do {
				System.out.print("Enter x: ");
				x = sc.nextInt();
			} while (x < 0 || x >= boardSize);

			do {
				System.out.print("Enter y: ");
				y = sc.nextInt();
			} while (y < 0 || y >= boardSize);
			
			if (board.getField(x, y) == ' ') {
				break;
			}else  {
				System.out.println("The field is already taken.Chose another field.");
			}
		}
		int[] cordinates = {x, y};

		return cordinates;
	}
}
