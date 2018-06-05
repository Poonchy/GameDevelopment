import java.awt.Graphics;

public abstract class Entity {
	
	public static Main main;
	public int LocalX, LocalY, GlobalX, GlobalY, height, width;
	
	
	@SuppressWarnings("static-access")
	public Entity(Main main, int LocalX, int LocalY, int GlobalX, int GlobalY, int width, int height) {
		this.main = main;
		this.LocalX = LocalX;
		this.LocalY = LocalY;
		this.GlobalX = GlobalX;
		this.GlobalY = GlobalY;
		this.width = width;
		this.height = height;
	}
	
	public abstract void update();
	
	public abstract void render(Graphics g);

}
