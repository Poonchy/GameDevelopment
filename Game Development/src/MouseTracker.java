import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseTracker implements MouseListener, MouseMotionListener{
	
	private boolean clickedWithinBounds(Button button, MouseEvent arg) {
		System.out.println(arg.getX());
		System.out.println(arg.getY());
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
			MenuState.startbtn.imagepath = AssetLoader.imgstartbtnhover;
		} else {
			MenuState.startbtn.imagepath = AssetLoader.imgstartbtn;
		}
		if (clickedWithinBounds(MenuState.endbtn, arg0)) {
			MenuState.endbtn.imagepath = AssetLoader.imgendbtnhover;
		} else {
			MenuState.endbtn.imagepath = AssetLoader.imgendbtn;
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
	
	

