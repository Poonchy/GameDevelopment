import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {

	public static Tile[] tileType = new Tile[256];
	public static Tile air = new AirTile(0);
	public static Tile dirt = new DirtTile(1);
	public static Tile metal = new MetalTile(2);
	
	
	public static final int TILE_WIDTH = 60,
							TILE_HEIGHT = 60;
	
	protected BufferedImage texture;
	protected final int id;

	public Tile(BufferedImage texture, int id){
		this.texture = texture;
		this.id = id;
		tileType[id] = this;
	}
	
	
	public void update(){
		
	}
	
	public void render(Graphics g, int x, int y){
		g.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null);
	}
	
}
