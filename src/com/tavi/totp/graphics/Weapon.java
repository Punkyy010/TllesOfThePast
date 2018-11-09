package com.tavi.totp.graphics;

public class Weapon {

	public static SpriteSheet weapon = new SpriteSheet("/player/weapons.png",16);
	public static SpriteSheet rocks = new SpriteSheet("/sheets/rocks.png",48);
	public static SpriteSheet pl = new SpriteSheet("/sheets/menu_pl.png",64);
	public static SpriteSheet rip = new SpriteSheet("/sheets/ripper.png",96);
	
	public static Sprite[] font_char = Sprite.split(weapon);
	public static Sprite[] rock_char = Sprite.split(rocks);
	public static Sprite[] pl_char = Sprite.split(pl);
	public static Sprite[] rip_char = Sprite.split(rip);

	private String chars = "12345678"; //
	private String rock = "12";
	private String ple = "12";
	private String r = "1";
	
	public Weapon(){
		
	}
	
	public void render(String text ,Screen screen,int x,int y,int flip){
		for(int i = 0;i < text.length();i++){
			char currentChar = text.charAt(i);
			int index = chars.indexOf(currentChar);
			if(index == -1) continue;
			screen.renderSprite(x + i * 16 ,y, font_char[index],false,flip);
		}
		
	}
	
	public void renderR(String text ,Screen screen,int x,int y,int flip){
		for(int i = 0;i < text.length();i++){
			char currentChar = text.charAt(i);
			int index = r.indexOf(currentChar);
			if(index == -1) continue;
			screen.renderSprite(x + i * 96 ,y, rip_char[index],false,flip);
		}
		
	}
	
	public void renderRock(String text ,Screen screen,int x,int y,int flip){
		for(int i = 0;i < text.length();i++){
			char currentChar = text.charAt(i);
			int index = rock.indexOf(currentChar);
			if(index == -1) continue;
			screen.renderSprite(x + i * 48 ,y, rock_char[index],false,flip);
		}
		
	}
	public void renderPl(String text ,Screen screen,int x,int y,int flip){
		for(int i = 0;i < text.length();i++){
			char currentChar = text.charAt(i);
			int index = ple.indexOf(currentChar);
			if(index == -1) continue;
			screen.renderSprite(x + i * 64 ,y, pl_char[index],false,flip);
		}
		
	}
	
}
