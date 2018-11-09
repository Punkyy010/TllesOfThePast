package com.tavi.totp.entity.mob;

import com.tavi.totp.graphics.Screen;
import com.tavi.totp.graphics.Sprite;

public class Steps extends Entity{

	private Sprite sprite;
	public int lifespan = 500;
	private int diff = 0;
	
	public Steps(double x,double y){
		this.x = x;
		this.y = y;
		sprite = Sprite.Dust;
	}
	
	public void update(){
		
		lifespan--;
		if(lifespan == 0){
			remove();
		}
	}
	
	public void render(Screen screen){
		screen.renderMob2((int)x + diff,(int) y, sprite, 0);
	}
	
}
