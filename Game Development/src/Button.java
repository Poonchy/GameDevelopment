import java.awt.AWTEvent;
import java.awt.Event;
import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Button{
	public int width;
	public int height;
	public int xPoS;
	public int yPoS;
	public BufferedImage imagepath;
	public String functionName;
	
	public Button(int widtht, int heightt, int xPoSt, int yPoSt, BufferedImage image) {
		height = heightt;
		width = widtht;
		xPoS = xPoSt;
		yPoS = yPoSt;
		imagepath = image;
	}
}