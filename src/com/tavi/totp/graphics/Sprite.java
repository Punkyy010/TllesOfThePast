package com.tavi.totp.graphics;

public class Sprite {

	public final int SIZE;
	private int x, y;
	public int[] pixels;
	public int width ,height;
	protected SpriteSheet sheet;
	
	public static Sprite waterSprite_1 = new Sprite(32,3,0,SpriteSheet.tiles);
	public static Sprite waterSprite_2 = new Sprite(32,2,0,SpriteSheet.tiles);
	public static Sprite DirtWallSprite = new Sprite(32,1,4,SpriteSheet.tiles);	
	public static Sprite DirtStairsSprite = new Sprite(32,0,4,SpriteSheet.tiles);
	public static Sprite grass = new Sprite(32, 0, 0, SpriteSheet.tiles);
	public static Sprite elevated_grass = new Sprite(32,7,0,SpriteSheet.tiles);
	public static Sprite grass_2 = new Sprite(32,1,0,SpriteSheet.tiles);
	public static Sprite grass_3 = new Sprite(32,4,4,SpriteSheet.tiles);
	public static Sprite flowerSprite = new Sprite(32,7,1,SpriteSheet.tiles);
	public static Sprite rockSprite = new Sprite(16,2,0,SpriteSheet.tiles);
	public static Sprite vineSprite = new Sprite(32,2,1,SpriteSheet.tiles);
	public static Sprite doorSprite = new Sprite(32,3,2,SpriteSheet.tiles);
	public static Sprite shadowSprite = new Sprite(32,5,0,SpriteSheet.tiles);
	public static Sprite transSprite = new Sprite(32,6,0,SpriteSheet.tiles);
	public static Sprite caveSprite = new Sprite(32,4,2,SpriteSheet.tiles);
	public static Sprite entrSprite = new Sprite(32,5,2,SpriteSheet.tiles);
	public static Sprite treebtmSprite = new Sprite(32,4,3,SpriteSheet.tiles);
	public static Sprite treetopSprite = new Sprite(32,5,3,SpriteSheet.tiles);
	public static Sprite holeSprite = new Sprite(32,6,3,SpriteSheet.tiles);
	public static Sprite DirtWallCurveSprite = new Sprite(32,5,4,SpriteSheet.tiles);
	public static Sprite DirtWallSideSprite = new Sprite(32,6,4,SpriteSheet.tiles);
	public static Sprite caveFloorSprite = new Sprite(32,6,2,SpriteSheet.tiles);
	public static Sprite caveOreSprite = new Sprite(32,6,1,SpriteSheet.tiles);
	public static Sprite DirtCenterSprite = new Sprite(32,0,5,SpriteSheet.tiles);
	public static Sprite DirtCornerSprite = new Sprite(32,2,5,SpriteSheet.tiles);
	public static Sprite DirtSideSprite = new Sprite(32,4,5,SpriteSheet.tiles);
	public static Sprite DirtTopSprite = new Sprite(32,1,5,SpriteSheet.tiles);
	public static Sprite WaterTopSprite = new Sprite(32,2,6,SpriteSheet.tiles);
	public static Sprite WaterCornerSprite = new Sprite(32,0,6,SpriteSheet.tiles);
	public static Sprite WaterSideSprite = new Sprite(32,1,6,SpriteSheet.tiles);
	public static Sprite WaterCorner2Sprite = new Sprite(32,3,6,SpriteSheet.tiles);
	public static Sprite BlackWall_Side = new Sprite(32,0,7,SpriteSheet.tiles);
	public static Sprite BlackWall_Top = new Sprite(32,0,7,SpriteSheet.tiles);
	public static Sprite Wood_back = new Sprite(32,7,2,SpriteSheet.tiles);
	public static Sprite ColumnSprite = new Sprite(32,7,3,SpriteSheet.tiles);
	public static Sprite Buddah = new Sprite(32,7,4,SpriteSheet.tiles);
	public static Sprite Gravel = new Sprite(32,6,5,SpriteSheet.tiles);
	public static Sprite Gravelmo = new Sprite(32,7,5,SpriteSheet.tiles);
	
	public static Sprite health_bar = new Sprite(3,0,0,SpriteSheet.health);
	
