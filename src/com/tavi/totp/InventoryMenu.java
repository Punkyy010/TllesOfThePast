package com.tavi.totp;

import com.tavi.totp.entity.mob.Player;
import com.tavi.totp.entity.mob.PowerMenu;
import com.tavi.totp.entity.projectile.GunProjectile;
import com.tavi.totp.graphics.Coins;
import com.tavi.totp.graphics.Font;
import com.tavi.totp.graphics.Light;
import com.tavi.totp.graphics.Powers;
import com.tavi.totp.graphics.Screen;
import com.tavi.totp.graphics.Sprite;
import com.tavi.totp.graphics.Weapon;
import com.tavi.totp.input.Keyboard;
import com.tavi.totp.sound.Sound;

public class InventoryMenu extends Menu{

	private Keyboard key;
	private Powers powers;
	private Weapon bag;
	private Light light;
	private PowerMenu pmenu;
	
	private int selected = 0;
	
	public static int HealthLevel = 1;
	public static int SpeedLevel = 1;
	public static int DamageLevel = 1;
	
	public static int HealthPrice = 2;
	public static int SpeedPrice = 4;
	public static int DamagePrice = 5;
	
	public void init(int width ,int height,Game game, Keyboard key){
		this.width = width;
		this.height = height;
		this.game = game;
		this.key = key;
		font = new Font();
		bag = new Weapon();
		light = new Light();
		powers = new Powers();
		pmenu = new PowerMenu();
		
	}
	
