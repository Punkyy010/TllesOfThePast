package com.tavi.totp.graphics;

public class CoinsBorder {

	public static SpriteSheet weapon = new SpriteSheet("/font/border.png",9);
	public static Sprite[] font_char = Sprite.split(weapon);

	private String chars = "12"; //
						  
	
	public CoinsBorder(){
		
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
