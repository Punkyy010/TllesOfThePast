package com.tavi.totp.mob.skeleton;

import com.tavi.totp.graphics.Screen;
import com.tavi.totp.graphics.Sprite;

public class ClassicLegs extends Legs{

private Sprite current = Sprite.arms_classic_down;

	
	public ClassicLegs() {
		Up = Sprite.legs_classic_up;
		Down = Sprite.legs_classic_down; 
		Left = Sprite.legs_classic_left;
		Right = Sprite.legs_classic_right;
		Rdown = Sprite.legs_classic_Rdown; 
		Ldown = Sprite.legs_classic_Ldown;
		Rup = Sprite.legs_classic_Rup;
		Lup = Sprite.legs_classic_Lup;
		Run_down = Sprite.legs_classic_down_run;
		Run_right = Sprite.legs_classic_right_run;
		Run_left = Sprite.legs_classic_left_run;
		Run_up = Sprite.legs_classic_up_run;
	}
	 
	public void update() {
		if (anim < 7500)
			anim++;
		else
			anim = 0;	
	}

	public void render(int x,int y,int dir,Screen screen) {
		animation(x,y,dir,false,current,screen);
	}
	
	
}
