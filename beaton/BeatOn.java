package beaton;

import java.awt.Font;
//import java.awt.Graphics; //not used until now
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BeatOn extends JFrame {
	
	// Create and Load Resources
	//private Graphics screenGraphics; // Not used until now
	private Font font;
	
	// Menubar
	private JLabel menuBar = new JLabel("BeatOn " + Main.version);
	
	// Title
	private JLabel titleLabel = new JLabel("BeatOn");
	
	// Buttons
	private JButton startButton = new JButton("Start");
	private JButton quitButton = new JButton("X");
	private JButton backButton = new JButton("<");
	
	private int mouseX, mouseY;
	
	public BeatOn() {
		// Init
		setTitle("BeatOn");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		setLayout(null);
		
		// Add Resources
		// MenuBar
		menuBar.setBounds(0, 0, Main.SCREEN_WIDTH, 30);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		
		// Title
		titleLabel.setBounds(Main.SCREEN_WIDTH / 2 - 50, 100, 100, 100);
		font = titleLabel.getFont();
		titleLabel.setFont(new Font(font.getName(), Font.PLAIN, 30));
		
		// StartButton
		styleButton(startButton, Main.SCREEN_WIDTH / 2 - 75, Main.SCREEN_HEIGHT - 200, 150, 50);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				startGame();
			}
		});
		
		// QuitButton
		styleButton(quitButton, Main.SCREEN_WIDTH - 75, Main.SCREEN_HEIGHT - 75, 50, 50);
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				terminate();
			}
		});
		
		// BackButton
		styleButton(backButton, 50, 50, 50, 50);
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				backMain();
			}
		});
		
		// Screen Init
		backButton.setVisible(false);
		
		add(menuBar);
		add(titleLabel);
		add(startButton);
		add(quitButton);
		
		add(backButton);
	}
	private void styleButton(JButton jb, int x, int y, int width, int height) {
		jb.setBounds(x, y, width, height);
		jb.setContentAreaFilled(false);
		jb.setFocusPainted(false);
	}
	
	private void startGame() {
		titleLabel.setVisible(false);
		startButton.setVisible(false);
		quitButton.setVisible(false);
		
		backButton.setVisible(true);
	}
	
	private void backMain() {
		backButton.setVisible(false);
		
		titleLabel.setVisible(true);
		startButton.setVisible(true);
		quitButton.setVisible(true);
	}
	
	public void terminate() {
		//TODO: Exit Code
		System.exit(0);
	}
}
