import java.awt.Graphics;

public abstract class State {
	
	Main main;
	static State currentState;
	
	public State(Main main) {
		this.main = main;
	}
	
	public abstract void update();
	
	public abstract void render(Graphics g);

	
	//Getters and Setters
	public static State getCurrentState() {
		return currentState;
	}

	public static void setCurrentState(State currentStatet) {
		currentState = currentStatet;
	}
	
}
