import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Player extends Creature{
	
	public ArrayList<Upgrade> upgrades;
	public Ability[] abilities;
	public boolean isJumping = false;
	int gunxpos = 10;
	int gunypos = main.windowHeight - 100;
	boolean turnedLeft = false;
	public BufferedImage gunPic;
	public static Ability grenada;
	public static Upgrade grenadaSplit;
 	
	public Player(Main main, int x, int y, int width, int height, BufferedImage image, int health, int speed, int jump, int baseDamage, int attackSpeed) {
		super(main, x, y - 100, width, height, image, health, speed, jump, baseDamage, attackSpeed);
		
		grenada = new Grenada(image, 3000, 4, null);
		
		abilities = new Ability[4];
		abilities[0] = grenada;
		abilities[1] = null;
		abilities[2] = null;
		abilities[3] = null;
		
		grenadaSplit = new GrenadaSplit();
		
		upgrades = new ArrayList<Upgrade>();
		
	}

	@Override
	public void update() {
		int mouseX = MouseInfo.getPointerInfo().getLocation().x;
		// WASD Movement
		if (KeyTracker.wpressed == true) {
			if (isJumping == false) {
				isJumping = true;
			}
		}
		if (KeyTracker.apressed == true) {
			xPos -= GameState.defaultchar.speed;
			gunxpos = xPos;
		}
		if (KeyTracker.spressed == true) {
		}
		if (KeyTracker.dpressed == true) {
			xPos += GameState.defaultchar.speed;
			gunxpos = xPos;
		}
		
		// Jumping Behavior
		if (isJumping == true) {
			if (GameState.defaultchar.jump <= -15) {
				GameState.defaultchar.jump = 15;
				isJumping = false;
			}
			if (isJumping == true) {
				yPos -= GameState.defaultchar.jump;
			}
			if (GameState.defaultchar.jump >-15) {
				GameState.defaultchar.jump -= 1;
			}
		}
		
		// Left and right image logic
		if (mouseX - xPos - 50 < 0) {
			turnedLeft = true;
		} else {
			turnedLeft = false;
		}
		if (turnedLeft == true) {
			image = AssetLoader.leftcapn;
			gunxpos = xPos - 70;
			gunypos = yPos + 40;
			if (KeyTracker.primaryWeapon) {
				gunPic = AssetLoader.rocketlauncher;
			} else {
				gunPic = AssetLoader.weaponleft;
			}
		} else {
			image = AssetLoader.capn;
			gunxpos = xPos;
			gunypos = yPos;
			if (KeyTracker.primaryWeapon) {
				gunPic = AssetLoader.rocketlauncher;
			} else {
				gunPic = AssetLoader.weapon; 
			}
		}
		
		for (Bullets b: Bullets.bulletlist) {
			b.update();
		}
		for (Rocket r: Rocket.Rocketlist) {
			r.update();
		}
		for (Grenade g: Grenade.grenadelist) {
			g.update();
		}
		
		// Grenade behavior
		grenada.update();
		
	}

	@Override
	public void render(Graphics g) {
		
		g.drawImage(image, xPos, yPos, width, height, null);
		ArmRotator.drawNewArm(g, gunxpos + 80, gunypos+30, gunPic);
		
		for (Bullets b: Bullets.bulletlist) {
			b.render(g);
		}
		for (Rocket r: Rocket.Rocketlist) {
			r.render(g);
		}
		for (Grenade ge: Grenade.grenadelist) {
			ge.render(g);
		}
		
		g.drawString("" + Grenada.grenadecd, 10, 10);
		
	}

}
