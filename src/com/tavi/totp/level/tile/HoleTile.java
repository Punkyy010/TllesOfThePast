package com.tavi.totp.level.tile;

import com.tavi.totp.graphics.Screen;
import com.tavi.totp.graphics.Sprite;

public class HoleTile extends Tile{

	public HoleTile(int id, int flip) {
		super(id, flip);
	}

	public void render(int x ,int y ,Screen screen){
		screen.renderTile(x << 5, y << 5, Sprite.holeSprite, flip);
	}
	
}
