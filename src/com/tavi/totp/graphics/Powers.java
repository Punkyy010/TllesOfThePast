package com.tavi.totp.graphics;

public class Powers {

	public static SpriteSheet powers = new SpriteSheet("/font/PowersBar.png",32);
	public static Sprite[] font_char = Sprite.split(powers);

	private String chars = "12a"
						  +"34b"
						  +"c5"; //
						  
	
	public Powers(){
		
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
