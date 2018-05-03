import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MainMenu{
	
	public void createMenu() {
		JFrame Menu = new JFrame("Main Menu");
		Menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Menu.getContentPane().setBackground(Color.red); 
		Menu.setSize(1200, 700);
		Menu.getContentPane().add(startButton());
		Menu.getContentPane().add(helpButton());
		Menu.getContentPane();
		Menu.setVisible(true);
	}
	
	public JButton startButton() {
		JButton startBtn = new JButton("Start Game");
		startBtn.setSize(100,40);
		startBtn.addActionListener(new ActionListener(){
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        System.out.println("This would start the game!");
		    }
		});
		return startBtn;
	}
	
	public JButton helpButton() {
		JButton helpBtn = new JButton("Help");
		helpBtn.setSize(100,40);
		helpBtn.addActionListener(new ActionListener(){
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        System.out.println("This would show instructions!");
		    }
		});
		return helpBtn;
	}
	
}
