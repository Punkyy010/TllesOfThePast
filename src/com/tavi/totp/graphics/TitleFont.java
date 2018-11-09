package com.tavi.totp.graphics;


public class TitleFont {

	public static SpriteSheet title = new SpriteSheet("/font/fontTitle.png",8);
	public static Sprite[] font_char = Sprite.split(title);

	private String chars = "ABCDEFGH" //
			  			   +"IJKLMNOP" //
			  			   +"QRSTUVWX" //
			  			   +"YZ012345" //
			  			   +"6789<>!:";
	
	public TitleFont(){
		
	}
	
	public void render(String text ,Screen screen,int x,int y,int color){
		for(int i = 0;i < text.length();i++){
			char currentChar = text.charAt(i);
			int index = chars.indexOf(currentChar);
			if(index == -1) continue;
			screen.renderSpriteText(x + i * 8 ,y, font_char[index],color,false);
		}
		
	}
	
}
