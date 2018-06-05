import java.awt.Graphics;
import java.awt.Point;

public class Map {
	private Main main;
	private int width, height; // Width and height of map in terms of tiles
	public int spawnX, spawnY;
	private int[][] tiles;
	
	public Map(Main main, String path){
		loadMap(path);
		this.main = main;
	}
	
	public void update(){
		//Updates all the Entities
		
	}
	
	public void render(Graphics g){
		int xStart = (int)Math.max(0, Main.XOffSet) / Tile.TILE_WIDTH;
		int xEnd = (int)Math.min(width, (Main.XOffSet + main.windowWidth) / Tile.TILE_WIDTH + 1);
		int yStart = (int)Math.max(0, Main.YOffSet / Tile.TILE_HEIGHT);
		int yEnd = (int)Math.min(height, (Main.YOffSet + main.windowHeight) / Tile.TILE_HEIGHT + 1);
		
		for(int y = yStart; y < yEnd; y++){
			for(int x = xStart; x < xEnd; x++){
				getTile(x, y).render(g, (int) (x * Tile.TILE_WIDTH), (int) (y*Tile.TILE_HEIGHT) );
			}
		}
		
		//Renders all the Entities
		
	}
	
	public Tile getTile(int x, int y){
		if(x < 0 || y < 0 || x >= width || y>= height) {
			return Tile.dirt;
		}
		
		Tile t = Tile.tileType[tiles[x][y]];
		if (t == null){
			return Tile.air;
		}
		return t;
	}
	
	private void loadMap(String path){
		String file = Utility.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utility.parseInt(tokens[0]);
		height = Utility.parseInt(tokens[1]);
		spawnX = Utility.parseInt(tokens[2]);
		spawnY = Utility.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				tiles[x][y] = Utility.parseInt(tokens[(x + y * width) + 4 ]);
			}
		}
		
	}
	
	
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
}
