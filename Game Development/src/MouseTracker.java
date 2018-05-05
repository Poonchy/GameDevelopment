import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

public class MouseTracker implements MouseListener, MouseMotionListener{
	
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
	
	private boolean clickedWithinBounds(Button button, MouseEvent arg) {
		
		if(arg.getX() >= button.xPoS 
				&& arg.getY()  >= button.yPoS 
				&& arg.getX()  <= (button.xPoS + button.width) 
				&& arg.getY()  <= (button.yPoS + button.height))
				{
					System.out.println("CLICKED AT: " + button.xPoS + " " + button.yPoS);
					return true;
				}
				return false;
		
	}



	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		System.out.println("Hello!");
		
		/*
		if(arg0.getButton() == MouseEvent.BUTTON1) {
			for(Button button : ArrayList buttonList) {
				if(inside area of any button) {
					
				}
			}
		}
		*/
		
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
	
	