	public static Sprite ripper = new Sprite(96,0,0,SpriteSheet.ripper);
	
	public static Sprite sword_1 = new Sprite(16,0,0,SpriteSheet.sword);
	public static Sprite sword_2 = new Sprite(16,1,0,SpriteSheet.sword);
	
	public static Sprite wallSprite = new Sprite(32,4,1,SpriteSheet.tiles);
	public static Sprite wallSprite_1 = new Sprite(32,1,2,SpriteSheet.tiles);
	public static Sprite wallSprite_2 = new Sprite(32,2,2,SpriteSheet.tiles);
	public static Sprite wallSprite_3 = new Sprite(16,3,3,SpriteSheet.tiles);
	public static Sprite wallSprite_4 = new Sprite(16,4,3,SpriteSheet.tiles);
	
	public static Sprite EmptySlot = new Sprite(16,0,0,SpriteSheet.inventory);
	
	//public static Sprite health = new Sprite(2,0,0,SpriteSheet.ui);
	//public static Sprite stamina = new Sprite(2,1,0,SpriteSheet.ui);
	
	//public static Sprite EmptySlot = new Sprite(16,0,0,SpriteSheet.inventory);
	
	public static Sprite HalfBlackSprite = new Sprite(32,5,0,SpriteSheet.tiles);
	public static Sprite blackSprite = new Sprite(32,4,0,SpriteSheet.tiles);
	public static Sprite healSprite = new Sprite(32,2,3,SpriteSheet.tiles);
	public static Sprite pathSprite = new Sprite(32,1,3,SpriteSheet.tiles);
	
	public static Sprite fanceSprite = new Sprite(32,3,1,SpriteSheet.tiles); // orizontala
	public static Sprite spawnZombie = new Sprite(16,12,12,SpriteSheet.tiles);
	public static Sprite rockpathTile = new Sprite(32,0,2,SpriteSheet.tiles);
	
	public static Sprite grass1Tile = new Sprite(32,5,6,SpriteSheet.tiles);
	public static Sprite grass2Tile = new Sprite(32,6,6,SpriteSheet.tiles);
	public static Sprite grass3Tile = new Sprite(32,7,6,SpriteSheet.tiles);
	
	//public static Sprite HeartSprite = new Sprite(16,0,7,SpriteSheet.player);
	
	//public static Sprite fog = new Sprite(50,0,0,SpriteSheet.fog);
	
	//public static Sprite player_diagonal_1 = new Sprite(16,0,3,SpriteSheet.player);
	
	public static Sprite hit_star = new Sprite(16,2,1,SpriteSheet.eschimo);
	
	public static Sprite bullet_1 = new Sprite(6,0,0,SpriteSheet.bullets);
	public static Sprite bullet_2 = new Sprite(6,1,0,SpriteSheet.bullets);
	public static Sprite bullet_3 = new Sprite(6,2,0,SpriteSheet.bullets);
	public static Sprite bullet_4 = new Sprite(6,3,0,SpriteSheet.bullets);
	public static Sprite bullet_5 = new Sprite(6,0,1,SpriteSheet.bullets);
	
	public static Sprite eschimo_down = new Sprite(16,0,0,SpriteSheet.eschimo);
	public static Sprite eschimo_down_1 = new Sprite(16,1,0,SpriteSheet.eschimo);
	public static Sprite eschimo_down_2 = new Sprite(16,2,0,SpriteSheet.eschimo);
	public static Sprite eschimo_side = new Sprite(16,0,1,SpriteSheet.eschimo);
	public static Sprite eschimo_side_1 = new Sprite(16,1,1,SpriteSheet.eschimo);
	public static Sprite eschimo_up = new Sprite(16,0,2,SpriteSheet.eschimo);
	public static Sprite eschimo_up_1 = new Sprite(16,1,2,SpriteSheet.eschimo);
	public static Sprite eschimo_up_2 = new Sprite(16,2,2,SpriteSheet.eschimo);

