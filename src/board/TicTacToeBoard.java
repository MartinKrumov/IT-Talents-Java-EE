package board;

public class TicTacToeBoard extends GameBoard {

	public TicTacToeBoard(int rows) {
		if (rows >= 3 && rows <= 10) {
			this.setBoard(new char[rows][rows]);

			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < rows; j++) {
					this.setField(i, j, ' ');
				}
			}
		} else {
			System.out.println("Invalid Input(3-10).");
		}
	}

	@Override
	public void printBoard() {
		int length = this.getBoard().length;
		
		for (int i = 0; i < length; i++) {
			for (int k = 0; k < length; k++) {
				System.out.print("+---");
			}
			
			System.out.print("+\n| ");	
			for (int j = 0; j < length; j++) {
				System.out.print(this.getField(i, j) + " | ");
			}
			System.out.println();
			
			if (i == length - 1) {
				System.out.print("+");
				for (int k = 0; k < length; k++) {
					System.out.print("---" + "+");
				}
			}
		}
	}
}
