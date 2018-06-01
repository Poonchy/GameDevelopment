import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Warrior extends Creature{
	
	public ArrayList<Upgrade> upgrades;
	public Ability[] abilities;
	public boolean isJumping = false;
	int gunxpos = 10;
	int gunypos = main.windowHeight - 100;
	public static boolean turnedLeft = false;
	public BufferedImage gunPic;
	Protection forcefield = new Protection(image, 10000, 1, null);
	
	public Warrior(Main main, int x, int y, int width, int height, BufferedImage image, int health, int speed, int jump, int baseDamage, int attackSpeed) {
		super(main, x, y - 100, width, height, image, health, speed, jump, baseDamage, attackSpeed);
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
			xPos -= GameState.ladycharacter.speed;
			gunxpos = xPos;
		}
		if (KeyTracker.spressed == true) {
		}
		if (KeyTracker.dpressed == true) {
			xPos += GameState.ladycharacter.speed;
			gunxpos = xPos;
		}
		
		// Jumping Behavior
		if (isJumping == true) {
			if (GameState.ladycharacter.jump <= -15) {
				GameState.ladycharacter.jump = 15;
				isJumping = false;
			}
			if (isJumping == true) {
				yPos -= GameState.ladycharacter.jump;
			}
			if (GameState.ladycharacter.jump >-15) {
				GameState.ladycharacter.jump -= 1;
			}
		}
		
		// Left and right image logic
		if (mouseX - xPos - 50 < 0) {
			turnedLeft = true;
		} else {
			turnedLeft = false;
		}
		if (turnedLeft == true) {
			image = AssetLoader.leftwarrior;
			gunxpos = xPos - 70;
			gunypos = yPos + 40;
			if (KeyTracker.primaryWeapon) {
				gunPic = AssetLoader.shotgun;
			} else {
				gunPic = AssetLoader.pistol;
			}
		} else {
			image = AssetLoader.warrior;
			gunxpos = xPos;
			gunypos = yPos;
			if (KeyTracker.primaryWeapon) {
				gunPic = AssetLoader.shotgun;
			} else {
				gunPic = AssetLoader.pistol; 
			}
		}
		
		for (Melee b: Melee.meleelist) {
			b.update();
		}
		
	}

	@Override
	public void render(Graphics g) {
		
		g.drawImage(image, xPos, yPos, width, height, null);
		
		for (Melee b: Melee.meleelist) {
			b.render(g);
		}
		
	}

}
