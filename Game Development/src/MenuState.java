import java.awt.Graphics;

public class MenuState extends State{
	
	Main main;
	Button startbtn, endbtn;
	
	public MenuState(Main main) {
		super(main);
		startbtn = new Button(100, 40, 20, 20, ImageLoader.loadImage("/res/textures/startbtn.png"));
		
	}
	
	public void update() {
		
	}
	
	public void render(Graphics g) {
		g.drawImage(startbtn.imagepath, startbtn.xPoS, startbtn.yPoS, startbtn.width, startbtn.height, null);
	}
	
}
