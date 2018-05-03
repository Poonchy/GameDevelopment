import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MenuState{
	Main main;
	Button startbtn, endbtn;
	public MenuState(Main main) {
		this.main = main;
		startbtn = new Button(100, 40, 20, 20, ImageLoader.loadImage("/res/textures/startbtn.png"));
	}
	
	public void update() {
		
	}
	
	public void render(Graphics g) {
		g.drawImage(startbtn.imagepath, startbtn.xPoS, startbtn.yPoS, startbtn.width, startbtn.height, null);
	}
	
}
