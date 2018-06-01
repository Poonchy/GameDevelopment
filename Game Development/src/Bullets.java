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
	static BufferedImage bullet = ImageLoader.loadImage("res/textures/bullet.png");
	private double angle;
	
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
	}
	
	public static void makeBullet(int xposition, int yposition) {
		int mouseY = MouseInfo.getPointerInfo().getLocation().y;
        int mouseX = MouseInfo.getPointerInfo().getLocation().x;
        if (GameState.character.turnedLeft == true) {
        	double angle = -Math.atan2(mouseY - yposition-25, mouseX - xposition-100);
        	angle += Math.random() * .1;
        	angle -= Math.random() * .1;
        	Bullets tempbullet = new Bullets (main, xposition+100, yposition+30, 10, 10, bullet, 25, 100, angle, true);
        	Player.bulletlist.add(tempbullet);
        } else {
        	double angle = -Math.atan2(mouseY - yposition-45, mouseX - xposition-50);
        	angle += Math.random() * .1;
        	angle -= Math.random() * .1;
        	Bullets tempbullet = new Bullets (main, xposition+10, yposition+50, 10, 10, bullet, 25, 100, angle, false);
        	Player.bulletlist.add(tempbullet);
        }
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
        	  @Override
        	  public void run() {
    			Player.bulletlist.poll();
        	  }
    	}, 1000);
	}
	
	
	@Override
	public void update() {
		this.xPos += this.speed * Math.cos(this.angle);
		this.yPos -= this.speed * Math.sin(this.angle);
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
		if (GameState.character.turnedLeft == true) {
			at.rotate(-this.angle, 0, -10);
		} else {
			at.rotate(-this.angle, 50, 0);
		}
		at.scale(testx, testy);
	    g2d.drawImage(image, at, null);
	}

}
