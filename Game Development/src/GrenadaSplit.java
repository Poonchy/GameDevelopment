import java.awt.MouseInfo;
import java.util.Timer;
import java.util.TimerTask;

public class GrenadaSplit extends Upgrade {
	
	public GrenadaSplit() {
		super(Player.grenada);
	}

	@Override
	public void runBehavior() {
		if(Grenada.grenadecd >0) {
			makeGrenade(GameState.defaultchar.gunxpos, GameState.defaultchar.gunypos);
			Grenada.grenadeTossed = true;
			Grenada.grenadecd -= 1;
		}
		
	}
	
	public static void makeGrenade(int xposition, int yposition) {
		int mouseY = MouseInfo.getPointerInfo().getLocation().y;
	    int mouseX = MouseInfo.getPointerInfo().getLocation().x;
	    if (GameState.defaultchar.turnedLeft == true) {
	        double angle = -Math.atan2(mouseY - yposition-25, mouseX - xposition-100);
	        Grenade tempbullet = new Grenade (xposition+100, yposition+30, 30, 30, 18, 30, angle, 25, true);
	        Grenade.grenadelist.add(tempbullet);
	    } else {
	        double angle = -Math.atan2(mouseY - yposition-45, mouseX - xposition-50);
	        Grenade tempbullet = new Grenade (xposition+10, yposition+50, 30, 30, 18, 30, angle, 25, false);
	        Grenade.grenadelist.add(tempbullet);
	    }
	    Timer timer = new Timer();
	    timer.schedule(new TimerTask() {
	        @Override
	        public void run() {
	        	Grenada.grenadecd += 3;
	        	Grenade.makeGrenade(Grenade.grenadelist.peek().xPos, Grenade.grenadelist.peek().yPos, 30, -100);
	        	Grenade.makeGrenade(Grenade.grenadelist.peek().xPos, Grenade.grenadelist.peek().yPos, 10, -100);
	        	Grenade.makeGrenade(Grenade.grenadelist.peek().xPos, Grenade.grenadelist.peek().yPos, 0, -50);
	        	Grenade.grenadelist.poll();
	        }
	    }, 700);
	        
	}

}
