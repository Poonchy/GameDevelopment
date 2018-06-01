import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class Projectile extends Entity{
	
	public int speed;
	public BufferedImage image;
	public int duration;

	public Projectile(Main main, int x, int y, int width, int height, BufferedImage image, int speed, int duration) {
		super(main, x, y, width, height);
		this.speed = speed;
		this.duration = duration;
		this.image = image;
	}

	@Override
	public abstract void update();

	@Override
	public abstract void render(Graphics g);

}
