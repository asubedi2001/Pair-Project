
public class GameState {

	//double check if static is correct. I think it is. 
	private static Cell[][] cellArray = new Cell[8][8]; // current state of cells on board
	private boolean turn; //true -> player1Turn false->player2Turn
	int [][] currentBoard = new int[8][8];	

	//Constructor
	GameState() {
		for(int a = 0;a < 8; a++) {
			for(int b = 0; b < 8; b++) {
				cellArray[a][b] = new Cell();
				//sets the row and col 
				cellArray[a][b].setRow(a);
				cellArray[a][b].setCol(b);
			}
		}
				
		//Initialize the states of the beginning pieces (pieces in the middle)
		for(int i = 3; i < 5; i++) {
			for(int a = 3; a<5; a++) {
				if(i == a) {
					cellArray[i][a].setWhite();
				}else {
					cellArray[i][a].setBlack();
				}
			}
		}
	
	}

	public void setTurn(boolean turnSet) {
		turn = turnSet;
	}

	public boolean getTurn() {
		return turn;
	}

	public static Cell[][] getCellArray() {
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

		/*if anything goes wrong, make sure to check over here for any intialization issues. 
		It was saying for all of these variables that they might not have been intialized*/
		boolean isPlaceableHorizontal = false;
		boolean isPlaceableVertical = false;
		boolean isPlaceableIncline = false;
		boolean isPlaceableDecline = false;
		boolean isPlaceableInclineOrDecline = false;


		//creates a new array and sets contents in that array equal to cellArray's states
		for(int rw = 0; rw < 8; rw ++) {
			for(int cl = 0; cl< 8; cl++) {
				currentBoard[rw][cl] = cellArray[rw][cl].getState(); 
			}
		}

		
		// REMEBER TO ADD THIS LINE OF CODE, IF THE STATUS OF THE POTENTIAL PIECE IS NOT EXMPTY, RETURN FALSE
		if(potentialCell.getState() == 0 ) {
			if(!turn) {
				//player 2 (Black)

				//checks vertically
				if(row == 0) {
					if(currentBoard[row+1][col] == 1) {
						isPlaceableVertical = true;
					}else {
						isPlaceableVertical = false;
					}
				}else if (row == 7) {
					if(currentBoard[row-1][col] == 1) {
						isPlaceableVertical = true;
					}else {
						isPlaceableVertical = false;
					}
				}else {
					//if in between, check both sides
					if(currentBoard[row+1][col] == 1 || currentBoard[row-1][col] == 1) {
						isPlaceableVertical = true;						
					}else{
						isPlaceableVertical = false;
					}
				}

				//check horizontally
				if(col == 0) {
					if(currentBoard[row][col+1] == 1) {
						isPlaceableHorizontal = true;
					}else {
						isPlaceableHorizontal = false;
					}
				}else if (row == 7) {
					if(currentBoard[row][col-1] == 1) {
						isPlaceableHorizontal = true;
					}else {
						isPlaceableHorizontal = false;
					}
				}else {
					//if in between, check both sides
					if(currentBoard[row][col+1] == 1 || currentBoard[row][col-1] == 1) {
						isPlaceableHorizontal = true;						
					}else{
						isPlaceableHorizontal = false;
					}
				}


				//check Incline TODO make sure that the edge cases are taken care of inside of the if statements. 
				// Row 0, Row 7, Col 0, Col 7, and the rest can be placed in an else statement 
				if(row == 0 && col == 0) { 					//decline
					if(currentBoard[row + 1][col + 1] == 1) {
						isPlaceableDecline = true;
					}else {
						isPlaceableDecline = false;
					}
				}else if(row == 0 && col == 7) {
					if(currentBoard[row +1][col-1] == 1) {
						isPlaceableIncline = true;
					}else {
						isPlaceableIncline = false;
					}
				}else if(row == 7 && col == 7){				//decline
					if(currentBoard[row - 1][col - 1] == 1) {
						isPlaceableDecline = true;
					}else {
						isPlaceableDecline = false;
					}
				}else if(row == 7 && col == 0){
					if(currentBoard[row - 1][col + 1] == 1) {
						isPlaceableIncline = true;
					}else {
						isPlaceableIncline = false;
					}
				}else if(col == 0){							// incline but on first coloumn
					if(currentBoard[row - 1][col + 1] == 1) {
						isPlaceableIncline = true;
					}else {
						isPlaceableIncline = false;
					}
				}else if(col == 7){							// decline but on last coloumn
					if(currentBoard[row - 1][col - 1] == 1) {
						isPlaceableDecline = true;
					}else {
						isPlaceableDecline = false;
					}
				}else{

					//if in between, check both sides
					//checks decline portion (below)		// checks incline portion (below)
					if(currentBoard[row + 1][col+1] == 1 || currentBoard[row - 1][col + 1] == 1 
							||currentBoard[row + 1][col - 1] == 1 || currentBoard[row - 1][col - 1] == 1) {
						isPlaceableInclineOrDecline = true;						
					}else{
						isPlaceableInclineOrDecline = false;
					}
				}

			}else {
				//if player 1

				//checks vertically
				if(row == 0) {
					if(currentBoard[row+1][col] == 2) {
						isPlaceableVertical = true;
					}else {
						isPlaceableVertical = false;
					}
				}else if (row == 7) {
					if(currentBoard[row-1][col] == 2) {
						isPlaceableVertical = true;
					}else {
						isPlaceableVertical = false;
					}
				}else {
					//if in between, check both sides
					if(currentBoard[row+1][col] == 2 || currentBoard[row-1][col] == 2) {
						isPlaceableVertical = true;						
					}else{
						isPlaceableVertical = false;
					}
				}

				//check horizontally
				if(col == 0) {
					if(currentBoard[row][col+1] == 2) {
						isPlaceableHorizontal = true;
					}else {
						isPlaceableHorizontal = false;
					}
				}else if (row == 7) {
					if(currentBoard[row][col-1] == 2) {
						isPlaceableHorizontal = true;
					}else {
						isPlaceableHorizontal = false;
					}
				}else {
					//if in between, check both sides
					if(currentBoard[row][col+1] == 2 || currentBoard[row][col-1] == 2) {
						isPlaceableHorizontal = true;						
					}else{
						isPlaceableHorizontal = false;
					}
				}


				//check Incline TODO make sure that the edge cases are taken care of inside of the if statements. 
				// Row 0, Row 7, Col 0, Col 7, and the rest can be placed in an else statement 
				if(row == 0 && col == 0) { 					//decline
					if(currentBoard[row + 1][col + 1] == 2) {
						isPlaceableDecline = true;
					}else {
						isPlaceableDecline = false;
					}
				}else if(row == 0 && col == 7) {
					if(currentBoard[row +1][col-1] == 2) {
						isPlaceableIncline = true;
					}else {
						isPlaceableIncline = false;
					}
				}else if(row == 7 && col == 7){				//decline
					if(currentBoard[row - 1][col - 1] == 2) {
						isPlaceableDecline = true;
					}else {
						isPlaceableDecline = false;
					}
				}else if(row == 7 && col == 0){
					if(currentBoard[row - 1][col + 1] == 2) {
						isPlaceableIncline = true;
					}else {
						isPlaceableIncline = false;
					}
				}else if(col == 0){							// incline but on first coloumn
					if(currentBoard[row - 1][col + 1] == 2) {
						isPlaceableIncline = true;
					}else {
						isPlaceableIncline = false;
					}
				}else if(col == 7){							// decline but on last coloumn
					if(currentBoard[row - 1][col - 1] == 2) {
						isPlaceableDecline = true;
					}else {
						isPlaceableDecline = false;
					}
				}else{

					//if in between, check both sides
					//checks decline portion (below)		// checks incline portion (below)
					if(currentBoard[row + 1][col+1] == 2 || currentBoard[row - 1][col + 1] == 2 
							||currentBoard[row + 1][col - 1] == 2 || currentBoard[row - 1][col - 1] == 2) {
						isPlaceableInclineOrDecline = true;						
					}else{
						isPlaceableInclineOrDecline = false;
					}
				}
			}
		}
		return (isPlaceableHorizontal || isPlaceableVertical || 
				isPlaceableIncline || isPlaceableDecline || isPlaceableInclineOrDecline );

	}

	//look at a column, row, or diagonal. If there is a piece that is the player's color is blocked by an opponent's color and there is no empty piece in between, placeable is true

/*	// implement these methods later I guess
	private boolean isBlack(int rowCounter, int col) {
		return (currentBoard[rowCounter][col]) == 2;
	}
	private boolean isWhite(int rowCounter, int col) {
		return (currentBoard[rowCounter][col]) == 1;
	}
	private boolean isEmpty(int rowCounter, int col) {
		return (currentBoard[rowCounter][col]) == 0;
	}*/
	
	public int Winner(Player player1, Player player2) {
		if(player1.returnPoints(1) > player2.returnPoints(2)) {
			return 1; // Player 1 (White Wins)
		}else if(player1.returnPoints(1) < player2.returnPoints(2)) {
			return 2; // Player 2 (Black Wins)
		}else {
			return 0; // 0 in this case means a draw 
		}
	}

}
