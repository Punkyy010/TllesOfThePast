package com.tavi.totp.graphics;

public class Light {
	public static SpriteSheet weapon = new SpriteSheet("/player/black.png",20);
	public static Sprite[] font_char = Sprite.split(weapon);

	private String chars = "abcdef"+
							"ghijkl"+
							"mnopqr"+
							"stuvwx"+
							"yz1234"+
							"567890"; //
						  
	public Light(){
		
	}
	
	public void render(String text ,Screen screen,int x,int y,int flip){
		for(int i = 0;i < text.length();i++){
			char currentChar = text.charAt(i);
			int index = chars.indexOf(currentChar);
			if(index == -1) continue;
			screen.renderSprite(x + i * 20 ,y, font_char[index],false,flip);
		}
		
	}
	
}
