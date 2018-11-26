package com.tavi.totp.entity.projectile;

import com.tavi.totp.entity.mob.Player;
import com.tavi.totp.graphics.Screen;
import com.tavi.totp.graphics.Sprite;


public class FistProjectile extends Projectile{

	//private Tile tile;
	
		public boolean up = false;
		public boolean down = false;
		public boolean left = false;
		public boolean side = false;
		
		public FistProjectile(int x, int y, double dir) {
			super(x, y, dir);
			range = 20;
			speed = 1;
			//DAMAGE = 2;
			FIRE_RATE = 30 ;
			sprite = Sprite.shoot_fist_down;
			nx = speed * Math.cos(angle);
			ny = speed * Math.sin(angle);

		}

		public void update() {
			if(level.tileCollision((int)x ,(int)y ,nx ,ny ,4)){ 
				level.getTile((int)x, (int)y).remove();
				remove();
			}else
			move();
			
			
			//if(Mouse.getX() > Game.width / 2 && Mouse.getY() > Game.width / 2 ) 
			
			
			if(side)
				sprite = Sprite.shoot_fist_left;
			
			
			
		}

		protected void move() {
			x += nx;
			y += ny;
			if (distance() > range) remove();
			
		}

		public void render(Screen screen) {
			
			if(down)
				screen.renderProjectile((int) x, (int) y, this,4);
			if(up)
				screen.renderProjectile((int) x, (int) y, this,2);
			if(side)
				screen.renderProjectile((int) x, (int) y, this,0);
			if(side && Player.isFlipped)
				screen.renderProjectile((int) x, (int) y, this,2);
			
		}
}
