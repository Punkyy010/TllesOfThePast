package com.tavi.totp.level.tile;


import com.tavi.totp.graphics.Screen;
import com.tavi.totp.graphics.Sprite;


public class GrassTile extends Tile {
	

	static int anim = 0;
	static int s = 1;
	public static Sprite sprite;
	
	public GrassTile(int id,int flip) {
		super(id,flip);

	}
	
	public void update(){
		anim++;
		if (anim % 720 == 0) {
			s *= -1;
		}
		if (s == -1) sprite = Sprite.grass;
		if (s == 1) sprite = Sprite.grass1Tile;
	}

	public void render(int x ,int y,Screen screen){
			screen.renderTile(x << 5, y << 5, Sprite.grass,flip);
	}

	
}
