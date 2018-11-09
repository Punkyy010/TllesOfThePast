package com.tavi.totp.entity.mob;


import java.util.Random;

import com.tavi.totp.Game;
import com.tavi.totp.graphics.Screen;
import com.tavi.totp.graphics.Sprite;

public class Zombie extends Mob {
	
	//private Screen screen;
	private boolean walking;
	private int anim = 0;
	public static int maxHealth;
	public static int health;
	public static boolean spawn = false;
	public int randomWalk = 0;
	public Mob mob;
	private double xa ,ya;	
	
	public Zombie(int level){
		//this.x = x;
		//this.y = y;
		sprite = Sprite.zombie_down;
		maxHealth =( Game.currentLevel + 1) * 5;
		health = maxHealth;
		isHit = false;
		take_life = false;
		health_now = health;
	}
	
	public void update(){
		
		if (anim < 7500)
			anim++;
		else
			anim = 0;
		
		//System.out.println(this.health_now);
		
		xa = 0;
		ya = 0;
		int radius = 100;
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
		
		if(health <= 0){
			die();
		}
		
		
		if (xa != 0 || ya != 0) {
			move(xa, ya);
			walking = true;
		} else {
			walking = false;
		}	
	}
	
	public boolean blocks(Entity e){
		return true;
	}
	
	protected void die(){
		super.die();
		//level.add(new Particle(x, y, 10));
	}
	
	public void render(Screen screen){
		int flip = 0;
		if (ya > 0) {
			sprite = Sprite.zombie_up;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.zombie_up_1;
				} 
			}
		}

		if (xa < 0) {
			sprite = Sprite.zombie_side_1;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.zombie_side_1;
				} else {
					sprite = Sprite.zombie_side;
				}
			}
		}

		if (ya < 0) {
			sprite = Sprite.zombie_down;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.zombie_down_1;
				} else {
					sprite = Sprite.zombie_down_2;
				}
			}
		}

		if (xa > 0) {
			flip = 1;
			sprite = Sprite.zombie_side_1;
			flip = 1;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.zombie_side_1;
				} else {
					sprite = Sprite.zombie_side;
				}
			}
		}
		
		screen.renderMob2((int)x-1, (int)y+6, Sprite.player_shadow,0);
		screen.renderMob((int)x,(int)y,sprite,flip);
		
		//if(take_life){ health_ratio --;
		//System.out.println("Muie");}
		for(int i = 1;i<= this.health_ratio;i++){
			screen.renderMob3((int)x - 3/2 +(i*3),(int) y-6, Sprite.health_bar, 0);
		//if(player)
		}
		
		
	}
	
}
