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
		g.drawImage(image, xPos, yPos, width, height, null);
	}
	
	
	private boolean isCollected() {
		if((((GameState.defaultchar.xPos + 100 >= this.xPos)
				&&(GameState.defaultchar.xPos  <= (this.xPos + this.width)))
				&&((GameState.defaultchar.yPos + GameState.defaultchar.height  >= this.yPos) 
				&&(GameState.defaultchar.yPos + GameState.defaultchar.height  <= (this.yPos + this.height))))) 
			{
				return true;
			}
				return false;
	}
	
	

}
