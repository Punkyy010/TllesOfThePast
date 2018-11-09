package com.tavi.totp;

import com.tavi.totp.entity.mob.Player;
import com.tavi.totp.graphics.Screen;
import com.tavi.totp.graphics.TitleFont;
import com.tavi.totp.input.Keyboard;

public class WinMenu extends Menu{

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
		
		
		font.render("YOU WON", screen, 120, 30, 0xFF00A700);
		font.render("PRESS SPACE TO RESTART", screen, 80, 50, 0xFFFFFF);
		font.render("MONEY: " + Player.money, screen, 80, 70, 0xFFFFFF);
		font.render("DAMAGE LEVEL: " + InventoryMenu.DamageLevel, screen, 80, 90, 0xFFFFFF);
		font.render("HEALTH LEVEL: " + InventoryMenu.HealthLevel, screen, 80, 110, 0xFFFFFF);
		font.render("SPEED LEVEL: " + InventoryMenu.SpeedLevel, screen, 80, 130, 0xFFFFFF);

	}
	
}
