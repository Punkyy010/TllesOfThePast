package com.tavi.totp.entity.mob.weapons;


import com.tavi.totp.entity.mob.Player;
import com.tavi.totp.graphics.Screen;
import com.tavi.totp.graphics.Sprite;

public class Sword extends Weapon{

	private Sprite current = Sprite.player_sword_down;
	
	
	public Sword() {
<<<<<<< HEAD
		avgDmg = 2;
		avgSpeed = 1;
		avgWeight = 5;
=======
		
>>>>>>> 5360f2dfcb2cec230bbec932ee21a7371e3a76cf
	}
	
	protected void spriteChange() {
		if(Player.inHand) {
			Up = Sprite.sword_up;
			Down = Sprite.sword_down; 
			Left = Sprite.sword_left;
			Right = Sprite.sword_right;
			Rdown = Sprite.sword_down_right; 
			Ldown = Sprite.sword_down_left;
			Rup = Sprite.sword_up_right;
			Lup = Sprite.sword_up_left;
		}else {
			Up = Sprite.sword_back;
			Down = Sprite.sword_down_left; 
			Left = Sprite.sword_down_left;
			Right = Sprite.sword_down_left;
			Rdown = Sprite.sword_down_left; 
			Ldown = Sprite.sword_down_left;
			Rup = Sprite.sword_back;
			Lup = Sprite.sword_back;
		}
	}
	
	public void render(int x, int y, int dir, Screen screen) {
		int xp = x;
		int yp = y;
		spriteChange();
		//System.out.println("is in hand ? " + inHand);
		if(Player.inHand) {
			if(checkDir(dir, current) == Up) {
				yp = yp + 1;
				xp = xp + 6;
			}else if(checkDir(dir, current) == Right) {
				yp = yp + 5;
				xp = xp + 2;
			}else if(checkDir(dir, current) == Left) {
				yp = yp + 4;
				xp = xp - 8;
			}else if(checkDir(dir, current) == Down) {
				yp = yp + 8;
				xp = xp - 6;
			}else if(checkDir(dir, current) == Ldown) {
				yp = yp + 8;
				xp = xp - 8;
			}else if(checkDir(dir, current) == Rdown) {
				yp = yp + 8;
				xp = xp - 3;
			}else if(checkDir(dir, current) == Rup) {
				yp = yp + 2;
				xp = xp + 9;
			}else {
				yp = yp + 2;
				xp = xp - 2;	
			}
		}else {
			xp = xp - 1;
			yp = yp + 1;
		}
				screen.renderMob2(xp, yp, checkDir(dir,current), 0);
	}
	
}
