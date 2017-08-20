package board;

import java.util.Random;
import java.util.Scanner;

public class MinesweeperBorad extends GameBoard {
	private int rows;
	private int cols;
	private int numberOfMines;

	public int getRows() {
		return rows;
	}

	public int getCols() {
		return cols;
	}


	public int getNumberOfMines() {
		return numberOfMines;
	}

	public MinesweeperBorad() {
		this.menu();
		this.setBoard(new char[rows][cols]);
		
		this.placeMines(); //Places the mines in the board
		this.placeNumbers(); //Places the numbers on the board
	}

	public void menu() {
		Scanner sc = new Scanner(System.in);
		
		info();
		int choice = sc.nextInt();

		while (choice < 1 || choice > 5) {
			System.out.print("Please enter again: ");
			choice = sc.nextInt();
		}

		switch (choice) {
		case 1:
			this.rows = 8;
			this.cols = 8;
			this.numberOfMines = 10;
			break;
		case 2:
			this.rows = 16;
			this.cols = 16;
			this.numberOfMines = 49;
			break;
		case 3:
			this.rows = 16;
			this.cols = 30;
			this.numberOfMines = 99;
			break;
		case 4:
			this.rows = 16;
			this.cols = 30;

			System.out.print("Enter number of mines between[0,480]: ");
			this.numberOfMines = sc.nextInt();

			while (numberOfMines < 0 || numberOfMines > 480) {
				System.out.print("Please enter mines again: ");
				numberOfMines = sc.nextInt();
			}
			break;
		case 5:
			System.exit(0);
		}
		System.out.println("\n");
		
//		sc.close();
	}
	
	public void info() {
		System.out.println("\tMINESWEEPER");
		System.out.println("1) Beginer -> 8x8 and 10 mines.");
		System.out.println("2) Intermediate -> 16x16 and 49 mines.");
		System.out.println("3) Expert -> 16x30 and 99 mines.");
		System.out.println("4) Custom -> 16x30 and the player choose the number of mines.");
		System.out.println("5) Exit.");
		System.out.print("\nEnter your choice: ");
	}
	
	public void placeMines() {
		Random random = new Random();
		int minesPlaced = 0;

		while (minesPlaced < this.numberOfMines) {
			int x = random.nextInt(this.rows);
			int y = random.nextInt(this.cols);
		
			// make sure we don't place a mine on top of another
			if (this.getField(x, y) != '*') {
				this.setField(x, y, '*');
				minesPlaced++;
			}
		}
	}
	
	public void placeNumbers() {
		// Finds how many mines are around the square
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.cols; j++) {
				if (this.getField(i, j) != '*') {
					char symbol = minesNear(i, j);		
					this.setField(i, j, symbol);
				}
			}
		}
	}
	
	public char minesNear(int row, int col) {
		int mines = 0;
		// check mines in all directions
		mines += mineChecker(row - 1, col - 1); // NW
		mines += mineChecker(row - 1, col); // N
		mines += mineChecker(row - 1, col + 1); // NE
		mines += mineChecker(row, col - 1); // W
		mines += mineChecker(row, col + 1); // E
		mines += mineChecker(row + 1, col - 1); // SW
		mines += mineChecker(row + 1, col); // S
		mines += mineChecker(row + 1, col + 1); // SE
		
		if (mines > 0) {
			return (char)(mines + 48);
		} else {
			return ' ';
		}
	}
	
	// returns 1 if there's a mine a x, y or 0 if there isn't
	public int mineChecker(int x, int y) {
		if ((x >= 0 && x < this.rows) && (y >= 0 && y < this.cols) && this.getField(x, y) == '*') {
			return 1;
		} else {
			return 0;
		}
	}
	
	@Override
	public void printBoard() {
		for (int i = 0; i < this.rows; i++) {
			for (int k = 0; k < this.cols; k++) {
				System.out.print("+---");
			}
			System.out.print("+\n| ");
			for (int j = 0; j < this.cols; j++) {
				System.out.print(this.getField(i, j) + " | ");
			}
			
			System.out.println();
			
			if (i == this.rows - 1) {
				System.out.print("+");
				for (int k = 0; k < this.cols; k++) {
					System.out.print("---" + "+");
				}
			}
		}
		System.out.println();
	}
}
