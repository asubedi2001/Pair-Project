import java.util.ArrayList;

public class GameState {
    private boolean turn; //true -> player1Turn false->player2Turn
    private int[][] currentBoard = new int[8][8];
    private ArrayList<Cell> cellsToUpdate = new ArrayList<Cell>();

    GameState() {

        //init all to 0
        for (int a = 0; a < 8; a++) {
            for (int b = 0; b < 8; b++) {
                currentBoard[a][b] = 0;
            }
        }
        //Initialize the states of the beginning pieces (pieces in the middle)
        for (int i = 3; i < 5; i++) {
            for (int a = 3; a < 5; a++) {
                if (i == a) {
                    currentBoard[i][a] = 1;
                } else {
                    currentBoard[i][a] = 2;
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

    public int[][] getCurrentBoard() {
        return currentBoard;
    }

    public void updateCellArray(int row, int col, int state) {

        if (state == 0) {
            currentBoard[row][col] = 0;
        } else if (state == 1) {
            currentBoard[row][col] = 1;
        } else if (state == 2) {

            currentBoard[row][col] = 2;
        }


    }

    public int playerTurn(boolean turn) {
        if (turn) {
            return 1; //return white int
        } else {
            return 2;
        }
    }

    private boolean downDirection(int rw, int cl) {
        int x = rw;
        int y = cl;

        int playerTurn = playerTurn(turn);
        int opponentPlayer = playerTurn(!turn);

        if (currentBoard[x][y] != 0) { 
            return false;
        }

        //down
        if (x + 1 > 7) {
            return false;
        }
        if (currentBoard[x + 1][y] == opponentPlayer) { 

            int num = 0;

            for (int a = 2; x + a < 8; a++) {

                if (a == 7) {
                    return false;
                }


                if (currentBoard[x + a][y] == playerTurn) {

                    num = (x + a);
                    a = 8; 
                }

            }
            int diff = num - x; 
            
            for (int b = 0; b < diff; b++) {
                cellsToUpdate.add(new Cell(x + b, y, playerTurn));
            }
            if (num > 1) {
                return true;
            } else {
                return false;
            }
        } else {

            return false;
        }
    }

    private boolean upDirection(int rw, int cl) {
        int x = rw;
        int y = cl;

        int playerTurn = playerTurn(turn);
        int opponentPlayer = playerTurn(!turn);

        if (currentBoard[x][y] != 0) { 
            return false;
        }

        //checks up
        if (x - 1 < 0) {
            return false;
        }
        if (currentBoard[x - 1][y] == opponentPlayer) { 

            int num = 0;

            for (int a = 2; x - a > 0; a++) {

                if (a == 7) {
                    return false;
                }
                if (currentBoard[x - a][y] == playerTurn) {

                    num = (y + a);
                    a = 8; 
                }

            }
            int diff = num - y; 
            
            for (int b = 0; b < diff; b++) {
                cellsToUpdate.add(new Cell(x - b, y, playerTurn));
            }
            if (num > 1) {
                return true;
            } else {
                return false;
            }
        } else {

            return false;
        }
    }

    private boolean leftDirection(int rw, int cl) {
        int x = rw;
        int y = cl;

        int playerTurn = playerTurn(turn);
        int opponentPlayer = playerTurn(!turn);

        if (currentBoard[x][y] != 0) {
            return false;
        }

        //left
        if (y + 1 > 7) {
            return false;
        }
        if (currentBoard[x][y + 1] == opponentPlayer) {

            int num = 0;

            for (int a = 2; y + a < 8; a++) {

                if (a == 7) {
                    return false;
                }
                if (currentBoard[x][y + a] == playerTurn) {

                    num = (y + a);
                    a = 8; 
                }

            }
            int diff = num - y; 
            
            for (int b = 0; b < diff; b++) {
                cellsToUpdate.add(new Cell(x, y + b, playerTurn));
            }
            if (num > 1) {
                return true;
            } else {
                return false;
            }
        } else {

            return false;
        }
    }

    private boolean rightDirection(int rw, int cl) {

        int x = rw;
        int y = cl;

        int playerTurn = playerTurn(turn);
        int opponentPlayer = playerTurn(!turn);

        if (currentBoard[x][y] != 0) { 
            return false;
        }
        if (y - 1 < 0) {
            return false;
        }
        //right
        if (currentBoard[x][y - 1] == opponentPlayer) {
            int num = 0;

            for (int a = 2; y - a > 0; a++) {

                if (a == 7) {
                    return false;
                }
                if (currentBoard[x][y - a] == playerTurn) {
                    num = (y + a);
                    a = 8; 
                }

            }
            int diff = num - y; 
            for (int b = 0; b < diff; b++) {
                cellsToUpdate.add(new Cell(x, y - b, playerTurn));
            }
            if (num > 1) {
                return true;
            } else {
                return false;
            }
        } else {

            return false;
        }


    }

    private boolean downLeftDirection(int rw, int cl) {
        int x = rw;
        int y = cl;

        int playerTurn = playerTurn(turn);
        int opponentPlayer = playerTurn(!turn);

        if (currentBoard[x][y] != 0) { 
            return false;
        }

        //down
        if (x + 1 > 7 || y + 1 > 7) {

            return false;
        }
        if (currentBoard[x + 1][y + 1] == opponentPlayer) { 

            int num = 0;

            for (int a = 2; x + a < 8 && y + a < 8; a++) {

                if (a == 7) {
                    return false;
                }


                if (currentBoard[x + a][y + a] == playerTurn) {

                    num = (x + a);
                    a = 8; 
                }

            }
            int diff = num - x; 
            
            for (int b = 0; b < diff; b++) {

                //updateCellArray(x + b, y + b, playerTurn);// Sets everything in between equal
                cellsToUpdate.add(new Cell(x + b, y + b, playerTurn));

            }

            if (num > 1) {
                return true;
            } else {
                return false;
            }
        } else {

            return false;
        }
    }

    private boolean downRightDirection(int rw, int cl) {
        int x = rw;
        int y = cl;

        int playerTurn = playerTurn(turn);
        int opponentPlayer = playerTurn(!turn);

        if (currentBoard[x][y] != 0) { 
            return false;
        }

        //down
        if (x + 1 > 7 || y - 1 < 0) {

            return false;
        }
        if (currentBoard[x + 1][y - 1] == opponentPlayer) { 

            int num = 0;

            for (int a = 2; x + a < 8 && y - a > 0; a++) {

                if (a == 7) {
                    return false;
                }


                if (currentBoard[x + a][y - a] == playerTurn) {

                    num = (x + a);
                    a = 8; 
                }

            }
            
            int diff = num - x; 
            
            for (int b = 0; b < diff; b++) {

                // updateCellArray(x + b, y - b, playerTurn);// Sets everything in between equal
                cellsToUpdate.add(new Cell(x + b, y - b, playerTurn));
            }

            if (num > 1) {
                return true;
            } else {
                return false;
            }
        } else {

            return false;
        }
    }

    private boolean upRightDirection(int rw, int cl) {
        int x = rw;
        int y = cl;

        int playerTurn = playerTurn(turn);
        int opponentPlayer = playerTurn(!turn);

        if (currentBoard[x][y] != 0) { 
            return false;
        }

        //down
        if (x - 1 < 0 || y - 1 < 0) {

            return false;
        }
        if (currentBoard[x - 1][y - 1] == opponentPlayer) { 

            int num = 0;

            for (int a = 2; x - a > 0 && y - a > 0; a++) {

                if (a == 7) {
                    return false;
                }


                if (currentBoard[x - a][y - a] == playerTurn) {

                    num = (x + a);
                    a = 8; 
                }

            }
            
            int diff = num - x; 
            
            for (int b = 0; b < diff; b++) {

                // updateCellArray(x - b, y - b, playerTurn);// Sets everything in between equal
                cellsToUpdate.add(new Cell(x - b, y - b, playerTurn));
            }

            if (num > 1) {
                return true;
            } else {
                return false;
            }
        } else {

            return false;
        }
    }

    private boolean upLeftDirection(int rw, int cl) {
        int x = rw;
        int y = cl;

        int playerTurn = playerTurn(turn);
        int opponentPlayer = playerTurn(!turn);

        if (currentBoard[x][y] != 0) { 
            return false;
        }
        //down
        if (x - 1 < 0 || y + 1 > 7) {
            return false;
        }
        if (currentBoard[x - 1][y + 1] == opponentPlayer) { 
            int num = 0;
            for (int a = 2; x - a > 0 && y + a < 8; a++) {
                if (a == 7) {
                    return false;
                }
                if (currentBoard[x - a][y + a] == playerTurn) {
                    num = (x + a);
                    a = 8; 
                }
            }
            int diff = num - x; 
            for (int b = 0; b < diff; b++) {
                cellsToUpdate.add(new Cell(x - b, y + b, playerTurn));
            }
            if (num > 1) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean isPlaceable(int rw, int cl) {
        cellsToUpdate.clear();
        downLeftDirection(rw, cl);
        downRightDirection(rw, cl);
        upRightDirection(rw, cl);
		upLeftDirection(rw, cl);
		downDirection(rw, cl);
		upDirection(rw, cl);
		leftDirection(rw, cl);
		rightDirection(rw, cl);
		if (cellsToUpdate.size() > 0) {
            for (Cell cell : cellsToUpdate) {
                updateCellArray(cell.getRow(), cell.getCol(), cell.getState());
            }
            return true;
        } else {
            return false;
        }


    }

    //isPlaceable for GameOver is used in the GameOver method
    private boolean isPlaceableForGameOver(int rw, int cl) {

        if (downLeftDirection(rw, cl) || downRightDirection(rw, cl) ||
        	upRightDirection(rw, cl)  || upLeftDirection(rw, cl)    ||
        	downDirection(rw, cl)	  || upDirection(rw, cl)		||
        	leftDirection(rw, cl)	  || rightDirection(rw, cl)		
           ) {
            return true;
        }
        return false;
        
    }

    //should be used by a GUI class in order to determine whether
    public boolean gameOver() {
        
    	for (int a = 0; a < 8; a++) {
            for (int b = 0; b < 8; b++) {
            	if(isPlaceableForGameOver(a,b)) {
            		return false;
            	}
            }
        }
    	
        return true;
    }


    public int PlayerTwoPoints() {
        int points = 0;
        for (int a = 0; a < 8; a++) {
            for (int b = 0; b < 8; b++) {
                if (currentBoard[a][b] == 2) {
                    points++;
                }
            }
        }
        return points;
    }

    public int PlayerOnePoints() {
        int points = 0;
        for (int a = 0; a < 8; a++) {
            for (int b = 0; b < 8; b++) {
                if (currentBoard[a][b] == 1) {
                    points++;
                }
            }
        }
        return points;
    }

    //look at a column, row, or diagonal. If there is a piece that is the player's color is blocked by an opponent's color and there is no empty piece in between, placeable is true


}