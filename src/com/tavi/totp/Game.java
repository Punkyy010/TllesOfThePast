package com.tavi.totp;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.tavi.totp.entity.mob.Player;
import com.tavi.totp.entity.mob.TreeLevel1;
import com.tavi.totp.graphics.Font;
import com.tavi.totp.graphics.Screen;
import com.tavi.totp.input.Keyboard;
import com.tavi.totp.input.Mouse;
import com.tavi.totp.level.Level;
import com.tavi.totp.level.SpawnLevel;
import com.tavi.totp.mob.skeleton.Skeleton;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;

	Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
	public static int scale = 2;
	public static int width = 250 ; //450 300 250
	public static int height = 183; //275 193 183
	public static String title = "TILES OF THE PAST";
	public static boolean sound = true;

	private Player player;
	private TreeLevel1 t;
	public static boolean running = false;

	private Screen screen; 
	private Level level;	
	private Gui gui; 
	public static Menu menu;
	public JFrame frame;
	public Font font;
	public Keyboard key = new Keyboard(this);
	private Level[] levels = new Level[4];
	public static int currentLevel = 0;
	public static boolean levelChanged = false;
	public static int Wd;
	public static int Hg;
	
	private Thread thread;
	private static BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	public static boolean isLimit = false;
	
	public Game() {
		setMinimumSize(size);
		setMaximumSize(size);
		setPreferredSize(size);
		
		Wd = size.width;
		Hg = size.height;
	

		screen = new Screen(width, height,pixels);
		key = new Keyboard(this);

		
		Mouse mouse = new Mouse();
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
	}
	
	public void setGui(Gui gui){
		this.gui = gui;
		if(gui != null) gui.init(width, height, this, key);
	}
	
	public void setMenu(Menu menu){
		this.menu = menu;
		if (menu != null) menu.init(width,height,this, key);
	}

	public static int getWindowWidth() {
		return Wd;
	}

	public static int getWindowHeight() {
		return Hg;
	}
	
	public synchronized void start() {
		running = true;
		thread = new Thread(this,title + "_Main");
		thread.start();
	}

	public synchronized void stop() {
		running = false;
		
		try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}
	
	public void resetGame(){
		levels = new Level[4];
		currentLevel = 0;
		
		levels[3] = new SpawnLevel("/levels/level4.png");
		levels[2] = new SpawnLevel("/levels/level3.png");
		levels[1] = new SpawnLevel("/levels/Level2.png");
		levels[0] = new SpawnLevel("/levels/StartZone.png");
		
		level = levels[currentLevel];
		setGui(new Gui());
		font = new Font();
		player = new Player(this,key);
		level.add(player);
	}
	
	public void init(){
		resetGame();
		setMenu(new MainMenu());
	}

	public void changeLevel(int dir){
		level.remove(player);
		currentLevel += dir;
		level = levels[currentLevel];
		level.add(player);
		levelChanged = true;
	}
	
	
	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int updates = 0;
		
		init();
		
		requestFocus();
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				update();
				updates++;
				delta--;
			}
			render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println(updates + " updates, " + frames + " fps");
				updates = 0;
				frames = 0;
			}
		}
		stop();
	}
	
	public void update() {
		key.tick();
		if(!hasFocus()){
			key.releaseAll();
		}else{
		if(menu != null){
			menu.update();
			
		}else{
			level.update();
			gui.update();
			if(Player.health == 0) setMenu(new GameOver());
			if(key.esc.clicked) setMenu(new EscMenu());
			if(key.e.clicked) setMenu(new InventoryMenu());
		}
		
		}
	}
	
	public static double get_xScroll(double x) {
		double xScroll = x;
		if (xScroll < 32) isLimit = true;
		if (xScroll > Level.width * 32 - Screen.width ) {
			isLimit = true;
			xScroll = Level.width * 32 - Screen.width ;
		}
		return xScroll;
	}
	
	public static double get_yScroll(double y) {
		double yScroll = y;
		if (yScroll < 32) yScroll = 32;
		if (yScroll > Level.height * 32 - Screen.height ) {
			isLimit = true;
			yScroll = Level.height * 32 - Screen.height ;
		}
		return yScroll;
	}
	
	public void render() {
		
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			requestFocus();
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		
		isLimit = false;
		double xScroll = player.x + 6 - Screen.width / 2;
		double yScroll = player.y + 9 - Screen.height / 2;
	
		xScroll = get_xScroll(xScroll);
		yScroll = get_yScroll(yScroll);
		
		level.renderBackground((int)xScroll,(int)yScroll, screen);
		level.renderSprites(screen,(int)xScroll,(int)yScroll);
		//level.renderBackgroundObjects((int)xScroll,(int)yScroll,screen);
		if(menu != null){
			menu.render(screen);
		}
		
		if(Player.health != 0){
			if(menu == null){
				//gui.paint(g,xScroll,yScroll);
				gui.render(screen);
			}
		}
		
		g.dispose();
		bs.show();
	}
	
	public static void main(String[] args) {
		
		Game game = new Game();
		JFrame frame = new JFrame();
		frame.setUndecorated(true);
		frame.setTitle(Game.title);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.add(game);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
	    Image cursorImage = toolkit.getImage("res/levels/cursor.png");
	    Point cursorHotSpot = new Point(0,0);
	    Cursor customCursor = toolkit.createCustomCursor(cursorImage, cursorHotSpot, "Cursor");
	    frame.setCursor(customCursor);
		//Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		game.start();
		
	}
}