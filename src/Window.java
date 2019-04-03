
public class Window {

	private JFrame frame;
	private JPanel contentPane;
	private JPanel Menu;
	
	frame = new JFrame("Sudoku");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	contentPane = new JPanel();
	contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
	frame.setContentPane(contentPane);

	

	frame.setVisible(true);
	frame.pack();
	frame.setResizable(false);

	frame.setLocationRelativeTo(null);

	
}
