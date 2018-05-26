import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;

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
		g.drawImage(AssetLoader.mainmenuart, 0,0, windowWidth, windowHeight, null);
		g.setColor(Color.white);
		g.setFont(new Font("Dialog", Font.PLAIN, 100)); 
		g.drawString("Insert name here.", (windowWidth - 800) / 2, 150);
		g.drawImage(startbtn.imagepath, startbtn.xPos, startbtn.yPos, startbtn.width, startbtn.height, null);
		g.drawImage(endbtn.imagepath, endbtn.xPos, endbtn.yPos, endbtn.width, endbtn.height, null);
	}
	
}
