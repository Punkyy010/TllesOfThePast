package com.tavi.totp.mob.skeleton;

import com.tavi.totp.graphics.Screen;
import com.tavi.totp.graphics.Sprite;

public class ClassicHead extends Head{

	private Sprite current = Sprite.player_head_down;
	
	public ClassicHead() {
		//current = Sprite.player_head_down;
		Up = Sprite.player_head_up;
		Down = Sprite.player_head_down;
		Left = Sprite.player_head_left;
		Right = Sprite.player_head_right;
		Rdown = Sprite.player_head_Rdown;
		Ldown = Sprite.player_head_Ldown;
		Rup = Sprite.player_head_Rup;
		Lup = Sprite.player_head_Lup;
	}
	
	public void update(int dirr) {
	
	}
	
	public void render(int x,int y,int dirr,Screen screen) {
		screen.renderMob2(x, y, checkDir(dirr,current), 0);
		//System.out.println(current);
	}
	
}
