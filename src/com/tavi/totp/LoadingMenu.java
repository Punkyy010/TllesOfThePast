package com.tavi.totp;

import com.tavi.totp.graphics.Font;
import com.tavi.totp.graphics.Screen;
import com.tavi.totp.level.Level;

public class LoadingMenu extends Menu{

	private Game game;
	
	public LoadingMenu(){
		font = new Font();
	}
	
	public void update(){
		Game.levelChanged = false;
		if(Level.mobReady)
			game.setMenu(null);
	}
	
	public void render(Screen screen){
		for(int x = 0; x <= Game.width;x++){
			for(int y = 0; y <= Game.height;y++){
				Font.render("~", screen, x, y, 0xFF000000);
				Font.render("LOADING...", screen, 100, 100, 0xFFFFFF);
			}
		}
		
	}
	
}
