package com.tavi.totp;

import com.tavi.totp.graphics.Font;
import com.tavi.totp.graphics.Light;
import com.tavi.totp.graphics.Screen;
import com.tavi.totp.graphics.TitleFont;
import com.tavi.totp.input.Keyboard;
import com.tavi.totp.sound.Sound;

public class EscMenu extends Menu{

	private Keyboard key;
	
	private TitleFont title;
	private Light light;

	private int selected = 0;
	private String options1 = "RESUME";
	private String options2 = "EXIT GAME";
	
	public void init(int width ,int height,Game game, Keyboard key) {
		this.width = width;
		this.height = height;
		this.key = key;
		this.game = game;
		this.font = new Font();
		this.light = new Light();
		title = new TitleFont();
		
	}

	public void update(){
		if(key.esc.clicked){
			game.setMenu(null);
		}
		if(key.down.clicked){
			selected++;
			Sound.select.play();
		}
		if(key.up.clicked){
			selected--;
			Sound.select.play();
		}
		
		int len = 2;
		if (selected < 0) selected += len;
		if (selected >= len) selected -= len;
	
		
		if(key.enter.clicked || key.space.clicked){
			if(selected == 0)
				game.setMenu(null);
			if(selected == 1)
				System.exit(0);
		}
	}
	
	public void light(Screen screen){
		for(int x = 0; x <= Game.width/2 - 58;x++){
			for(int y = 0; y <= Game.height;y++){
					Font.render("~", screen, x, y, 0xFF000000);
			}
		}
		for(int x = Game.width/2 - 58; x <= Game.width;x++){
			for(int y = 0; y <= 25;y++){
				Font.render("~", screen, x, y, 0xFF000000);
			}
		}
		for(int x = Game.width/2 - 58; x <= Game.width;x++){
			for(int y = Game.height - 25; y <= Game.height;y++){
				Font.render("~", screen, x, y, 0xFF000000);
			}
		}
		for(int x = Game.width/2 + 70; x <= Game.width;x++){
			for(int y = 25; y <= Game.height;y++){
				Font.render("~", screen, x, y, 0xFF000000);
			}
		}
		
		light.render("abcdef", screen, Game.width/2 - 50, 30, 0);
		light.render("ghijkl", screen, Game.width/2 - 50, 50, 0);
		light.render("mnopqr", screen, Game.width/2 - 50, 70, 0);
		light.render("stuvwx", screen, Game.width/2 - 50, 90, 0);
		light.render("yz1234", screen, Game.width/2 - 50, 110, 0);
		light.render("567890", screen, Game.width/2 - 50, 130, 0);
	}
	
	
	public void render(Screen screen){
		
		int col = 0xFFFFFF;
		
		if(Game.currentLevel == 1) light(screen);
		
		String msg = options1;
		int wo = Game.width/2 - (msg.length()*8)/2;
		int ho = Game.height/2 - 2*16;
		for(int i = 0;i <= 1 ;i++){
			
			if(i == 0)
				msg = options1;
			if(i == 1)
				msg = options2;
			
			
			if(i == selected){
				msg = ">" + msg + "<";
			}
			
			if(i == 1){
				title.render(msg,screen,wo -10,ho,col);
			}else
				title.render(msg,screen, wo, ho,col);
				ho += 10;
		}
		
	}
	
}
