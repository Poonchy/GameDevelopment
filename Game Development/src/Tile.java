import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile{
	
	public int LocalX, LocalY, GlobalX, GlobalY;
	
	public static Tile[] tileType = new Tile[256];
	public static Tile air = new TileAir(0);
	public static Tile dirt = new TileDirt(1);
	public static Tile metal = new TileMetal(2);
	
	public static final int TILE_WIDTH = 100,
							TILE_HEIGHT = 100;
	
	protected BufferedImage texture;
	protected final int id;

	public Tile(BufferedImage texture, int id){
		this.texture = texture;
		this.id = id;
		
		
		tileType[id] = this;
	}

	public void update(){
		this.LocalX = this.GlobalX - Main.XOffSet;
		this.LocalY = this.GlobalY;
	}
	
	public void render(Graphics g, int x, int y){
		g.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null);
	}
	
	public boolean isSolid(){
		return false;
	}
	
	public int gteId(){
		return id;
	}
	
}