import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class LadyChar extends Creature{
	
	public ArrayList<Upgrade> upgrades;
	public Ability[] abilities;
	public boolean isJumping = false;
	int gunxpos = 10;
	int gunypos = main.windowHeight - 100;
	boolean turnedLeft = false;
	public BufferedImage gunPic;
	Protection forcefield = new Protection(image, 10000, 1, null);
	
	public LadyChar(Main main, int LocalX, int LocalY, int GlobalX, int GlobalY, int width, int height, BufferedImage image, int health, int speed, int jump, int baseDamage, int attackSpeed) {
		super(main, LocalX, LocalY, GlobalX, GlobalY, width, height, image, health, speed, jump, baseDamage, attackSpeed);
		abilities = new Ability[4];
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
			LocalX -= GameState.ladycharacter.speed;
			gunxpos = LocalX;
		}
		if (KeyTracker.spressed == true) {
		}
		if (KeyTracker.dpressed == true) {
			LocalX += GameState.ladycharacter.speed;
			gunxpos = LocalX;
		}
		
		// Jumping Behavior
		if (isJumping == true) {
			if (GameState.ladycharacter.jump <= -15) {
				GameState.ladycharacter.jump = 15;
				isJumping = false;
			}
			if (isJumping == true) {
				LocalY -= GameState.ladycharacter.jump;
			}
			if (GameState.ladycharacter.jump >-15) {
				GameState.ladycharacter.jump -= 1;
			}
		}
		
		// Left and right image logic
		if (mouseX - LocalX - 50 < 0) {
			turnedLeft = true;
		} else {
			turnedLeft = false;
		}
		if (turnedLeft == true) {
			image = AssetLoader.leftlady;
			gunxpos = LocalX - 70;
			gunypos = LocalY + 40;
			if (KeyTracker.primaryWeapon) {
				gunPic = AssetLoader.shotgun;
			} else {
				gunPic = AssetLoader.pistol;
			}
		} else {
			image = AssetLoader.lady;
			gunxpos = LocalX;
			gunypos = LocalY;
			if (KeyTracker.primaryWeapon) {
				gunPic = AssetLoader.shotgun;
			} else {
				gunPic = AssetLoader.pistol; 
			}
		}
		
		for (Bullets b: Bullets.bulletlist) {
			b.update();
		}
		for (Forcefield g: Forcefield.forcefieldlist) {
			g.update();
		}
		
		forcefield.update();
		
	}

	@Override
	public void render(Graphics g) {
		
		g.drawImage(image, LocalX, LocalY, width, height, null);
		ArmRotator.drawNewArm(g, gunxpos + 80, gunypos+30, gunPic);
		
		for (Bullets b: Bullets.bulletlist) {
			b.render(g);
		}
		for (Forcefield ge: Forcefield.forcefieldlist) {
			ge.render(g);
		}
		
		g.drawString("" + Forcefield.forcefieldcd, 10, 10);
		
	}

}
