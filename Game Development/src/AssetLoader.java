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
