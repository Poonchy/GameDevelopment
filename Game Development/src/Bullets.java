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
	private double angle;
	private int original;
	
	public Bullets(Main main, int LocalX, int LocalY, int GlobalX, int GlobalY, int width, int height, BufferedImage image, int speed, int duration, double angle, boolean left) {
		super(main, LocalX, LocalY, GlobalX, GlobalY, width, height, image, speed, duration);
		this.width = width;
		this.LocalX = LocalX;
		this.LocalY = LocalY;
		this.GlobalX = GlobalX;
		this.GlobalY = GlobalY;
		this.height = height;
		this.image = image;
		this.speed = speed;
		this.duration = duration;
		this.angle = angle;
	}
	
	public static void makeBullet(int xposition, int yposition) {
		int mouseY = MouseInfo.getPointerInfo().getLocation().y;
        int mouseX = MouseInfo.getPointerInfo().getLocation().x;
        if (GameState.defaultchar.turnedLeft == true) {
        	double angle = -Math.atan2(mouseY - yposition-25, mouseX - xposition-100);
        	angle += Math.random() * .1;
        	angle -= Math.random() * .1;
        	Bullets tempbullet = new Bullets (main, GameState.activePlayer.LocalX, yposition+30 - Main.YOffSet, GameState.activePlayer.GlobalX, yposition+30, 10, 10, AssetLoader.bullet, 25, 100, angle, true);
        	bulletlist.add(tempbullet);
        } else {
        	double angle = -Math.atan2(mouseY - yposition-45, mouseX - xposition-50);
        	angle += Math.random() * .1;
        	angle -= Math.random() * .1;
        	Bullets tempbullet = new Bullets (main, GameState.activePlayer.LocalX, yposition+30 - Main.YOffSet, GameState.activePlayer.GlobalX + 110, yposition+30, 10, 10, AssetLoader.bullet, 25, 100, angle, false);
        	bulletlist.add(tempbullet);
        }
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
        	  @Override
        	  public void run() {
    			bulletlist.poll();
        	  }
    	}, 1000);
	}
	
	
	@Override
	public void update() {
		this.GlobalX += this.speed * Math.cos(this.angle);
		this.GlobalY -= this.speed * Math.sin(this.angle);
		this.LocalX = this.GlobalX - Main.XOffSet;
		this.LocalY = this.GlobalY;
	}
	
	@Override
	public void render(Graphics g) {
		double width = this.width;
		double height = this.height;
		double testx = width / AssetLoader.bullet.getWidth();
		double testy = height / AssetLoader.bullet.getHeight();
		Graphics2D g2d = (Graphics2D) g;
		AffineTransform at = new AffineTransform();
		at.translate(this.LocalX, this.LocalY);
		if (GameState.defaultchar.turnedLeft == true) {
			at.rotate(-this.angle, 0, -10);
		} else {
			at.rotate(-this.angle, 50, 0);
		}
		at.scale(testx, testy);
	    g2d.drawImage(image, at, null);
	}

}
