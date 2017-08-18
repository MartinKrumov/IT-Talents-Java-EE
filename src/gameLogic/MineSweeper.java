package gameLogic;

import java.util.Scanner;
import board.MinesweeperBorad;

public class MineSweeper {
	private MinesweeperBorad mineField;
	private char[][] emptyBoard;
	private boolean[][] visitedFields;
	
	public MineSweeper(MinesweeperBorad mineField) {
		this.mineField = mineField;
		this.emptyBoard = new char[mineField.getRows()][mineField.getCols()];
		this.setEmptyBoard();
		
		this.visitedFields = new boolean[mineField.getRows()][mineField.getCols()];
	}
	
	public void setEmptyBoard() {
		for (int i = 0; i < emptyBoard.length; i++) {
			for (int j = 0; j < emptyBoard[i].length; j++) {
				this.emptyBoard[i][j] = '+';
			}
		}
	}

	public void getCordinates() {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			int x, y;

			do {
				System.out.print("Enter x: ");
				x = sc.nextInt();
			} while (x < 0 || x >= mineField.getRows());

			do {
				System.out.print("Enter y: ");
				y = sc.nextInt();
			} while (y < 0 || y >= mineField.getCols());

			System.out.println();

			if (mineField.getField(x, y) != '*' && mineField.getField(x, y) != ' ') {
				uncoverFields(x, y, mineField.getField(x, y));
				showBoard(emptyBoard);
			} else if (mineField.getField(x, y) == ' ') {
				uncoverFields(x, y, mineField.getField(x, y));
				showBoard(emptyBoard);
			} else if (mineField.getField(x, y) == '*') {
				System.out.println("\t\tG A M E  O V E R!\n");
				mineField.printBoard();
				break;
			}

			if (minesLeft()) {
				System.out.println("\t\tYOU WON THE GAME :)\n");
				mineField.printBoard();
				break;
			}
		}
//		sc.close();
	}

	private boolean minesLeft() {
		int visited = 0;
		for (int i = 0; i < mineField.getRows(); i++) {
			for (int j = 0; j < mineField.getCols(); j++) {
				if (this.emptyBoard[i][j] != '+') {
					visited++;
				}
			}
		}

		int fields = mineField.getRows() * mineField.getCols();
		if (fields - visited == mineField.getNumberOfMines()) {
			return true;
		}
		return false;
	}

	public void uncoverFields(int x, int y, char symbol) {
		emptyBoard[x][y] = symbol;

		if (symbol != ' ') {
			return;
		}

		if (!visitedFields[x][y]) {
			visitedFields[x][y] = true;
		} else {
			return;
		}

		for (int i = x - 1; i <= x + 1; i++) {
			for (int j = y - 1; j <= y + 1; j++) {
				if ((i >= 0 && i < mineField.getRows()) && (j >= 0 && j < mineField.getCols())) {
					uncoverFields(i, j, mineField.getField(i, j));
				}
			}
		}
	}

	public static void showBoard(char[][] emptyBoard) {
		for (int i = 0; i < emptyBoard.length; i++) {
			for (int j = 0; j < emptyBoard[i].length; j++) {
				System.out.print(emptyBoard[i][j] + " ");
			}
			System.out.println();
		}
	}
}
