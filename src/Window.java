import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window {

	private JFrame frame;
	private JPanel contentPane;
	private JPanel Menu;

	public Window() {


		frame = new JFrame("Sudoku");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		frame.setContentPane(contentPane);

		frame.setVisible(true);
		contentPane.setPreferredSize(new Dimension(500,500));
		frame.pack();
		frame.setResizable(false);

		frame.setLocationRelativeTo(null);
	}

}
