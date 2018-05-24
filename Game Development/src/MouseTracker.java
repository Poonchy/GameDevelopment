import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Timer;
import java.util.TimerTask;

public class MouseTracker implements MouseListener, MouseMotionListener{
	int bulletid;
	Bullets bullet;
	int bulletx = GameState.defaultchar.gunxpos;
	int bullety;
	boolean shooting = false;
	boolean slowFire = false;
	
	int mouseX, mouseY;
	
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
		mouseX = MouseInfo.getPointerInfo().getLocation().x;
		mouseY = MouseInfo.getPointerInfo().getLocation().y;
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
				State.setCurrentState(Main.chooseState);
			}
		}
		if (State.getCurrentState() == Main.chooseState) {
			if (clickedWithinBounds(ChooseState.charonebtn, arg0)) {
				GameState.whichChar = "Default";
				State.setCurrentState(Main.gameState);
			}
			if (clickedWithinBounds(ChooseState.chartwobtn, arg0)) {
				GameState.whichChar = "Mlady";
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
	TimerTask makeBullets = new SMGFire();
	TimerTask makeRocket = new RPGFire();
	TimerTask makePistolB = new PistolFire();
	TimerTask makeShotgun = new ShotgunFire();
	
	@Override
	public void mousePressed(MouseEvent arg0) {
		if (GameState.whichChar == "Default") {
			if (shooting == true) {
				makeBullets.cancel();
				makeRocket.cancel();
			}
			if (KeyTracker.primaryWeapon) {
				shooting = true;
				makeRocket = new RPGFire();
				if (!slowFire) {
					slowFire = true;
					timer.scheduleAtFixedRate(makeRocket, 0, 1000);
					Timer timer = new Timer();
			        timer.schedule(new TimerTask() {
			        	  @Override
			        	  public void run() {
			    			slowFire = false;
			        	  }
			    	}, 1000);
				}
			} else {
				makeBullets = new SMGFire();
				timer.scheduleAtFixedRate(makeBullets, 0, 50);
			}
		} else if (GameState.whichChar == "Mlady") {
			if (shooting == true) {
				makePistolB.cancel();
				makeShotgun.cancel();
			}
			if (!KeyTracker.primaryWeapon) {
				shooting = true;
				makePistolB = new PistolFire();
				if (!slowFire) {
					slowFire = true;
					timer.scheduleAtFixedRate(makePistolB, 0, 500);
					Timer timer = new Timer();
			        timer.schedule(new TimerTask() {
			        	  @Override
			        	  public void run() {
			    			slowFire = false;
			        	  }
			    	}, 500);
				}
			} else {
				shooting = true;
				makeShotgun = new ShotgunFire();
				if (!slowFire) {
					slowFire = true;
					timer.scheduleAtFixedRate(makeShotgun, 0, 800);
					Timer timer = new Timer();
			        timer.schedule(new TimerTask() {
			        	  @Override
			        	  public void run() {
			    			slowFire = false;
			        	  }
			    	}, 800);
				}
			}
		}
	}
	
	private class SMGFire extends TimerTask {
	    public void run() {
	    	Bullets.makeBullet(GameState.defaultchar.gunxpos, GameState.defaultchar.gunypos);
	    }
	}
	
	private class RPGFire extends TimerTask {
	    public void run() {
	    	Rocket.makeRocket(GameState.defaultchar.gunxpos, GameState.defaultchar.gunypos);
	    }
	}
	
	private class PistolFire extends TimerTask {
	    public void run() {
	    	Bullets.makeBullet(GameState.ladycharacter.gunxpos, GameState.ladycharacter.gunypos);
	    }
	}
	
	private class ShotgunFire extends TimerTask {
	    public void run() {
	    	Bullets.makeBullet(GameState.ladycharacter.gunxpos, GameState.ladycharacter.gunypos);
	    	Bullets.makeBullet(GameState.ladycharacter.gunxpos, GameState.ladycharacter.gunypos);
	    	Bullets.makeBullet(GameState.ladycharacter.gunxpos, GameState.ladycharacter.gunypos);
	    	Bullets.makeBullet(GameState.ladycharacter.gunxpos, GameState.ladycharacter.gunypos);
	    	Bullets.makeBullet(GameState.ladycharacter.gunxpos, GameState.ladycharacter.gunypos);
	    	Bullets.makeBullet(GameState.ladycharacter.gunxpos, GameState.ladycharacter.gunypos);
	    	Bullets.makeBullet(GameState.ladycharacter.gunxpos, GameState.ladycharacter.gunypos);
	    	Bullets.makeBullet(GameState.ladycharacter.gunxpos, GameState.ladycharacter.gunypos);
	    	Bullets.makeBullet(GameState.ladycharacter.gunxpos, GameState.ladycharacter.gunypos);
	    	Bullets.makeBullet(GameState.ladycharacter.gunxpos, GameState.ladycharacter.gunypos);
	    	Bullets.makeBullet(GameState.ladycharacter.gunxpos, GameState.ladycharacter.gunypos);
	    }
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		if (GameState.whichChar == "Default") {
			makeBullets.cancel();
			makeRocket.cancel();
			shooting = false;
		}
		if (GameState.whichChar == "Mlady") {
			makePistolB.cancel();
			makeShotgun.cancel();
			shooting = false;
		}
	}


	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}
	
	

