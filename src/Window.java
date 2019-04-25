import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Window {
	JPanel contentPane;
	JFrame boardPanelFrame;
	JLabel label;


	// KAMEHAMEHAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
	// Can you add a video to a JPanel
	//https://coderanch.com/t/667697/java/Embed-Video-JFrame
	Window(){




		boardPanelFrame = new JFrame("BoardPanel Class");
		contentPane = new JPanel(new GridLayout(0, 2, 10, 10));

		boardPanelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		boardPanelFrame.setContentPane(contentPane);

		boardPanelFrame.pack();
		boardPanelFrame.setSize(1600,850);
		boardPanelFrame.setResizable(true);
	

	}
	private static void runGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new BoardPanel(boardPanelFrame);
	}
	
	public JFrame getJFrame() {
		return boardPanelFrame;
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				runGUI();
			}
		});
	}





}
