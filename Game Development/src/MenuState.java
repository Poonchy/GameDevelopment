import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

public class MenuState extends State{
	
	Main main;
	Button startbtn, endbtn;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int windowWidth = (int) screenSize.getWidth();
	private int windowHeight = (int) screenSize.getHeight();
	private int btnxoffset = (windowWidth/2) - 100;
	private int btnyoffset = (windowHeight/2) - 100;
	
	public MenuState(Main main) {
		super(main);
		startbtn = new Button(200, 80, btnxoffset, btnyoffset, ImageLoader.loadImage("/res/textures/startbtn.png"));
		endbtn = new Button(200, 80, btnxoffset, btnyoffset + 100, ImageLoader.loadImage("/res/textures/startbtn.png"));
	}
	
	public void update() {
		startbtn.imagepath = MouseTracker.mouseEnter(btnxoffset, btnyoffset, "startbtn");
		endbtn.imagepath = MouseTracker.mouseEnter(btnxoffset, btnyoffset + 100, "endbtn");
	}
	
	public void render(Graphics g) {
		g.drawImage(startbtn.imagepath, startbtn.xPoS, startbtn.yPoS, startbtn.width, startbtn.height, null);
		g.drawImage(endbtn.imagepath, endbtn.xPoS, endbtn.yPoS, endbtn.width, endbtn.height, null);
	}
	
}
