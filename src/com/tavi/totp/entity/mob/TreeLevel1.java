package com.tavi.totp.entity.mob;

import java.awt.Graphics;

import com.tavi.totp.graphics.Screen;
import com.tavi.totp.graphics.Sprite;

public class TreeLevel1 extends Trees{
	
	public TreeLevel1(int level) {

		sprite = Sprite.treebtmSprite;
	}
	
	public boolean blocks(Entity e){
		return true;
	}
	
	public void update() {
	}
	
	public void render(Screen screen) {
		screen.renderTile((int)x-8, (int)y-8, Sprite.treebtmSprite, 0);
	}
	
}
