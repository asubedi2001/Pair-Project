/**
 * 
 */

/**
 * @author amehro1977
 *
 */
public class HumanPlayer extends Player {
	//I guess I don't need these since they were implemented in the Player class?
	/*	private int points;
		private Cell[][] array = new Cell[8][8];
		private int[][] intArray = new int[8][8];*/
	
	HumanPlayer(GameState game) {
		super(game);
		// TODO Auto-generated constructor stub
	}

	@Override
	void selectCell() {
		// TODO Auto-generated method stub

	}

	@Override
	void selectColor() {
		// TODO Auto-generated method stub

	}

	@Override
	int returnPoints() {
		// TODO Auto-generated method stub
		for(int a = 0; a < 8; a++){
			for(int b = 0; b < 8; b++) {
				if(intArray[a][b] == 1) {
					 //TODO Need to see the thing on the left. Like hover over it. 
				}
			}
		}
		
	}

}
