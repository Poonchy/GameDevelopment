import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class Creature extends Entity{
	
	public BufferedImage image;
	public int health;
	public int speedx;

	public Creature(Main main, int x, int y, int width, int height, BufferedImage image, int health, int speed) {
		super(main, x, y, width, height);
		this.image = image;
		this.health = health;
		this.speedx = speed;
	}

	@Override
	public abstract void update();

	@Override
	public abstract void render(Graphics g);

}
