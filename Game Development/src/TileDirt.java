
public class TileDirt extends Tile {

	public TileDirt(int id) {
		super(AssetLoader.Rocket, id);
		
	}
	
	public boolean isSolid() {
		return false;
	}

}
