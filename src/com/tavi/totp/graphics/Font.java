package com.tavi.totp.graphics;

public class Font {
	
	public static SpriteSheet font = new SpriteSheet("/font/font.png",8);
	public static SpriteSheet demon = new SpriteSheet("/sheets/d_head.png",20);
	public static Sprite[] font_char = Sprite.split(font);
	public static Sprite[] de_char = Sprite.split(demon);
	static int space = 0;

	private static String chars = "ABCDEFGH" //
						  +"IJKLMNOP" //
						  +"QRSTUVWX" //
						  +"YZ012345" //
						  +"6789.,!?" //
						  +"'”-+=/\\%" //
						  +"()<>:;~`"; 
	private static String de = "1";
	
	public static void render(String text ,Screen screen,int x,int y,int color){
		for(int i = 0;i < text.length();i++){
			char currentChar = text.charAt(i);
			if(currentChar == ' ') space = 20;
			int index = chars.indexOf(currentChar);
			if(index == -1) continue;
			screen.renderSpriteText(x + i * 8  ,y, font_char[index],color,false);
		}
		
	}
	
	public static void renderD(String text ,Screen screen,int x,int y,int flip){
		for(int i = 0;i < text.length();i++){
			char currentChar = text.charAt(i);
			if(currentChar == ' ') space = 20;
			int index = de.indexOf(currentChar);
			if(index == -1) continue;
			screen.renderSprite(x + i * 20 ,y, de_char[index],false,flip);
		}
		
	}
	
	public static void renderW(String text ,Screen screen,int x,int y,int flip){
		for(int i = 0;i < text.length();i++){
			char currentChar = text.charAt(i);
			if(currentChar == ' ') space = 20;
			int index = chars.indexOf(currentChar);
			if(index == -1) continue;
			screen.renderSprite(x + i * 8 ,y, font_char[index],false,flip);
		}
		
	}
	
}