
public class TileDirt extends Tile {

	public TileDirt(int id) {
		super(AssetLoader.dirt, id);
		
	}
	
	public boolean isSolid() {
		return false;
	}

}
