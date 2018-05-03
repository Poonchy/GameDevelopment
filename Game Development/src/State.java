import java.awt.Graphics;

public abstract class State {
	
	Main main;
	State currentState;
	
	public State(Main main) {
		this.main = main;
	}
	
	public abstract void update();
	
	public abstract void render(Graphics g);

	
	//Getters and Setters
	public State getCurrentState() {
		return currentState;
	}

	public void setCurrentState(State currentState) {
		this.currentState = currentState;
	}
	
}
