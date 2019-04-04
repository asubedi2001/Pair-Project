import java.awt.Graphics;

public class Cell {

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
