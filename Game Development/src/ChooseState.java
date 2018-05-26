import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;

public class ChooseState extends State{
	
	Main main;
	public static Button charonebtn, chartwobtn, charthreebtn;
	public static Button endbtn;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int windowWidth = (int) screenSize.getWidth();
	private int windowHeight = (int) screenSize.getHeight();
	private int btnxoffset = (windowWidth/2) - 100;
	private int btnyoffset = windowHeight - 200;
	
	public ChooseState(Main main) { 
		super(main);
		charonebtn = new Button(200, 200, btnxoffset - 400, btnyoffset, AssetLoader.capn);
		chartwobtn = new Button(200, 200, btnxoffset, btnyoffset, AssetLoader.lady);
		charthreebtn = new Button(200, 200, btnxoffset + 400, btnyoffset, AssetLoader.warrior);
	}
	
	public void update() {
	}
	
	public void render(Graphics g) {
		g.setFont(new Font("TimesRoman", Font.PLAIN, 100)); 
		g.drawString("Choose your hero!", (windowWidth - 800) / 2, 150);
		g.drawImage(charonebtn.imagepath, charonebtn.xPos, charonebtn.yPos, charonebtn.width, charonebtn.height, null);
		g.drawImage(chartwobtn.imagepath, chartwobtn.xPos, chartwobtn.yPos, chartwobtn.width, chartwobtn.height, null);
		g.drawImage(charthreebtn.imagepath, charthreebtn.xPos, charthreebtn.yPos, charthreebtn.width, charthreebtn.height, null);
	}
	
}