	public static Sprite ghost_down = new Sprite(16,0,0,SpriteSheet.ghost);
	public static Sprite ghost_down_1 = new Sprite(16,1,0,SpriteSheet.ghost);
	public static Sprite ghost_down_2 = new Sprite(16,2,0,SpriteSheet.ghost);
	public static Sprite ghost_side = new Sprite(16,0,1,SpriteSheet.ghost);
	public static Sprite ghost_side_1 = new Sprite(16,1,1,SpriteSheet.ghost);
	public static Sprite ghost_up = new Sprite(16,0,2,SpriteSheet.ghost);
	public static Sprite ghost_up_1 = new Sprite(16,1,2,SpriteSheet.ghost);
	public static Sprite ghost_up_2 = new Sprite(16,2,2,SpriteSheet.ghost);
	
	public static Sprite player_up = new Sprite(18,0,0,SpriteSheet.player2);
	public static Sprite player_up_1 = new Sprite(18,0,1,SpriteSheet.player2);
	public static Sprite player_up_2 = new Sprite(18,0,2,SpriteSheet.player2);
	public static Sprite player_up_breath = new Sprite(18,3,6,SpriteSheet.player2);
	
	public static Sprite player_down = new Sprite(18,2,0,SpriteSheet.player2);
	public static Sprite player_down_1 = new Sprite(18,2,1,SpriteSheet.player2);
	public static Sprite player_down_2 = new Sprite(18,2,2,SpriteSheet.player2);
	public static Sprite player_down_breath = new Sprite(18,2,6,SpriteSheet.player2);
	
	public static Sprite player_side = new Sprite(18,1,0,SpriteSheet.player2);
	public static Sprite player_side_1 = new Sprite(18,1,1,SpriteSheet.player2);
	public static Sprite player_side_2 = new Sprite(18,0,6,SpriteSheet.player2);
	public static Sprite player_side_3 = new Sprite(18,1,6,SpriteSheet.player2);
	
	public static Sprite player_head_helm = new Sprite(18,4,2,SpriteSheet.player2);
	
	public static Sprite player_side_down = new Sprite(18,4,4,SpriteSheet.player2);
	public static Sprite player_side_down_2 = new Sprite(18,5,4,SpriteSheet.player2);
	public static Sprite player_side_down_3 = new Sprite(18,4,6,SpriteSheet.player2);
	public static Sprite player_side_down_breath = new Sprite(18,5,6,SpriteSheet.player2);
	
	
	public static Sprite player_side_up = new Sprite(18,4,3,SpriteSheet.player2);
	public static Sprite player_side_up_2 = new Sprite(18,5,3,SpriteSheet.player2);
	public static Sprite player_side_up_3 = new Sprite(18,6,6,SpriteSheet.player2);
	public static Sprite player_side_up_breath = new Sprite(18,7,6,SpriteSheet.player2);
	
	public static Sprite player_water_down = new Sprite(18,3,0,SpriteSheet.player2);
	public static Sprite player_water_down_1 = new Sprite(18,3,1,SpriteSheet.player2);
	public static Sprite player_water_side = new Sprite(18,4,0,SpriteSheet.player2);
	public static Sprite player_water_side_1 = new Sprite(18,4,1,SpriteSheet.player2);
	public static Sprite player_water_up = new Sprite(18,5,0,SpriteSheet.player2);
	public static Sprite player_water_up_2 = new Sprite(18,5,1,SpriteSheet.player2);
	 
	public static Sprite player_shadow = new Sprite(18,5,5,SpriteSheet.player2);
	
	public static Sprite player_climb_up = new Sprite(18,3,2,SpriteSheet.player2);
	public static Sprite player_climb_up_2 = new Sprite(18,3,3,SpriteSheet.player2);
	public static Sprite player_climb_up_3 = new Sprite(18,3,4,SpriteSheet.player2);
	
	public static Sprite player_climb_side = new Sprite(18,1,4,SpriteSheet.player2);
	public static Sprite player_climb_side_1 = new Sprite(18,1,5,SpriteSheet.player2);
	
	public static Sprite playerp_water_down = new Sprite(18,2,5,SpriteSheet.player2);
	public static Sprite playerp_water_down_1 = new Sprite(18,3,5,SpriteSheet.player2);
	public static Sprite playerp_water_side = new Sprite(18,4,5,SpriteSheet.player2);
	public static Sprite playerp_water_side_1 = new Sprite(18,5,5,SpriteSheet.player2);
	public static Sprite playerp_water_up = new Sprite(18,5,0,SpriteSheet.player2);
	
