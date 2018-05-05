import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

public class MouseTracker implements MouseListener, MouseMotionListener{
	
	private boolean clickedWithinBounds(Button button, MouseEvent arg) {
		
		if(arg.getX() >= button.xPos 
				&& arg.getY()  >= button.yPos 
				&& arg.getX()  <= (button.xPos + button.width) 
				&& arg.getY()  <= (button.yPos + button.height))
				{
					return true;
				}
				return false;
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		if (clickedWithinBounds(MenuState.startbtn, arg0)) {
			MenuState.startbtn.imagepath = ImageLoader.loadImage("/res/textures/startbtnhover.png");
		} else {
			MenuState.startbtn.imagepath = ImageLoader.loadImage("/res/textures/startbtn.png");
		}
		if (clickedWithinBounds(MenuState.endbtn, arg0)) {
			MenuState.endbtn.imagepath = ImageLoader.loadImage("/res/textures/endbtnhover.png");
		} else {
			MenuState.endbtn.imagepath = ImageLoader.loadImage("/res/textures/endbtn.png");
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(clickedWithinBounds(MenuState.endbtn, arg0)) {
			System.exit(0);
		}
		
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}
	
	

