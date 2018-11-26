package com.tavi.totp.entity.mob;

import java.util.List;
import java.util.Random;

import com.tavi.totp.Game;
import com.tavi.totp.entity.mob.weapons.Fist;
import com.tavi.totp.entity.mob.weapons.Sword;
import com.tavi.totp.entity.projectile.Projectile;
import com.tavi.totp.entity.projectile.SwordProjectile;
import com.tavi.totp.graphics.Screen;
import com.tavi.totp.graphics.Sprite;
import com.tavi.totp.level.Level;
import com.tavi.totp.level.tile.Tile;

public abstract class Mob extends Entity {

	protected int dir = 0;
	protected boolean moving = false;
	protected int xKnockback , yKnockback;
	public int swimTimer = 0;
	private Random random = new Random();
	public int healthmax = ( Game.currentLevel + 1) * 7;
	public static int money;
	private int Damage;
 
	public Mob(){ 
		x = y = 6;
		xr = 8;
		yr = 4;
	}
	

	public boolean equals(Entity otherObject){
	    if(otherObject instanceof Entity){ 
	        return true;
	    }
	    return false; 
	}
	
	protected void Mob_Collision(int DAMAGE) {
		for(int i = 0;i < level.entities.size();i++){
			Entity e = level.entities.get(i);
			//if(!(this.equals(e))){
				if((int)x /32 == (int)e.x /32 && (int)y /32 == (int)e.y /32){
					DAMAGE = random.nextInt(DAMAGE);
					remove();
					e.isHit = true;
					level.add(new TextParticle("" + DAMAGE, (int)e.x, (int)e.y , 0xFFff3434));
					if(Damage == DAMAGE + 1) level.add(new TextParticle("CRIT!", (int)e.x + 20, (int)e.y +20, 0xFFff3434));
					e.health -= DAMAGE;
					if(e.health <= 0){
						for(int j = 0;j <= Level.mobmoney;j++){
						if(!(e instanceof Player))
							level.add(new CoinParticle((int)e.x, (int)e.y , 0));
						}
						e.remove();
					}
					//Sound.hurt.play();
				}
				isHit = false;
			//}
		}
	}
	
	public boolean move(double xa, double ya) {

		//if (isSwimming()) {
		//	if (swimTimer++ % 2 == 0) return true;
		//}
		
		if(xKnockback < 0){
			move2(-1,0);
			xKnockback++;
		}
		if(xKnockback > 0){
			move2(1,0);
			xKnockback--;
		}
		if(yKnockback < 0){
			move2(0,-1);
			xKnockback++;
		}
		if(yKnockback > 0){
			move2(0,1);
			xKnockback--;
		}

		if(!Entity_Collision(xa,ya)) return false;

		if (xa != 0 && ya != 0) {
			
			move(xa, 0);
			move(0, ya);
			return true;
		}

		if (xa > 0) dir = 1; //right
		if (xa < 0) dir = 3; //left
		if (ya > 0) dir = 2; //down
		if (ya < 0) dir = 0; //up 
		if (ya < 0 && xa < 0) dir = 4;

		return super.move2(xa, ya);
	}
	
	protected void die(){
		remove();
	}
	
	public boolean Entity_Collision(double xa,double ya) {
		List<Entity> wasInside = level.getEntities((int)x, (int)y , (int)x + xr, (int)y + yr);
		List<Entity> isInside = level.getEntities((int)x + (int)xa - xr, (int)y + (int)ya -yr, (int)x + (int)xa + xr, (int)y + (int)ya + yr);
		for (int i = 0; i < isInside.size(); i++) {
			Entity e = isInside.get(i);
			if (e == this) continue; 

			e.touchedBy(this);
		}
		isInside.removeAll(wasInside);
		for (int i = 0; i < isInside.size(); i++) {
			Entity e = isInside.get(i);
			if (e == this) continue;

			if (e.blocks(this)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean blocks(Entity e) {
		return true;
	}
	
	public void update() {
		//Mob_Collision(Damage);
	}
	
	public void anim(Sprite sprite1,Sprite sprite2,Sprite sprite3,int anim,boolean walking){
		sprite = sprite1;
		if(walking){
			if(anim % 20 > 10){
				sprite = sprite2;
			}else{
				sprite = sprite3;
			}
		}
	}
	
	
	public boolean isSwimming(){
		Tile tile = level.getTile((int)x * 32, (int)y * 32);
		return tile == Tile.waterTile;
	}

	public boolean canSwim() {
		return false;
	}

	//protected boolean isSwimming() {
		//Tile tile = level.getTile(x * 32, y * 32);
		//return tile == Tile.waterTile;
	//}
	
	

	protected void shoot(double x, double y, double dir) {
		//dir *=  180 / Math.PI;
		
		if(Player.weapon instanceof Fist){
			Projectile q = new SwordProjectile(x, y, dir,new Fist());
			level.add(q);
		}
		if(Player.weapon instanceof Sword){
			Projectile q = new SwordProjectile(x, y, dir,new Sword());
			level.add(q);
		}

	}


	public void render(Screen screen) {

	}

}
