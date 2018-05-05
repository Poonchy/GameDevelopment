import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Button{
	public int width;
	public int height;
	public int xPos;
	public int yPos;
	public BufferedImage imagepath;
	public String functionName;
	
	public Button(int widtht, int heightt, int xPoSt, int yPoSt, BufferedImage image) {
		height = heightt;
		width = widtht;
		xPos = xPoSt;
		yPos = yPoSt;
		imagepath = image;
	}
	
	public void render(Graphics g) {
		
	}
}