public class TileMetal extends Tile {

	public TileMetal(int id) {
		super(AssetLoader.metal, id);
		
	}
	
	public boolean isSolid() {
		return false;
	}

}
