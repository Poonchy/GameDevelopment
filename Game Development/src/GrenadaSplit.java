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
			makeSplitGrenade(GameState.defaultchar.gunxpos + Main.XOffSet, GameState.defaultchar.gunypos + Main.YOffSet);
			Grenada.grenadeTossed = true;
			Grenada.grenadecd -= 1;
		}
		
	}
	
	public static void makeSplitGrenade(int xposition, int yposition) {
		int mouseY = MouseInfo.getPointerInfo().getLocation().y;
	    int mouseX = MouseInfo.getPointerInfo().getLocation().x;
	    if (GameState.defaultchar.turnedLeft == true) {
	    	double angle = -Math.atan2(mouseY - (yposition - Main.YOffSet), mouseX - (xposition - Main.XOffSet));
        	Grenade tempbullet = new Grenade (xposition - Main.XOffSet, yposition - Main.YOffSet, xposition, yposition, 30, 30, 18, 30, angle, 25, true);
        	Grenade.grenadelist.add(tempbullet);
	    } else {
	    	double angle = -Math.atan2(mouseY - (yposition - Main.YOffSet), mouseX - (xposition - Main.XOffSet));
        	Grenade tempbullet = new Grenade (xposition - Main.XOffSet , yposition - Main.YOffSet , xposition, yposition, 30, 30, 18, 30, angle, 25, false);
        	Grenade.grenadelist.add(tempbullet);
	    }
	    Timer timer = new Timer();
	    timer.schedule(new TimerTask() {
	        @Override
	        public void run() {
	        	Grenada.grenadecd += 3;
	        	Grenade.makeGrenade(Grenade.grenadelist.peek().GlobalX, Grenade.grenadelist.peek().GlobalY, 30, -100);
	        	Grenade.makeGrenade(Grenade.grenadelist.peek().GlobalX, Grenade.grenadelist.peek().GlobalY, 10, -100);
	        	Grenade.makeGrenade(Grenade.grenadelist.peek().GlobalX, Grenade.grenadelist.peek().GlobalY, 0, -50);
	        	Grenade.grenadelist.poll();
	        }
	    }, 700);
	        
	}

}