	public static Sprite player_pistol_down = new Sprite(18,2,3,SpriteSheet.player2);
	public static Sprite player_pistol_down_2 = new Sprite(18,2,4,SpriteSheet.player2);
	public static Sprite player_pistol_down_3 = new Sprite(18,2,5,SpriteSheet.player2);
	
	public static Sprite player_pistol_side = new Sprite(18,1,2,SpriteSheet.player2);
	public static Sprite player_pistol_side_2 = new Sprite(18,1,3,SpriteSheet.player2);
	
	public static Sprite player_pistol_up = new Sprite(18,0,3,SpriteSheet.player2);
	public static Sprite player_pistol_up_2 = new Sprite(18,0,4,SpriteSheet.player2);
	public static Sprite player_pistol_up_3 = new Sprite(18,0,5,SpriteSheet.player2);
	
	public static Sprite player_sword_down = new Sprite(18,1,8,SpriteSheet.player2);
	public static Sprite player_sword_left = new Sprite(18,0,8,SpriteSheet.player2);
	public static Sprite player_sword_right = new Sprite(18,2,8,SpriteSheet.player2);
	
	public static Sprite shoot_wizard = new Sprite(18,0,4,SpriteSheet.player);
	public static Sprite shoot_fist_down = new Sprite(16,1,4,SpriteSheet.player);
	public static Sprite shoot_fist_right = new Sprite(16,2,4,SpriteSheet.player);
	public static Sprite shoot_fist_left = new Sprite(16,3,4,SpriteSheet.player);
	public static Sprite shoot_fist_up = new Sprite(16,0,5,SpriteSheet.player);
	public static Sprite shoot_fist_rUp = new Sprite(16,0,6,SpriteSheet.player);
	public static Sprite shoot_fist_lUp = new Sprite(16,1,6,SpriteSheet.player);
	public static Sprite shoot_fist_lDown = new Sprite(16,2,6,SpriteSheet.player);
	public static Sprite shoot_fist_rDown = new Sprite(16,3,6,SpriteSheet.player);
	
	public static Sprite gun_side = new Sprite(18,0,7,SpriteSheet.player2);
	public static Sprite gun_top = new Sprite(18,2,7,SpriteSheet.player2);
	public static Sprite gun_diag = new Sprite(18,1,7,SpriteSheet.player2);
	public static Sprite gun_diag_up = new Sprite(18,4,7,SpriteSheet.player2);
	public static Sprite gun_up = new Sprite(18,3,7,SpriteSheet.player2);
	public static Sprite gun_down = new Sprite(18,5,7,SpriteSheet.player2);
	
	public static Sprite player_new = new Sprite(18,0,0,SpriteSheet.player3);
	
	public static Sprite Dust = new Sprite(18,4,5,SpriteSheet.player2);
	
	public static Sprite zombie_down = new Sprite(16,0,0,SpriteSheet.zombie);
	public static Sprite zombie_down_1 = new Sprite(16,1,0,SpriteSheet.zombie);
	public static Sprite zombie_down_2 = new Sprite(16,2,0,SpriteSheet.zombie);
	
	public static Sprite zombie_up = new Sprite(16,0,2,SpriteSheet.zombie);
	public static Sprite zombie_up_1 = new Sprite(16,1,2,SpriteSheet.zombie);
	
	public static Sprite zombie_side = new Sprite(16,0,1,SpriteSheet.zombie);
	public static Sprite zombie_side_1 = new Sprite(16,1,1,SpriteSheet.zombie);
	
	/////////////new body skeleton
	//head classic
	public static Sprite player_head_down = new Sprite(18,0,0,SpriteSheet.heads);
	public static Sprite player_head_up = new Sprite(18,4,0,SpriteSheet.heads);
	public static Sprite player_head_Rup = new Sprite(18,3,0,SpriteSheet.heads);
	public static Sprite player_head_Lup = new Sprite(18,5,0,SpriteSheet.heads);
	public static Sprite player_head_Rdown = new Sprite(18,1,0,SpriteSheet.heads);
	public static Sprite player_head_Ldown = new Sprite(18,7,0,SpriteSheet.heads);
	public static Sprite player_head_left = new Sprite(18,6,0,SpriteSheet.heads);
	public static Sprite player_head_right = new Sprite(18,2,0,SpriteSheet.heads);
	
