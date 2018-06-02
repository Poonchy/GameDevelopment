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
	public Melee(Main main, int LocalX, int LocalY, int GlobalX, int GlobalY, int width, int height, BufferedImage image, int speed, int duration) {
		super(main, LocalX, LocalY, GlobalX, GlobalY, width, height, image, speed, duration);
		this.width = width;
		this.LocalX = LocalX;
		this.LocalY = LocalY;
		this.height = height;
		this.image = image;
		this.speed = speed;
		this.duration = duration;
	}
	
	public static void makeHitbox(int xposition, int yposition) {
    	Melee tempbullet = new Melee (main, xposition - Main.XOffSet, yposition - Main.YOffSet, xposition, yposition, 50, 100, AssetLoader.bullet, 25, 100);
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
			this.LocalX = GameState.warrior.LocalX - 50;
			this.LocalY = GameState.warrior.LocalY;
			this.GlobalX = GameState.warrior.GlobalX - 50;
			this.GlobalY = GameState.warrior.GlobalY;
		} else {
			this.LocalX = GameState.warrior.LocalX + GameState.warrior.width;
			this.LocalY = GameState.warrior.LocalY;
			this.GlobalX = GameState.warrior.GlobalX + GameState.warrior.width;
			this.GlobalY = GameState.warrior.GlobalY;
		}
	}
	
	@Override
	public void render(Graphics g) {
		g.fillRect(this.LocalX, this.LocalY, this.width, this.height);
	}

}
