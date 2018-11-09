package com.tavi.totp.level.tile;

import com.tavi.totp.entity.mob.Entity;
import com.tavi.totp.entity.mob.Player;
import com.tavi.totp.entity.projectile.Projectile;
import com.tavi.totp.graphics.Screen;
import com.tavi.totp.graphics.Sprite;
import com.tavi.totp.level.Level;

public class WaterCorner2Tile extends Tile{

	public WaterCorner2Tile(int id,int flip) {
		super(id,flip);

	}

	public boolean mayPass(Level level, int x, int y, Entity e) {
		if(e instanceof Player)
			return false;
		else if( e instanceof Projectile)
			return false;
		else
			return true;
	}
	

	public boolean swim(Level level ,int x,int y ,Player player){
		return player.canSwim(); 
	}
	
	public void render(int x ,int y,Screen screen){
			screen.renderTile(x << 5, y << 5, Sprite.WaterCorner2Sprite,flip);
	}
	
}