	//arms classic
	public static Sprite arms_classic_down = new Sprite(18,0,0,SpriteSheet.arms);
	public static Sprite arms_classic_up = new Sprite(18,4,0,SpriteSheet.arms);
	public static Sprite arms_classic_Rup = new Sprite(18,3,0,SpriteSheet.arms);
	public static Sprite arms_classic_Lup = new Sprite(18,5,0,SpriteSheet.arms);
	public static Sprite arms_classic_Rdown = new Sprite(18,1,0,SpriteSheet.arms);
	public static Sprite arms_classic_Ldown = new Sprite(18,7,0,SpriteSheet.arms);
	public static Sprite arms_classic_left = new Sprite(18,6,0,SpriteSheet.arms);
	public static Sprite arms_classic_right = new Sprite(18,2,0,SpriteSheet.arms); 
	public static Sprite arms_classic_right_run = new Sprite(18,9,0,SpriteSheet.arms);
	public static Sprite arms_classic_down_run = new Sprite(18,8,0,SpriteSheet.arms);
	public static Sprite arms_classic_left_run = new Sprite(18,11,0,SpriteSheet.arms);
	public static Sprite arms_classic_up_run = new Sprite(18,10,0,SpriteSheet.arms);
	//public static Sprite arms_classic_ = new Sprite(18,2,0,SpriteSheet.arms); 
	
	//legs classic
	public static Sprite legs_classic_down = new Sprite(18,0,0,SpriteSheet.legs);
	public static Sprite legs_classic_up = new Sprite(18,4,0,SpriteSheet.legs);
	public static Sprite legs_classic_Rup = new Sprite(18,3,0,SpriteSheet.legs); 
	public static Sprite legs_classic_Lup = new Sprite(18,5,0,SpriteSheet.legs);
	public static Sprite legs_classic_Rdown = new Sprite(18,1,0,SpriteSheet.legs);
	public static Sprite legs_classic_Ldown = new Sprite(18,7,0,SpriteSheet.legs);
	public static Sprite legs_classic_left = new Sprite(18,6,0,SpriteSheet.legs);
	public static Sprite legs_classic_right = new Sprite(18,2,0,SpriteSheet.legs);
	public static Sprite legs_classic_right_run = new Sprite(18,9,0,SpriteSheet.legs);
	public static Sprite legs_classic_down_run = new Sprite(18,8,0,SpriteSheet.legs);
	public static Sprite legs_classic_left_run = new Sprite(18,11,0,SpriteSheet.legs);
	public static Sprite legs_classic_up_run = new Sprite(18,10,0,SpriteSheet.legs);
	
	//armor head
	public static Sprite armor_head_down = new Sprite(18,0,1,SpriteSheet.heads);
	public static Sprite armor_head_up = new Sprite(18,4,1,SpriteSheet.heads);
	public static Sprite armor_head_Rup = new Sprite(18,3,1,SpriteSheet.heads);
	public static Sprite armor_head_Lup = new Sprite(18,5,1,SpriteSheet.heads);
	public static Sprite armor_head_Rdown = new Sprite(18,1,1,SpriteSheet.heads);
	public static Sprite armor_head_Ldown = new Sprite(18,7,1,SpriteSheet.heads);
	public static Sprite armor_head_left = new Sprite(18,6,1,SpriteSheet.heads);
	public static Sprite armor_head_right = new Sprite(18,2,1,SpriteSheet.heads);
	
	//body classic
	public static Sprite player_body_down = new Sprite(18,0,0,SpriteSheet.bodies);
	public static Sprite player_body_up = new Sprite(18,4,0,SpriteSheet.bodies);
	public static Sprite player_body_Rup = new Sprite(18,3,0,SpriteSheet.bodies);
	public static Sprite player_body_Lup = new Sprite(18,5,0,SpriteSheet.bodies);
	public static Sprite player_body_Rdown = new Sprite(18,1,0,SpriteSheet.bodies);
	public static Sprite player_body_Ldown = new Sprite(18,7,0,SpriteSheet.bodies);
	public static Sprite player_body_left = new Sprite(18,6,0,SpriteSheet.bodies);
	public static Sprite player_body_right = new Sprite(18,2,0,SpriteSheet.bodies);
	
