package com.tavi.totp.level.tile;

import com.tavi.totp.entity.mob.Entity;
import com.tavi.totp.graphics.Screen;
import com.tavi.totp.level.Level;
import com.tavi.totp.graphics.Sprite;

public class DirtWallTile extends Tile{

	public DirtWallTile(int id,int flip){
		super (id,flip);
	}
	
	public void render(int x,int y,Screen screen){
		screen.renderTile(x << 5, y << 5, Sprite.DirtWallSprite, flip);
	}
	
	public boolean mayPass(Level level, int x, int y, Entity e) {
		return true;
	}
	
}
