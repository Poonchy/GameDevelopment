import java.awt.Graphics;

public class Map {

	Main main;
	private int width, height; // Width and height of map in terms of tiles
	public int spawnX, spawnY; // Spawn point for player
	private int[][] tilesGrid;
	
	public Map(Main main, String path){
		this.main = main;
		loadMap(path);
	}
	
	public void update(){
		/*
		if(handler.getKeyboardManager().cameraDown){
			handler.getCamera().move(0, handler.getCamera().CAMERA_SPEED);
		}else if(handler.getKeyboardManager().cameraUp){
			handler.getCamera().move(0, -handler.getCamera().CAMERA_SPEED);
		}else if(handler.getKeyboardManager().cameraLeft){
			handler.getCamera().move(-handler.getCamera().CAMERA_SPEED, 0);
		}else if(handler.getKeyboardManager().cameraRight){
			handler.getCamera().move(handler.getCamera().CAMERA_SPEED, 0);
		}else{
			handler.getCamera().move(0, 0);
		}
		
		//Updates all the Entities
		entityManager.update();
		*/
	}
	
	public void render(Graphics g){
		
		// Rendering only what's in camera view
		/*
		int xStart = (int)Math.max(0, handler.getCamera().getxOffset() / Tile.TILE_WIDTH);
		int xEnd = (int)Math.min(width, (handler.getCamera().getxOffset() + handler.getWidth()) / Tile.TILE_WIDTH + 1);
		int yStart = (int)Math.max(0, handler.getCamera().getyOffset() / Tile.TILE_HEIGHT);
		int yEnd = (int)Math.min(height, (handler.getCamera().getyOffset() + handler.getHeight()) / Tile.TILE_HEIGHT + 1);
		
		for(int y = yStart; y < yEnd; y++){
			for(int x = xStart; x < xEnd; x++){
				getTile(x, y).render(g, (int) (x * Tile.TILE_WIDTH - handler.getCamera().getxOffset()), (int) (y*Tile.TILE_HEIGHT - handler.getCamera().getyOffset()));
			}
		}
		*/
		
		//Renders all the Entities
		//entityManager.render(g);
		
		
		// Rendering everything (dumb rendering)
		
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				if(getTile(x, y) == null) {
					
				}else{
					getTile(x, y).render(g, x * Tile.TILE_WIDTH, y*Tile.TILE_HEIGHT + (main.windowHeight - height*Tile.TILE_HEIGHT) );
				}
			}
		}
		
	}
	
	public Tile getTile(int x, int y){ // gets tile with grid position input, not coordinates
		if(x < 0 || y < 0 || x >= width || y>= height) {
			return null;
		}
		
		Tile t = Tile.tileType[tilesGrid[x][y]];
		if (t == null){
			return null;
		}
		return t;
	}
	
	private void loadMap(String path){
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tilesGrid = new int[width][height];
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				tilesGrid[x][y] = Utils.parseInt(tokens[(x + y * width) + 4 ]);
			}
		}
		
	}
	

}
