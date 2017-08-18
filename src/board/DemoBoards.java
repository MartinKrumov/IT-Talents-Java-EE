package board;

import java.util.Scanner;

import gameLogic.MineSweeper;
import gameLogic.TicTacToe;

public class DemoBoards {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		GameBoard houndFox = new HoundsAndFoxBoard(8);
		
		houndFox.printBoard();
		
//		GameBoard board = new TicTacToeBoard(3);
//		TicTacToe playerX = new TicTacToe((TicTacToeBoard)board, 'X');
//		TicTacToe playerO = new TicTacToe((TicTacToeBoard)board, 'O');
//		board.printBoard();
//		startTicTacToeGame(sc, board, playerX, playerO);
//		
//		System.out.println("\n\n");
		
//		GameBoard mineBorad = new MinesweeperBorad();
//		MineSweeper player = new MineSweeper((MinesweeperBorad)mineBorad);
//		mineBorad.printBoard();
//		player.getCordinates();
		
	}

	public static void startTicTacToeGame(Scanner sc, GameBoard tictac, TicTacToe playerX, TicTacToe playerO) {
		int x, y;
		int boardSize = ((TicTacToeBoard)tictac).getBoard().length;
		while (true) { //TODO: ArrayOutOfBounds!! or startTicTacToeGame()	
			
			while (true) {
				System.out.println("\nPlayer X: ");
				do {
					System.out.print("Enter x: ");
					x = sc.nextInt();
				} while (x < 0 || x >= boardSize);

				do {
					System.out.print("Enter y: ");
					y = sc.nextInt();
				} while (y < 0 || y >= boardSize);
				
				if (tictac.getField(x, y) == ' ') {
					break;
				}else  {
					System.out.println("The field is already taken.Chose another field.");
				}
			}
			playerX.makeMove(x,y);
			
			if(playerX.checkForWin(x, y)) {
				System.out.println("Player X has won!");
				tictac.printBoard();
				break;
			}
			if (playerX.checkForDraw()) {
				System.out.println("Draw!");
				tictac.printBoard();
				break;
			}
			
			tictac.printBoard();
			System.out.println("\nPlayer O: ");
			while (true) {
				do {
					System.out.print("Enter x: ");
					x = sc.nextInt();
				} while (x < 0 || x >= boardSize);

				do {
					System.out.print("Enter y: ");
					y = sc.nextInt();
				} while (y < 0 || y >= boardSize);
				
				if (tictac.getField(x, y) == ' ') {
					break;
				}else  {
					System.out.println("The field is already taken.Chose another field.");
				}
			}
			playerO.makeMove(x,y);
			
			if(playerO.checkForWin(x, y)) {
				System.out.println("Player O has won!");
				tictac.printBoard();
				break;
			}
			
			tictac.printBoard();
		}
	}
}