	//body camouflage
	public static Sprite body_camo_down = new Sprite(18,0,1,SpriteSheet.bodies);
	public static Sprite body_camo_up = new Sprite(18,4,1,SpriteSheet.bodies);
	public static Sprite body_camo_Rup = new Sprite(18,3,1,SpriteSheet.bodies);
	public static Sprite body_camo_Lup = new Sprite(18,5,1,SpriteSheet.bodies);
	public static Sprite body_camo_Rdown = new Sprite(18,1,1,SpriteSheet.bodies);
	public static Sprite body_camo_Ldown = new Sprite(18,7,1,SpriteSheet.bodies);
	public static Sprite body_camo_left = new Sprite(18,6,1,SpriteSheet.bodies);
	public static Sprite body_camo_right = new Sprite(18,2,1,SpriteSheet.bodies);
	
	public static Sprite player_hands_front = new Sprite(18,9,1,SpriteSheet.player2);
	public static Sprite player_feet_front = new Sprite(18,10,1,SpriteSheet.player2);
	
	//sword weapon
	public static Sprite sword_left = new Sprite(18,0,0,SpriteSheet.weapons);
	public static Sprite sword_right = new Sprite(18,2,0,SpriteSheet.weapons);
	public static Sprite sword_down_left = new Sprite(18,1,0,SpriteSheet.weapons);
	public static Sprite sword_down_right = new Sprite(18,3,0,SpriteSheet.weapons);
	public static Sprite sword_up_right = new Sprite(18,4,0,SpriteSheet.weapons);
	public static Sprite sword_up_left = new Sprite(18,5,0,SpriteSheet.weapons);
	public static Sprite sword_up = new Sprite(18,6,0,SpriteSheet.weapons);
	public static Sprite sword_down = new Sprite(18,7,0,SpriteSheet.weapons);
	public static Sprite sword_back = new Sprite(18,8,0,SpriteSheet.weapons);
	
	public Sprite(SpriteSheet sheet,int width,int height){
		SIZE = (width == height) ? width : -1;
		this.width = width;
		this.height = height;
		this.sheet = sheet;
	}
	
	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		load();
	}

	public Sprite(int[] pixels ,int width, int height){
		SIZE = (width == height) ? width : -1;
		this.width = width;
		this.height = height;
		this.pixels = new int[width*height];
		for(int i =0;i < pixels.length;i++){
			this.pixels[i] = pixels[i];
		}
	}
	
	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}
	
	
	public static Sprite[] split(SpriteSheet sheet){
		int amount = (sheet.getWidth() * sheet.getHeight()) / (sheet.SPRITE_WIDTH * sheet.SPRITE_HEIGHT);
		Sprite[] sprites = new Sprite[amount];
		int position = 0;
		int[] pixels = new int[sheet.SPRITE_WIDTH * sheet.SPRITE_HEIGHT];
		
		for(int ypos = 0; ypos < sheet.getHeight() / sheet.SPRITE_HEIGHT; ypos++){
			for(int xpos = 0; xpos < sheet.getWidth() / sheet.SPRITE_WIDTH; xpos++){
				
				for(int y = 0; y < sheet.SPRITE_HEIGHT ;y++){
					for(int x = 0; x < sheet.SPRITE_WIDTH ;x++){
						int xo = x + xpos * sheet.SPRITE_WIDTH;
						int yo = y + ypos * sheet.SPRITE_HEIGHT;
						
						pixels[x+y*sheet.SPRITE_WIDTH] = sheet.getPixels()[xo + yo * sheet.getWidth()];
					}
				}
				
				sprites[position++] = new Sprite(pixels ,sheet.SPRITE_WIDTH ,sheet.SPRITE_HEIGHT);
			}
		}
		
		return sprites;
	}
	
	
	private void load() {
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SPRITE_WIDTH];
			}
		}
	}

}
