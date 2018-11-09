package com.tavi.totp.level.tile;

import com.tavi.totp.entity.mob.Entity;
import com.tavi.totp.graphics.Screen;
import com.tavi.totp.graphics.Sprite;
import com.tavi.totp.level.Level;

public class PathTile extends Tile{

	public static boolean isTrue = false;
	
	public PathTile(int id,int flip) {
		super(id,flip);
	}

	public void render(int x ,int y,Screen screen){
		
		screen.renderTile(x << 5, y << 5, Sprite.pathSprite,flip);
		if(isTrue) screen.renderTile(x << 5, y << 5, Sprite.HalfBlackSprite, flip);
	}
	
	public boolean mayPass(Level level, int x, int y, Entity e) {
		return false;
	}
	
}
