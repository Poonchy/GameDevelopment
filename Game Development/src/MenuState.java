import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

public class MenuState extends State{
	
	Main main;
	public static Button startbtn;
	public static Button endbtn;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int btnxoffset = (main.windowWidth/2) - 100;
	private int btnyoffset = (main.windowHeight/2) - 100;
	
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
	}
	
}
