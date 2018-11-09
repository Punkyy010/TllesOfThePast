package com.tavi.totp.level.tile;

import com.tavi.totp.graphics.Screen;
import com.tavi.totp.graphics.Sprite;

public class GravelTile extends Tile{

	
	public GravelTile(int id,int flip) {
		super(id,flip);

	}

	public void render(int x ,int y,Screen screen){
		
		//if(Player.onGrass){
			//screen.renderTile(x * 32, y * 32, sprite.grass_2, flip);
		//}else
			screen.renderTile(x << 5, y << 5, Sprite.Gravel,flip);
	}
	
}
