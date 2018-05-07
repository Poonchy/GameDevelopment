import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.geom.AffineTransform;

public class ArmRotator {
	public static void drawNewArm(Graphics g) {
		double testx = 200.0 / 445.0;
		double testy = 80.0 / 179.0;
		int OneAndHalfY = 100 + (100/2);
		int OneAndHalfX = 100 + (40/2);
		int mouseY = MouseInfo.getPointerInfo().getLocation().y;
        int mouseX = MouseInfo.getPointerInfo().getLocation().x;
        double angle = Math.atan2((mouseY-OneAndHalfY),(mouseX-OneAndHalfX));
		Graphics2D g2d = (Graphics2D) g;
		AffineTransform at = AffineTransform.getTranslateInstance(0,0);
		at.translate(100,100);
		at.scale(testx, testy);
	    at.rotate(angle, 100, 140);
	    g2d.drawImage(AssetLoader.imgendbtn, at, null);
	}
}
