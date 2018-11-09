package com.tavi.totp;

import com.tavi.totp.entity.mob.Player;
import com.tavi.totp.graphics.Font;
import com.tavi.totp.graphics.Screen;
import com.tavi.totp.level.Level;

public class TransitionMenu extends Menu{

	private int dir;
	private int time;
	private int anim = 0;
	private int s = 1;
	int flip = 0;
	
	public TransitionMenu(int dir){
		this.dir = dir;
		font = new Font();
	}
	
	public void update(){
		time += 2;
		if(time == 30) {
			Level.kills = 0;
			Player.health = Player.maxhealth;
			game.changeLevel(dir);
			
		}
		if(time == 360) game.setMenu(null);
		
		anim++;
		if (anim % 180 == 0) {
			s *= -1;
		}
		if(s == 1) flip = 1;
		if(s == -1) flip = 2;
	}
	
	public void render(Screen screen){
		for(int x = 0; x <= Game.width;x++){
			for(int y = 0; y <= Game.height;y++){
				Font.render("~", screen, x, y, 0xFF000000);
			}
		}
		
		Font.renderD("1", screen, Game.width/2-10, Game.height/2-10, flip);
		
	}
	
	
}