	public void update(){
		if(key.e.clicked || key.esc.clicked){
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
		
		if(HealthLevel != 1)
		HealthPrice = HealthLevel * 2;
		if(SpeedLevel != 1)
		SpeedPrice = SpeedLevel * 4;
		if(DamageLevel != 1)
		DamagePrice = DamageLevel * 5;
		
		int len = 3;
		if (selected < 0) selected += len;
		if (selected >= len) selected -= len;
		
		if(key.enter.clicked || key.space.clicked){
			if(selected == 0){
				if(Player.money >= HealthPrice){
					Player.money = Player.money - HealthPrice;
					HealthLevel++;
					Player.health +=1;
					Sound.powerup.play();
				}else{
					Sound.notenough.play();
				}
			}
			if(selected == 2){
				if(Player.money >= DamagePrice){
					Player.money = Player.money - DamagePrice;
					DamageLevel += 1;
					Player.Damage += 1;
					Sound.powerup.play();
				}else{
					Sound.notenough.play();
				}
			}
			if(selected == 1){
				if(Player.money >= SpeedPrice){
					Player.money = Player.money - SpeedPrice;
					SpeedLevel++;
					GunProjectile.FIRE_RATE -=1;
					Sound.powerup.play();
				}else{
					Sound.notenough.play();
				}
			}
			
		}
	}
	
	public void light(Screen screen){
		
		for(int x = 0; x <= Game.width/5 - 58;x++){
			for(int y = 0; y <= Game.height;y++){
				Font.render("~", screen, x, y, 0xFF000000);
			}
		}
		for(int x = Game.width/5 - 58; x <= Game.width;x++){
			for(int y = 0; y <= 25;y++){
				Font.render("~", screen, x, y, 0xFF000000);
			}
		}
		for(int x = Game.width/5 - 58; x <= Game.width;x++){
			for(int y = Game.height - 25; y <= Game.height;y++){
				Font.render("~", screen, x, y, 0xFF000000);
			}
		}
		for(int x = Game.width/5 + 70; x <= Game.width;x++){
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
		
		String coinz = Integer.toString(Player.money);
		
		if(Game.currentLevel == 1) light(screen);
		
		for(int x = 32; x <= Game.width - 32;x+=32){
			for(int y = 32; y <= Game.height - 32;y+=32){
				pmenu.render("1", screen, 16, 16, 0); // left top
				//pmenu.render("2", screen, x + 48, Game.height/5, 0);
				//pmenu.render("a", screen, x + 48, Game.height/5+32, 0);
				//pmenu.render("a", screen, x+ 48, Game.height/5+64, 0);
				//pmenu.render("a", screen, x+ 48, Game.height/5+96, 0);
				pmenu.render("1", screen, Game.width - 48, Game.height - 48, 1); // right bottom
				
				
				pmenu.render("1", screen,Game.width - 32, 16, 2);
				//pmenu.render("2", screen, x + 32, Game.height/5 + 128, 1);
				pmenu.render("1", screen, 16, Game.height - 32, 1);
				
			}
		}
		pmenu.render("3", screen, Game.width/5+ 48, Game.height/5 + 32, 0);
		pmenu.render("3", screen, Game.width/5+ 48, Game.height/5 + 64, 0);
		pmenu.render("3", screen, Game.width/5+ 48, Game.height/5 + 96, 0);

		pmenu.render("3", screen, Game.width - Game.width/4 -24, Game.height/5 + 32, 2);
		pmenu.render("3", screen, Game.width - Game.width/4 -24, Game.height/5 + 64, 2);
		pmenu.render("3", screen, Game.width - Game.width/4 -24, Game.height/5 + 96, 2);
		pmenu.render("1", screen, Game.width - Game.width/4 -24, Game.height/5 + 128,3);
		
		
		Font.render("POWER-UPS:", screen, Game.width/3, Game.height/6, 0xFFFFFFFF);
		for(int i = 100 ;i < 164;i+=16)
		screen.renderSprite(5, 5, Sprite.EmptySlot, true, 0);
		
		powers.render("a", screen, Game.width/5 + 55, Game.height/4 , 0);
		powers.render("2",screen, Game.width/5 + 32 + 55,Game.height/4 ,0);
		powers.render("1", screen, Game.width/5 + 64 + 55, Game.height/4 , 2);
		Font.render("HEALTH", screen, Game.width/5 + 32 + 55, Game.height/4  + 5, 0xFFFFFFFF);
		Font.render("LVL." +HealthLevel, screen, Game.width/5 + 32 + 55, Game.height/4 + 15, 0xFFFFFF);
		
		if(selected != 0){
		powers.render("1", screen, Game.width/2 + 35, Game.height/4, 0);
		powers.render("1", screen, Game.width /2 + 45, Game.height/4, 2);
		Font.render("BUY", screen, Game.width /2 + 45, Game.height/4 + 5, 0Xffffffff);
		Coins.render("a" + HealthPrice, screen, Game.width /2 + 42, Game.height/4 + 16, 0);
		}else{
			powers.render("3", screen, Game.width/2+ 35, Game.height/4, 0);
			powers.render("3", screen, Game.width /2 + 45, Game.height/4, 2);	
			Font.render("BUY", screen, Game.width /2 + 45, Game.height/4 + 5, 0Xffffffff);
			Coins.render("a" + HealthPrice, screen, Game.width /2 + 42, Game.height/4 + 16, 0);
		}
		
		powers.render("c", screen, Game.width/5 + 55, Game.height/4 + Game.height/5, 0);
		powers.render("2",screen, Game.width/5 + 32 + 55, Game.height/4 + Game.height/5, 0);
		powers.render("1", screen, Game.width/5 + 64 + 55, Game.height/4 + Game.height/5, 2);
		Font.render("SPEED", screen, Game.width/5 + 32 + 55, Game.height/4 + Game.height/5 + 5, 0xFFFFFFFF);
		Font.render("LVL." +SpeedLevel, screen, Game.width/5 + 32 + 55, Game.height/4 + Game.height/5 + 15, 0xFFFFFF);
		
		if(selected != 1){
			powers.render("1", screen, Game.width /2+ 35, Game.height/4 + Game.height/5, 0);
			powers.render("1", screen, Game.width /2 + 45, Game.height/4 + Game.height/5, 2);
			Font.render("BUY", screen, Game.width /2 + 45, Game.height/4 + Game.height/5 + 5, 0Xffffffff);
			Coins.render("a" + SpeedPrice, screen, Game.width /2 +42, Game.height/4 + Game.height/5 + 16, 0);
		}else{
			powers.render("3", screen, Game.width /2+ 35, Game.height/4 + Game.height/5, 0);
			powers.render("3", screen, Game.width /2 + 45, Game.height/4 + Game.height/5, 2);
			Font.render("BUY", screen, Game.width /2 + 45, Game.height/4 + Game.height/5 + 5, 0Xffffffff);
			Coins.render("a" + SpeedPrice, screen,  Game.width /2 + 42, Game.height/4 + Game.height/5 + 16, 0);
			
		}
		
		powers.render("b", screen, Game.width/5 + 55, Game.height/2 + Game.height/8, 0);
		powers.render("2",screen, Game.width/5 + 32 + 55, Game.height/2 + Game.height/8, 0);
		powers.render("1", screen, Game.width/5 + 64 + 55, Game.height/2 + Game.height/8, 2);
		Font.render("DAMAGE", screen, Game.width/5 + 32 + 55, Game.height/2 + Game.height/8 + 5, 0xFFFFFFFF);
		Font.render("LVL." +DamageLevel, screen, Game.width/5 + 32 + 55, Game.height/2 + Game.height/8 + 15, 0xFFFFFF);

		if(selected != 2){
		powers.render("1", screen, Game.width /2+ 35, Game.height/2 + Game.height/8, 0);
		powers.render("1", screen, Game.width /2 + 45,Game.height/2 + Game.height/8, 2);
		Font.render("BUY", screen, Game.width /2 + 45, Game.height/2 + Game.height/8 + 5, 0Xffffffff);
		Coins.render("a" + DamagePrice, screen, Game.width /2 + 42, Game.height/2 + Game.height/8 + 16, 0);
		}else{
			powers.render("3", screen, Game.width /2+ 35, Game.height/2 + Game.height/8, 0);
			powers.render("3", screen, Game.width /2 + 45, Game.height/2 + Game.height/8, 2);	
			Font.render("BUY", screen, Game.width /2 + 45, Game.height/2 + Game.height/8 + 5, 0Xffffffff);
			Coins.render("a" + DamagePrice, screen, Game.width /2 + 42, Game.height/2 + Game.height/8 + 16, 0);
		}
		
		bag.render("8", screen, Game.width - 32, 3, 0);
		
		Coins.render("a", screen, Game.width - Game.width/3, Game.height /6, 0);
		Font.render(coinz, screen, Game.width/2 + Game.width/8, Game.height/6 -1, 0xFFFFD800);
		
	}
	
}
