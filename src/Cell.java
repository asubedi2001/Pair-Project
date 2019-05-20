public class Cell {
    public final static int EMPTY = 0;
    public final static int WHITE = 1;
    public final static int BLACK = 2;

    private int cellState;

    private int row;
    private int col;

    public Cell() {
        cellState = EMPTY;

    }
    public Cell(int row1, int col1, int state) {
        cellState = state;
        row = row1;
        col = col1;


    }
    //getter and setters for getState
    public int getState() {
        return cellState;
    }
    public void setWhite() {
        cellState = WHITE;
    }
    public void setBlack() {
        cellState = BLACK;
    }
    public void setEmpty() {
        cellState = EMPTY;
    }

    //rows and columns getter and setters
    public void setRow(int desiredRow) {
        row = desiredRow;
    }

    public void setCol(int desiredCol) {
        col = desiredCol;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}