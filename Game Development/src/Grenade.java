import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.Queue;

public class Grenade extends Projectile {
	public static Queue<Grenade> grenadelist = new ConcurrentLinkedQueue <Grenade>();
	static BufferedImage grenade = ImageLoader.loadImage("res/textures/grenade.png");
	private double angle;
	private int yspeed;
	public static int grenadecd = 3;
	public static boolean isCharging;
	public Grenade(Main main, int x, int y, int width, int height, BufferedImage image, int speed, int duration, double angle, boolean left, int yspeed) {
		super(main, x, y, width, height, image, speed, duration);
		this.width = width;
		this.xPos = x;
		this.yPos = y;
		this.height = height;
		this.image = image;
		this.speed = speed;
		this.duration = duration;
		this.angle = angle;
		this.yspeed = yspeed;
	}
	
	public static void makeGrenade(int xposition, int yposition) {
		if (grenadecd > 0) {
			int mouseY = MouseInfo.getPointerInfo().getLocation().y;
	        int mouseX = MouseInfo.getPointerInfo().getLocation().x;
	        if (GameState.turnedLeft == true) {
	        	double angle = -Math.atan2(mouseY - yposition-25, mouseX - xposition-100);
	        	Grenade tempbullet = new Grenade (main, xposition+100, yposition+30, 30, 30, grenade, 18, 30, angle, true, 25);
	        	grenadelist.add(tempbullet);
	        } else {
	        	double angle = -Math.atan2(mouseY - yposition-45, mouseX - xposition-50);
	        	Grenade tempbullet = new Grenade (main, xposition+10, yposition+50, 30, 30, grenade, 18, 30, angle, false, 25);
	        	grenadelist.add(tempbullet);
	        }
	        Timer timer = new Timer();
	        timer.schedule(new TimerTask() {
	        	  @Override
	        	  public void run() {
	    			grenadelist.poll();
	        	  }
	    	}, 3000);
	        grenadecd -= 1;
		}
	}
	
	
	@Override
	public void update() {
		this.xPos += this.speed * Math.cos(this.angle);
		this.yspeed -= 1;
		this.yPos -= this.yspeed;
	}
	
	@Override
	public void render(Graphics g) {
		double width = this.width;
		double height = this.height;
		double testx = width / grenade.getWidth();
		double testy = height / grenade.getHeight();
		Graphics2D g2d = (Graphics2D) g;
		AffineTransform at = new AffineTransform();
		at.translate(this.xPos, this.yPos);
		if (GameState.turnedLeft == true) {
			at.rotate(-this.angle, 0, -10);
		} else {
			at.rotate(-this.angle, 50, 0);
		}
		at.scale(testx, testy);
	    g2d.drawImage(image, at, null);
	}

}