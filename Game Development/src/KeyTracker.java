import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyTracker implements KeyListener{
	public static boolean wpressed;
	public static boolean apressed;
	public static boolean spressed;
	public static boolean dpressed;

	@Override
	public void keyPressed(KeyEvent e) {
		if (State.getCurrentState() == Main.gameState) { //Checks if in gameState
			if (e.getKeyCode() == 87) { //W Pressed
				wpressed = true;
			}
			if (e.getKeyCode() == 65) { //A Pressed
				apressed = true;
			}
			if (e.getKeyCode() == 83) { //S Pressed
				spressed = true;
			}
			if (e.getKeyCode() == 68) { //D Pressed
				dpressed = true;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (State.getCurrentState() == Main.gameState) { //Checks if in gameState
			if (e.getKeyCode() == 87) { //W Released
				wpressed = false;
			}
			if (e.getKeyCode() == 65) { //A Released
				apressed = false;
			}
			if (e.getKeyCode() == 83) { //S Released
				spressed = false;
			}
			if (e.getKeyCode() == 68) { //D Released
				dpressed = false;
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
