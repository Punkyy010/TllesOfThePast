package com.tavi.totp.entity.mob;

import com.tavi.totp.graphics.Screen;
import com.tavi.totp.graphics.Sprite;
import com.tavi.totp.graphics.SpriteSheet;

public class PowerMenu {

	public static SpriteSheet PMenu = new SpriteSheet("/font/PowerMenu.png",32);
	public static Sprite[] font_char = Sprite.split(PMenu);

	private String chars = "12a"
						  +"34b"
						  +"c5"; //
						  
	
	public PowerMenu(){
		
	}
	
	public void render(String text ,Screen screen,int x,int y,int flip){
		for(int i = 0;i < text.length();i++){
			char currentChar = text.charAt(i);
			int index = chars.indexOf(currentChar);
			if(index == -1) continue;
			screen.renderSprite(x + i * 9 ,y, font_char[index],false,flip);
		}
	}
	
}
