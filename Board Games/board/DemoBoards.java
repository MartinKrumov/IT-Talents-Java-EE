package board;

import java.util.Scanner;

import gameLogic.HoundsAndFox;
import gameLogic.MineSweeper;
import gameLogic.TicTacToe;

public class DemoBoards {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		GameBoard board;
		int choice;

		while (true) {

			gameMenu();
			choice = sc.nextInt();

			while (choice < 1 || choice > 5) {
				System.out.print("Please enter again: ");
				choice = sc.nextInt();
			}

			if (choice == 5) {
				break;
			}

			switch (choice) {
			case 1:
				System.out.print("Enter size of the board: ");
				int size = sc.nextInt();

				while (size < 3 || size > 10) {
					System.out.print("Please enter again: ");
					size = sc.nextInt();
				}

				board = new TicTacToeBoard(size);
				TicTacToe playerX = new TicTacToe((TicTacToeBoard) board, 'X');
				TicTacToe playerO = new TicTacToe((TicTacToeBoard) board, 'O');
				board.printBoard();
				
				TicTacToe.startTicTacToeGame(board, playerX, playerO);

				board.clearBoard();
				break;
			case 2:
				System.out.println("Not finished yet.");
				break;
			case 3:

				board = new MinesweeperBorad();
				MineSweeper player = new MineSweeper((MinesweeperBorad) board);
//				board.printBoard();
				player.getCordinates();

				board.clearBoard();
				break;
			case 4:
				System.out.print("Enter size of the board: ");
				size = sc.nextInt();

				while (size < 3 || size > 10) {
					System.out.print("Please enter again: ");
					choice = sc.nextInt();
				}

				board = new HoundsAndFoxBoard(size);
				HoundsAndFox game = new HoundsAndFox((HoundsAndFoxBoard) board);
				game.startFoxAndHoundsGame();

				board.clearBoard();
				break;
			}

			System.out.println("\nWould you want to play again? ('y' for yes, 'n' for no)");
			char ch = sc.next().charAt(0);
			if (ch == 'n') {
				break;
			}
		}

	}

	public static void gameMenu() {
		System.out.println("\tWelcome to Board Games\n");
		System.out.println("1.Tic Tac Toe.");
		System.out.println("2.Dots and Boxes (Not Finished).");
		System.out.println("3.Minesweeper.");
		System.out.println("4.Fox and Hounds");
		System.out.println("5.Exit\n");
		System.out.print("Enter your choice: ");
	}
}
