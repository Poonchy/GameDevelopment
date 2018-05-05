import java.awt.Graphics;

public abstract class Entity {
	
	public Main main;
	public int xPos, yPos, height, width;
	
	
	public Entity(Main main, int x, int y, int width, int height) {
		this.main = main;
		xPos = x;
		yPos = y;
		this.width = width;
		this.height = height;
	}
	
	public abstract void update();
	
	public abstract void render(Graphics g);

}
