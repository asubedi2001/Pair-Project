import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel {
    GameState state;
    int counter = 0;

    BoardPanel(GameState gameState) {
        state = gameState;
    }

    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
        int w = this.getWidth();
        int h = this.getHeight();
        Graphics2D G = (Graphics2D) g;
        counter++;

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
        for (int a = 0; a < 8; a++) {
            for (int b = 0; b < 8; b++) {
                if (state.getCurrentBoard()[a][b] == 1) {
                    int[] coordinate = calcPixStart(new Cell(a, b, 1));
                    G.setColor(Color.BLACK);
                    G.drawOval(coordinate[0] +5, coordinate[1] + 8, (w / 8) -8, (h / 8) -8);
                }
                if (state.getCurrentBoard()[a][b] == 2) {
                    int[] coordinate = calcPixStart(new Cell(a, b, 2));
                    G.setColor(Color.BLACK);
                    G.fillOval(coordinate[0] + 5, coordinate[1] + 8, (w / 8) -8, (h / 8) -8);
                    G.drawOval(coordinate[0] + 5, coordinate[1] + 8, (w / 8) -8, (h / 8) -8);
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
        coordinate[0] = (w / 8) * xCell + 1;
        coordinate[1] = (h / 8) * yCell + 1;
        return coordinate;

    }

    public Cell calcCellClicked(int xPix, int yPix) {
        int h = this.getHeight();
        int w = this.getWidth();

        final int widthDifference = (w / 8);
        final int heightDifference = (h / 8);

        boolean xFound = false;
        boolean yFound = false;

        Cell cell = new Cell();

        for (int a = 0; a < 8; a++) {
            if (!xFound) {
                xFound = (xPix >= ((widthDifference) * a) && xPix <= ((widthDifference) * a + (widthDifference)));
                cell.setCol(a);
            }

        }

        for (int b = 0; b < 8; b++) {

            if (!yFound) {
                yFound = (yPix >= ((heightDifference) * b) && yPix <= ((heightDifference) * b + (heightDifference)));

                cell.setRow(b);
            }

        }
        return cell;
    }



}