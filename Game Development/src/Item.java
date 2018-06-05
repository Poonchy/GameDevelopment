import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Item extends Entity{
	
	public BufferedImage image;

	public Item(Main main, int x, int y, int width, int height, BufferedImage image) {
		super(main, x, y, width, height);
		this.image = image;
	}

	@Override
	public void update() {
		
		if(isCollected()) {
			System.out.println("TOUCHING THE ITEM");
			GameState.defaultchar.upgrades.add(Player.grenadaSplit);
			GameState.items[0] = null;
		}
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(image, xPos - Main.xOffset, yPos - Main.yOffset, width, height, null);
	}
	
	
	private boolean isCollected() {
		if((((GameState.defaultchar.xPos + 100 >= this.xPos - Main.xOffset)
				&&(GameState.defaultchar.xPos  <= (this.xPos + this.width - Main.xOffset)))
				&&((GameState.defaultchar.yPos + GameState.defaultchar.height  >= this.yPos - Main.yOffset) 
				&&(GameState.defaultchar.yPos + GameState.defaultchar.height  <= (this.yPos + this.height - Main.yOffset))))) 
			{
				return true;
			}
				return false;
	}
	
	

}
