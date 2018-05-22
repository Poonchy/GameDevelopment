import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
public class GameState extends State {
	Main main;
	static Player character;
	Bullets boolet;
	
	public GameState(Main main) {
		super(main);
		character = new Player(main, 10, main.windowHeight, 100, 100, ImageLoader.loadImage("res/textures/capn.png"), 4, 4, -15, 4, 4);
	}
	
	public void update() {
		
		character.update();
		
		for (Bullets b: Bullets.bulletlist) {
			b.update();
		}
		for (Grenade g: Grenade.grenadelist) {
			g.update();
		}
	}
	
	public void render(Graphics g) {
		character.render(g);
	}
}
