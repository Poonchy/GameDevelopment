import java.awt.image.BufferedImage;

public class AssetLoader {
	
	static int buttonwidth = 445;
	static int buttonheight = 179;
	private static BufferedImage gameUi = ImageLoader.loadImage("res/textures/gameButtons.png");
	public static BufferedImage imgstartbtn = gameUi.getSubimage(0, buttonheight, buttonwidth, buttonheight);
	public static BufferedImage imgstartbtnhover = gameUi.getSubimage(buttonwidth, buttonheight, buttonwidth, buttonheight);;
	public static BufferedImage imgendbtn = gameUi.getSubimage(0, 0, buttonwidth, buttonheight);;
	public static BufferedImage imgendbtnhover = gameUi.getSubimage(buttonwidth, 0, buttonwidth, buttonheight);;
	public static BufferedImage weapon = ImageLoader.loadImage("res/textures/weapon.png");
	public static BufferedImage weaponleft = ImageLoader.loadImage("res/textures/weaponleft.png");
    public static BufferedImage leftcapn = ImageLoader.loadImage("res/textures/capnleft.png");
    public static BufferedImage capn = ImageLoader.loadImage("res/textures/capn.png");
    public static BufferedImage leftlady = ImageLoader.loadImage("res/textures/mladyleft.png");
    public static BufferedImage lady = ImageLoader.loadImage("res/textures/mlady.png");
    public static BufferedImage rocketlauncher = ImageLoader.loadImage("res/textures/rocketlauncher.png");
    public static BufferedImage bullet = ImageLoader.loadImage("res/textures/bullet.png");
    public static BufferedImage grenade = ImageLoader.loadImage("res/textures/grenade.png");
    public static BufferedImage Rocket = ImageLoader.loadImage("res/textures/missle.png");
    public static BufferedImage shotgun = ImageLoader.loadImage("res/textures/shotgun.png");
    public static BufferedImage pistol = ImageLoader.loadImage("res/textures/pistol.png");
    public static BufferedImage mainmenuart = ImageLoader.loadImage("res/textures/menuart.jpg");
    public static BufferedImage leftwarrior = ImageLoader.loadImage("res/textures/warriorleft.png");
    public static BufferedImage warrior = ImageLoader.loadImage("res/textures/warrior.png");
    
    
    
	public static void init(){
		/*int buttonwidth = 445;
		int buttonheight = 179;
		
		SpriteSheet gameUI = new SpriteSheet(ImageLoader.loadImage("res/textures/gameButtons.png"));
		
		//Tiles
		
		//Entities
		
		//Buttons
		imgstartbtn = gameUI.crop(0, buttonheight, buttonwidth, buttonheight);
		imgstartbtnhover = gameUI.crop(buttonwidth, buttonheight, buttonwidth, buttonheight);
		imgendbtn = gameUI.crop(0, 0, buttonwidth, buttonheight);
		imgendbtnhover = gameUI.crop(buttonwidth, 0, buttonwidth, buttonheight); */
	}

}
