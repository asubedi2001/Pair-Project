import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;



public class BoardPanel extends JPanel{

	private int panelWidth;
	private int panelHeight;
	private JFrame windowFrame;
	
	BoardPanel(JFrame frame){
		windowFrame = frame;
		panelWidth = windowFrame.getWidth();  
		panelHeight= windowFrame.getHeight();  
	}

	
	void mouseListener(MouseEvent e) {
		
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D OG = (Graphics2D) g;
		
		g.setColor(Color.BLACK);
		
		g.drawLine(panelHeight/8, panelWidth/8, 50, 50);
		
		
		OG.setColor(Color.BLACK);


		OG.setColor(Color.RED);



		OG.setColor(Color.BLACK);

	}  
	private static void runGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new Window();
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				runGUI();
			}
		});
	}
	
	public void setMode(boolean solvingMode) {
		
	}

	
}
