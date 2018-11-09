package com.tavi.totp.graphics;


import com.tavi.totp.entity.projectile.Projectile;

public class Screen {

	public static int width;
	public static int height;
	public int[] pixels;
	public int anim = 0;
	public final int MAP_SIZE = 4;
	public final int MAP_SIZE_MASK = MAP_SIZE - 1;
	public int[] tiles = new int[MAP_SIZE * MAP_SIZE];
	private final int alpha_color = 0xFFFF00FF;

	public int xOffset, yOffset;

	//private Sprite sprite;

	public Screen(int width, int height,int[] pixels) {
		this.width = width;
		this.height = height;
		this.pixels = pixels;
		pixels = new int[width * height];

	}

	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}
	
	public void renderSpriteText(int xp ,int yp ,Sprite sprite,int color,boolean fixed){
		if(fixed){
			xp -= xOffset;
			yp -= yOffset;
		}
		
		for(int y = 0 ;y < sprite.getHeight();y++){
			int ya = y + yp; 
			for(int x = 0 ;x < sprite.getWidth();x++){
				int xa = x + xp;
				if (xa < -sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
				int col = sprite.pixels[x + y * sprite.getWidth()];
				if(col != alpha_color) pixels[xa + ya * width] = color;
			}
		}
			
		
	}
	
	public void renderSprite(int xp ,int yp ,Sprite sprite,boolean fixed,int flip){
		if(fixed){
			xp -= xOffset;
			yp -= yOffset;
		}
		
		for(int y = 0 ;y < sprite.getHeight();y++){
			int ya = y + yp; 
			int ys = y;
			if(flip == 1 || flip == 3)
				ys = (sprite.SIZE-1) - y;
			for(int x = 0 ;x < sprite.getWidth();x++){
				int xa = x + xp;
				int xs = x;
				if(flip == 2 || flip == 3)
					xs = (sprite.SIZE-1) - x;
				if (xa < -sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
				int col = sprite.pixels[xs + ys * sprite.getWidth()];
				if(col != alpha_color) pixels[xa + ya * width] = col;
			}
		}
			
		
	}

	public void renderTile(int xp, int yp,Sprite sprite,int flip) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < sprite.SIZE; y++) {
			int ya = y + yp;
			int ys = y;
			if(flip == 2 || flip == 3)
				ys = (sprite.SIZE-1) - y;
			for (int x = 0; x < sprite.SIZE; x++) {
				int xa = x + xp;
				int xs = x;
				if(flip == 1 || flip == 3)
					xs = (sprite.SIZE-1) - x;
				if (xa < -sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;
				//pixels[xa + ya * width] = sprite.pixels[x + y * sprite.SIZE];
				int col = sprite.pixels[xs + ys * sprite.SIZE];
				if(col != alpha_color) pixels[xa + ya * width] = col;
			}
		}
	}
	
	
	public void renderProjectile(int xp, int yp,Projectile p,int flip) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < p.getSpriteSize(); y++) {
			int ya = y + yp;
			int ys = y;
			if(flip == 2 || flip == 3) {
				ys = (p.getSpriteSize()-1) - y;
			}
			for (int x = 0; x < p.getSpriteSize(); x++) {
				int xa = x + xp;
				int xs = x;
				if(flip == 1 || flip == 3) {
					xa = (p.getSpriteSize()-1) - x;
				}
				if (xa < -p.getSpriteSize() || xa >= width || ya < 0 || ya >= height) break;
				if(xa < 0 ) xa = 0;
				int col = p.getSprite().pixels[xs + ys * p.getSprite().SIZE];
				if(col != alpha_color) pixels[xa + ya * width] = col;
			}
		}
	}

	
	public void renderMob(int xp, int yp, Sprite sprite,int flip) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < 16; y++) {
			int ya = y + yp;
			int ys = y;
			if(flip == 2 || flip == 3) {
				ys = 15 - y;
			}
			for (int x = 0; x < 16; x++) {
				int xa = x + xp;
				int xs = x;
				if(flip == 1 || flip == 3) {
					xs = 15 - x;
				}
				if (xa < -16 || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;
				int col = sprite.pixels[xs + ys * 16];
				if(col != alpha_color) pixels[xa + ya * width] = col;
			}
		}
	}
	
	public void renderDmg(int xp, int yp, Sprite sprite,int flip) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < 16; y++) {
			int ya = y + yp;
			int ys = y;
			if(flip == 2 || flip == 3) {
				ys = 15 - y;
			}
			for (int x = 0; x < 16; x++) {
				int xa = x + xp;
				int xs = x;
				if(flip == 1 || flip == 3) {
					xs = 15 - x;
				}
				if (xa < -16 || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;
				int col = sprite.pixels[xs + ys * 16];
				if(col != alpha_color) pixels[xa + ya * width] = col;
			}
		}
	}

	public void renderMob2(int xp, int yp, Sprite sprite,int flip) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < 18; y++) {
			int ya = y + yp;
			int ys = y;
			if(flip == 2 || flip == 3) {
				ys = 17 - y;
			}
			for (int x = 0; x < 18; x++) {
				int xa = x + xp;
				int xs = x;
				if(flip == 1 || flip == 3) {
					xs = 17 - x;
				}
				if (xa < -18 || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;
				int col = sprite.pixels[xs + ys * 18]; 
				if(col != alpha_color) pixels[xa + ya * width] = col;
			}
		}
	}
	public void renderMob3(int xp, int yp, Sprite sprite,int flip) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < 3; y++) {
			int ya = y + yp;
			int ys = y;
			if(flip == 2 || flip == 3) {
				ys = 2 - y;
			}
			for (int x = 0; x < 3; x++) {
				int xa = x + xp;
				int xs = x;
				if(flip == 1 || flip == 3) {
					xs = 2 - x;
				}
				if (xa < -1 || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;
				int col = sprite.pixels[xs + ys * 3];
				if(col != alpha_color) pixels[xa + ya * width] = col;
			}
		}
	}
	
	public void setOffset(int xOffset, int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;

	}

}
