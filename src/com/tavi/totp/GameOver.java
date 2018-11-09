package com.tavi.totp;


import com.tavi.totp.entity.mob.Player;
import com.tavi.totp.graphics.Screen;
import com.tavi.totp.graphics.TitleFont;


import com.tavi.totp.input.Keyboard;

public class GameOver extends Menu{

	public int width = Game.width;
	public int height = Game.height;
	
	Game game;
	Keyboard key;
	TitleFont font;
	Menu menu;
	Player player;

	public void init(int width ,int height,Game game, Keyboard key) {
		this.width = width;
		this.height = height;
		this.key = key;
		this.game = game;
		font = new TitleFont();
	}

	public void update(){
		if(key.space.clicked){
			game.init();
		}
	}

	public void render(Screen screen) {

		screen.clear();
		
		
		font.render("GAME OVER", screen, Game.width/2 - 4*8, Game.height/3, 0xFFFF0000);
		font.render("PRESS SPACE TO RESTART", screen, Game.width/2 - 22*4, Game.height/2, 0xFFFFFF);
		font.render("MONEY: " + Player.money, screen, Game.width/2 - 8*7 - 4, Game.height/2 + Game.height/8, 0xFFFFFF);
		font.render("DAMAGE LEVEL: " + InventoryMenu.DamageLevel, screen, Game.width/2 - 15*4, Game.height/2 + Game.height/6, 0xFFFFFF);
		font.render("HEALTH LEVEL: " + InventoryMenu.HealthLevel, screen, Game.width/2-15*4, Game.height/2 + Game.height/5, 0xFFFFFF);
		font.render("SPEED LEVEL: " + InventoryMenu.SpeedLevel, screen, Game.width/2-15*4, Game.height/2 + Game.height/4 - 5, 0xFFFFFF);

	}

}
