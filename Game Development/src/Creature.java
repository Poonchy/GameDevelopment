import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class Creature extends Entity{
	
	public BufferedImage image;
	public int health, speed, jump, baseDamage, attackSpeed;

	public Creature(Main main, int x, int y, int width, int height, BufferedImage image, int health, int speed, int jump, int baseDamage, int attackSpeed) {
		super(main, x, y, width, height);
		this.image = image;
		this.health = health;
		this.speed = speed;
		this.jump = jump;
		this.baseDamage = baseDamage;
		this.attackSpeed = attackSpeed;
	}

	@Override
	public abstract void update();

	@Override
	public abstract void render(Graphics g);

}
