
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

}


