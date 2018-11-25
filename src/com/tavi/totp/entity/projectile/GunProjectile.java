package com.tavi.totp.entity.projectile;

import java.util.Random;

import com.tavi.totp.InventoryMenu;
import com.tavi.totp.entity.mob.Player;
import com.tavi.totp.graphics.Screen;
import com.tavi.totp.graphics.Sprite;


public class GunProjectile extends Projectile {

	//private Tile tile;
	public static int DAMAGE = 1;
	public static boolean isHit = false;
	public Player player;
	public static Random random = new Random();
	private static int DMG;
	
	public GunProjectile(double x, double y, double dir) {
		super(x, y, dir);
		range = 200;
		speed = 4;
		sprite = Sprite.bullet_1;
		nx = speed * Math.cos(angle);
		ny = speed * Math.sin(angle);
		FIRE_RATE = 30;
	}

	public void update() {
		//System.out.println(DAMAGE);
		if(DAMAGE > 10)
			DAMAGE = 10;
		
		
		
		if(InventoryMenu.DamageLevel <= 3) sprite = Sprite.bullet_1;
		if(InventoryMenu.DamageLevel > 3 && InventoryMenu.DamageLevel <= 6) sprite = Sprite.bullet_2;
		if(InventoryMenu.DamageLevel > 6 && InventoryMenu.DamageLevel <= 9) sprite = Sprite.bullet_3;
		if(InventoryMenu.DamageLevel > 9 && InventoryMenu.DamageLevel <= 12) sprite = Sprite.bullet_4;
		if(InventoryMenu.DamageLevel > 12 && InventoryMenu.DamageLevel <= 15) sprite = Sprite.bullet_5;
		
		if(level.tileCollision((int)x ,(int)y ,nx ,ny ,4)){ //&& level.getTile((int)this.x / 32, (int)this.y / 32).getId() != 3){ 
			remove();
			
			//if (level.getTile((int)this.x / 32, (int)this.y / 32).getId() == 9) {
				//FanceTile.health--;
			//}
			
		}else
			move();
	}
	
	protected void move() {
		x += nx;
		y += ny;
		isHit = false;
		Mob_Collision(DAMAGE,DMG);
		if (distance() > range) remove();
		
	}

	public void render(Screen screen) {
		
		screen.renderProjectile((int)x+6, (int)y+6, this,0);
		
	}

}
