package com.tavi.totp.entity.projectile;

import com.tavi.totp.entity.mob.Player;
import com.tavi.totp.graphics.Screen;
import com.tavi.totp.graphics.Sprite;

public class SwordProjectile extends Projectile{

	public int DAMAGE = 1,DMG=1;
	
	public SwordProjectile(double x,double y,double dir) {
		super(x,y,dir);
		range = 5;
		speed = 0.5;
		sprite = Sprite.shoot_fist;
	}
	
	public void move() {
		
		switch(Player.dirr) {
			case 1:
				nx = -speed;
				ny = 0;
				sprite = Sprite.shoot_fist3;
				break;
			case 2:
				nx = speed;
				ny = 0;
				sprite = Sprite.shoot_fist2;
				break;
			case 3:
				nx = 0;
				ny = -speed;
				sprite = Sprite.shoot_fist4;
				break;
			case 4:
				nx = 0;
				ny = speed;
				sprite = Sprite.shoot_fist;
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
		if(Player.dirr == 1)
			screen.renderProjectile((int)Player.xp - 12, (int)Player.yp + 1, this, 0);
		if(Player.dirr == 2)
			screen.renderProjectile((int)Player.xp + 12, (int)Player.yp + 1, this, 0);
		if(Player.dirr == 3)
			screen.renderProjectile((int)Player.xp + 1, (int)Player.yp - 12, this, 0);
		if(Player.dirr == 4)
			screen.renderProjectile((int)Player.xp + 1, (int)Player.yp + 14, this, 0);
		
	}
	
	
}
