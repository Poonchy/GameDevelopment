/*
 * Made by: Ronin
 */
import java.awt.Canvas;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JFrame;

public class Main extends JFrame implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8234134890401296256L;
	public boolean isRunning;
	private int ticks;
	private int frames;
	private int fps = 60;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public int windowWidth = (int) screenSize.getWidth();
	public int windowHeight = (int) screenSize.getHeight();
	private Canvas canvas = new Canvas();
	private BufferStrategy bufferStrategy;
	private Graphics g;
	
	//States
	static MenuState menuState;
	static GameState gameState;
	static ChooseState chooseState;
	
	//Peripherals
	MouseTracker mouseTracker;
	KeyTracker keyTracker;
	
	//Camera
	public static int XOffSet = 0;
	public static int YOffSet = 0;
	
	//Audio
	
	public static void main(String[] args) {
		Main main = new Main();
		main.run();
		System.exit(0);
	}
	
	public void initialize() throws IOException, URISyntaxException {
				
	//Window stuff
		setTitle("Some Game Thing"); 
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setUndecorated(true);
		setResizable(false);
		setVisible(true);
		isRunning = true;
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image cursorImage = ImageLoader.loadImage("/textures/reticle.png");
		Point cursorHotSpot = new Point(15,15);
		Cursor customCursor = toolkit.createCustomCursor(cursorImage, cursorHotSpot, "Cursor");
		setCursor(customCursor);
		addMouseListener(mouseTracker);
		addMouseMotionListener(mouseTracker);
		
	//Canvas
	//The canvas is what the graphics are "drawn" on
		canvas.setPreferredSize(new Dimension(windowWidth, windowHeight));
		canvas.setMaximumSize(new Dimension(windowWidth, windowHeight));
		canvas.setMinimumSize(new Dimension(windowWidth, windowHeight));
		canvas.setFocusable(false);
		canvas.addMouseListener(mouseTracker);
		canvas.addMouseMotionListener(mouseTracker);
		add(canvas);
		pack();
		
	//States
		menuState = new MenuState(this);
		gameState = new GameState(this);
		chooseState = new ChooseState(this);
		State.setCurrentState(menuState);

	//Peripherals
		mouseTracker = new MouseTracker();
		keyTracker = new KeyTracker();
		
	//Listeners
		addMouseListener(mouseTracker);
	    addMouseMotionListener(mouseTracker);
	    addKeyListener(keyTracker);
	    canvas.addMouseListener(mouseTracker); //add mouse listeners to both jframe and canvas so whichever is active or focused mouse will still be tracked
	    canvas.addMouseMotionListener(mouseTracker);
	    
	//Audio
		AssetLoader.loadMusic();
	}
	
	//Updates variables, sets positions (numbers stuff)
	public void update() {
		State.getCurrentState().update();
	}
	
	//Draws the graphics
	public void render() {
		   bufferStrategy = canvas.getBufferStrategy();
		   if(bufferStrategy == null){
			   canvas.createBufferStrategy(3);
			   return;
		   }
		   g = bufferStrategy.getDrawGraphics();
		   //Clears the screen
		   g.clearRect(0, 0, windowWidth, windowHeight);
		   
		   //Displays the images
		   
		   State.getCurrentState().render(g);
		   
		   //Displays the buffer
		   bufferStrategy.show();
		   g.dispose();
	}

	@Override
	public void run() {
		try {
			initialize();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long fpsTimer = System.currentTimeMillis();
		
		while(isRunning) { // updates, 
			long firstTime = System.currentTimeMillis(); 
            ticks++;
            update(); 
             
            frames++;
            render(); 
             
            // Time it took for one frame. If it took longer than frame cap, do nothing. If it was faster than frame cap, delay the next frame. 
            long delay = (1000 / fps) - (System.currentTimeMillis() - firstTime); 
             
            if (delay > 0) 
            { 
            	 
                    try{ 
                            Thread.sleep(delay); 
                    } 
                    catch(Exception e){} 
            } 
            
            //Every 60 seconds (or whatever the fps is) print how many updates and how many frames there have been
            if(System.currentTimeMillis() - fpsTimer >=1000 ){
            	fpsTimer = System.currentTimeMillis();
            	System.out.println("ticks: " + ticks + " frames: " + frames);
            	ticks = 0;
            	frames = 0;
            }
             
		}// GAME LOOP 
		setVisible(false); 
	} // run
	
	
} // class
