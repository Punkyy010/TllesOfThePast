package com.tavi.totp.entity.mob;

import com.tavi.totp.graphics.Coins2;
import com.tavi.totp.graphics.Screen;

public class CoinParticle extends Entity{
	private String msg = "1";
	private int flip ;
	private int time = 0;
	private int s = 1;
	public double xa,ya,za;
	public double xx,yy,zz;
	
	public CoinParticle(int x ,int y ,int flip){
		this.x = x;
		this.y = y;
		this.flip = flip;
		xx = x;
		yy = y;
		zz = 2;
		xa = random.nextGaussian() * 0.3;
		ya = random.nextGaussian() * 0.2;
		za = random.nextGaussian() * 0.7 + 2;
	}
	
	public void update(){
		int radius = 50;
		int xp = Player.xp;
		int yp = Player.yp;
		time++;
		if(this.x >= xp && this.x <= xp + 7 && this.y >= yp && this.y <= yp+7){
			Player.money+=1;
			remove();
		}else if(time > 320) remove();
		xx += xa;
		yy += ya;
		zz += za;
		if(zz < 0){
			zz = 0;
			za *= -0.5;
			ya *= 0.6;
			xa *= 0.6;
		}
		za -=0.15;
		x = (int) xx;
		y = (int) yy;
		
		int dx = Math.abs(xp - (int)this.x);
		int dy = Math.abs(yp - (int)this.y);
		double distance = Math.sqrt((dx * dx) + (dy * dy));
		if(distance <= radius){
			if ((int)xp > this.x) xa += 2;
			if ((int)xp < this.x) xa -= 2;
			if ((int)yp > this.y) ya += 2;
			if ((int)yp < this.y) ya -= 2;
		}
		
	}
	
	public void render(Screen screen){
		anim++;
		if (anim % 1420 == 0) { 
			s *= -1;
		}
		if(s == 1) msg = "3";
		if(s == -1) msg = "1";
		
		Coins2.renderC(msg, screen, (int)x - msg.length() * 8, (int)y - (int) (zz) , flip);
	}
	
}
