package com.tavi.totp;

import com.tavi.totp.input.Keyboard;

public class AboutMenu extends Menu{
	
	public int width = Game.width;
	public int height = Game.height;
	
	Game game;
	Keyboard key;
	
	public void init(int width,int height,Game game){
		this.width = width * 4;
		this.height = height * 4;
		
		key = new Keyboard(game);
	}
	
	public void update(){
		if(key.space.clicked){
			game.setMenu(new MainMenu());
		}
	}
	
	
}
