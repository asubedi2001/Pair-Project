import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Window {

	private JFrame frame;
	private JPanel contentPane;
	private JPanel Menu;
	private JLabel backgroundImg;
	private BoardPanel board;
	private GameState state;
	private JLabel score;

	public Window() {
		state = new GameState();
		board = new BoardPanel();
		frame = new JFrame("Othello");
		contentPane = new JPanel();

		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		contentPane.setPreferredSize(new Dimension(1600,900));
		contentPane.add(board);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(contentPane);
		frame.pack();
		frame.setResizable(true);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		contentPane.addMouseListener(new MouseListener()
		{
			public void mouseClicked(MouseEvent e) {	
			}
			
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}

			public void mousePressed(MouseEvent e){		
			}
			public void mouseReleased(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				
				Cell z = board.calcCellClicked(x,y);
				int cellCol = z.getCol();
				int cellRow = z.getRow();
				Cell[][] copyCellArray = GameState.getCellArray();
				if(state.isPlaceable(copyCellArray[cellRow][cellCol])) {
					if(state.getTurn()) {
						GameState.getCellArray()[cellRow][cellCol].setWhite();	
					}else {
						GameState.getCellArray()[cellRow][cellCol].setBlack();
					}
					state.setTurn(!state.getTurn());
					board.repaint();
				}
			}
		});
		
	}

}
