import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Item extends Entity{
	
	public BufferedImage image;

	public Item(Main main, int LocalX, int LocalY, int GlobalX, int GlobalY, int width, int height, BufferedImage image) {
		super(main, LocalX, LocalY, GlobalX, GlobalY, width, height);
		this.image = image;
	}

	@Override
	public void update() {
		this.LocalX = this.GlobalX - Main.XOffSet;
		if(Utility.checkCollision(this.LocalX, this.LocalY, this.width, this.height, GameState.defaultchar.LocalX, GameState.defaultchar.LocalY, GameState.defaultchar.width, GameState.defaultchar.height)) {
			System.out.println("TOUCHING THE ITEM");
			GameState.defaultchar.upgrades.add(Player.grenadaSplit);
			GameState.items[0] = null;
		}
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(image, LocalX, LocalY, width, height, null);
	}

	
}
