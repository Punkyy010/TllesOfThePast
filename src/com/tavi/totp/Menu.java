package com.tavi.totp;

import com.tavi.totp.graphics.Font;
import com.tavi.totp.graphics.Light;
import com.tavi.totp.graphics.Screen;
import com.tavi.totp.input.Keyboard;


public class Menu {
	
	protected Game game;
	
	public int width = Game.width;
	public int height = Game.height;
	public Font font;
	public Light light;

	
	public void init(int width ,int height,Game game, Keyboard key) {
		this.width = width;
		this.height = height;
		this.game = game;
		this.font = new Font();
		this.light = new Light();
	}
	
	public void update(){
		
	}
	
	
 	public void render(Screen screen){
 		
		
	} 
	
}
