package com.tavi.totp.level.tile;

import com.tavi.totp.entity.mob.Entity;
import com.tavi.totp.entity.mob.Player;
import com.tavi.totp.entity.projectile.Projectile;
import com.tavi.totp.graphics.Screen;
import com.tavi.totp.graphics.Sprite;
import com.tavi.totp.level.Level;

public class waterTile extends Tile {
	
	//private AnimatedSprite water = new AnimatedSprite(SpriteSheet.tiles_water, 32, 32, 2);
	
	static int anim = 0;
	static int s = 1;
	public static Sprite sprite = Sprite.waterSprite_1;
	
	public waterTile(int id,int flip) {
		super(id,flip);
	}

	public void update(){
		anim++;
		if (anim % 720 == 0) {
			s *= -1;
		}
		//if (s == -1) sprite = Sprite.waterSprite_1;
		//if (s == 1) sprite = Sprite.waterSprite_2;
	}
	
	public void render(int x ,int y,Screen screen){
		
		screen.renderTile(x << 5, y << 5, sprite,flip);
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
	
}
