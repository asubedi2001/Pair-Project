
public class GameState {
	private Cell[][] cellArray; // current state of cells on board
	private boolean turn; //true -> player1Turn false->player2Turn
	int [][] currentBoard = new int[8][8];	
	GameState() {
		cellArray = new Cell[8][8];
		for(int a = 0;a < 8; a++) {
			for(int b = 0; b < 8; b++) {
				cellArray[a][b].setRow(a);
				cellArray[a][b].setRow(b);
			}
		}

	}

	public void setTurn(boolean turnSet) {
		turn = turnSet;
	}

	public boolean getTurn() {
		return turn;
	}

	public Cell[][] getCellArray() {
		return cellArray;
		// return the reference for the array of cells
	}
	public void updateCellArray(int row, int col, int state){
		if(state == 0) {
			cellArray[row][col].setEmpty();
		} else if(state == 1) {
			cellArray[row][col].setWhite();
		}else if(state == 2) {
			cellArray[row][col].setBlack();
		}


	}

	// Should create an array for this that has a true and false for each player. This should be only a couple lines long
	public boolean isPlaceable(Cell potentialCell) {
		//potentialCell is the cell that the user is trying to use
		int row = potentialCell.getRow();
		int col = potentialCell.getCol();

		//creates a new array and sets contents in that array equal to cellArray's states

		for(int rw = 0; rw < 8; rw ++) {
			for(int cl = 0; cl< 8; cl++) {
				currentBoard[rw][cl] = cellArray[rw][cl].getState(); 
			}
		}

		// REMEBER TO ADD THIS LINE OF CODE, IF THE STATUS OF THE POTENTIAL PIECE IS NOT EXMPTY, RETURN FALSE
		if(potentialCell.getState() != 0 ) {
			return false;
		}else {

			//if player 2
			if(turn) {
				boolean colHasBlack;

				int colHasWhiteAfterBlack = 0;



				for(int rowCounter = 0; rowCounter < 7; rowCounter++) {
					if(rowCounter == 0) {
						if(isBlack(rowCounter, col)) {
							colHasBlack = true;
							if(isEmpty(rowCounter+1, col)) {
								colHasBlack = false;
							}
						}
					}

					if(currentBoard[rowCounter][col] == 2) {

					}
				}

			}else {

			}
		}




		//checks vertically first


		//iterates through currentBoard
		for(int[] a: currentBoard) {
			for(int element: a) {

			}
			// search up how to do for each loop for double array
		}

	}

	//look at a column, row, or diagonal. If there is a piece that is the player's color is blocked by an opponent's color and there is no empty piece in between, placeable is true

	// need a way to access and modify the cell array though i guess that can be done through getCellArray()

	private boolean isBlack(int rowCounter, int col) {
		return (currentBoard[rowCounter][col]) == 2;
	}
	private boolean isWhite(int rowCounter, int col) {
		return (currentBoard[rowCounter][col]) == 1;
	}
	private boolean isEmpty(int rowCounter, int col) {
		return (currentBoard[rowCounter][col]) == 0;
	}

}


