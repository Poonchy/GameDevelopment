import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.Queue;

public class Bullets extends Projectile {
	public static Queue<Bullets> bulletlist = new ConcurrentLinkedQueue <Bullets>();
	static BufferedImage bullet = ImageLoader.loadImage("res/textures/bullet.png");
	private double angle;
	private boolean left;
	public Bullets(Main main, int x, int y, int width, int height, BufferedImage image, int speed, int duration, double angle, boolean left) {
		super(main, x, y, width, height, image, speed, duration);
		this.width = width;
		this.xPos = x;
		this.yPos = y;
		this.height = height;
		this.image = image;
		this.speed = speed;
		this.duration = duration;
		this.angle = angle;
		this.left = left;
	}
	
	public static void makeBullet(int xposition, int yposition) {
		int mouseY = MouseInfo.getPointerInfo().getLocation().y;
        int mouseX = MouseInfo.getPointerInfo().getLocation().x;
        double angle = -Math.atan2((mouseY-yposition),(mouseX-xposition));
        if (GameState.turnedLeft == true) {
        	Bullets tempbullet = new Bullets (main, xposition + 80 + (int)(50 * Math.cos(angle)), yposition - (int)(50 * Math.sin(angle)), 10, 10, bullet, 10, 100, angle, true);
        	bulletlist.add(tempbullet);
        } else {
        	Bullets tempbullet = new Bullets (main, xposition + 80 + (int)(50 * Math.cos(angle)), yposition + 40 - (int)(50 * Math.sin(angle)), 10, 10, bullet, 10, 100, angle, false);
        	bulletlist.add(tempbullet);
        }
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
        	  @Override
        	  public void run() {
    			bulletlist.poll();
        	  }
    	}, 2000);
	}
	
	
	@Override
	public void update() {
		if (this.left == true) {
			this.xPos += this.speed * Math.cos(this.angle);
			this.yPos -= this.speed * Math.sin(this.angle);
		} else {
			this.xPos += this.speed * Math.cos(this.angle);
			this.yPos -= this.speed * this.angle;
		}
	}
	
	@Override
	public void render(Graphics g) {
		double width = this.width;
		double height = this.height;
		double testx = width / bullet.getWidth();
		double testy = height / bullet.getHeight();
		Graphics2D g2d = (Graphics2D) g;
		AffineTransform at = new AffineTransform();
		at.translate(this.xPos, this.yPos);
		if (this.left == true) {
			at.rotate(-this.angle, -80-(int)(50 * Math.cos(angle)), -(int)(50 * Math.sin(angle)));
		} else {
			at.rotate(-this.angle);
		}
		at.scale(testx, testy);
	    g2d.drawImage(image, at, null);
	}

}
