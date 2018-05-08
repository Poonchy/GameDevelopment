import java.awt.image.BufferedImage;

public class Upgrade {
	
	public BufferedImage icon;
	public int  healthBuff,
				speedBuff,
				jumpBuff,
				damageBuff,
				attackSpeedBuff;

	public Upgrade(BufferedImage icon, int healthBuff, int speedBuff, int jumpBuff, int damageBuff, int attackSpeedBuff) {
		this.icon = icon;
		this.healthBuff = healthBuff;
		this.speedBuff = speedBuff;
		this.jumpBuff = jumpBuff;
		this.damageBuff = damageBuff;
		this.attackSpeedBuff = attackSpeedBuff;
	}
	

}
