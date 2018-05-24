import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

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
				Grenade.makeGrenade(GameState.defaultchar.gunxpos, GameState.defaultchar.gunypos);
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