
public class GameState {
	private Cell[][] cellArray; // current state of cells on board

	GameState() {
		cellArray = new Cell[8][8];

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

	public boolean isPlaceable(Cell potentialCell) {
		//potentialCell is the cell that the user is trying to use

		//creates a new array and sets contents in that array equal to cellArray's states
		int [][] currentBoard = new int[8][8];
		for(int rw = 0; rw < 8; rw ++) {
			for(int cl = 0; cl< 8; cl++) {
				currentBoard[rw][cl] = cellArray[rw][cl].getState(); 
			}
		}

		//iterates through currentBoard
		for(int[] a: currentBoard) {
			for(int element: a) {
				
			}
			// search up how to do for each loop for double array
		}

	}

	//look at a column, row, or diagonal. If there is a piece that is the player's color is blocked by an opponent's color and there is no empty piece in between, placeable is true

	// need a way to access and modify the cell array though i guess that can be done through getCellArray()



}


