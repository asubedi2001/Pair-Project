
public class GameState {


    //double check if static is correct. I think it is.
    private static Cell[][] cellArray = new Cell[8][8]; // current state of cells on board
    private boolean turn; //true -> player1Turn false->player2Turn
    int[][] currentBoard = new int[8][8];

    //Constructor
    GameState() {
        for (int a = 0; a < 8; a++) {
            for (int b = 0; b < 8; b++) {
                cellArray[a][b] = new Cell();
                //sets the row and col
                cellArray[a][b].setRow(a);
                cellArray[a][b].setCol(b);
            }
        }

        //Initialize the states of the beginning pieces (pieces in the middle)
        for (int i = 3; i < 5; i++) {
            for (int a = 3; a < 5; a++) {
                if (i == a) {
                    cellArray[i][a].setWhite();
                } else {
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

    public void updateCellArray(int row, int col, int state) {
        if (state == 0) {
            cellArray[row][col].setEmpty();
        } else if (state == 1) {
            cellArray[row][col].setWhite();
        } else if (state == 2) {
            cellArray[row][col].setBlack();
        }


    }

    private int playerTurn(boolean turn) {
        if (turn) {
            return 1;
        } else {
            return 2;
        }
    }

    // Should create an array for this that has a true and false for each player. This should be only a couple lines long
    public boolean isPlaceable(Cell potentialCell) {
        //potentialCell is the cell that the user is trying to use
        int row = potentialCell.getRow();
        int col = potentialCell.getCol();
        int state = potentialCell.getState();
        int playerTurn = playerTurn(turn);
        //remember to add placeable array
        //creates a new array and sets contents in that array equal to cellArray's states
        for (int rw = 0; rw < 8; rw++) {
            for (int cl = 0; cl < 8; cl++) {
                currentBoard[rw][cl] = cellArray[rw][cl].getState();
            }
        }

        if (state == 0) {
           // If it contains same piece vertically
            for (int a = 0; a < 8; a++) {
                if(row-1 < 0){
                    if (currentBoard[a][col] == playerTurn &&  currentBoard[row+1][col] == playerTurn(!turn) ) {
                        System.out.println("Row: " + row + " " + "Col: " + col );
                        return true;
                    }
                }else if(row+1 > 7){
                    if (currentBoard[a][col] == playerTurn &&  currentBoard[row-1][col] == playerTurn(!turn) ) {
                        System.out.println("Row: " + row + " " + "Col: " + col );
                        return true;
                    }
                }else{
                    if (currentBoard[a][col] == playerTurn && (currentBoard[row-1][col] == playerTurn(!turn) || currentBoard[row+1][col] == playerTurn(!turn) )) {
                        System.out.println("Row: " + row + " " + "Col: " + col );
                        return true;
                    }
                }

            }

            for (int a = 0; a < 8; a++) {
                if(col-1 < 0){
                    if (currentBoard[row][a] == playerTurn &&  currentBoard[row][col+1] == playerTurn(!turn) ) {
                        System.out.println("Row: " + row + " " + "Col: " + col );
                        return true;
                    }
                }else if(col+1 > 7){
                    if (currentBoard[row][a] == playerTurn &&  currentBoard[row][col-1] == playerTurn(!turn) ) {
                        System.out.println("Row: " + row + " " + "Col: " + col );
                        return true;
                    }
                }else{
                    if (currentBoard[row][a] == playerTurn && (currentBoard[row][col+1] == playerTurn(!turn) || currentBoard[row][col-1] == playerTurn(!turn) )) {
                        System.out.println("Row: " + row + " " + "Col: " + col );
                        return true;
                    }
                }

            }
//The following is for the code for diagonals and does not really work at all
            for(int a = 0; a < 8; a++){
            //incline does not work
                if(col-1 < 0){
                    if (currentBoard[row][a] == playerTurn &&  currentBoard[row][col+1] == playerTurn(!turn) ) {
                        System.out.println("Row: " + row + " " + "Col: " + col );
                        return true;
                    }
                }else if(col+1 > 7){
                    if (currentBoard[row][a] == playerTurn &&  currentBoard[row][col-1] == playerTurn(!turn) ) {
                        System.out.println("Row: " + row + " " + "Col: " + col );
                        return true;
                    }
                }else{
                    if (currentBoard[row][a] == playerTurn && (currentBoard[row][col+1] == playerTurn(!turn) || currentBoard[row][col-1] == playerTurn(!turn) )) {
                        System.out.println("Row: " + row + " " + "Col: " + col );
                        return true;
                    }
                }
            }
            for(int a = 0; a < 8; a++){
//decline
            }
            return false;

        } else {
            return false;
        }



    

    public int Winner(Player player1, Player player2) {
        if (player1.returnPoints(1) > player2.returnPoints(2)) {
            return 1; // Player 1 (White Wins)
        } else if (player1.returnPoints(1) < player2.returnPoints(2)) {
            return 2; // Player 2 (Black Wins)
        } else {
            return 0; // 0 in this case means a draw
        }
    }


}
