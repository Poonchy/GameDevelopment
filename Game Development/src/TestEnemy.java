import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
public class TestEnemy extends Enemy {
	boolean isjumping = false;
	boolean turnedLeft = true;
	int gunxpos = 300;
	int gunypos = main.windowHeight - 100;
	public BufferedImage gunPic;
	public BufferedImage TestEnemy = AssetLoader.TestEnemy;
	
	public TestEnemy(Main main, int x, int y, int width, int height, BufferedImage image, int health, int speed,
			int jump, int baseDamage, int attackSpeed) {
		super(main, x, y - 100, width, height, image, health, speed, jump, baseDamage, attackSpeed);
		image = TestEnemy;
		// TODO Auto-generated constructor stub
	}

	public void render(Graphics g) {
			g.drawImage(image, xPos, yPos, width, height, null);
	}


}
