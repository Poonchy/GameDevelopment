import java.awt.event.ActionListener;

import javax.swing.JFrame;

public abstract class Main extends JFrame implements ActionListener{
	public static void main(String[] args) {
		
		//Creating Main Menu for game.
		MainMenu mainmenu;
		mainmenu = new MainMenu();
		mainmenu.createMenu();
		
	}
}
