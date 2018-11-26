package com.tavi.totp.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {

	private String path;
	public final int SIZE;
	public final int SPRITE_HEIGHT;
	public final int SPRITE_WIDTH;
	public int width,height;
	public int[] pixels;
	private Sprite[] sprites;
	
	public static SpriteSheet tiles = new SpriteSheet("/sheets/tiles32.png", 256,256); 
	public static SpriteSheet inventory = new SpriteSheet("/player/inventory.png",160);
	//public static SpriteSheet tiles_water = new SpriteSheet(tiles,2,0,2,1,32); 
	public static SpriteSheet zombie = new SpriteSheet("/player/Zombie.png",128);
	public static SpriteSheet sword = new SpriteSheet("/player/sword.png",32);
	//public static SpriteSheet fog = new SpriteSheet("/textures/fog.png",50);
	//public static SpriteSheet ui = new SpriteSheet("/player/uihs.png",4);
	public static SpriteSheet weapons = new SpriteSheet("/player/weapon.png",162,252);
	public static SpriteSheet player = new SpriteSheet("/player/spritesheet.png", 128);
	public static SpriteSheet eschimo = new SpriteSheet("/player/Eschimo.png",48);
	public static SpriteSheet bullets = new SpriteSheet("/player/bullets.png",24);
	public static SpriteSheet health = new SpriteSheet("/player/health.png",3);
	public static SpriteSheet ghost = new SpriteSheet("/player/Ghost.png",48);
	
	public static SpriteSheet ripper = new SpriteSheet("/sheets/ripper.png",96);
	
	public static SpriteSheet player2 = new SpriteSheet("/player/player2.png", 234);
	public static SpriteSheet heads = new SpriteSheet("/player/heads.png",144);
	public static SpriteSheet bodies = new SpriteSheet("/player/bodies.png",144);
	public static SpriteSheet arms = new SpriteSheet("/player/arms.png",234); 
	public static SpriteSheet legs = new SpriteSheet("/player/legs.png",216); 
	public static SpriteSheet player3 = new SpriteSheet("/player/playerline.png",18);
	//public static SpriteSheet player_up = new SpriteSheet(player,0,0,1,3,16);
	//public static SpriteSheet player_down = new SpriteSheet(player,2,0,1,3,16);
	//public static SpriteSheet player_side = new SpriteSheet(player,1,0,1,2,16);
	//public static SpriteSheet player_water_up = new SpriteSheet(player,5,0,1,1,16);
	//public static SpriteSheet player_water_down = new SpriteSheet(player,3,0,1,2,16);
	//public static SpriteSheet player_water_side = new SpriteSheet(player,4,0,1,2,16);

	public SpriteSheet(SpriteSheet sheet ,int x ,int y ,int width ,int height ,int SizeP){
		int xs = SizeP * x;
		int ys = SizeP * y;
		int wid = width * SizeP;
		int heig = height * SizeP;
		if(width == height) SIZE = width;
		else SIZE = -1;
		SPRITE_HEIGHT = heig;
		SPRITE_WIDTH = wid;
		pixels = new int[wid * heig];
		for(int y0 =0; y0 < heig;y0++){
			int yp = y0 + ys;
			for(int x0 =0; x0 < heig; x0++){
				int xp = x0 + xs;
				pixels[x0 + y0 * wid] = sheet.pixels[xp + yp * sheet.SPRITE_WIDTH];
			}
		}
		int frames = 0;
		sprites = new Sprite[width * height];
		for(int ya =0; ya < height;ya++){
			for(int xa =0; xa < width;xa++){
				int[] spritePix = new int[SizeP * SizeP];
				for(int y0 =0; y0 < SizeP;y0++){
					for(int x0 =0; x0 < SizeP; x0++){
						spritePix[x0 + y0 * SizeP] = pixels[(x0 + xa * SizeP) + (y0 + ya * SizeP) * SPRITE_WIDTH];
					}
				}
				Sprite sprite = new Sprite(spritePix,SizeP,SizeP);
				sprites[frames++] = sprite;
			}
		}
		
		
	}
	
	public SpriteSheet(String path, int size) {
		this.path = path;
		SIZE = size;
		SPRITE_WIDTH = size;
		SPRITE_HEIGHT = size;
		pixels = new int[SIZE * SIZE];
		load();
	}
	
	public SpriteSheet(String path, int width, int height) {
		this.path = path;
		SIZE = -1;
		SPRITE_WIDTH = width;
		SPRITE_HEIGHT = height;
		pixels = new int[SPRITE_WIDTH * SPRITE_HEIGHT];
		load();
	}

	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}
	
	public Sprite[] getSprites(){
		return sprites;
	}
	
	public int[] getPixels(){
		return pixels;
	}
	
	private void load() {
		try {
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
			width = image.getWidth();
			height = image.getHeight();
			pixels = new int[width * height];
			image.getRGB(0, 0, width, height, pixels, 0, width);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
