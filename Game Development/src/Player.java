import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Player extends Creature{
	
	public ArrayList<Upgrade> upgrades;
	public Ability[] abilities;
	public boolean isJumping = false;
	int gunxpos = 10;
	int gunypos = main.windowHeight - 100;
	boolean turnedLeft = false;
	public BufferedImage gunPic;
	Grenada Grenada = new Grenada(image, 3000, 4, null);
	public static Queue<Bullets> bulletlist = new ConcurrentLinkedQueue <Bullets>();
	public static Queue<Grenade> grenadelist = new ConcurrentLinkedQueue <Grenade>();
	
	public Player(Main main, int x, int y, int width, int height, BufferedImage image, int health, int speed, int jump, int baseDamage, int attackSpeed) {
		super(main, x, y - 100, width, height, image, health, speed, jump, baseDamage, attackSpeed);
		abilities = new Ability[4];
		upgrades = new ArrayList<Upgrade>();
		
		abilities[0] = Grenada;
		
	}

	@Override
	public void update() {
		// WASD Movement
		if (KeyTracker.wpressed == true) {
			if (isJumping == false) {
				isJumping = true;
			}
		}
		if (KeyTracker.apressed == true) {
			xPos -= GameState.character.speed;
			gunxpos = xPos;
		}
		if (KeyTracker.spressed == true) {
		}
		if (KeyTracker.dpressed == true) {
			xPos += GameState.character.speed;
			gunxpos = xPos;
		}
		
		// Jumping Behavior
		if (isJumping == true) {
			if (GameState.character.jump <= -15) {
				GameState.character.jump = 15;
				isJumping = false;
			}
			if (isJumping == true) {
				yPos -= GameState.character.jump;
			}
			if (GameState.character.jump >-15) {
				GameState.character.jump -= 1;
			}
		}
		
		// Left and right image logic
		if (main.mouseTracker.mouseX - xPos - 50 < 0) {
			turnedLeft = true;
		} else {
			turnedLeft = false;
		}
		if (turnedLeft == true) {
			image = AssetLoader.leftcapn;
			gunxpos = xPos - 70;
			gunypos = yPos + 40;
			gunPic = AssetLoader.weaponleft;
		} else {
			image = AssetLoader.capn;
			gunxpos = xPos;
			gunypos = yPos;
			gunPic = AssetLoader.weapon;
		}
		
		// Grenade behavior
		
		abilities[0].update();
		
	}

	@Override
	public void render(Graphics g) {
		
		g.drawImage(image, xPos, yPos, width, height, null);
		ArmRotator.drawNewArm(g, gunxpos + 80, gunypos+30, gunPic);
		Iterator<Bullets> iter = bulletlist.iterator();
		while(iter.hasNext()) {
		  iter.next().render(g);
		}
		
		Iterator<Grenade> giter = grenadelist.iterator();
		while(giter.hasNext()) {
		  giter.next().render(g);
		}
		g.drawString("" + Grenade.grenadecd, 10, 10);
		
	}

}
