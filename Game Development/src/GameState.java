import java.awt.Graphics;
public class GameState extends State {
	Main main;
	static LadyChar ladycharacter;
	static Player defaultchar;
	static Projectile projectile;
	static String whichChar;
	
	public GameState(Main main) {
		super(main);
		ladycharacter = new LadyChar(main, 10, main.windowHeight, 100, 100, AssetLoader.capn, 4, 4, -15, 4, 4);
		defaultchar = new Player(main, 10, main.windowHeight, 100, 100, AssetLoader.lady, 4, 4, -15, 4, 4);
	}
	
	public void update() {
		if (whichChar == "Default") {
			defaultchar.update();
		} else if (whichChar == "Mlady") {
			ladycharacter.update();
		}
	}
	
	public void render(Graphics g) {
		if (whichChar == "Default") {
			defaultchar.render(g);
		} else if (whichChar == "Mlady") {
			ladycharacter.render(g);
		}
	}
}
