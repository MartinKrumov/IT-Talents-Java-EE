package board;

public class HoundsAndFoxBoard extends GameBoard{
	
	public HoundsAndFoxBoard(int rows) {
		if (rows >= 4 && rows <= 16) {
			this.setBoard(new char[rows][rows]);

			for (int i = 0; i < rows; i++) {
				if (i % 2 == 0) {
					for (int j = 0; j < rows; j++) {
						if (j % 2 == 0) {
							this.setField(i, j, ' ');
						} else {
							this.setField(i, j, 'B');
						}
					}
				} else {
					for (int j = 0; j < rows; j++) {
						if (j % 2 == 0) {
							this.setField(i, j, 'B');
						} else {
							this.setField(i, j, ' ');
						}
					}
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
