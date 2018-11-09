package com.tavi.totp.mob.skeleton;

import com.tavi.totp.graphics.Screen;
import com.tavi.totp.graphics.Sprite;

public class CamoBody extends Body{

private Sprite current = Sprite.player_body_down;
	 
	public CamoBody() {
		Up = Sprite.body_camo_up;
		Down = Sprite.body_camo_down;
		Left = Sprite.body_camo_left;
		Right = Sprite.body_camo_right;
		Rdown = Sprite.body_camo_Rdown;
		Ldown = Sprite.body_camo_Ldown;
		Rup = Sprite.body_camo_Rup;
		Lup = Sprite.body_camo_Lup;
	}
	 
	public void update() {
		
	}
	
	public void render(int x,int y, int dir,Screen screen) {
		screen.renderMob2(x, y, checkDir(dir,current), 0);
	}
	
	
}
