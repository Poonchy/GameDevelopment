import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Enemy extends Creature {

	public Enemy(Main main, int x, int y, int width, int height, BufferedImage image, int health, int speed, int jump, int baseDamage, int attackSpeed) {
		super(main, x, y, width, height, image, health, speed, jump, baseDamage, attackSpeed);
		
	}

	@Override
	public void update() {
		

	}

	@Override
	public void render(Graphics g) {
		

	}

}
