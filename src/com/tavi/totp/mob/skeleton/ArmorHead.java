package com.tavi.totp.mob.skeleton;

import com.tavi.totp.graphics.Screen;
import com.tavi.totp.graphics.Sprite;

public class ArmorHead extends Head{

private Sprite current = Sprite.player_head_down;
	
	public ArmorHead() {
		//current = Sprite.player_head_down;
		Up = Sprite.armor_head_up;
		Down = Sprite.armor_head_down;
		Left = Sprite.armor_head_left;
		Right = Sprite.armor_head_right;
		Rdown = Sprite.armor_head_Rdown;
		Ldown = Sprite.armor_head_Ldown;
		Rup = Sprite.armor_head_Rup;
		Lup = Sprite.armor_head_Lup;
	}
	
	public void update(int dirr) {
	
	}
	
	public void render(int x,int y,int dirr,Screen screen) {
		screen.renderMob2(x, y, checkDir(dirr,current), 0);
		//System.out.println(current);
	}
	
	
}
