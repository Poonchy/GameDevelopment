import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Projectile extends Entity{
	
	public int speed;
	public BufferedImage image;
	public int duration;

	public Projectile(Main main, int x, int y, int width, int height, BufferedImage image, int speed, int duration) {
		super(main, x, y, width, height);
		this.image = image;
		this.speed = speed;
		this.duration = duration;
	}

	@Override
	public void update() {
		
	}

	@Override
	public void render(Graphics g) {
		
	}

}
