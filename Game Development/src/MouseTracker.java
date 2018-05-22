import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Timer;
import java.util.TimerTask;

public class MouseTracker implements MouseListener, MouseMotionListener{
	int bulletid;
	Bullets bullet;
	int bulletx = GameState.gunxpos;
	int bullety;
	boolean shooting = false;
	
	private boolean clickedWithinBounds(Button button, MouseEvent arg0) {
		if(((arg0.getX() >= button.xPos)
			&&(arg0.getX()  <= (button.xPos + button.width)))
			&&((arg0.getY()  >= button.yPos) 
			&&(arg0.getY()  <= (button.yPos + button.height)))) 
		{
			return true;
		}
			return false;
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		if (State.getCurrentState() == Main.menuState) {
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
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if (State.getCurrentState() == Main.menuState) {
			if(clickedWithinBounds(MenuState.endbtn, arg0)) {
				System.exit(0);
			}
			if(clickedWithinBounds(MenuState.startbtn, arg0)) {
				State.setCurrentState(Main.gameState);
			}
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

	Timer timer = new Timer();
	TimerTask task = new MyTimerTask();
	
	@Override
	public void mousePressed(MouseEvent arg0) {
		if (shooting == true) {
			task.cancel();
		}
		shooting = true;
		task = new MyTimerTask();
		timer.scheduleAtFixedRate(task, 0, 20);
	}
	
	private class MyTimerTask extends TimerTask {
	    public void run() {
	    	Bullets.makeBullet(GameState.gunxpos, GameState.gunypos);
	    }
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		task.cancel();
		shooting = false;
	}


	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}
	
	

