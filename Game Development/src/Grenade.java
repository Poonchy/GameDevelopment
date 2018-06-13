import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.geom.AffineTransform;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.Queue;

public class Grenade extends Projectile {
	
	public static Queue<Grenade> grenadelist = new ConcurrentLinkedQueue <Grenade>();
	private double angle;
	private int yspeed;
	public static int grenadecd = 3;
	public static boolean isCharging;
	private boolean left;
	
	public Grenade(int LocalX, int LocalY, int GlobalX, int GlobalY, int width, int height, int speed, int duration, double angle, int yspeed, boolean left) {
		super(main, LocalX, LocalY, GlobalX, GlobalY, width, height, AssetLoader.grenade, speed, duration);
		this.width = width;
		this.LocalX = LocalX;
		this.LocalY = LocalY;
		this.height = height;
		this.speed = speed;
		this.duration = duration;
		this.angle = angle;
		this.yspeed = yspeed;
		this.left = left;
	}
	
	public static void makeGrenade(int xposition, int yposition) {
		if (Grenada.grenadecd > 0) {
			int mouseY = MouseInfo.getPointerInfo().getLocation().y;
	        int mouseX = MouseInfo.getPointerInfo().getLocation().x;
	        if (GameState.defaultchar.turnedLeft == true) {
	        	double angle = -Math.atan2(mouseY - (yposition-25 - Main.YOffSet), mouseX - (xposition-100 - Main.XOffSet));
	        	Grenade tempbullet = new Grenade (xposition+100 - Main.XOffSet, yposition+30 - Main.YOffSet, xposition+100, yposition+30, 30, 30, 18, 30, angle, 25, true);
	        	grenadelist.add(tempbullet);
	        } else {
	        	double angle = -Math.atan2(mouseY - (yposition-45  - Main.YOffSet), mouseX - (xposition-50 - Main.XOffSet));
	        	Grenade tempbullet = new Grenade (xposition+10 - Main.XOffSet, yposition+50 - Main.YOffSet, xposition+10, yposition+50, 30, 30, 18, 30, angle, 25, false);
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
	        	Grenade tempbullet = new Grenade (xposition+100 - Main.XOffSet, yposition+30 - Main.YOffSet, xposition+100, yposition+30, 30, 30, 18, 30, angle, 25, true);
	        	grenadelist.add(tempbullet);
	        } else {
	        	double angle = -Math.atan2(distanceY, distanceX);
	        	Grenade tempbullet = new Grenade (xposition+10 - Main.XOffSet, yposition+50 - Main.YOffSet, xposition+10, yposition+50, 30, 30, 18, 30, angle, 25, false);
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
		this.GlobalX += this.speed * Math.cos(this.angle);
		this.yspeed -= 1;
		this.GlobalY -= this.yspeed;
		this.LocalX = this.GlobalX - Main.XOffSet;
		this.LocalY = this.GlobalY - Main.YOffSet;
	}
	
	@Override
	public void render(Graphics g) {
		double width = this.width;
		double height = this.height;
		double testx = width / image.getWidth();
		double testy = height / image.getHeight();
		Graphics2D g2d = (Graphics2D) g;
		AffineTransform at = new AffineTransform();
		at.translate(this.LocalX, this.LocalY);
		if (this.left == true) {
			at.rotate(-this.angle, 0, -10);
		} else {
			at.rotate(-this.angle, 50, 0);
		}
		at.scale(testx, testy);
	    g2d.drawImage(image, at, null);
	}

}