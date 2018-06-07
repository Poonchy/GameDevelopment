import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

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

	public Player(Main main, int LocalX, int LocalY, int GlobalX, int GlobalY, int width, int height, BufferedImage image, int health, int speed, int jump, int baseDamage, int attackSpeed) {
		super(main, LocalX, LocalY, GlobalX, GlobalY, width, height, image, health, speed, jump, baseDamage, attackSpeed);
		
		grenada = new Grenada(image, 3000, 4, null);
		
		abilities = new Ability[4];
		abilities[0] = grenada;
		abilities[1] = null;
		abilities[2] = null;
		abilities[3] = null;
		
		grenadaSplit = new GrenadaSplit();
		
		upgrades = new ArrayList<Upgrade>();
		
		abilities[0] = grenada;
		
	}

	@Override
	public void update() {
		int mouseX = MouseInfo.getPointerInfo().getLocation().x;
		// WASD Movement
		if (KeyTracker.spacePressed == true) {
			if (isJumping == false) {
				isJumping = true;
			}
		}
		if (KeyTracker.aPressed == true) {
			GameState.defaultchar.speed = -10;
		} else
		if (KeyTracker.sPressed == true) {
		} else
		if (KeyTracker.dPressed == true) {
			GameState.defaultchar.speed = 10;
		} else {
			GameState.defaultchar.speed = 0;
		}
		if (KeyTracker.aPressed == true && KeyTracker.dPressed == true) {
			GameState.defaultchar.speed = 0;
		}
		
		// Jumping Behavior
		if (isJumping == true) {
			if (GameState.defaultchar.jumpHeight <= -15) {
				GameState.defaultchar.jumpHeight = 15;
				isJumping = false;
			}
			if (isJumping == true) {
				//y
				GlobalY -= GameState.defaultchar.jumpHeight;
				Main.YOffSet -= GameState.defaultchar.jumpHeight;
				gunypos = LocalY;
			}
			if (GameState.defaultchar.jumpHeight >-15) {
				GameState.defaultchar.jumpHeight -= 1;
			}
			
			/* this.GlobalY -= this.jumpHeight;
			Main.YOffSet -= this.jumpHeight;
			isJumping = false; */
		}
		
		// Left and right image logic
		if (mouseX - LocalX - 50 < 0) {
			turnedLeft = true;
		} else {
			turnedLeft = false;
		}
		if (turnedLeft == true) {
			image = AssetLoader.leftcapn;
			gunxpos = LocalX - 70;
			gunypos = LocalY + 40;
			if (KeyTracker.primaryWeapon) {
				gunPic = AssetLoader.rocketlauncher;
			} else {
				gunPic = AssetLoader.weaponleft;
			}
		} else {
			image = AssetLoader.capn;
			gunxpos = LocalX;
			gunypos = LocalY;
			if (KeyTracker.primaryWeapon) {
				gunPic = AssetLoader.rocketlauncher;
			} else {
				gunPic = AssetLoader.weapon; 
			}
		}
		
		// Global and Local position updates (VERY IMPORTANT)
		//x
		GlobalX += GameState.defaultchar.speed;
		Main.XOffSet += GameState.defaultchar.speed;
		LocalX = GlobalX  - Main.XOffSet;
		gunxpos = LocalX;
		
		//y
		LocalY = GlobalY  - Main.YOffSet;
		
		
		//Update player's projectile
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

		g.drawImage(image, LocalX, LocalY, width, height, null);
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
