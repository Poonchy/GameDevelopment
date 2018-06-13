import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyTracker implements KeyListener{
	public static boolean spacePressed,aPressed,sPressed,dPressed,onePressed,grenadetossed,primaryWeapon;

	@Override
	public void keyPressed(KeyEvent e) {
		if (State.getCurrentState() == Main.gameState) { //Checks if in gameState
			if (e.getKeyCode() == 32) { //Space Pressed
				spacePressed = true;
			}
			if (e.getKeyCode() == 65) { //A Pressed
				aPressed = true;
			}
			if (e.getKeyCode() == 83) { //S Pressed
				sPressed = true;
			}
			if (e.getKeyCode() == 68) { //D Pressed
				dPressed = true;
			}
			if (e.getKeyCode() == 49) { //1 Pressed
				onePressed = true;
			}
			if (e.getKeyCode() == 192) { //` Pressed
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (State.getCurrentState() == Main.gameState) { //Checks if in gameState
			if (e.getKeyCode() == 32) { //Space Released
				spacePressed = false;
			}
			if (e.getKeyCode() == 65) { //A Released
				aPressed = false;
			}
			if (e.getKeyCode() == 83) { //S Released
				sPressed = false;
			}
			if (e.getKeyCode() == 68) { //D Released
				dPressed = false;
			}
			if (e.getKeyCode() == 49) { //1 released
				onePressed = false;
			}
			if (e.getKeyCode() == 192) { //` Pressed
				if (!MouseTracker.mouseHeld) {
					if (primaryWeapon) {
						primaryWeapon = false;
					} else {
						primaryWeapon = true;
					}
				}
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
