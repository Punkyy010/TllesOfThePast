package com.tavi.totp.mob.skeleton;

import com.tavi.totp.graphics.Screen;
import com.tavi.totp.graphics.Sprite;

public class ClassicArms extends Arms{

	private Sprite current = Sprite.arms_classic_down;
	//private Sprite Run_up_side,Run_down_side;
	
	public ClassicArms() {
		Up = Sprite.arms_classic_up;
		Down = Sprite.arms_classic_down;
		Left = Sprite.arms_classic_left;
		Right = Sprite.arms_classic_right;
		Rdown = Sprite.arms_classic_Rdown;
		Ldown = Sprite.arms_classic_Ldown;
		Rup = Sprite.arms_classic_Rup;
		Lup = Sprite.arms_classic_Lup;
		Run_down = Sprite.arms_classic_down_run;
		Run_right = Sprite.arms_classic_right_run;
		Run_left = Sprite.arms_classic_left_run;
		Run_up = Sprite.arms_classic_up_run;
	}
	
	public void update() {
		if (anim < 7500)
			anim++;
		else
			anim = 0;	
	}

	public void render(int x,int y,int dir,Screen screen) {
		animation(x,y,dir,true,current,screen);
	}
	
	
}
