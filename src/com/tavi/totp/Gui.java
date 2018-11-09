package com.tavi.totp;

import java.awt.Color;
import java.awt.Graphics;

import com.tavi.totp.entity.mob.Mob;
import com.tavi.totp.entity.mob.Player;
import com.tavi.totp.graphics.Coins;
import com.tavi.totp.graphics.Coins2;
import com.tavi.totp.graphics.CoinsBorder;
import com.tavi.totp.graphics.Font;
import com.tavi.totp.graphics.Light;
import com.tavi.totp.graphics.Screen;
import com.tavi.totp.graphics.Weapon;
import com.tavi.totp.input.Keyboard;
import com.tavi.totp.input.Mouse;
import com.tavi.totp.level.Level;

public class Gui {

	protected Game game;
	protected Screen screen;
	protected Level level;
	protected Player player;
	protected Font font;
	protected Weapon weapon;
	protected Keyboard key;
	protected CoinsBorder border;
	protected Coins coins;
	protected Mob mob;
	protected Light light;
	
	public int width = Game.width;
	public int height = Game.height;
	
	public static boolean has = false;
	//private BufferedImage light;
	
	int secounds = 0;
	int minutes = 0;
	public static String wp = "2";
	public static int kills = 0;
	
	public void init(int width,int height,Game game,Keyboard key){
		this.width = width;
		this.height = height;
		this.key = key;
		font = new Font();
		light = new Light();
		coins = new Coins();
		weapon = new Weapon();
		border = new CoinsBorder(); 
		//light = loadImageFrom.LoadImageFrom(Game.class,"");
	}
	
	
	public void secounds(){
		secounds++;
	}
	
	public void update(){
		
		//Game.scale = 2;
		
		//System.out.println(Game.scale);
		
		if(Player.changeL) kills = 0;
		
		if(key.one.clicked) wp = "2";
		//if(key.two.clicked) wp = "2";
		
	}
	
	public void light(Screen screen){
		for(int x = 0; x <= Game.width/2 - 58;x++){
			for(int y = 0; y <= Game.height;y++){
					Font.render("~", screen, x, y, 0xFF000000);
			}
		}
		for(int x = Game.width/2 - 58; x <= Game.width;x++){
			for(int y = 0; y <= 25;y++){
				Font.render("~", screen, x, y, 0xFF000000);
			}
		}
		for(int x = Game.width/2 - 58; x <= Game.width;x++){
			for(int y = Game.height - 25; y <= Game.height;y++){
				Font.render("~", screen, x, y, 0xFF000000);
			}
		}
		for(int x = Game.width/2 + 70; x <= Game.width;x++){
			for(int y = 25; y <= Game.height;y++){
					Font.render("~", screen, x, y, 0xFF000000);
			}
		}
		
		light.render("abcdef", screen, Game.width/2 - 60, Game.height/2-90, 0);
		light.render("ghijkl", screen, Game.width/2 - 60, Game.height/2-60, 0);
		light.render("mnopqr", screen, Game.width/2 - 60, Game.height/2-30, 0);
		light.render("stuvwx", screen, Game.width/2 - Game.height/2 +30, 90, 0);
		light.render("yz1234", screen, Game.width/2 - Game.height/2+60, 110, 0);
		light.render("567890", screen, Game.width/2 - 60,Game.height/2+90, 0);
	}
	
	
	int d = 0;
	public void render(Screen screen){
		
		Graphics g = null;
		String coinz = Integer.toString(Player.money);
		String killz = Integer.toString(Level.kills);
		
		//if(Game.currentLevel == 1) light(screen);
		//font.render( m + ":" + s, screen, 130, 10,0xFFFFFF);
		for(int i = 0;i < 50;i += 8){
			Font.render("~", screen, i, Game.height-8 , 0xFF808080);
		}
		for(int i = 0;i < 50;i += 8){
			Font.render("~", screen, i, Game.height-8-8, 0xFF808080);
		}
		//draw the hearts
		for(int i = 0;i < Player.health/2;i++) {
			Coins2.renderH("1", screen, 3 +i*9, Game.height-11, 0);
		}
		weapon.render("6", screen, 3, Game.height-8 - 20,0);
		border.render("1", screen, 23, Game.height-8-15, 0);
		border.render("2", screen, 32, Game.height-8-15, 0);
		border.render("2", screen, 41, Game.height-8-15, 0);
		border.render("1", screen, 50, Game.height-8-15, 2);
		Coins.render("a", screen, 30, Game.height-8-14, 0);
		//System.out.println(Player.coinz);
		Coins.render(coinz,screen,40,Game.height-8-14,0);
		Font.render(killz + "/20", screen, 0, 0, 0xFFFFFFFF);
		weapon.render("7", screen, Game.width-38, 10, 0);
		
	
		//has = true;
		//screen.renderSpriteText(5, 100, Sprite.health, 0xFFFFFFFF, true);
		//screen.renderSprite(100, 100, Sprite.health, true);
		
		weapon.render(wp, screen, Game.width-38, Game.height-38,0);
	}
	
	public void paint(Graphics g,double x,double y) {
			g.setColor(Color.BLUE);
			g.fillRect((int)x,(int) y,160,160);
	}
	
}
