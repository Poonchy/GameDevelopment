import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class ArmRotator {
	public static void drawNewArm(Graphics g) {
		double testx;
		double testy;
		Graphics2D g2d = (Graphics2D) g;
		testx = 200.0 / 445.0;
		testy = 80.0 / 179.0;
		AffineTransform at = AffineTransform.getTranslateInstance(0,0);
		at.translate(100,100);
		at.scale(testx, testy);
	    at.rotate(Math.toRadians(45));
	    g2d.drawImage(AssetLoader.imgendbtn, at, null);
	}
}
