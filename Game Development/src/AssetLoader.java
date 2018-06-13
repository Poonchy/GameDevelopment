import java.awt.image.BufferedImage;
import sun.audio.*;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;


public class AssetLoader{
	
	static int buttonwidth = 445;
	static int buttonheight = 179;
	private static BufferedImage gameUi = ImageLoader.loadImage("/textures/gameButtons.png");
	public static BufferedImage imgstartbtn = gameUi.getSubimage(0, buttonheight, buttonwidth, buttonheight);
	public static BufferedImage imgstartbtnhover = gameUi.getSubimage(buttonwidth, buttonheight, buttonwidth, buttonheight);;
	public static BufferedImage imgendbtn = gameUi.getSubimage(0, 0, buttonwidth, buttonheight);;
	public static BufferedImage imgendbtnhover = gameUi.getSubimage(buttonwidth, 0, buttonwidth, buttonheight);;
 
    public static BufferedImage TestEnemy = ImageLoader.loadImage("res/textures/TestEnemy.PNG");


	public static BufferedImage weapon = ImageLoader.loadImage("/textures/weapon.png");
	public static BufferedImage weaponleft = ImageLoader.loadImage("/textures/weaponleft.png");
    public static BufferedImage leftcapn = ImageLoader.loadImage("/textures/capnleft.png");
    public static BufferedImage capn = ImageLoader.loadImage("/textures/capn.png");
    public static BufferedImage leftlady = ImageLoader.loadImage("/textures/mladyleft.png");
    public static BufferedImage lady = ImageLoader.loadImage("/textures/mlady.png");
    public static BufferedImage rocketlauncher = ImageLoader.loadImage("/textures/rocketlauncher.png");
    public static BufferedImage bullet = ImageLoader.loadImage("/textures/bullet.png");
    public static BufferedImage grenade = ImageLoader.loadImage("/textures/grenade.png");
    public static BufferedImage Rocket = ImageLoader.loadImage("/textures/missle.png");
    public static BufferedImage shotgun = ImageLoader.loadImage("/textures/shotgun.png");
    public static BufferedImage pistol = ImageLoader.loadImage("/textures/pistol.png");
    public static BufferedImage mainmenuart = ImageLoader.loadImage("/textures/menuart.jpg");
    public static BufferedImage leftwarrior = ImageLoader.loadImage("/textures/warriorleft.png");
    public static BufferedImage warrior = ImageLoader.loadImage("/textures/warrior.png");
    public static BufferedImage dirt = ImageLoader.loadImage("/textures/dirtTile.png");
    public static BufferedImage metal = ImageLoader.loadImage("/textures/metalTile.jpg");
    public static AudioStream Audio;

    
    //Sounds
    static Main main = new Main();
    public static void loadMusic() throws IOException, URISyntaxException {
    	InputStream SMGFire;
    	URL url = main.getClass().getResource("res/sounds/machinegun.wav");
    	SMGFire = new FileInputStream(new File(url.toURI()));
    	Audio = new AudioStream(SMGFire);
    }
    
    public static void playMusic() throws IOException, URISyntaxException {
    	loadMusic();
		AudioPlayer.player.start(Audio);
    }
    
	public static void init(){
		
	}

}
