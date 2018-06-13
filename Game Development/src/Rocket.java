import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.Queue;

public class Rocket extends Projectile {
	public static Queue<Rocket> Rocketlist = new ConcurrentLinkedQueue <Rocket>();
	private double angle;
	public Rocket(Main main, int LocalX, int LocalY, int GlobalX, int GlobalY, int width, int height, BufferedImage image, int speed, int duration, double angle, boolean left) {
		super(main, LocalX, LocalY, GlobalX, GlobalY, width, height, image, speed, duration);
		this.width = width;
		this.LocalX = LocalX;
		this.LocalY = LocalY;
		this.height = height;
		this.image = image;
		this.speed = speed;
		this.duration = duration;
		this.angle = angle;
	}
	
	public static void makeRocket(int xposition, int yposition) {
		int mouseY = MouseInfo.getPointerInfo().getLocation().y;
        int mouseX = MouseInfo.getPointerInfo().getLocation().x;
        if (GameState.defaultchar.turnedLeft == true) {
        	double angle = -Math.atan2(mouseY - yposition-25, mouseX - xposition-100);
        	angle += Math.random() * .1;
        	angle -= Math.random() * .1;
        	Rocket tempRocket = new Rocket (main, GameState.activePlayer.LocalX, yposition+30 - Main.YOffSet, GameState.activePlayer.GlobalX, yposition+30, 50, 50, AssetLoader.Rocket, 40, 100, angle, true);
        	Rocketlist.add(tempRocket);
        } else {
        	double angle = -Math.atan2(mouseY - yposition-45, mouseX - xposition-50);
        	angle += Math.random() * .1;
        	angle -= Math.random() * .1;
        	Rocket tempRocket = new Rocket (main, GameState.activePlayer.LocalX, yposition+30 - Main.YOffSet, GameState.activePlayer.GlobalX + 110, yposition+30, 50, 50, AssetLoader.Rocket, 40, 100, angle, false);
        	Rocketlist.add(tempRocket);
        }
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
        	  @Override
        	  public void run() {
    			Rocketlist.poll();
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
		double testx = width / AssetLoader.Rocket.getWidth();
		double testy = height / AssetLoader.Rocket.getHeight();
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
