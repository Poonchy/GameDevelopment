import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Projectile extends Entity{
	
	public int speed;
	public BufferedImage image;

	public Projectile(Main main, int x, int y, int width, int height, BufferedImage image) {
		super(main, x, y, width, height);
		this.image = image;
	}

	@Override
	public void update() {
		
		
	}

	@Override
	public void render(Graphics g) {
		
		
	}

}
