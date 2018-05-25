import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.Queue;

public class Forcefield extends Projectile{
	public static Queue<Forcefield> forcefieldlist = new ConcurrentLinkedQueue <Forcefield>();
	static BufferedImage forcefieldimg = ImageLoader.loadImage("res/textures/forcefield.png");
	public static int forcefieldcd = 1;
	public static boolean isCharging;
	public Forcefield(Main main, int x, int y, int width, int height, BufferedImage image, int duration, int speed) {
		super(main, x, y, width, height, image, speed, duration);
		this.width = width;
		this.xPos = x;
		this.yPos = y;
		this.height = height;
		this.image = image;
		this.speed = speed;
		this.duration = duration;
	}
	
	public static void makeForcefield(int xposition, int yposition) {
		if (forcefieldcd > 0) {
			Forcefield forcefield = new Forcefield(main, GameState.ladycharacter.xPos-20, GameState.ladycharacter.yPos-20, 140, 140,  forcefieldimg, 5000, 0);
			forcefieldlist.add(forcefield);
	        Timer timer = new Timer();
	        timer.schedule(new TimerTask() {
	        	  @Override
	        	  public void run() {
	    			forcefieldlist.poll();
	        	  }
	    	}, 5000);
	        Timer add = new Timer();
	        add.schedule(new TimerTask() {
	        	  @Override
	        	  public void run() {
	    			forcefieldcd += 1;
	        	  }
	    	}, 10000);
	        forcefieldcd -= 1;
		}
	}
	
	
	@Override
	public void update() {
		this.xPos = GameState.ladycharacter.xPos - 20;
		this.yPos = GameState.ladycharacter.yPos - 20;
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(forcefieldimg, this.xPos, this.yPos, this.width, this.height, null);
	}

}