package com.tavi.totp.entity.projectile;

import java.util.Random;

import com.tavi.totp.entity.mob.CoinParticle;
import com.tavi.totp.entity.mob.Entity;
import com.tavi.totp.entity.mob.Ghost;
import com.tavi.totp.entity.mob.Pagan;
import com.tavi.totp.entity.mob.TextParticle;
import com.tavi.totp.entity.mob.Zombie;
import com.tavi.totp.graphics.Sprite;
import com.tavi.totp.level.Level;
import com.tavi.totp.sound.Sound;


public abstract class Projectile extends Entity {
	public static int FIRE_RATE;
	
	protected final double xOrigin, yOrigin;
	protected double angle;
	protected Sprite sprite;
	protected double x,y;
	protected double nx, ny;
	protected double speed, range, damage;
	
	protected final Random random = new Random();

	public Projectile(double x, double y, double dir) {
		xOrigin = x;
		yOrigin = y;
		angle = dir;
		this.x = x;
		this.y = y;
	}
	
	protected void Mob_Collision(int DAMAGE,int DMG) {
		for(int i = 0;i < level.entities.size();i++){
			Entity e = level.entities.get(i);
			if(e instanceof Zombie || e instanceof Pagan || e instanceof Ghost){
				if((int)x /32 == (int)e.x /32 && (int)y /32 == (int)e.y /32){
					DMG = random.nextInt(DAMAGE) + 2;
					remove();
					e.isHit = true;
					level.add(new TextParticle("" + DMG, (int)e.x, (int)e.y , 0xFFff3434));
					if(DMG == DAMAGE + 1) level.add(new TextParticle("CRIT!", (int)e.x + 20, (int)e.y +20, 0xFFff3434));
					e.health -= DMG;
					if(e.health <= 0){
						for(int j = 0;j <= Level.mobmoney;j++){
						level.add(new CoinParticle((int)e.x, (int)e.y , 0));
						}
						e.remove();
					}
					Sound.hurt.play();
				}
				isHit = false;
			}
		}
	}
	
	protected double distance() {
		double dist = 0;
		dist = Math.sqrt(Math.abs((xOrigin - x) * (xOrigin - x) + (yOrigin - y) * (yOrigin - y)));
		return dist;
	}
	
	public Sprite getSprite(){
		return sprite;
	}
	
	public int getSpriteSize(){
		return sprite.SIZE;
	}
	
	protected void move(){
		
	}

}
