package com.tavi.totp.entity.mob;

import java.util.Random;

import com.tavi.totp.Game;
import com.tavi.totp.Gui;
import com.tavi.totp.TransitionMenu;
import com.tavi.totp.WinMenu;
import com.tavi.totp.entity.mob.weapons.Fist;
import com.tavi.totp.entity.mob.weapons.Sword;
import com.tavi.totp.entity.mob.weapons.Weapon;
import com.tavi.totp.entity.projectile.GunProjectile;
import com.tavi.totp.graphics.Screen;
import com.tavi.totp.graphics.Sprite;
import com.tavi.totp.input.Keyboard;
import com.tavi.totp.input.Mouse;
import com.tavi.totp.level.Level;
import com.tavi.totp.mob.skeleton.ArmorHead;
import com.tavi.totp.mob.skeleton.Arms;
import com.tavi.totp.mob.skeleton.Body;
import com.tavi.totp.mob.skeleton.CamoBody;
import com.tavi.totp.mob.skeleton.ClassicArms;
import com.tavi.totp.mob.skeleton.ClassicBody;
import com.tavi.totp.mob.skeleton.ClassicHead;
import com.tavi.totp.mob.skeleton.ClassicLegs;
import com.tavi.totp.mob.skeleton.Head;
import com.tavi.totp.mob.skeleton.Legs;
import com.tavi.totp.sound.Sound;

public class Player extends Mob {

	private Keyboard input;
	public static Sprite gun;
	public static Sprite sword;
	private Game game;
	private int st = 0;
	public int sprint = 10;
	public boolean isBlack = false;
	public static boolean walking;
	public static int maxHealth = 6;
	private int maxstamina = 6; 
	public static int health;
	public static int stamina;
	public int fireRate = 0;
	public Steps steps;
	public static boolean inHand = false;
	public static boolean isHurt = false;
	public static boolean isSwimming = false;
	public static boolean isShooting = false;
	public static boolean isFlipped = false;
	public static boolean isDead = false; 
	public static boolean isClimbing = false;
	public static boolean change = false;
	public static boolean MoveInFront = false;
	public static boolean onGrass = false;
	private Random random = new Random();
	public static int xp,yp;
	public static boolean changeL = false;
	private boolean Down = false,Top = false,Left = false,Right = false,RTop = false,RDown = false,LTop = false,LDown=false;
	private int diff = 0;
	public static int dirr = 4;
	//private String selected = "Sword";
	public static int dirView = 0; // for skeletal
	private Head head;
	private Body body;
	private Arms arms;
	private Legs legs;
	public static Weapon weapon = new Fist();
	public static int Damage = weapon.avgDmg;
	
	public static final String Name = "Player";
	
	//private AnimatedSprite up = new AnimatedSprite(3, 16, 16, SpriteSheet.player_up);
	//private AnimatedSprite down = new AnimatedSprite(3, 16, 16, SpriteSheet.player_down);
	
	//private AnimatedSprite animSprite = down;
	
	public Player(Game game,Keyboard input) {
		this.input = input;
		this.game = game;
		x = 30 * 32;
		y = 46 * 32;
		money = 0;
		health = maxHealth;
		stamina = maxstamina;
		sprite = Sprite.player_down;
		gun = Sprite.gun_top;
		fireRate = GunProjectile.FIRE_RATE;
		head = new ClassicHead();
		body = new ClassicBody();
		arms = new ClassicArms();
		legs = new ClassicLegs();
		weapon = new Sword();
	}
	
	protected void die(){
		super.die();
	}
	
	public boolean canSwim() {
		return true;
	}
	
	private void Look_Detection(double angle) {
		if(angle > -30 && angle < 30){
			Down = true;
			dirr = 4;
			dirView = 0;
		}else Down = false;
		if(angle > 30 && angle < 60){
			RDown = true;
			dirr = 4;
			dirView = 1;
		}else RDown = false;
		if(angle > 60 && angle < 120){
			Right = true;
			dirr = 2;
			dirView = 2;
		}else Right = false;
		if(angle > 120 && angle < 150){
			RTop = true;
			dirr = 3;
			dirView = 3;
		}else RTop = false;
		if(angle > 150 && angle < 180 ){
			Top = true;
			dirr = 3;
			dirView = 4;
		}else if(angle < -150 && angle >-179.9999){
			Top = true;
			dirr = 3;
			dirView = 4;
		}else Top = false;			
		if(angle > -150 && angle < -120){
			LTop = true;
			dirr = 3;
			dirView = 5;
		}else LTop = false;
		if(angle > -120 && angle < -60){
			Left = true;
			dirr = 1;
			dirView = 6;
		}else Left = false;
		if(angle > -60 && angle < -30){
			LDown = true;
			dirr = 4;
			dirView = 7;
		}else LDown = false;

		if(Left || Right){
			gun = Sprite.gun_side;
			sword = Sprite.player_sword_left;
		}
		if(RDown || LDown){
			gun = Sprite.gun_diag;
			sword = Sprite.player_sword_down;
		}
		if(RTop || LTop){
			gun = Sprite.gun_diag_up;
		}
		if(Top){
			gun = Sprite.gun_up;
			dirr = 3;
		}
		if(Down){
			gun = Sprite.gun_down;
			sword = Sprite.player_sword_down;
			dirr = 4;
		}
	}
	
