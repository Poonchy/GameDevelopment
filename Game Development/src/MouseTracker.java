import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

public abstract class MouseTracker implements MouseListener, ActionListener{
	public static BufferedImage mouseEnter(int btnxoffset, int btnyoffset, String btnname) {
		BufferedImage whatImage;
		int mouseY = MouseInfo.getPointerInfo().getLocation().y;
        int mouseX = MouseInfo.getPointerInfo().getLocation().x;
        if((mouseX > btnxoffset && mouseX < btnxoffset + 200) && (mouseY > btnyoffset && mouseY < btnyoffset + 80)) {
        	whatImage = ImageLoader.loadImage("/res/textures/" + btnname + "hover.png");
        } else {
        	whatImage = ImageLoader.loadImage("/res/textures/" + btnname + ".png");
        }
        return whatImage;
	}
}
	
	

