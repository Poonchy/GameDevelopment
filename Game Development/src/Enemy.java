import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Enemy extends Creature {

	public Enemy(Main main, int LocalX, int LocalY, int GlobalX, int GlobalY, int width, int height, BufferedImage image, int health, int speed, int jump, int baseDamage, int attackSpeed) {
		super(main, LocalX, LocalY, GlobalX, GlobalY, width, height, image, health, speed, jump, baseDamage, attackSpeed);
		
	}

	@Override
	public void update() {
		

	}

	@Override
	public void render(Graphics g) {
		

	}

}
