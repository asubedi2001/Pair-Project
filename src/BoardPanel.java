import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BoardPanel extends JPanel {
    private ImageIcon blackCircIcon = new ImageIcon("img/black-circle-png47c-4a62-b41d-149d42a05759.png");
    private ImageIcon whiteCircIcon = new ImageIcon("img/circle-png-circle-icon-1600.png");
    private JLabel blackCirc = new JLabel(blackCircIcon);
    private JLabel whiteCirc = new JLabel(whiteCircIcon);

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    	int w = this.getWidth();
        int h = this.getHeight();
        Graphics2D G = (Graphics2D) g;
        boolean[][] placeable = GameState.getPlaceableArray();
        
        //draw lines
        for (int i = 0; i < 9; i++) {
            // draw horz lines
            if (i < 8 && i > 0) {
                G.drawLine(0, h - ((h / 8) * i), w, h - ((h / 8) * i));
            } else if (i == 8) {
                G.drawLine(0, 0, w, 0);
            } else {
                G.drawLine(0, h - 1, w, h - 1);
            }

        }

        //draw lines
        for (int i = 0; i < 9; i++) {
            // draw vert lines
            if (i < 8 && i > 0) {
                G.drawLine(w - ((w / 8) * i), 0, w - ((w / 8) * i), h);
            } else if (i == 8) {
                G.drawLine(0, 0, 0, h);
            } else {
                G.drawLine(w - 1, 0, w - 1, h);
            }

        }

        //draw board pieces
        for (Cell[] currentCellArray : GameState.getCellArray()) {
            for (Cell currentCell : currentCellArray) {
                if (currentCell.getState() == 1) {
                    int[] coordinate = calcPixStart(currentCell);
                    G.drawOval(coordinate[0], coordinate[1], w / 8, h / 8);
                } else if (currentCell.getState() == 2) {
                    int[] coordinate = calcPixStart(currentCell);
                    G.fillOval(coordinate[0], coordinate[1], w / 8, h / 8);
                }
            }
        }
        
        for(int i=0; i<8; i++) {
        	for(int a=0; a<8;a++) {
        		if(placeable[i][a]) {
        			int[] coordinate = calcPixStart(GameState.getCellArray()[i][a]);
        			G.fillRect(coordinate[0], coordinate[1], w/8, h/8);
        		}
        	}
        }
    }

    private int[] calcPixStart(Cell given) {
        int[] coordinate = new int[2];
        int h = this.getHeight();
        int w = this.getWidth();
        int xCell = given.getCol();
        int yCell = given.getRow();
        coordinate[0] = (w/8) * xCell;
        coordinate[1] = (h/8) * yCell;
      //  flipOverYEqualsNegX(coordinate);
        return coordinate;

    }
    
    /*private int[] flipOverYEqualsNegX(int[] flipThis) {
    	
    }*/

    // Just returns the Cell. You can retrieve the Cell's location using getRow and getCol. Or you can return an int[] with 2 values.
    public Cell calcCellClicked(int xPix, int yPix) {
        int h = this.getHeight();
        int w = this.getWidth();

        final int widthDifference = (w / 8);
        final int heightDifference = (h / 8);

        boolean xFound = false;
        boolean yFound = false;

        Cell cell = new Cell();

      //  System.out.println("XPix: " + xPix);
      //  System.out.println("yPix: " + yPix);
        for (int a = 0; a < 8; a++) {


            if (!xFound) {
                xFound = (xPix >= ((widthDifference) * a) && xPix <= ((widthDifference) * a + (widthDifference)));
                cell.setCol(a);
            }
           // System.out.println("X Interation: " + a + "  xFound: " + xFound);

        }

        for (int b = 0; b < 8; b++) {

            if (!yFound) {
                yFound = (yPix >= ((heightDifference) * b) && yPix <= ((heightDifference) * b + (heightDifference)));

                cell.setRow(b);
            }
           // System.out.println("Y Interation: " + b + "  yFound: " + yFound);

        }
        //System.out.println("Printed Row: " + cell.getRow() + " Printed Column: " + cell.getCol());
        return cell;
    }

    public BoardPanel() {

    }

}
