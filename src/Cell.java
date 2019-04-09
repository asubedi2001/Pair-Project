import java.awt.Graphics;

public class Cell {
	private int cellState;
	/*where 0 is empty
		  1 is  white
		  2 is  black*/
	private boolean placeable;
	Cell(){
		cellState = 0;
		placeable = false;
	}
	//the following methods are for the cellState variable
	public int getState() {
		return cellState;
	}
	public void setWhite() {
		cellState = 1;
	}
	public void setBlack() {
		cellState = 2;
	}
	public void setEmpty() {
		cellState = 0;
	}
	
	//the following methods is for the placeable
	public void setPlaceable(boolean isplaceable) {
		placeable = isplaceable;
	}

	private boolean showButtons = false;
	//changeable means a user can click on it as a move.
	private boolean changeable1;
	//changeable for player 1
	private boolean changeable2;
	//changeable for player2/computer
	private int state;
	// state :   black: 1 white: 0 none placed: -1
	
	
	public Cell() {
		
	}
	
	public Cell(int state) {
		
	}
	
	public void setState(int newState) {
		if(state > -1 && state < 2) {
			state = newState;
		}
	}
	
	public int getState() {
		return state;
	}
	
	public void setChangeable1(boolean newChangeable) {
		changeable1 = newChangeable;
	}
	
	public void setChangeable2(boolean newChangeable) {
		changeable2 = newChangeable;
	}

}


