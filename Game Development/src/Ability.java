import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class Ability {
	
	public BufferedImage icon;
	public int cooldown, uses;
	public String type;
	
	public Ability(BufferedImage icon, int cooldown, int uses, String type) {
		this.icon = icon;
		this.cooldown = cooldown;
		this.uses = uses;
		this.type = type;
	}
	
	public abstract void update();
	
	public abstract void render(Graphics g);

}
