import java.awt.Graphics;
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

	public void paint(Graphics g) {
		int w = this.getWidth();
		int h = this.getHeight();
		// TODO when u have gui buttons, make sure to shift the bottom/right-most line
		// down/right 1 pixel again

		for (int i = 0; i < 9; i++) {
			// draw horz lines
			if (i < 8 && i > 0) {
				g.drawLine(0, h - ((h / 8) * i), w, h - ((h / 8) * i));
			} else if (i == 8) {
				g.drawLine(0, 0, w, 0);
			} else {
				g.drawLine(0, h - 1, w, h - 1);
			}

		}

		for (int i = 0; i < 9; i++) {
			// draw vert lines
			if (i < 8 && i > 0) {
				g.drawLine(w - ((w / 8) * i), 0, w - ((w / 8) * i), h);
			} else if (i == 8) {
				g.drawLine(0, 0, 0, h);
			} else {
				g.drawLine(w - 1, 0, w - 1, h);
			}

		}

	}

	public void repaint(Cell[][] cellArray) {
		this.paint(this.getGraphics());
		int w = this.getWidth();
		int h = this.getHeight();
		//draw circles:
		for(Cell[] currentCellArray:cellArray) {
			for(Cell currentCell:currentCellArray) {
				blackCirc.setIcon(new ImageIcon(blackCircIcon.getImage().getScaledInstance(w/8, h/8, Image.SCALE_SMOOTH)));
				whiteCirc.setIcon(new ImageIcon(whiteCircIcon.getImage().getScaledInstance(w/8, h/8, Image.SCALE_SMOOTH)));
				if(currentCell.getState() == 1) {
					JLabel whiteCopy = whiteCirc;
					int[] coordinate = calcPixStart(currentCell);
					this.add(whiteCopy);
					whiteCopy.setLocation(coordinate[0], coordinate[1]);
				}else if(currentCell.getState() == 2){
					JLabel blackCopy = blackCirc;
					int[] coordinate = calcPixStart(currentCell);
					this.add(blackCopy);
					blackCopy.setLocation(coordinate[0], coordinate[1]);
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
		coordinate[0] = w - ((8 - xCell) - (w / 8));
		coordinate[1] = h - ((8 - yCell) - (h / 8));
		return coordinate;
	}

	private Cell calcCellClicked(int xPix, int yPix) {
		int rowClicked=-1, colClicked=-1;
		int h = this.getHeight();
		int w = this.getWidth();

		final int widthDifference = (w/8);
		final int heightDifference = (h/8);

		boolean xFound = false;
		boolean yFound = false;
		int row;
		int col;
		for(int a = 0; a < 8; a++) {

			while(!xFound) {
				xFound = (xPix <= ((w/8)*a) && xPix >= ((w/8)*a +(w/8)) );
			}

			row = a;
		}

		for(int b = 0; b < 8; b++) {

			while(!yFound) {
				yFound = (yPix <= ((h/8)*b) && yPix >= ((h/8)*b +(h/8)) );
			}

			col = b;
		}



		System.out.println(rowClicked + " " + colClicked);
	}

	public BoardPanel() {

	}

	void mouseListener(MouseEvent e) {

	}

	public void paintComponent(Graphics g) {

	}

	public void setMode(boolean solvingMode) {

	}

}
