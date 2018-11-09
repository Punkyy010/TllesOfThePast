package com.tavi.totp.mob.skeleton;

import com.tavi.totp.graphics.Screen;
import com.tavi.totp.graphics.Sprite;

public class ClassicBody extends Body{

	private Sprite current = Sprite.player_body_down;
	
	public ClassicBody() {
		Up = Sprite.player_body_up;
		Down = Sprite.player_body_down;
		Left = Sprite.player_body_left;
		Right = Sprite.player_body_right;
		Rdown = Sprite.player_body_Rdown;
		Ldown = Sprite.player_body_Ldown;
		Rup = Sprite.player_body_Rup;
		Lup = Sprite.player_body_Lup;
	}
	
	public void update() {
		
	}
	
	public void render(int x,int y, int dir,Screen screen) {
		screen.renderMob2(x, y, checkDir(dir,current), 0);
	}
	
	
}
