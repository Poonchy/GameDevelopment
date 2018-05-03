import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MenuState{
	Main main;
	public MenuState(Main main) {
		this.main = main;
	}
	
	public void update() {
		Button startbtn, endbtn;
		startbtn = new Button(100, 40, 20, 20);
		endbtn = new Button(100, 40, 20, 80);
	}
	
	public void render(Graphics g) {
		
	}
	
}
