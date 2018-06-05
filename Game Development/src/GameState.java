import java.awt.Graphics;
public class GameState extends State {
	Main main;
	public static LadyChar ladycharacter;
	public static Player defaultchar;
	static Projectile projectile;
	static String whichChar;
	public static Warrior warrior;
	public static Item grenadaUpg1;
	public static Item[] items = new Item[256];
	public static Creature activePlayer;
	
	public GameState(Main main) {
		super(main);
		ladycharacter = new LadyChar(main, 10, main.windowHeight - 100, 10, main.windowHeight - 100, 100, 100, AssetLoader.lady, 4, 4, -15, 4, 4);
		defaultchar = new Player(main, 10, main.windowHeight - 100, 10, main.windowHeight - 100, 100, 100, AssetLoader.capn, 4, 4, -15, 4, 4);
		warrior = new Warrior(main, 10, main.windowHeight, 10, main.windowHeight, 100, 100, AssetLoader.warrior, 4, 4, -15, 4, 4);
		grenadaUpg1 = new Item(main, main.windowWidth/2, main.windowHeight - 40, main.windowWidth/2, main.windowHeight - 40, 100, 40, AssetLoader.grenade);
		items[0] = grenadaUpg1;
	}
	
	public void update() {
		
		if (whichChar == "Default") {
			defaultchar.update();
			activePlayer = defaultchar;
		} else if (whichChar == "Mlady") {
			ladycharacter.update();
			activePlayer = ladycharacter;
		} else if (whichChar == "Warrior") {
			warrior.update();
			activePlayer = warrior;
		}
		
		if(items[0] != null) {
			items[0].update();
		}

	}
	
	public void render(Graphics g) {
		if (whichChar == "Default") {
			defaultchar.render(g);
		} else if (whichChar == "Mlady") {
			ladycharacter.render(g);
		} else if (whichChar == "Warrior") {
			warrior.render(g);
		}
		
		if(items[0] != null) {
			items[0].render(g);
		}
	}
	
}
