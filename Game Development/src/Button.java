import java.awt.image.BufferedImage;
import java.net.URL;

public class Button {
	public int width;
	public int height;
	public int xPoS;
	public int yPoS;
	public BufferedImage imagepath;
	public Button(int widtht, int heightt, int xPoSt, int yPoSt, BufferedImage image) {
		height = heightt;
		width = widtht;
		xPoS = xPoSt;
		yPoS = yPoSt;
		imagepath = image;
	}
}
