
package com.tavi.totp.entity.mob;

import com.tavi.totp.graphics.DmgFont;
import com.tavi.totp.graphics.Screen;

public class TextParticle extends Entity{
	private String msg;
	private int col ;
	private int time = 0;
	public double xa,ya,za;
	public double xx,yy,zz;
	public boolean isCrit = false;
	
	public TextParticle(String msg ,int x ,int y ,int col){
		this.msg = msg;
		this.x = x;
		this.y = y;
		this.col = col;
		xx = x;
		yy = y;
		zz = 2;
		xa = random.nextGaussian() * 0.3;
		ya = random.nextGaussian() * 0.2;
		za = random.nextGaussian() * 0.7 + 2;
	}
	
	public void update(){
		time++;
		if(time > 60) remove();
		xx += xa;
		yy += ya;
		zz += za;
		isCrit = true;
		if(zz < 0){
			zz = 0;
			za *= -0.5;
			ya *= 0.6;
			xa *= 0.6;
		}
		za -=0.15;
		x = (int) xx;
		y = (int) yy;
	}
	
	public void render(Screen screen){
			DmgFont.render(msg, screen, (int)x - msg.length() * 8 + 1, (int)y - (int) (zz) + 1, 0xFFFFFF);
			DmgFont.render(msg, screen, (int)x - msg.length() * 8, (int)y - (int) (zz) , col);
	}
	
}

