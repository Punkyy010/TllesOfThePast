package com.tavi.totp.level.tile;

import java.util.Random;

import com.tavi.totp.entity.mob.Entity;
import com.tavi.totp.entity.mob.Player;
import com.tavi.totp.graphics.Screen;
import com.tavi.totp.graphics.Sprite;
import com.tavi.totp.level.Level;

public class FanceTile extends Tile {

	public static int health = 10;
	public Player player;
	
	public FanceTile(int id,int flip) {
		super(id,flip);	
	}
	
	Random random = new Random();
	
	public void render(int x ,int y,Screen screen){		
			screen.renderTile(x << 5, y << 5, Sprite.fanceSprite,flip);
			//screen.renderSprite(x * 32, y * 32, Sprite.HalfBlackSprite, false, 0);
				
	}
	
	public boolean interact(Level level, int x, int y,Player player){
			if(health == 0) return true;
		
			return false;
	}
	
	public boolean mayPass(Level level, int x, int y,Entity e) {
		return true;
	}

}
