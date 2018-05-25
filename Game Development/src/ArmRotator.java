import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class ArmRotator {
	public static void drawNewArm(Graphics g, int xposition, int yposition, BufferedImage image) {
		double scalex;
		double scaley;
		if (KeyTracker.primaryWeapon) {
			scalex = 90.0 / image.getWidth();
			scaley = 90.0 / image.getHeight();
		} else {
			scalex = 50.0 / image.getWidth();
			scaley = 50.0 / image.getHeight();
		}
		int mouseY = MouseInfo.getPointerInfo().getLocation().y;
        int mouseX = MouseInfo.getPointerInfo().getLocation().x;
        double angle = Math.atan2((mouseY-yposition - 20),(mouseX-xposition));
		Graphics2D g2d = (Graphics2D) g;
		AffineTransform at = AffineTransform.getTranslateInstance(0,0);
		if (KeyTracker.primaryWeapon) {
			at.translate(xposition - 20,yposition);
			at.rotate(angle, -50, 0);
		} else {
			at.translate(xposition + 20,yposition);
			at.rotate(angle, -30, 0);
		}
		at.scale(scalex, scaley);
	    g2d.drawImage(image, at, null);
	}
}
