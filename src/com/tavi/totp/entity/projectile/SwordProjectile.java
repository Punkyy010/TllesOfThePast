package com.tavi.totp.entity.projectile;

import com.tavi.totp.entity.mob.Player;
import com.tavi.totp.entity.mob.weapons.Weapon;
import com.tavi.totp.graphics.Screen;
import com.tavi.totp.graphics.Sprite;

public class SwordProjectile extends Projectile{

	public int DAMAGE = 1,DMG=1;
	
	
	public SwordProjectile(double x,double y,double dir,Weapon w) {
		super(x,y,dir);
		range = 5;
		speed = 0.5;
		sprite = Sprite.shoot_fist_down;
		FIRE_RATE = 20;
	}
	
	public void move() {
		
		switch(Player.dirView) {
			case 0:
				nx = 0;
				ny = speed;
				sprite = Sprite.shoot_fist_down;
				break;
			case 1:
				nx = speed;
				ny = speed;
				sprite = Sprite.shoot_fist_rDown;
				break;
			case 2:
				nx = speed;
				ny = 0;
				sprite = Sprite.shoot_fist_right;
				break;
			case 3:
				nx = speed;
				ny = -speed;
				sprite = Sprite.shoot_fist_rUp;
				break;
			case 4:
				nx = 0;
				ny = -speed;
				sprite = Sprite.shoot_fist_up;
				break;
			case 5:
				nx = -speed;
				ny = -speed;
				sprite = Sprite.shoot_fist_lUp;
				break;
			case 6:
				nx = -speed;
				ny = 0;
				sprite = Sprite.shoot_fist_left;
				break;
			case 7:
				nx = -speed;
				ny = speed;
				sprite = Sprite.shoot_fist_lDown;
				break;
		}
		
		Mob_Collision(DAMAGE,DMG);
		
		x += nx;
		y += ny;
		
		if(distance() > range) remove();
	}
	
	public void update() {
		
		if(level.tileCollision((int)x ,(int)y ,nx ,ny ,4)) {
			remove();
		}else {
			move();
		}
		
		
	}
	
	
	public void render(Screen screen) {
		
		int xp = Player.xp;
		int yp = Player.yp;
		
		if(Player.dirView == 0) {
			xp = xp + 1;
			yp = yp + 14;
		}else if(Player.dirView == 1) {
			xp = xp + 9;
			yp = yp + 13;
		}else if(Player.dirView == 2) {
			xp = xp + 13;
			yp = yp + 2;
		}else if(Player.dirView == 3) {
			xp = xp + 10;
			yp = yp - 10;
		}else if(Player.dirView == 4) {
			xp = xp + 1;
			yp = yp - 11;
		}else if(Player.dirView == 5) {
			xp = xp - 10;
			yp = yp - 10;
		}else if(Player.dirView == 6) {
			xp = xp - 13;
			yp = yp + 2;
		}else {
			xp = xp - 9;
			yp = yp + 15;
		}
		
		screen.renderProjectile(xp, yp, this, 0);
		
	}
	
	
}
