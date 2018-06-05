public class TileMetal extends Tile {

	public TileMetal(int id) {
		super(AssetLoader.bullet, id);
		
	}
	
	public boolean isSolid() {
		return false;
	}

}