	private void Swimming(Screen screen) {
		// dir 1 = left
				//dir 2 = right
				//dir 3 = up
				// dir 4 = down
		int flip = 0;
		if (dir == 2) {
			flip = 0;
			if(isSwimming){
				sprite = Sprite.player_water_down;
				if (walking) {
					if (anim % 20 > 10) {
						sprite = Sprite.player_water_down;
					} else {
						sprite = Sprite.player_water_down_1;
					}
				}
			}
		}else if (dir == 0) {
			if(isSwimming){
				flip = 0;
				sprite = Sprite.player_water_up;
				if (walking) {
					if (anim % 20 > 10) {
						sprite = Sprite.player_water_up;
					} else {
						sprite = Sprite.player_water_up_2;
					}
				}
			}
		}else if (dir == 1) {
			if(isSwimming){
				flip = 1;
				sprite = Sprite.player_water_side;
				if (walking) {
					if (anim % 20 > 10) {
						sprite = Sprite.player_water_side;
					} else {
						sprite = Sprite.player_water_side_1;
					}
				}
			}
		}else if (dir == 3) {
			flip = 0;
			if(isSwimming){
				sprite = Sprite.player_water_side;
				if (walking) {
					if (anim % 20 > 10) {
						sprite = Sprite.player_water_side;
					} else {
						sprite = Sprite.player_water_side_1;
					}
				}
			}
		}
		screen.renderMob2((int)x, (int)y, sprite, flip);
	}
	
	public boolean blocks(Entity e){
		return true;
	}
	
	public void weaponInHand() {
		if(input.c.clicked && inHand == false) {
			inHand = true;
		}else if(input.c.clicked && inHand == true){
			inHand = false;
		}
	}
	
	int time = 100;
	public void update() {
		xp = (int)x;
		yp = (int)y;
		
		if(input.one.clicked) {
			body = new CamoBody();
		}
		if(input.two.clicked) {
			head = new ArmorHead();
		}
		
		weaponInHand();
		
		head.update();
		legs.update();
		arms.update();
		body.update();
		weapon.update();
		
		if(walking){
				if(anim%40>10){
					diff = 3;
				}else{
					diff = -3;
				}
			time--;
			Steps step = new Steps(x+diff,y);
			if(time == 0){
				level.add(step);
			}
			time = 100;
		}
		
		double dx = Mouse.getX() - Game.getWindowWidth() / 2;
		double dy = Mouse.getY() - Game.getWindowHeight() / 2;
		double angle = Math.atan2(dx, dy) * 180 / Math.PI;
		
		// dir 1 = left
		//dir 2 = right
		//dir 3 = up
		// dir 4 = down
	
		Look_Detection(angle);
		
		if (anim < 7500)
			anim++;
		else
			anim = 0;	
	
		
		if(GunProjectile.FIRE_RATE > 0) fireRate--;
		
		
		if(health == 0) die();
		
		double xa = 0;
		double ya = 0;
		long timer = System.currentTimeMillis();
		
		if(isSwimming){
			st++;
            if(stamina > 0 && st == 7){
            stamina -= 2;
            st = 0;
            }
		}
		
		if(stamina < 100 && !isSwimming && !isClimbing && !input.shift.down){
        	stamina++;
        	st = 0;
		}
	
	
		if (stamina == 0){
				health --;
				st = 0;
		}
		

		if(level.getTile((int) this.x / 32, (int)y / 32).getId() == 20){
			if(Level.kills >= 3 && Game.currentLevel != 3){
			game.setMenu(new TransitionMenu(Game.currentLevel + 1));
			x = 30 * 32;
			y = 46 * 32;
			}else if(Level.kills >= 0 && Game.currentLevel == 3)
			if(Game.currentLevel == 3){
				game.setMenu(new WinMenu());
				x = 30 * 32;
				y = 46 * 32;
			}
		}
		
		if (level.getTile((int)this.x / 32, (int)this.y / 32).getId() == 4) {
			timer++;
			if(isBlack == false && timer < 5){
				isBlack = true;
				timer =0;
			}else if(timer < 500){
				isBlack = false;
				timer =0;
			}
		}
		
		if (level.getTile((int)this.x / 32, (int)this.y / 32).getId() == 16) {
			change = true;
		}
		if (level.getTile((int)(this.x+8) / 32, (int)(this.y+15) / 32).getId() == 14) {
			if(health < 100)
            health++;
        }
		if (level.getTile((int)(this.x+8) / 32, (int)(this.y+15) / 32).getId() == 3 ||
				level.getTile((int)(this.x+8) / 32, (int)(this.y+15) / 32).getId() == 39 ||
				level.getTile((int)(this.x+8) / 32, (int)(this.y+15) / 32).getId() == 40 || 
				level.getTile((int)(this.x+8) / 32, (int)(this.y+15) / 32).getId() == 38 ||
				level.getTile((int)(this.x+8) / 32, (int)(this.y+15) / 32).getId() == 41 ||
				level.getTile((int)(this.x+8) / 32, (int)(this.y+15) / 32).getId() == 2) {
			
            isSwimming = true;
        }else{
        	isSwimming = false;
        }
        if (level.getTile((int)(this.x+10) / 32, (int)(this.y+13) / 32).getId() == 16) {
            isClimbing = true;
        }else{
        	isClimbing = false;
        }
        if(level.getTile((int) x / 32, (int) y / 32).getId() == 26){
        	for(int i = 0 ;i <= 1;i++){
        	//	y++;
        	}
        }
        
       if (level.getTile((int)this.x / 32, (int)this.y / 32).getId() == 13) {
        	if(health < 100)
        	health++;
        } 
       
        if(!isSwimming){
        	if (input.up.down) ya -=1;
			if (input.down.down) ya+=1;
			if (input.left.down) xa-=1;
			if (input.right.down) xa+=1;
        }else{
        	if (input.up.down) ya -=1;
			if (input.down.down) ya +=1;
			if (input.left.down) xa -=1;
			if (input.right.down) xa +=1;
        }
		
		if (input.shift.down) {
				st++;
				if(st == 7){
					stamina -= 1;
					st = 0;
				}
				
				if(!isSwimming && sprint != 0){
					
					sprint--;
					if (input.up.down) ya -= 2;
					if (input.down.down) ya += 2;
					if (input.left.down) xa -= 2;
					if (input.right.down) xa += 2;
				}
		}
		if(sprint != 10 && !input.shift.down) sprint++;
		
		if (xa != 0 || ya != 0) {
			move(xa, ya);
			walking = true;
		} else {
			walking = false;
		}
		
		clear();
		if(!isSwimming && !isClimbing)
		updateShooting();

	}
	
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	
	public boolean findStartPos(Level level){
		while(true){
			int x = random.nextInt(Level.width);
			int y = random.nextInt(Level.height);
			if(level.getTile(x, y).getId() == 1){
				this.x = x ;
				this.y = y;
				return true;
			}
		}
		
	}
	
