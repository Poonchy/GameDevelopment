import java.awt.Graphics;

public class GameState extends State {
	Main main;
	
	public GameState(Main main) {
		super(main);
	}
	
	public void update() {
		if (KeyTracker.wpressed == true) {
			System.out.println("W held");
		}
		if (KeyTracker.apressed == true) {
			System.out.println("A held");
		}
		if (KeyTracker.spressed == true) {
			System.out.println("S held");
		}
		if (KeyTracker.dpressed == true) {
			System.out.println("D held");
		}
	}
	
	public void render(Graphics g) {
		ArmRotator.drawNewArm(g);
	}
}
