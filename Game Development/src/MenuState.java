import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;

public class MenuState extends State{
	
	Main main;
	public static Button startbtn;
	public static Button endbtn;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int windowWidth = (int) screenSize.getWidth();
	private int windowHeight = (int) screenSize.getHeight();
	private int btnxoffset = (windowWidth/2) - 100;
	private int btnyoffset = (windowHeight/2) - 100;
	
	public MenuState(Main main) { 
		super(main);
		startbtn = new Button(200, 80, btnxoffset, btnyoffset, AssetLoader.imgstartbtn);
		endbtn = new Button(200, 80, btnxoffset, btnyoffset + 100, AssetLoader.imgendbtn);
	}
	
	public void update() {
	}
	
	public void render(Graphics g) {
		g.drawImage(startbtn.imagepath, startbtn.xPos, startbtn.yPos, startbtn.width, startbtn.height, null);
		g.drawImage(endbtn.imagepath, endbtn.xPos, endbtn.yPos, endbtn.width, endbtn.height, null);
		
		AffineTransform at = AffineTransform.getTranslateInstance(0, 0);
		at.rotate(Math.toRadians(45));
		at.translate(100, 0);
		at.scale(.5, .5);
		Graphics2D g2d= (Graphics2D) g;
		
		g2d.drawImage(startbtn.imagepath, at, null);
	}
	
}
