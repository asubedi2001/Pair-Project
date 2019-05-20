import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Window {

    private JFrame frame;
    private JPanel contentPane;
    private JPanel scoreContentPane;
    private JPanel endContent;
    private JPanel gameButtonPanel;
    private JPanel endButtonPanel;

    private JButton reset;
    private JButton forfeit;
    private JButton exit;
    private JButton restart;

    private JLabel player1;
    private JLabel player2;
    private JLabel score;
    private JLabel endText;
    private JLabel finalScore;

    private BoardPanel board;
    public static GameState state;
    private int playerOnePoints;
    private int playerTwoPoints;
    
    public Window() {
        initBoard();

        
        board.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {

            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }

            public void mousePressed(MouseEvent e) {

            }

            public void mouseReleased(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                Cell z = board.calcCellClicked(x, y);

                int cellCol = z.getCol();
                int cellRow = z.getRow();

                if ( state.isPlaceable(cellRow, cellCol) ) {
                    if (state.getTurn()) {
                        state.updateCellArray(cellRow, cellCol, 1);

                    } else {

                        state.updateCellArray(cellRow, cellCol, 2);

                    }
                    state.setTurn(!state.getTurn());
                }

                board.repaint();

                playerOnePoints = state.PlayerOnePoints();
                playerTwoPoints = state.PlayerTwoPoints();

                player1.setText("White: " + playerOnePoints);
                player2.setText("Black: " + playerTwoPoints);
                
                if(state.gameOver()) {
                	if(playerOnePoints > playerTwoPoints) {
    					endText.setText("White Wins");
    				}else if(playerTwoPoints > playerOnePoints){
    					endText.setText("Black Wins");
    				}else {
    					endText.setText("Its a Draw");
    				}
                	frame.setContentPane(endContent);
                	frame.validate();
                }
                
                finalScore.setText(playerOnePoints + " - " + playerTwoPoints);
            }
        });
    
        reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetBoard();
			}
        	
        });
   
        forfeit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(state.getTurn()) {
					endText.setText("Black Wins");
				}else {
					endText.setText("White Wins");
				}
				
				frame.setContentPane(endContent);
				frame.validate();
				
			}
        });
   
        exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
        	
        });
    
        restart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new Window();
			}
        	
        });
    }

    public void resetBoard() {
    	 //init all to 0
        for (int a = 0; a < 8; a++) {
            for (int b = 0; b < 8; b++) {
                state.updateCellArray(a, b, Cell.EMPTY);
            }
        }
        //Initialize the states of the beginning pieces (pieces in the middle)
        for (int i = 3; i < 5; i++) {
            for (int a = 3; a < 5; a++) {
                if (i == a) {
                    state.updateCellArray(i, a, Cell.WHITE);
                } else {
                	state.updateCellArray(i, a, Cell.BLACK);
                }
            }
        }
        
        player1.setText("White: 2");
		player2.setText("Black: 2");
		state.setTurn(true);
		board.repaint();
    }
    
	public void initBoard() {
		state = new GameState();
        board = new BoardPanel(state);
        frame = new JFrame("Othello");
        contentPane = new JPanel();
        scoreContentPane = new JPanel();
        endContent = new JPanel();
        gameButtonPanel = new JPanel();
        endButtonPanel = new JPanel();
        finalScore = new JLabel();
        
        playerOnePoints = state.PlayerOnePoints();
        playerTwoPoints = state.PlayerTwoPoints();

        endContent.setLayout(new BoxLayout(endContent, BoxLayout.Y_AXIS));
        
        gameButtonPanel.setLayout(new BoxLayout(gameButtonPanel, BoxLayout.Y_AXIS));
        
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
        contentPane.setPreferredSize(new Dimension(1600, 900));
        contentPane.setOpaque(true);
        contentPane.setBackground(Color.lightGray);

        gameButtonPanel.setBackground(Color.LIGHT_GRAY);
        endContent.setBackground(Color.LIGHT_GRAY);

        
        scoreContentPane.setLayout(new BoxLayout(scoreContentPane, BoxLayout.Y_AXIS));
        scoreContentPane.setPreferredSize(new Dimension(400, 150));
        scoreContentPane.setOpaque(true);
        scoreContentPane.setBackground(Color.lightGray);

        exit = new JButton("Exit Game");
        restart = new JButton("Restart Game");
        reset = new JButton("Reset ");
        forfeit = new JButton("Forfeit");
        
        score = new JLabel("Score: ");
        score.setFont(new Font("Serif", Font.PLAIN, 40));
        score.setForeground(Color.RED);
        score.setAlignmentX(JLabel.TOP_ALIGNMENT);
        score.setBorder(BorderFactory.createEmptyBorder(0, 100, 200, 0));

        player1 = new JLabel("White: 2");
        player1.setFont(new Font("Serif", Font.PLAIN, 30));
        player1.setForeground(Color.BLACK);
        player1.setAlignmentX(JLabel.TOP_ALIGNMENT);
        player1.setBorder(BorderFactory.createEmptyBorder(0, 100, 200, 0));

        player2 = new JLabel("Black: 2");
        player2.setFont(new Font("Serif", Font.PLAIN, 30));
        player2.setForeground(Color.BLACK);
        player2.setAlignmentX(JLabel.TOP_ALIGNMENT);
        player2.setBorder(BorderFactory.createEmptyBorder(0, 100, 200, 0));

        endText = new JLabel();
        endText.setFont(new Font("Serif", Font.PLAIN, 50));
        endText.setForeground(Color.BLACK);
        endText.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        
        endButtonPanel.setAlignmentX(JPanel.CENTER_ALIGNMENT);
        endButtonPanel.setBackground(Color.LIGHT_GRAY);
        endButtonPanel.add(restart);
        endButtonPanel.add(exit);
        
        endContent.add(endText);
        endContent.add(finalScore);
        endContent.add(endButtonPanel);
        
        gameButtonPanel.add(reset);
        gameButtonPanel.add(forfeit);

        scoreContentPane.add(score);
        scoreContentPane.add(player1);
        scoreContentPane.add(player2);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(contentPane);
        frame.pack();
        frame.setResizable(true);
        frame.setVisible(true);

        contentPane.add(gameButtonPanel);
        contentPane.add(board);
        contentPane.add(scoreContentPane);
        frame.setLocationRelativeTo(null);

        state.setTurn(true);
	}
}