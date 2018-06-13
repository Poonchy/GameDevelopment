import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class Projectile extends Entity{
	
	public int speed;
	public BufferedImage image;
	public int duration;

	public Projectile(Main main, int LocalX, int LocalY, int GlobalX, int GlobalY, int width, int height, BufferedImage image, int speed, int duration) {
		super(main, LocalX, LocalY, GlobalX, GlobalY, width, height);
		this.speed = speed;
		this.duration = duration;
		this.image = image;
	}

	@Override
	public abstract void update();

	@Override
	public abstract void render(Graphics g);

}
