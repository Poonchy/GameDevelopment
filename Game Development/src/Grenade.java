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
	private double angle;
	private int yspeed;
	
	public Grenade( int x, int y, int width, int height, int speed, int duration, double angle, int yspeed) {
		super(main, x, y, width, height, AssetLoader.grenade, speed, duration);
		this.width = width;
		this.xPos = x;
		this.yPos = y;
		this.height = height;
		this.speed = speed;
		this.duration = duration;
		this.angle = angle;
		this.yspeed = yspeed;
	}
	
	public static void makeGrenade(int xposition, int yposition) {
		if (Grenada.grenadecd > 0) {
			int mouseY = MouseInfo.getPointerInfo().getLocation().y;
	        int mouseX = MouseInfo.getPointerInfo().getLocation().x;
	        if (GameState.defaultchar.turnedLeft == true) {
	        	double angle = -Math.atan2(mouseY - yposition-25, mouseX - xposition-100);
	        	Grenade tempbullet = new Grenade ( xposition+100, yposition+30, 30, 30, 18, 30, angle, 25);
	        	grenadelist.add(tempbullet);
	        } else {
	        	double angle = -Math.atan2(mouseY - yposition-45, mouseX - xposition-50);
	        	Grenade tempbullet = new Grenade ( xposition+10, yposition+50, 30, 30, 18, 30, angle, 25);
	        	grenadelist.add(tempbullet);
	        }
	        Timer timer = new Timer();
	        timer.schedule(new TimerTask() {
	        	  @Override
	        	  public void run() {
	    			grenadelist.poll();
	    			
	        	  }
	    	}, 1000);
	        Grenada.grenadecd -= 1;
		}
	}
	
	// launch grenade based on distance inputed *not mouse position*
	public static void makeGrenade(int xposition, int yposition, int distanceX, int distanceY) {
		if (Grenada.grenadecd > 0) {
	        if (GameState.defaultchar.turnedLeft == true) {
	        	double angle = -Math.atan2(distanceY, distanceX*-1);
	        	Grenade tempbullet = new Grenade ( xposition+100, yposition+30, 30, 30, 18, 30, angle, 25);
	        	grenadelist.add(tempbullet);
	        } else {
	        	double angle = -Math.atan2(distanceY, distanceX);
	        	Grenade tempbullet = new Grenade ( xposition+10, yposition+50, 30, 30, 18, 30, angle, 25);
	        	grenadelist.add(tempbullet);
	        }
	        Timer timer = new Timer();
	        timer.schedule(new TimerTask() {
	        	  @Override
	        	  public void run() {
	    			grenadelist.poll();
	    			
	        	  }
	    	}, 1000);
	        Grenada.grenadecd -= 1;
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
		double testx = width / image.getWidth();
		double testy = height / image.getHeight();
		Graphics2D g2d = (Graphics2D) g;
		AffineTransform at = new AffineTransform();
		at.translate(this.xPos, this.yPos);
		if (GameState.defaultchar.turnedLeft == true) {
			at.rotate(-this.angle, 0, -10);
		} else {
			at.rotate(-this.angle, 50, 0);
		}
		at.scale(testx, testy);
	    g2d.drawImage(image, at, null);
	}

}