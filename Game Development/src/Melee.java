import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.Queue;

public class Melee extends Projectile {
	public static Queue<Melee> meleelist = new ConcurrentLinkedQueue <Melee>();
	public Melee(Main main, int x, int y, int width, int height, BufferedImage image, int speed, int duration) {
		super(main, x, y, width, height, image, speed, duration);
		this.width = width;
		this.xPos = x;
		this.yPos = y;
		this.height = height;
		this.image = image;
		this.speed = speed;
		this.duration = duration;
	}
	
	public static void makeHitbox(int xposition, int yposition) {
    	Melee tempbullet = new Melee (main, xposition, yposition, 50, 100, AssetLoader.bullet, 25, 100);
    	meleelist.add(tempbullet);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
        	  @Override
        	  public void run() {
    			meleelist.poll();
        	  }
    	}, 500);
	}
	
	
	@Override
	public void update() {
		if (Warrior.turnedLeft) {
			this.xPos = GameState.warrior.xPos - 50;
			this.yPos = GameState.warrior.yPos;
		} else {
			this.xPos = GameState.warrior.xPos + GameState.warrior.width;
			this.yPos = GameState.warrior.yPos;
		}
	}
	
	@Override
	public void render(Graphics g) {
		g.fillRect(this.xPos, this.yPos, this.width, this.height);
	}

}
