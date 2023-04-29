import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Puzzle extends JFrame implements ActionListener {

	JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, next,Exit;
	JLabel timerLabel;
	boolean isTimerStart = false;
	private JLabel imageLabel,imageLabel2,imageLabel3,imageLabel4,imageLabel5,imageLabel6;
	private JLayeredPane lpane = new JLayeredPane();

	private JPanel panel,panel2;
	private ImageIcon image2;



	Puzzle() {


        

		super("8- PUZZLE GAME");
		
		
		  

		b1 = new JButton("1");
		b2 = new JButton(" ");
		b3 = new JButton("3");
		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		b7 = new JButton("7");
		b8 = new JButton("8");
		b9 = new JButton("2");
		
		next = new JButton("New");
		Exit = new JButton( "Exit");

		b1.setBackground(Color.decode("#2ec4b6"));
		b2.setBackground(Color.decode("#2ec4b6"));
		b3.setBackground(Color.decode("#2ec4b6"));
		b4.setBackground(Color.decode("#2ec4b6"));
		b5.setBackground(Color.decode("#2ec4b6"));
		b6.setBackground(Color.decode("#2ec4b6"));
		b7.setBackground(Color.decode("#2ec4b6"));
		b8.setBackground(Color.decode("#2ec4b6"));
		b9.setBackground(Color.decode("#2ec4b6"));
		
		b1.setBounds(350, 120, 75, 60);
		b2.setBounds(450, 120, 75, 60);
		b3.setBounds(550, 120, 75, 60);
		b4.setBounds(350, 200, 75, 60);
		b5.setBounds(450, 200, 75, 60);
		b6.setBounds(550, 200, 75, 60);
		b7.setBounds(350, 280, 75, 60);
		b8.setBounds(450, 280, 75, 60);
		b9.setBounds(550, 280, 75, 60);
		next.setBounds(350, 370, 125, 50);
		Exit.setBounds(500,370,125,50);


		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(b6);
		add(b7);
		add(b8);
		add(b9);
		add(next);
		add(Exit);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);


		next.addActionListener(this);
		next.setBackground(Color.decode("#ffca3a"));
		next.setForeground(Color.white);

        Exit.setBackground(Color.decode("#ef233c"));
		Exit.setForeground(Color.white);
        Exit.addActionListener(e -> dispose());




		timerLabel = new JLabel(" Time Left - 01:00");
		timerLabel.setHorizontalAlignment(JLabel.CENTER);
		timerLabel.setBorder(BorderFactory.createLineBorder(Color.blue));
		  timerLabel.setFont(new Font("Arial", Font.PLAIN, 35));
		  timerLabel.setForeground(Color.black);
		  timerLabel.setOpaque(true);
		  timerLabel.setBackground(Color.gray);
		add(timerLabel, BorderLayout.NORTH);

		JLabel label = new JLabel("<html> How to Play the Game ? <br><br>  1 - Click on the tile which you want to move <br> 2 -  It Shifts to availabel vacant place <br> 3 - Arrange all the Tile in Ascending Order <br> 4 -  Take care of the Timer <br> <br>Henry is Waiting For You</html>");
		label.setFont(new Font("Arial", Font.PLAIN, 25));
		add(label);
		label.setBorder(BorderFactory.createLineBorder(Color.gray, 3));
		label.setBounds(20,100,300,370);
		
		add(label);
        add(timerLabel, BorderLayout.NORTH);
        setLocationRelativeTo(null);



         panel = new JPanel(new BorderLayout());

		ImageIcon imageIcon = new ImageIcon("1.png");
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(330, 530, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        imageLabel = new JLabel(scaledIcon);

		panel.add(imageLabel, BorderLayout.EAST);


	
		JLabel background = new JLabel(new ImageIcon("puzzle.png"));
		//setContentPane(background);
		add(background);

		
		getContentPane().setBackground(Color.decode("#6290c3"));

		
		//setLayout(null);
		
        setLocationRelativeTo(null);

        getContentPane().add(panel);
		//getContentPane().add(panel2);
        setSize(new Dimension(1000, 600));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // Show the frame
        setVisible(true);
		setLayout(new BorderLayout());
		setResizable(false);

		
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(!isTimerStart) {
			  // Create the timer with a 3 minute interval
			  int interval = 1000; // 1 second
			  int duration =60; // 2 minutes
			  Timer timer = new Timer(interval, new TimerListener(duration,this ));
			  timer.start();
			  isTimerStart = true;
		}

		if (e.getSource() == next) {

			String s = b4.getText();
			b4.setText(b9.getText());
			b9.setText(s);

			s = b1.getText();
			b1.setText(b5.getText());
			b5.setText(s);

			s = b2.getText();
			b2.setText(b7.getText());
			b7.setText(s);

			

		}

		if (e.getSource() == b1) {
			String s = b1.getText();
			if (b2.getText().equals(" ")) {
				b2.setText(s);
				b1.setText(" ");
			} else if (b4.getText().equals(" ")) {
				b4.setText(s);
				b1.setText(" ");
			}

		}

		if (e.getSource() == b2) {
			String s = b2.getText();
			if (b1.getText().equals(" ")) {
				b1.setText(s);
				b2.setText(" ");
			} else if (b3.getText().equals(" ")) {
				b3.setText(s);
				b2.setText(" ");
			} else if (b5.getText().equals(" ")) {
				b5.setText(s);
				b2.setText(" ");
			}

		}

		if (e.getSource() == b3) {
			String s = b3.getText();
			if (b2.getText().equals(" ")) {
				b2.setText(s);
				b3.setText(" ");
			} else if (b6.getText().equals(" ")) {
				b6.setText(s);
				b3.setText(" ");
			}

		}

		if (e.getSource() == b4) {
			String s = b4.getText();
			if (b1.getText().equals(" ")) {
				b1.setText(s);
				b4.setText(" ");
			} else if (b5.getText().equals(" ")) {
				b5.setText(s);
				b4.setText(" ");
			} else if (b7.getText().equals(" ")) {
				b7.setText(s);
				b4.setText(" ");
			}

		}

		if (e.getSource() == b5) {
			String s = b5.getText();
			if (b2.getText().equals(" ")) {
				b2.setText(s);
				b5.setText(" ");
			} else if (b4.getText().equals(" ")) {
				b4.setText(s);
				b5.setText(" ");
			} else if (b6.getText().equals(" ")) {
				b6.setText(s);
				b5.setText(" ");
			} else if (b8.getText().equals(" ")) {
				b8.setText(s);
				b5.setText(" ");
			}

		}

		if (e.getSource() == b6) {
			String s = b6.getText();
			if (b3.getText().equals(" ")) {
				b3.setText(s);
				b6.setText(" ");
			} else if (b5.getText().equals(" ")) {
				b5.setText(s);
				b6.setText(" ");
			} else if (b9.getText().equals(" ")) {
				b9.setText(s);
				b6.setText(" ");
			}

		}

		if (e.getSource() == b7) {
			String s = b7.getText();
			if (b4.getText().equals(" ")) {
				b4.setText(s);
				b7.setText(" ");
			} else if (b8.getText().equals(" ")) {
				b8.setText(s);
				b7.setText(" ");
			}

		}

		if (e.getSource() == b8) {
			String s = b8.getText();
			if (b7.getText().equals(" ")) {
				b7.setText(s);
				b8.setText(" ");
			} else if (b5.getText().equals(" ")) {
				b5.setText(s);
				b8.setText(" ");
			} else if (b9.getText().equals(" ")) {
				b9.setText(s);
				b8.setText(" ");
			}

		}

		if (e.getSource() == b9) {
			String s = b9.getText();
			if (b8.getText().equals(" ")) {
				b8.setText(s);
				b9.setText(" ");
			} else if (b6.getText().equals(" ")) {
				b6.setText(s);
				b9.setText(" ");
			}

			if (b1.getText().equals("1") && b2.getText().equals("2") &&
					b3.getText().equals("3") && b4.getText().equals("4") &&
					b5.getText().equals("5") && b6.getText().equals("6") &&
					b7.getText().equals("7") && b8.getText().equals("8") &&
					b9.getText().equals(" ")) {
				JOptionPane.showMessageDialog(Puzzle.this, "You won the game!");
			}
		}
	}

	public static void main(String[] args) {

		// new Puzzle();
		new Puzzle();


	}

	
	class TimerListener implements ActionListener {
		private int counter;
		private Puzzle puzzle;

		public TimerListener(int duration, Puzzle puzzle) {
			this.counter = duration;
			this.puzzle = puzzle;
		}

	public void actionPerformed(ActionEvent e) {
		if (counter > 0) {
			counter--;

			if (counter <= 50) {
				
				panel.removeAll();
				ImageIcon imageIcon = new ImageIcon("2.png");
        		Image image = imageIcon.getImage();
        		Image scaledImage = image.getScaledInstance(330, 530, Image.SCALE_SMOOTH);		
				ImageIcon scaledIcon = new ImageIcon(scaledImage);
				imageLabel = new JLabel(scaledIcon);
				panel.add(imageLabel, BorderLayout.EAST);

			}

			if (counter <= 40) {
				
				panel.removeAll();
				ImageIcon imageIcon = new ImageIcon("3.png");
        		Image image = imageIcon.getImage();
        		Image scaledImage = image.getScaledInstance(330, 530, Image.SCALE_SMOOTH);		
				ImageIcon scaledIcon = new ImageIcon(scaledImage);
				imageLabel = new JLabel(scaledIcon);
				panel.add(imageLabel, BorderLayout.EAST);


			}
			
			if (counter <= 30) {
				
				panel.removeAll();
				ImageIcon imageIcon = new ImageIcon("4.png");
        		Image image = imageIcon.getImage();
        		Image scaledImage = image.getScaledInstance(330, 530, Image.SCALE_SMOOTH);		
				ImageIcon scaledIcon = new ImageIcon(scaledImage);
				imageLabel = new JLabel(scaledIcon);
				panel.add(imageLabel, BorderLayout.EAST);


			}
			if (counter <= 20) {
				
				panel.removeAll();
				ImageIcon imageIcon = new ImageIcon("5.png");
        		Image image = imageIcon.getImage();
        		Image scaledImage = image.getScaledInstance(330, 530, Image.SCALE_SMOOTH);		
				ImageIcon scaledIcon = new ImageIcon(scaledImage);
				imageLabel = new JLabel(scaledIcon);
				panel.add(imageLabel, BorderLayout.EAST);


			}
			if (counter <= 10) {
				
				panel.removeAll();
				ImageIcon imageIcon = new ImageIcon("6.png");
        		Image image = imageIcon.getImage();
        		Image scaledImage = image.getScaledInstance(330, 530, Image.SCALE_SMOOTH);		
				ImageIcon scaledIcon = new ImageIcon(scaledImage);
				imageLabel = new JLabel(scaledIcon);
				panel.add(imageLabel, BorderLayout.EAST);


			}

			int minutes = counter / 60;
			int seconds = counter % 60;
			timerLabel.setText(String.format("Time Left - %02d:%02d", minutes, seconds));
		} else {
		
			Object[] options = {"Exit", "Play Again"};
			int choice = JOptionPane.showOptionDialog(Puzzle.this,
					"Game over! Do you want to play again?",
					"Game Over",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null,
					options,
					options[1]);
	
			if (choice == JOptionPane.YES_OPTION) {
				puzzle.dispose(); // close the JFrame
			} else if (choice == JOptionPane.NO_OPTION) {
				puzzle.setVisible(false); // hide the JFrame
				puzzle.dispose(); // dispose the JFrame
				main(null); // restart the application
			}
			((Timer) e.getSource()).stop();
		}
	 }
   }
}

