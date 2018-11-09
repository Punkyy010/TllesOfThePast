package com.tavi.totp.level.tile;

import com.tavi.totp.entity.mob.Entity;
import com.tavi.totp.graphics.Screen;
import com.tavi.totp.graphics.Sprite;
import com.tavi.totp.level.Level;

public class WallTile_1 extends Tile {

	public static int health = 10;
	
	public WallTile_1(int id,int flip) {
		super(id,flip);
	}

	public void render(int x ,int y,Screen screen){
		screen.renderTile(x << 5, y << 5, Sprite.wallSprite,flip);	
		
		if(health == 0){
			screen.renderTile(x << 5, y << 5, Sprite.grass,flip);
		}
		
	}
	
	
	public boolean mayPass(Level level, int x, int y, Entity e) {
		return true;
	}
	
}
