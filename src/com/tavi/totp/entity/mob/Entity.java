package com.tavi.totp.entity.mob;

import java.util.Random;
import com.tavi.totp.Game;
import com.tavi.totp.graphics.Screen;
import com.tavi.totp.graphics.Sprite;
import com.tavi.totp.level.Level;
import com.tavi.totp.level.tile.Tile;

public class Entity {

	protected Sprite sprite;
	public double x;
	public double y;
	public int xp ,yp;
	public int xr = 8;
	public int yr = 8;
	public boolean removed = false;
	protected Level level;
	protected final Random random = new Random();
	protected int anim = 0;
	public boolean isHit = false;
	public int healthmax = ( Game.currentLevel + 1) * 5;
	public int health = healthmax; 
	public boolean take_life = true;
	public int health_now = health;
	public int health_ratio = 4;

	public boolean findStartPos(Level level){
		int x = random.nextInt(Level.width);
		int y = random.nextInt(Level.height);
		int xx = x * 32 + 16;
		int yy = y * 32 + 16;
		
		if (level.player != null) {
			int xd = (int)level.player.x - xx;
			int yd = (int)level.player.y - yy;
			if (xd * xd + yd * yd < 80 * 80) return false;
		}
		
		if(level.entities.size() > 50) return false;
		//System.out.println(level.entities.size());
		
		if(level.getTile(x, y).mayPass(level, x, y, this) == false ){
			this.x = xx;
			this.y = yy;
			return true;
		}
		
		return false;
		
	}
	
	public boolean isInRadius(double px,double py,int radius) {
		return !(this.x + xr + radius < px || this.y + yr + radius < py || this.x - xr - radius > px || this.y - yr - radius > py);
	}
	
	
	public boolean findTilePos(Level level,Tile tile) {
		int x0 = 0;
		int x1 = Level.width;
		int y0 = 0;
		int y1 = Level.height;
		int xx = (int)x * 32;
		int yy = (int)y * 32;
		
		if (level.player != null) {
			int xd = (int)level.player.x - xx;
			int yd = (int)level.player.y - yy;
			if (xd * xd + yd * yd < 80 * 80) return false;
		}
		
		for(int yt = y0;yt <= y1;yt+=32) {
			for(int xt = x0; xt <= x1; xt+=32) {
				if(level.getTile(xt, yt) == tile) {					
					this.x = xt *32;
					this.y = yt *32;
					return true;
				}
			}
		}
		
		
		return false;
	}

	public void update() {
	
		// if(WizardProjectile.isHit) level.add(new TextParticle("" + WizardProjectile.DAMAGE, (int)x, (int)y, 0xFFA5000));
	}

	public void render(Screen screen) {

	}

	public void remove() {

		removed = true;
	
	}

	public boolean isRemoved() {

		return removed;
	}

	protected boolean isSolidTile(double xa, double ya, double x, double y) {
        if (level == null) {
            return false;
        }
        Tile lastTile = level.getTile(((int)this.x + (int)x) / 32 ,((int)this.y + (int)y) / 32);
        Tile newTile = level.getTile(((int)this.x + (int)x + (int)xa) / 32 , ((int)this.y + (int)y + (int)ya) / 32);
        if (!lastTile.equals(newTile) && newTile.mayPass(level, (int)this.x, (int)this.y, this)) {
            return true;
        }
        return false;
    }
	
    //private List<Entity> entities = new ArrayList<Entity>();

	
	private boolean collision(double xa, double ya) {
		
		int xMin = 2;
        int xMax = 15;
        int yMin = 15;
        int yMax = 19;
        if(Player.isSwimming){
        	yMax = 1;
        	xMax = 18;
        }
        if (level.getTile((int)this.x / 32, (int)this.y / 32).getId() == 30) {
        	xMax = 18;
        	xMin = 20;
        }
        if (level.getTile((int)this.x / 32, (int)this.y / 32).getId() == 25) {
        	xMax = 32;
        	xMin = 32;
        	yMax = 7;
        }
        
        
        int yMinWater = 0;
        for (int x = xMin; x < xMax; x++) {
            if (isSolidTile((int)xa, (int)ya, x, yMin)) {
                return true;
            }
        }
        for (int x = xMin; x < xMax; x++) {
            if (isSolidTile((int)xa,(int) ya, x, yMax)) {
                return true;
            }
        }
        for (int y = yMin; y < yMax; y++) {
            if (isSolidTile((int)xa, (int)ya, xMin, y)) {
                return true;
            }
        }
        for (int y = yMin; y < yMax; y++) {
            if (isSolidTile((int)xa, (int)ya, xMax, y)) {
                return true;
            }
        }
        if(Player.isSwimming || Player.isClimbing){
        	 for (int y = yMinWater; y < yMax; y++) {
                 if (isSolidTile((int)xa, (int)ya, yMinWater, y)) {
                     return true;
                 }
             }
        }
        
        return false;
	}
	
	private int abs(double value){
		if(value < 0) return -1;
		return 1;
	}
	
	public void touchedBy(Entity e){
		
	}
	
	public void init(Level level) {
		this.level = level;
	}
	
	public boolean blocks(Entity e){
		return false;
	}

	public boolean move2(double xa, double ya) {
		
		while(xa != 0){
			if(Math.abs(xa) > 0){
				if(!collision(abs(xa),ya)){
					this.x += abs(xa);
				}
				xa-= abs(xa);
			}else {
				if(!collision(abs(xa),ya)){
					this.x += xa;
				}
				xa = 0;
			}
			
		}
		
		while(ya != 0){
			if(Math.abs(ya) > 0){
				if(!collision(xa,abs(ya))){
					this.y += abs(ya);
				}
				ya-= abs(ya);
			}else {
				if(!collision(xa,abs(ya))){
					this.y += ya;
				}
				ya = 0;
			}
			
		}	
		
		return false;
	}
	
	public double getX(){
		return x;
	}
	public double getY(){
		return y;
	}

	public boolean canSwim() {
		return false;
	}

	public boolean intersects(int x0, int y0, int x1, int y1) {
		return !(x + xr < x0 || y + yr < y0 || x - xr > x1 || y - yr > y1);
	}

}
