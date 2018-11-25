package com.tavi.totp.entity.mob.weapons;

import com.tavi.totp.entity.mob.Player;
import com.tavi.totp.entity.projectile.Projectile;
import com.tavi.totp.graphics.Screen;
import com.tavi.totp.graphics.Sprite;

public abstract class Weapon {

	protected Sprite Down,Up,Left,Right,Ldown,Rdown,Lup,Rup,notEquiped;
	protected int anim = 0;
	protected Projectile p;

	
	public Sprite checkDir(int dirr,Sprite current) {
		if(dirr == 0) current = Down; 
		else if(dirr == 1) current = Rdown;
		else if(dirr == 2) current = Right;
		else if(dirr == 3) current = Rup;
		else if(dirr == 4) current = Up;
		else if(dirr == 5) current = Lup;
		else if(dirr == 6) current = Left;
		else current = Ldown;
		return current;
	}
	
	public void update() {
	}
	
	public void animation(int x,int y,int dirr,boolean arms,Sprite current,Screen screen) {
		Sprite curr = checkDir(dirr,current);
		/*Sprite anim1 = Run_down;
		
		if(dirr == 0 || dirr == 1 || dirr == 7) {
			anim1 = Run_down;
		}else if(dirr == 2) {
			anim1 = Run_right;
		}else if(dirr == 3 || dirr == 4 || dirr == 5) {
			anim1 = Run_up;
		}else if(dirr == 6){
			anim1 = Run_left;
		}*/
		
		if (Player.walking) {
			if (anim % 20 > 10) {
				//screen.renderMob2(x, y, anim1, 0);
			} else {
				//screen.renderMob2(x, y, anim1, 1);
			}
		}else {
			screen.renderMob2(x, y, curr, 0);
		}
		
	}
	public void render(int x,int y,int dir,Screen screen) {
		
	}
}
