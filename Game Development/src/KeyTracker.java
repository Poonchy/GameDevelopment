import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

public class KeyTracker implements KeyListener{
	public static boolean wpressed,apressed,spressed,dpressed,onepressed;
	public static boolean grenadetossed;
	public static boolean primaryWeapon;

	@Override
	public void keyPressed(KeyEvent e) {
		if (State.getCurrentState() == Main.gameState) { //Checks if in gameState
			if (e.getKeyCode() == 32) { //Space Pressed
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
			if (e.getKeyCode() == 49) { //1 Pressed
				onepressed = true;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (State.getCurrentState() == Main.gameState) { //Checks if in gameState
			if (e.getKeyCode() == 32) { //Space Released
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
			if (e.getKeyCode() == 49) { //1 released
				onepressed = false;
			}
			if (e.getKeyCode() == 32) { //Space Pressed
				if (primaryWeapon) {
					primaryWeapon = false;
				} else {
					primaryWeapon = true;
				}
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
