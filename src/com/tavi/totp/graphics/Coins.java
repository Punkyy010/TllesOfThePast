package com.tavi.totp.graphics;

public class Coins {

	public static SpriteSheet weapon = new SpriteSheet("/font/coins.png",7);
	public static Sprite[] font_char = Sprite.split(weapon);

	private static String chars = "a1234567890"; //
						  
	
	public Coins(){
		
	}
	
	public static void render(String text ,Screen screen,int x,int y,int flip){
		for(int i = 0;i < text.length();i++){
			char currentChar = text.charAt(i);
			int index = chars.indexOf(currentChar);
			if(index == -1) continue;
			screen.renderSprite(x + i * 7 ,y, font_char[index],false,flip);
		}
		
	}
	
	
}
