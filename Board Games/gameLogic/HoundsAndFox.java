package gameLogic;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import board.HoundsAndFoxBoard;
import gameLogic.FoxAndHound.*;

public class HoundsAndFox {
	private Fox fox;
	private ArrayList<Hound> hounds = new ArrayList<>();
	private HoundsAndFoxBoard board;
	private int boardSize;

	public HoundsAndFox(HoundsAndFoxBoard board) {
		this.board = board;
		this.boardSize = board.getBoard().length;

		this.fox = new Fox();
		for (int i = 0; i < boardSize / 2; i++) {
			this.hounds.add(new Hound());
		}

		this.setStartingCordinates();
		this.placeFigures();
	}

	private void setStartingCordinates() {
		int col = boardSize / 2;
		if (col % 2 == 0) {
			this.fox.setCurrentCol(col);
		} else if (boardSize % 2 != 0) {
			this.fox.setCurrentCol(col);
		} else {
			this.fox.setCurrentCol(col - 1);
		}
		this.fox.setCurrentRow(boardSize - 1);

		for (Hound hound : hounds) { // set the starting cord for hounds
			hound.setCurrentRow(0);
		}
		int startingCol = 1;
		for (int i = 0; i < this.hounds.size(); i++) {
			hounds.get(i).setCurrentCol(startingCol);
			hounds.get(i).setCurrentRow(0);
			startingCol += 2;
		}
	}

	private void placeFigures() {
		this.board.setField(fox.getCurrentRow(), fox.getCurrentCol(), fox.getSymbol());

		for (Hound hound : hounds) {
			this.board.setField(hound.getCurrentRow(), hound.getCurrentCol(), hound.getSymbol());
		}
	}

	public void foxMakeMove() {
		int x, y;
		Scanner sc = new Scanner(System.in);

		while (true) {
			do {
				System.out.print("\nEnter x: ");
				x = sc.nextInt();
			} while (!isValidMove(x) || !isValidRow(x));

			do {
				System.out.print("Enter y: ");
				y = sc.nextInt();
			} while (!isValidMove(y) || !isValidCol(y));

			if (this.board.getField(x, y) == 'B') {
				this.board.setField(fox.getCurrentRow(), fox.getCurrentCol(), 'B');
				fox.setCurrentRow(x);
				fox.setCurrentCol(y);
				this.board.setField(x, y, fox.getSymbol());
				break;
			} else if (this.board.getField(x, y) == 'H') {
				System.out.println("The field is already taken.Chose another field.");
			} else {
				System.out.println("Invalid Input.");
			}
		}
	}

	public boolean isValidRow(int n) {
		return fox.getCurrentRow() - 1 == n || fox.getCurrentRow() + 1 == n;
	}

	public boolean isValidCol(int n) {
		return fox.getCurrentCol() - 1 == n || fox.getCurrentCol() + 1 == n;
	}

	public boolean checkCordinate(int n) {
		return n < 0 || n >= boardSize;
	}

	public void houndMakeMove() {
		int x, y;
		while (true) {
			int randomDog = new Random().nextInt(hounds.size());
			Hound hound = hounds.get(randomDog);

			x = hound.getCurrentRow() + 1;
			if (new Random().nextBoolean()) {
				y = hound.getCurrentCol() + 1;
			} else {
				y = hound.getCurrentCol() - 1;
			}
			if (isValidMove(x) && isValidMove(y)) {
				if (this.board.getField(x, y) == 'B') {
					this.board.setField(hound.getCurrentRow(), hound.getCurrentCol(), 'B');
					hound.setCurrentRow(x);
					hound.setCurrentCol(y);
					this.board.setField(x, y, hound.getSymbol());
					break;
				}
			}

		}
	}

	public boolean isValidMove(int x) {
		return x >= 0  && x < this.boardSize;
	}

	public void startFoxAndHoundsGame() {
		board.printBoard();
		while (true) {
			foxMakeMove();
			
			if (fox.getCurrentRow() == 0) {
				System.out.println("\n\tFOX WON!");
				System.out.println();
				board.printBoard();
				break;
			}
			board.printBoard();
			
			houndMakeMove();
		}
	}
}
