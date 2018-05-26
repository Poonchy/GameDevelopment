import java.awt.Graphics;
public class GameState extends State {
	Main main;
	public Map map;
	static LadyChar ladycharacter;
	static Player defaultchar;
	static Projectile projectile;
	static String whichChar;
	static Warrior warrior;
	
	public GameState(Main main) {
		super(main);
		map = new Map(main, "res/maps/map1.txt");
		ladycharacter = new LadyChar(main, 10, main.windowHeight, 100, 100, AssetLoader.lady, 4, 4, -15, 4, 4);
		defaultchar = new Player(main, 10, main.windowHeight, 100, 100, AssetLoader.capn, 4, 4, -15, 4, 4);
		warrior = new Warrior(main, 10, main.windowHeight, 100, 100, AssetLoader.warrior, 4, 4, -15, 4, 4);
	}
	
	public void update() {
		
		map.update();
		
		if (whichChar == "Default") {
			defaultchar.update();
		} else if (whichChar == "Mlady") {
			ladycharacter.update();
		} else if (whichChar == "Warrior") {
			warrior.update();
		}
		
	}
	
	public void render(Graphics g) {
		
		map.render(g);
		
		if (whichChar == "Default") {
			defaultchar.render(g);
		} else if (whichChar == "Mlady") {
			ladycharacter.render(g);
		} else if (whichChar == "Warrior") {
			warrior.render(g);
		}
	}
	
	
}
