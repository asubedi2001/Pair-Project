
public class GameState {
	private int[][] Cell; 
	
	GameState() {
		Cell = new int[8][8];
	}
	
	public int[][] getCellArray() {
		return Cell;
	}
	// need a way to access and modify the cell array though i guess that can be done through getCellArray()
	

	
}
