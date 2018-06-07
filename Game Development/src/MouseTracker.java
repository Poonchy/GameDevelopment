import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Timer;
import java.util.TimerTask;

public class MouseTracker implements MouseListener, MouseMotionListener{
	int bulletid;
	int prevX, prevY, mouseXOff, mouseYOff;
	Bullets bullet;
	int bulletx = GameState.defaultchar.gunxpos;
	int bullety;
	static boolean shooting = false;
	boolean slowFire = false;
	public static boolean mouseHeld;
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
	
	public void updateCamera() {
		mouseX = MouseInfo.getPointerInfo().getLocation().x;
		mouseY = MouseInfo.getPointerInfo().getLocation().y;
		mouseXOff = (int) ((mouseX - GameState.activePlayer.LocalX + 50) / 8);
		mouseYOff = (int) ((mouseY - GameState.activePlayer.LocalY + 50) / 4);
		Main.XOffSet = Main.XOffSet + mouseXOff - prevX;
		Main.YOffSet = Main.YOffSet + mouseYOff - prevY;
		prevX = mouseXOff;
		prevY = mouseYOff;
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
		if(State.getCurrentState() == Main.gameState) {
			updateCamera();
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
			if (clickedWithinBounds(ChooseState.charthreebtn, arg0)) {
				GameState.whichChar = "Warrior";
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
	TimerTask swingAxe = new SwingAxe();
	
	@Override
	public void mousePressed(MouseEvent arg0) {
		mouseHeld = true;
		if (GameState.whichChar == "Default") { // Character Default
			if (shooting == true) {
				makeBullets.cancel();
				makeRocket.cancel();
			}
			if (KeyTracker.primaryWeapon) {
				if (!slowFire) {
					makeRocket = new RPGFire();
					timer.scheduleAtFixedRate(makeRocket, 0, 2000);
				}
			} else {
				if (!shooting) {
					makeBullets = new SMGFire();
					timer.scheduleAtFixedRate(makeBullets, 0, 50);
				}
			}
		} else if (GameState.whichChar == "Mlady") { // Character M'lady
			if (shooting == true) {
				makePistolB.cancel();
				makeShotgun.cancel();
			}
			if (!KeyTracker.primaryWeapon) {
				if (!shooting) {
					makePistolB = new PistolFire();
					timer.scheduleAtFixedRate(makePistolB, 0, 400);
				}
			} else {
				if (!slowFire) {
					makeShotgun = new ShotgunFire();
					timer.scheduleAtFixedRate(makeShotgun, 0, 1000);
				}
			}
		} else if (GameState.whichChar == "Warrior") {
			if (shooting == true) {
				swingAxe.cancel();
			}
			if (!KeyTracker.primaryWeapon) {
				if (!shooting) {
					swingAxe = new SwingAxe();
					timer.scheduleAtFixedRate(swingAxe, 0, 1000);
				}
			}
		}
	}
	
	private class SMGFire extends TimerTask {
	    public void run() {
	    	if (!shooting) {
	    		Bullets.makeBullet(GameState.defaultchar.gunxpos, GameState.defaultchar.gunypos);
	    		try {
					AssetLoader.playMusic();
				} catch (IOException | URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    	shooting = true;
	    	Timer timer = new Timer();
	        timer.schedule(new TimerTask() {
	        	  @Override
	        	  public void run() {
	    			shooting = false;
	        	  }
	    	}, 40);
	    }
	}
	
	private class RPGFire extends TimerTask {
	    public void run() {
	    	if (!slowFire) {
	        	Rocket.makeRocket(GameState.defaultchar.gunxpos, GameState.defaultchar.gunypos);
	        }
	    	slowFire = true;
	    	Timer timer = new Timer();
	        timer.schedule(new TimerTask() {
	        	  @Override
	        	  public void run() {
	        		  System.out.println("Slowfire detected!");
	    			slowFire = false;
	        	  }
	    	}, 1990);
	    }
	}
	
	private class PistolFire extends TimerTask {
	    public void run() {
	    	if (!shooting) {
	    		Bullets.makeBullet(GameState.ladycharacter.gunxpos, GameState.ladycharacter.gunypos);
	        }
	    	shooting = true;
	    	Timer timer = new Timer();
	        timer.schedule(new TimerTask() {
	        	  @Override
	        	  public void run() {
	    			shooting = false;
	        	  }
	    	}, 390);
	    }
	}
	
	private class ShotgunFire extends TimerTask {
	    public void run() {
	    	if (!slowFire) {
	    		for (int i = 0; i < 10; i++) {
		    		Bullets.makeBullet(GameState.ladycharacter.gunxpos, GameState.ladycharacter.gunypos);
		    	}
	        }
	    	slowFire = true;
	    	Timer timer = new Timer();
	        timer.schedule(new TimerTask() {
	        	  @Override
	        	  public void run() {
	    			slowFire = false;
	        	  }
	    	}, 990);
	    }
	}
	
	private class SwingAxe extends TimerTask {
	    public void run() {
	    	if (!slowFire) {
	    		for (int i = 0; i < 10; i++) {
		    		Melee.makeHitbox(GameState.ladycharacter.gunxpos, GameState.ladycharacter.gunypos);
		    	}
	        }
	    	slowFire = true;
	    	Timer timer = new Timer();
	        timer.schedule(new TimerTask() {
	        	  @Override
	        	  public void run() {
	    			slowFire = false;
	        	  }
	    	}, 990);
	    }
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		mouseHeld = false;
		if (GameState.whichChar == "Default") {
			makeBullets.cancel();
			makeRocket.cancel();
		}
		if (GameState.whichChar == "Mlady") {
			makePistolB.cancel();
			makeShotgun.cancel();
		}
		if (GameState.whichChar == "Warrior") {
			swingAxe.cancel();
		}
	}


	@Override
	public void mouseDragged(MouseEvent arg0) {
		if(State.getCurrentState() == Main.gameState) {
			updateCamera();
		}
	}
	
	
}
	
	