	private void clear(){
		for(int i = 0;i < level.getProjectiles().size();i++){
			Entity p = level.getProjectiles().get(i);
			if(p.isRemoved()) level.getProjectiles().remove(i);
		}
	}
	
	private void updateShooting() {
		double xScroll = x - Screen.width / 2;
		double yScroll = y - Screen.height / 2;
		
		if (Mouse.getButton() == 1 && fireRate <= 0) {
			double dx = Mouse.getX() - Game.get_xScroll(xScroll);
			double dy = Mouse.getY() - Game.get_yScroll(yScroll);
			double dir = Math.atan2(dy,dx);
			
			shoot(x, y, dir);
			Sound.shoot2.play();
			fireRate = GunProjectile.FIRE_RATE;
		}
	}
	
	public void anim2(Sprite sprite1,Sprite sprite2,int anim,boolean walking){
		if(walking){
			if(anim % 20 > 10){
				sprite = sprite1;
			}else{
				sprite = sprite2;
			}
		}
	}
	
	public void steps(int x,int y,Screen screen){
		if(walking){
			if(anim%40>10){ 
				level.add(steps);
			}else{
				
			}
		}
	}

	public void render(Screen screen) {
		if(!isSwimming) {
			isFlipped = false;
			if(dirr == 3 && inHand) {
				weapon.render((int)x, (int)y, dirView, screen);
				body.render((int)x, (int)y,dirView, screen);
				head.render((int)x,(int)y,dirView,screen);
				legs.render((int)x, (int)y, dirView, screen);
				arms.render((int)x,(int)y,dirView,screen);
			}else if(dirr == 1 && inHand){
				weapon.render((int)x, (int)y, dirView, screen);
				body.render((int)x, (int)y,dirView, screen);
				head.render((int)x,(int)y,dirView,screen);
				legs.render((int)x, (int)y, dirView, screen);
				arms.render((int)x,(int)y,dirView,screen);
			}else if(dirr != 3 && !inHand){
				weapon.render((int)x, (int)y, dirView, screen);
				body.render((int)x, (int)y,dirView, screen);
				head.render((int)x,(int)y,dirView,screen);
				legs.render((int)x, (int)y, dirView, screen);
				arms.render((int)x,(int)y,dirView,screen);
			}else {
				body.render((int)x, (int)y,dirView, screen);
				head.render((int)x,(int)y,dirView,screen);
				legs.render((int)x, (int)y, dirView, screen);
				weapon.render((int)x, (int)y, dirView, screen);
				arms.render((int)x,(int)y,dirView,screen);
			}
		}else {
			Swimming(screen);
		}
	}
}
	