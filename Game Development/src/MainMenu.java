import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MainMenu {
	public void createMenu() {
		JFrame Menu = new JFrame("Main Menu");
		Menu.getContentPane().add(startButton());
		Menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Menu.getContentPane().setBackground(Color.red); 
		Menu.setSize(1200, 700);
		Menu.setVisible(true);
	}
	public JButton startButton() {
		JButton startBtn = new JButton("Start Game");
		startBtn.setSize(100,20);
		return startBtn;
	}
}
