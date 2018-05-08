import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends Creature{
	
	public ArrayList<Upgrade> upgrades;
	public Ability[] abilities;
	
	public Player(Main main, int x, int y, int width, int height, BufferedImage image, int health, int speed, int jump, int baseDamage, int attackSpeed) {
		super(main, x, y, width, height, image, health, speed, jump, baseDamage, attackSpeed);
		abilities = new Ability[4];
		upgrades = new ArrayList<Upgrade>();
		
	}

	@Override
	public void update() {
		
	}

	@Override
	public void render(Graphics g) {
		
		
	}
	

}
