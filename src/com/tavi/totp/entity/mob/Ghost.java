package com.tavi.totp.entity.mob;

import java.util.Random;

import com.tavi.totp.graphics.Screen;
import com.tavi.totp.graphics.Sprite;

public class Ghost extends Mob{

	private boolean walking;
	private int xa,ya;
	public int health ;
	
	public Ghost(int level){
		sprite = Sprite.ghost_down;
		health = healthmax;
	}
	
	public void update(){
	
		//System.out.println(health);

		
		move();
		
		if (anim < 7500)
			anim++;
		else
			anim = 0;
		
		if(health == 0){
			die(); 
		}
	}
	
	public void move(){
		
		if (anim < 7500)
			anim++;
		else
			anim = 0;
		
		xa = 0;
		ya = 0;
		int radius = 50;
		int xp = Player.xp;
		int yp = Player.yp;
		int dx = Math.abs(xp - (int)this.x);
		int dy = Math.abs(yp - (int)this.y);
		double distance = Math.sqrt((dx * dx) + (dy * dy));
		if (isHit){
			if ((int)xp > this.x) xa += 1;
			if ((int)xp < this.x) xa -= 1;
			if ((int)yp > this.y) ya += 1;
			if ((int)yp < this.y) ya -= 1;
		}else if(distance <= radius){
			if ((int)xp > this.x) xa += 1;
			if ((int)xp < this.x) xa -= 1;
			if ((int)yp > this.y) ya += 1;
			if ((int)yp < this.y) ya -= 1;
		}else{
			Random random = new Random();
			if(random.nextInt(40)==0){
				xa = random.nextInt(3)-1;
				ya = random.nextInt(3)-1;
				if (random.nextInt(4) == 0) {
					xa = 0;
					ya = 0;		
				}
			}
		}
		
		if (xa != 0 || ya != 0) {
			move(xa, ya);
			walking = true;
		} else {
			walking = false;
		}	
		
	}
	
	protected void die(){
		super.die();
	}
	
	public void render(Screen screen){
		int flip = 0;
		if (ya > 0) {
			sprite = Sprite.ghost_up;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.ghost_up_1;
				}else{
					sprite = Sprite.ghost_up_2;
				}
			}
		}

		if (xa < 0) {
			sprite = Sprite.ghost_side_1;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.ghost_side_1;
				} else {
					sprite = Sprite.ghost_side;
				}
			}
		}

		if (ya < 0) {
			sprite = Sprite.ghost_down;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.ghost_down_1;
				} else {
					sprite = Sprite.ghost_down_2;
				}
			}
		}

		if (xa > 0) {
			flip = 1;
			sprite = Sprite.ghost_side_1;
			flip = 1;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.ghost_side_1;
				} else {
					sprite = Sprite.ghost_side;
				}
			}
		}
		
		screen.renderMob2((int)x-1,(int) y+6, Sprite.player_shadow,0);
		screen.renderMob((int)x,(int)y,sprite,flip);
		
		for(int i = 1;i<= this.health_ratio;i++){
			screen.renderMob3((int)x-3/2 +(i*3),(int) y-6, Sprite.health_bar, 0);
		//if(player)
		}
		
	}
}

