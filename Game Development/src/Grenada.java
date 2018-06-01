import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.Queue;

public class Grenada extends Ability {
	private boolean grenadeTossed = false;
	public Grenada(BufferedImage icon, int cooldown, int uses, String type) {
		super(icon, uses, uses, type);
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				if ((Grenade.grenadecd < uses) && (Grenade.isCharging == false)) {
		        	Grenade.grenadecd += 1;
		        	Grenade.isCharging = false;
		      	}
		    }
		}, 0, cooldown);
	}
	
	@Override
	public void update() {
		
		if (KeyTracker.onepressed) {
			if (grenadeTossed == true) {
			} else {
				Grenade.makeGrenade(GameState.character.gunxpos, GameState.character.gunypos);
				grenadeTossed = true;
			}
		} else {
			grenadeTossed = false;
		}
	}
	
	@Override
	public void render(Graphics g) {
		
	}

}