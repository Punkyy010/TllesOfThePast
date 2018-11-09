package com.tavi.totp.graphics;

public class Coins2 {

	public static SpriteSheet weapon = new SpriteSheet("/font/coins.png",7);
	public static SpriteSheet coin = new SpriteSheet("/font/coinGround.png",8);
	public static SpriteSheet health = new SpriteSheet("/player/healthp.png",8);
	public static Sprite[] font_char = Sprite.split(weapon);
	public static Sprite[] coin_char = Sprite.split(coin);
	public static Sprite[] health_char = Sprite.split(health);

	private static String chars = "a1234567890"; //
	private static String cooin = "1234";
	private static String heal = "123";
	static int space = 0;
						  
	
	public Coins2(){
		
	}
	
	public static void render(String text ,Screen screen,int x,int y,int flip){
		for(int i = 0;i < text.length();i++){
			char currentChar = text.charAt(i);
			if(currentChar == ' ') space = 20;
			int index = chars.indexOf(currentChar);
			if(index == -1) continue;
			screen.renderSprite(x + i * 7 ,y, font_char[index],true,flip);
		}
		
	}
	
	public static void renderC(String text ,Screen screen,int x,int y,int flip){
		for(int i = 0;i < text.length();i++){
			char currentChar = text.charAt(i);
			if(currentChar == ' ') space = 20;
			int index = cooin.indexOf(currentChar);
			if(index == -1) continue;
			screen.renderSprite(x + i * 8 ,y, coin_char[index],true,flip);
		}
		
	}
	
	public static void renderH(String text ,Screen screen,int x,int y,int flip){
		for(int i = 0;i < text.length();i++){
			char currentChar = text.charAt(i);
			if(currentChar == ' ') space = 20;
			int index = heal.indexOf(currentChar);
			if(index == -1) continue;
			screen.renderSprite(x + i * 8 ,y, health_char[index],true,flip);
		}
		
	}
	
	public void renderSprite(int xp ,int yp ,Screen screen){
		
		screen.renderSprite(xp, yp, Sprite.ripper, false, 0);
			
		
	}
	
	
}