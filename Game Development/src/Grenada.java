import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

public class Grenada extends Ability {
	static boolean grenadeTossed = false;
	public static int grenadecd = 3;
	public static boolean isCharging;
	
	public Grenada(BufferedImage icon, int cooldown, int uses, String type) {
		super(icon, uses, uses, type);
		
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				if ((grenadecd < uses) && (isCharging == false)) {
		        	grenadecd += 1;
		        	isCharging = false;
		      	}
		    }
		}, 0, cooldown);
		
	}
	
	@Override
	public void update() {
		
		if (KeyTracker.onePressed) {
			
			if (grenadeTossed == true) {
			} else {
				if(GameState.defaultchar.upgrades.isEmpty()) {
					Grenade.makeGrenade(GameState.defaultchar.GlobalX, GameState.defaultchar.GlobalY);
					grenadeTossed = true;	
				}else {
					Player.grenadaSplit.runBehavior();
					System.out.println("THROW UPGRADED GRENADE");
				}
				
			}
		} else {
			grenadeTossed = false;
		}
		
	}
	
	@Override
	public void render(Graphics g) {
		
	}

}