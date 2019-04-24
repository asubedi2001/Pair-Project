
public abstract class Player {
	protected int points;
	protected Cell[][] array = new Cell[8][8];
	protected int[][] intArray = new int[8][8];
	protected int colorType;
	Player(GameState game, int BlackOrWhite){
		//probably will come across an issue here with referencing. 
		array = game.getCellArray();// <--- On this line
		colorType = BlackOrWhite;
		for(int a = 0; a < 8; a ++) {
			for(int b = 0; b < 8; b ++) {
				intArray[a][b] = array[a][b].getState(); //ToDo if you run into an exception over here, then it is due to the referencing above
			}
		}

	}
	abstract void selectCell();
	
	abstract void selectColor();
	
/*	abstract void player1Wins();
	
	abstract void player2Wins();*/
	
	int returnPoints(int WhiteOrBlack) {  // If this player is white, enter 1, else if black, enter 2                                         
		// TODO Auto-generated method stub
		points = 0;
		for(int a = 0; a < 8; a++){
			for(int b = 0; b < 8; b++) {
				if(intArray[a][b] == colorType) {
					 points++;
			
				}
			}
		}
		return points;
		
	}
		

		
}
