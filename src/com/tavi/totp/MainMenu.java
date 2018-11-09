package com.tavi.totp;

import com.tavi.totp.graphics.Screen;
import com.tavi.totp.graphics.TitleFont;
import com.tavi.totp.graphics.Weapon;
import com.tavi.totp.input.Keyboard;
import com.tavi.totp.input.Mouse;
import com.tavi.totp.sound.Sound;

public class MainMenu extends Menu{

protected Game game;
	
	private int selected = 0;
	private String options1 = "NEW GAME"; //,"Instructions" ,"Exit Game"};
	private String options2 = "INSTRUCTIONS";
	private String options3 = "EXIT GAME";
	private String options4 = "SETTINGS";
	private Keyboard key;
	private TitleFont title;
	private Weapon weapon;
	
	
	public int width = Game.width;
	public int height = Game.height;
	
	private boolean about = false;
	private boolean settings = false;
	public static String number = "4" ;
	public static String sound = "4";
	static int anim = 0;
	static int s = 1;

	
	public void init(int width ,int height,Game game, Keyboard key) {
		this.width = width;
		this.height = height;
		this.key = key;
		this.game = game;
		title = new TitleFont();
		weapon = new Weapon();
		
	}
	
	public void update(){
		
		if(key.down.clicked){
			selected++;
			Sound.select.play();
		}
		if(key.up.clicked){
			selected--;
			Sound.select.play();
		}
		
		int len = 4;
		if (selected < 0) selected += len;
		if (selected >= len) selected -= len;
		
		if(!about)
		if(key.enter.clicked || key.space.clicked){
			if(selected == 0)
			game.setMenu(null);
			if(selected == 1)
				about = true;
			if(selected == 2)
				settings = true;
			if(selected == 3)
				System.exit(0);
		}
		
		if(Mouse.getX() >= 240 && Mouse.getX() <= 310 && Mouse.getY() >= 220 && Mouse.getY() <= 290 && Mouse.getButton() == 1){
			if(sound == "4"){
				sound = "5";
				Game.sound= false;
			}else if(sound == "5"){
				sound = "4";
				Game.sound= true;
			}
		}
		
	}
	
 	public void render(Screen screen){
 		screen.clear();
 		
 		int col = 0xFFFFFF;
 		
 		for(int x = 0; x <= width/8;x++){
			for(int y = 0; y <= height/8;y++){
				weapon.render("3", screen, x * 16, y * 16,0);
			}
		}
 		
 		anim++;
		if (anim % 360 == 0) {
			s *= -1;
		}
 		
 		title.render(Game.title, screen, Game.width/2 - (Game.title.length()*8)/2 , 20,0xFFFFFF);
 		title.render(Game.title, screen, Game.width/2 - (Game.title.length()*8)/2 - 1 , 21,0x267F00);
 		
 		if(s == 1){
 		weapon.renderPl("1", screen, Game.width/2 + 23, Game.height/2 - 30, 0); 	
 		}
 		if(s == -1){
 		weapon.renderPl("2", screen, Game.width/2 + 23, Game.height/2 - 30, 0); 	
 		}
 		
 		weapon.renderRock("12", screen, Game.width/2 + 10 , Game.height - 68, 0);
 		//weapon.renderR("1", screen, Game.width/2 +10, Game.height - 100, 0);
 		
 			
 		String msg = options1;
 		int wo = (msg.length()*8)/2-15;
		int ho = Game.height/2 + 4 * 8;
 		
		for(int i = 0;i <= 3 ;i++){
			
			if(i == 0)
				msg = options1;
			if(i == 1)
				msg = options2;
			if(i == 2)
				msg = options4;
			if(i == 3)
				msg = options3;
		
			
			if(i == selected){
				msg = ">" + msg + "<";
			}
			
			if(i == 1){
				title.render(msg,screen,wo -10,ho,col);
			}else
				title.render(msg,screen, wo, ho,col);
				ho += 10;
		}
		
		
		if(about){
			screen.clear();
			for(int x = 0; x <= width/8;x++){
				for(int y = 0; y <= height/8;y++){
					weapon.render("3", screen, x * 16, y * 16,0);
				}
			}
			title.render("ESC TO GO BACK", screen, 5, 5, 0xB20000);
			title.render("INSTRUCTIONS", screen, 10, 40, 0xFFFFFF);
			title.render("1", screen, 10, 60, 0xB20000);
			title.render("CLICK TO SHOOT", screen, 26, 60, 0xFFFFFF);
			title.render("2", screen, 10, 80, 0xB20000);
			title.render("KILL YOUR ENEMIES", screen, 26, 80, 0xFFFFFF);
			title.render("3", screen, 10, 100, 0xB20000);
			title.render("UPGRADE YOUR CHARACTER", screen, 26, 100, 0xFFFFFF);
			title.render("4", screen, 10, 120, 0xB20000);
			title.render("4 PASS THROUGH HELL TO ESCAPE", screen, 26, 120, 0xFFFFFF);
			
			
			if(key.esc.clicked) about = false;
		}
		
		if(settings){
			
			screen.clear();
			title.render("ESC TO GO BACK", screen, 10, 10, 0xFFFFFF);
			title.render("TYPE 1 TO 5 FOR SCALE:", screen, 10, 40, 0xFFFFFF);
	
			if(key.one.clicked) number = "1";
			if(key.two.clicked) number = "2";
			if(key.three.clicked) number = "3";
			if(key.five.clicked) number = "5";
			if(key.four.clicked) number = "4";
			
			title.render(number, screen, 195, 40, 0xFF0011);
			
			title.render("SOUND:", screen, 10, 60, 0xFFFFFF);
			
			weapon.render(sound, screen, 60, 56,0);
			
			
			//System.out.println(Mouse.getX() +" " + Mouse.getY());
			
			if(key.esc.clicked) settings = false;
			
		}
		
	} 
	
}
