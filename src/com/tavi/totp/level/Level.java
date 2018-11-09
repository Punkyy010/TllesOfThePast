package com.tavi.totp.level;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import com.tavi.totp.Game;
import com.tavi.totp.entity.mob.CoinParticle;
import com.tavi.totp.entity.mob.Entity;
import com.tavi.totp.entity.mob.Ghost;
import com.tavi.totp.entity.mob.Mob;
import com.tavi.totp.entity.mob.Pagan;
import com.tavi.totp.entity.mob.Particle;
import com.tavi.totp.entity.mob.Player;
import com.tavi.totp.entity.mob.Steps;
import com.tavi.totp.entity.mob.Zombie;
import com.tavi.totp.entity.projectile.Projectile;
import com.tavi.totp.graphics.Screen;
import com.tavi.totp.level.tile.Tile;
import com.tavi.totp.sound.Sound;

public class Level {

	Projectile projectile;
	Entity entity;
	public static int width;
	public static int height;
	protected int[] tilesInt;
	protected int[] tiles;
	public boolean animated = false;
	public int anim = 0;
	public Player player;
	public static int mobmoney = 0;
	private int spawn_counter = 0;
	private Comparator<Entity> spriteSorter = new Comparator<Entity>() {
		public int compare(Entity e0, Entity e1) {
			if (e1.y < e0.y) return +1;
			if (e1.y > e0.y) return -1;
			return 0;
		}

	};
	
	private static final int GRASS_COL = 0xFF00FF00;
	private static final int WALLTILE_COL = 0xFF404040;
	private static final int WALLTILE2_COL = 0xFFA0A0A0;
	private static final int WATER_COL = 0xFF1B7EFF;
	private static final int TREEBOTTOM_COL = 0xFF267F00;
	private static final int FLOWER_COL = 0xFFFFFF00;
	private static final int DOOR_COL = 0xFF7F3F3F;
	private static final int VINE_COL = 0xFFDAFF7F;
	private static final int HEAL_COL = 0xFFFF0000;
	private static final int FANCE_COL = 0xFFC0C0C0;
	private static final int TREETOP_COL = 0xFF267F00;
	private static final int DIRTWALL_COL = 0xFF603F2C;
	private static final int DIRTSTAIRS_COL = 0xFF6D4E3C;
	private static final int CAVEFLOOR_COL = 0xFF555555;
	private static final int CAVEORE_COL = 0xFFD3D3D3;
	private static final int DIRTCENTER_COL = 0xFFBC8869;
	private static final int DIRTCORNER_COL = 0xFFA8795E;
	private static final int DIRTSIDE_COL = 0xFF996E55;
	private static final int DIRTTOP_COL = 0xFF8C654E;
	private static final int ELEVATEDGRASS_COL = 0xFF23D132;
	private static final int WATERCORNER2_COL = 0xFF519FFF;
	private static final int COLUMN_COL = 0xFFADACAE;
	private static final int BUDDAH_COL = 0xFF694938;
	private static final int GRAVEL_COL = 0xFF6D7075;
	private static final int GRAVELMO_COL = 0xFF3F4346;

	
	private Random random = new Random();

	public static boolean mobReady = false;
	public static boolean killed = false;
	public static int kills = 0;
	public static int spawned = 0;
	
	public List<Entity>[] entitiesInTiles;

	public List<Entity> entities = new ArrayList<Entity>();
	public List<Entity> projectiles = new ArrayList<Entity>();
	public List<Player> players = new ArrayList<Player>();
	private List<Entity> particles = new ArrayList<Entity>();
	private List<Entity> steps = new ArrayList<Entity>();
	//private List<Tile> tiless = new ArrayList<Tile>();
	Random r = new Random();
	
	
	public Level(int width, int height) {
		Level.width = width;
		Level.height = height;
		
		
		generateLevel();
		
		//tilesInt = new int[width * height];
	}
	
	public void sortAndRender(Screen screen , List<Entity> list){
		Collections.sort(list,spriteSorter);
		for(int i = 0 ; i < list.size();i++){
			list.get(i).render(screen);
		}
	}
	
	public boolean tileCollision(int x ,int y,double xa, double ya,int size) {
		boolean stop = false;
		for (int c = 0; c < 4; c++) {
			int xt = (int)((x + xa) + c % 2 * size +5) >> 5;
			int yt = (int)((y + ya) + c / 2 * size +5) >> 5;
			if (getTile(xt, yt).mayPass(this, yt, yt, projectile)) stop = true;
		}
		return stop;
	}
	
	public Level(String path) {
		loadLevel(path);
		generateLevel();
		entitiesInTiles = new ArrayList[width * height];
		for (int i = 0; i < width * height; i++) {
			entitiesInTiles[i] = new ArrayList<Entity>();
			//System.out.println("yeee");
		}
	}

	protected void generateLevel() {
	}

	protected void loadLevel(String path) {

	}

	public void update() {
	
		while(spawn_counter != 20) {
		
			Spawn(10);
			spawn_counter++;
			
		}
		
	
		
		for (int i = 0; i < entities.size(); i++) {
			Entity e = entities.get(i);
			int xto = (int)e.x >> 5;
			int yto = (int)e.y >> 5;
			
	
			if(e.health <= (e.health_now * 75) /100){
				e.health_ratio--;
				e.health_now = e.health;
			}
			
			//System.out.println(projectiles.size());
			
			//if(player.x == entity instanceof Zombie){
			//	player.health--;
			//}
			
			//entities.indexOf(zombie.x) && player.x == entities.indexOf(zombie.y)
			e.update();

			 Random random = new Random();
			 
			// mobmoney = 0;
			if (e instanceof Zombie || e instanceof Pagan || e instanceof Ghost){
				if(e.removed) {
					mobmoney = random.nextInt(3);
					killed = true;
					kills++;
					if(e instanceof CoinParticle)
						Sound.pickup.play();
					entities.remove(i--);
					removeEntity(xto, yto, e);
				} else {
					int xt = (int)e.x >> 5;
					int yt = (int)e.y >> 5;
					killed = false;
	
					if (xto != xt || yto != yt) {
						removeEntity(xto, yto, e);
						insertEntity(xt, yt, e);
					}
				}
			}else{
				if(e.removed) {
					if(e instanceof CoinParticle)
						Sound.pickup.play();
					entities.remove(i--);
					removeEntity(xto, yto, e);
				} else {
					int xt =(int) e.x >> 5;
					int yt = (int)e.y >> 5;
					killed = false;
	
					if (xto != xt || yto != yt) {
						removeEntity(xto, yto, e);
						insertEntity(xt, yt, e);
					}
				}
			}			
			
       }
		
	}
	
	public List<Player> getPlayers(){
		return players;
	}
	
	public void Spawn(int count){
		Mob mob = null;
		//for(int i = 0;i < count;i++){
			
			int level = Game.currentLevel;
			
			if (random.nextInt(2) == 0 && Game.currentLevel == 0)
				mob = new Pagan(level);
			else if(random.nextInt(2) == 1  && Game.currentLevel == 1)
				mob = new Ghost(level);
			else if(random.nextInt(2) == 1  && Game.currentLevel == 2)
				mob = new Ghost(level);
			else if(random.nextInt(2) == 1  && Game.currentLevel == 3)
				mob = new Ghost(level);
		
			
			
			if(mob != null && mob.findStartPos(this)){
				this.add(mob);
			}
		//}
	}
	
	
	//private List<Entity> rowSprites = new ArrayList<Entity>();
	
	private List<Entity> rowSprite = new ArrayList<Entity>();
	
	public void renderSprites(Screen screen,int xScroll,int yScroll){
		int x0 = xScroll >> 5;
		int x1 = (xScroll + screen.width + 32) >> 5;
		int y0 = yScroll >> 5;
		int y1 = (yScroll + screen.height + 32) >> 5;
		//int w = (screen.width + 31) >> 5;
		//int h = (screen.height + 31) >> 5;
		
		screen.setOffset(xScroll, yScroll);
	
		for(int y = y0;y <= y1;y++){
			for(int x = x0;x <= x1; x++){
				if(x < 0 || y < 0 || x >= width || y >= height) continue;
				rowSprite.addAll(entitiesInTiles[x + y * width]);
				rowSprite.addAll(projectiles);
				rowSprite.addAll(steps);
				if(rowSprite.size() > 0){
					sortAndRender(screen,rowSprite);
				}
			}
			rowSprite.clear();
			
		}
		screen.setOffset(0, 0);
		
	}
	
	public void renderBackground(int xScroll, int yScroll, Screen screen) {
		
		int x0 = xScroll >> 5;
		int x1 = (xScroll + screen.width + 32) >> 5;
		int y0 = yScroll >> 5;
		int y1 = (yScroll + screen.height + 32) >> 5;
		
		screen.setOffset(xScroll, yScroll);
		
		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).render(x, y, screen);
				getShadow(x, y).render(x, y, screen);
				getTileOver(x, y).render(x, y, screen);
				//System.out.println("te");
			}
		}
		screen.setOffset(0, 0);
	}
	
	public List<Entity> getProjectiles(){
		return projectiles;
	}
	
	public void add(Entity entity) {
		if(entity instanceof Player){
			player = (Player) entity;
		}else if (entity instanceof Particle) {
			particles.add((Particle) entity);
		}else if (entity instanceof Projectile) {
			projectiles.add((Projectile) entity);
		}else if(entity instanceof Steps){
			steps.add((Steps) entity);
		}
			entity.removed = false;
			entities.add(entity);
			entity.init(this);
			
			insertEntity((int)entity.x >> 5, (int)entity.y >> 5, entity);
		
	}

	public void remove(Entity e){
		
		e.removed = true;
		entities.remove(e);
		int xto = (int)e.x >> 5;
		int yto = (int)e.y >> 5;
		
		removeEntity(xto, yto, e);
	}
	
	private void insertEntity(int x, int y, Entity e) {
		if (x < 0 || y < 0 || x >= width || y >= height) return;
		entitiesInTiles[x + y * width].add(e);
		//System.out.println("tep");
	}

	private void removeEntity(int x, int y, Entity e) {
		if (x < 0 || y < 0 || x >= width || y >= height) return;
		entitiesInTiles[x + y * width].remove(e);
		
	}
	
	public List<Entity> getEntities(int x0, int y0, int x1, int y1) {
		List<Entity> result = new ArrayList<Entity>();
		int xt0 = (x0 >> 5) - 1; // x-obiectu 1 impartit la marimea unui tile
		int yt0 = (y0 >> 5) - 1;
		int xt1 = (x1 >> 5) + 1;
		int yt1 = (y1 >> 5) + 1;
		for (int y = yt0; y <= yt1; y++) { //
			for (int x = xt0; x <= xt1; x++) {
				if (x < 0 || y < 0 || x >= width || y >= height) continue;
				List<Entity> entities = entitiesInTiles[x + y * width];
				for (int i = 0; i < entities.size(); i++) {
					Entity e = entities.get(i);
					if (e.intersects(x0, y0, x1, y1)) result.add(e);
				}
			}
		}
		return result;
	}
	  
	public List<Player> getPlayers(Entity e, int radius) {
		List<Player> result = new ArrayList<Player>();
		int ex = (int)e.getX();
		int ey = (int)e.getY();
		for (int i = 0; i< players.size(); i++) {
			//System.out.println(players.size());
			Player player = players.get(i);
			int x = (int)player.getX();
			int y = (int)player.getY();
			int dx = Math.abs(x - ex);
			int dy = Math.abs(y - ey);
			double distance = Math.sqrt((dx * dx) + (dy * dy));
			if (distance <= radius) result.add(player);
		}
		return result;
	}
	
	  
	  public void setTile(int x,int y ,Tile t){
		  if (x < 0 || y < 0 || x >= Level.width || y >= Level.height) return;
		  tiles[x + y * width] = t.getId();
	  }

	// Grass = 0xFF00FF00
	// Flower = 0xFFFFFF00
	// Rock = 0xFF7F7F00
	// WALL = 0xFF808080
	  
	  int randomGrass = r.nextInt(2);
	  
	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= Level.width || y >= Level.height) return Tile.transTile;
		
		Tile.flip = 0;
		if(tiles[x + y * width] == FLOWER_COL) return Tile.flowerTile;
		if(tiles[x + y * width] == ELEVATEDGRASS_COL) return Tile.elevatedGrassTile;
		Tile.flip = 0;
		if (tiles[x + y * width] == WALLTILE_COL) return Tile.wallTile;
		Tile.flip = 0;
		if (tiles[x + y * width] == WALLTILE2_COL) return Tile.wallTile_1;
		Tile.flip = 0;
		if (tiles[x + y * width] == 0xFF606060) return Tile.wallTile_2;
		Tile.flip = 0;
		if(tiles[x + y * width] == 0xFF000000) return Tile.blackTile;
		Tile.flip = 0;
		if (tiles[x + y * width] == BUDDAH_COL)  return Tile.BuddahTile;
		Tile.flip = 0;
		if (tiles[x + y * width] == GRASS_COL)  return Tile.grassOver;
		Tile.flip = 0;
		if(tiles[x + y * width] == TREEBOTTOM_COL) return Tile.treebtmTile;
		Tile.flip = 0;
		if (tiles[x + y * width] == FLOWER_COL) return Tile.flowerTile;
		Tile.flip = 0;
		if (tiles[x + y * width] == COLUMN_COL) return Tile.ColumnTile;
		Tile.flip = 0;
		if (tiles[x + y * width] == GRAVEL_COL) return Tile.gravelTile;
		Tile.flip = 0;
		if (tiles[x + y * width] == GRAVELMO_COL) return Tile.gravelmoTile;
		Tile.flip = 0;
		if (tiles[x + y * width] == DOOR_COL) return Tile.doorTile;
		Tile.flip = 0;
		if (tiles[x + y * width] == VINE_COL) return Tile.vineTile;
		Tile.flip = 0;
		if(tiles[x + y * width] == CAVEFLOOR_COL) return Tile.caveFloorTile;
		Tile.flip = 0;
		if(tiles[x + y * width] == CAVEORE_COL) return Tile.caveOreTile;
		Tile.flip = 0;
		if(tiles[x + y * width] == DIRTCENTER_COL) return Tile.dirtCenterTile;
		Tile.flip = 0;
		if(tiles[x + y * width] == DIRTCORNER_COL && tiles[(x+1) + y * width] == DIRTTOP_COL && tiles[x + (y-1) * width] == DIRTSIDE_COL){
			Tile.flip = 3;
			return Tile.dirtCornerTile;
		}
		Tile.flip = 0;
		
		
		//if (tiles[x + y * width] == WATER_COL) return Tile.waterTile_1;
		if (tiles[x + y * width] == WATER_COL) return Tile.waterTile;
		if(tiles[x + y * width] == WATERCORNER2_COL) return Tile.waterTile;
		if (tiles[x + y * width] == 0xFFFFFFFF) return Tile.spawnTile;
		if(tiles[x + y * width] == 0xFF808080) return Tile.rockpathTile;
		if(tiles[x + y * width] == HEAL_COL) return Tile.healTile;
		if(tiles[x + y * width] == 0xFFFFD1B5 || tiles[x + y * width] == 0xFF2D2D2D || tiles[x + y * width] == 0xFF000000) return Tile.pathTile;
		if(tiles[x + y * width] == FANCE_COL)	return Tile.fanceTile;
		if(tiles[x + y * width] == 0xFF7F3300) return Tile.holeTile;
		if(tiles[x + y * width] == DIRTWALL_COL && tiles[(x-1) + y * width] == ELEVATEDGRASS_COL ){
			return Tile.dirtWallSideTile;
		}
		Tile.flip = 0;
		if(tiles[x + y * width] == DIRTWALL_COL && tiles[(x+1) + y * width] == ELEVATEDGRASS_COL){
			Tile.flip = 1;
			return Tile.dirtWallSideTile;
		}
		Tile.flip = 0;
		
		Tile.flip = 0;
		if(tiles[x + y * width] == DIRTWALL_COL && tiles[(x - 1) + y * width] != DIRTWALL_COL && tiles[(x - 1) + y * width] != DIRTSTAIRS_COL){
			return Tile.dirtWallCurveTile;
		}
		Tile.flip = 0;
		if(tiles[x + y * width] == DIRTWALL_COL && tiles[(x + 1) + y * width] != DIRTWALL_COL && tiles[(x + 1) + y * width] != DIRTSTAIRS_COL){
			Tile.flip = 1;
			return Tile.dirtWallCurveTile;
		}
		if(tiles[x + y * width] == DIRTWALL_COL) return Tile.dirtWallTile;
		if(tiles[x + y * width] == DIRTSTAIRS_COL) return Tile.dirtStairsTile;
		
		
		return Tile.transTile;
	}
	
	public Tile getShadow(int x,int y){
		if(x < 0 || y < 0 || x >= width || y >= height) return Tile.transTile;
		
		//if ((tiles[x + (y-1) * width] == 0xFFC0C0C0 || tiles[x + (y-1) * width] == 0xFF606060 || tiles[x + (y-1) * width] == 0xFFA0A0A0) && (tiles[x + y * width] == 0xFF808080 || tiles[x + y * width] == 0xFF00FF00 || tiles[x + y * width] == 0xFFFFD1B5)) return Tile.shadowTile;
		
		
		return Tile.transTile;
		
	}
	
	public Tile getTileOver(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height) return Tile.transTile;
		Tile.flip=0;
		
		if(tiles[x + y * width] == DIRTCORNER_COL && tiles[(x-1) + y * width] == DIRTTOP_COL && tiles[x + (y+1) * width] == DIRTSIDE_COL){
			Tile.flip = 0;
			return Tile.dirtCornerTile;
		}
		Tile.flip = 0;
		
		if(tiles[x + y * width] == DIRTCORNER_COL && tiles[(x+1) + y * width] == DIRTTOP_COL && tiles[x + (y+1) * width] == DIRTSIDE_COL){
			Tile.flip = 1;
			return Tile.dirtCornerTile;
		}
		Tile.flip = 0;
		
		if(tiles[x + y * width] == DIRTCORNER_COL && tiles[(x-1) + y * width] == DIRTTOP_COL && tiles[x + (y-1) * width] == DIRTSIDE_COL){
			Tile.flip = 2;
			return Tile.dirtCornerTile;
		}
		Tile.flip = 0;
		
		if(tiles[x + y * width] == DIRTSIDE_COL && tiles[(x-1) + y * width] == DIRTCENTER_COL) return Tile.dirtSideTile;
		if(tiles[x + y * width] == DIRTSIDE_COL && tiles[(x+1) + y * width] == DIRTCENTER_COL){
			Tile.flip = 1;
			return Tile.dirtSideTile;
		}
		Tile.flip = 0;
		
		
		if(tiles[x + y * width] == DIRTTOP_COL && tiles[x + (y+1) * width] == DIRTCENTER_COL) return Tile.dirtTopTile;
		if(tiles[x + y * width] == DIRTTOP_COL && tiles[x + (y-1) * width] == DIRTCENTER_COL){
			Tile.flip = 3;
			return Tile.dirtTopTile;
		}
		Tile.flip = 0;
		
		//WATER
		
		if(tiles[x + y * width] == WATER_COL && tiles[(x-1) + y * width] == GRASS_COL && tiles[x + (y-1) * width] == GRASS_COL){
			Tile.flip = 1;
			return Tile.waterCornerTile;
		}
		Tile.flip = 0;
		
		if(tiles[x + y * width] == WATER_COL && tiles[(x-1) + y * width] == GRASS_COL && tiles[x + (y+1) * width] == GRASS_COL){
			Tile.flip = 3;
			return Tile.waterCornerTile;
		}
		Tile.flip = 0;
		
		if(tiles[x + y * width] == WATER_COL && tiles[(x+1) + y * width] == GRASS_COL && tiles[x + (y+1) * width] == GRASS_COL){
			Tile.flip = 2;
			return Tile.waterCornerTile;
		}
		Tile.flip = 0;
		
		if(tiles[x + y * width] == WATER_COL && tiles[(x+1) + y * width] == GRASS_COL && tiles[x + (y-1) * width] == GRASS_COL){
			Tile.flip = 4;
			return Tile.waterCornerTile;
		}
		Tile.flip = 0;
		
		if(tiles[x + y * width] == WATER_COL && tiles[(x+1) + y * width] == GRASS_COL) return Tile.waterSideTile;
		if(tiles[x + y * width] == WATER_COL && tiles[(x-1) + y * width] == GRASS_COL){
			Tile.flip = 1;
			return Tile.waterSideTile;
		}
		Tile.flip = 0;
		
		if(tiles[x + y * width] == WATER_COL && tiles[x + (y-1) * width] == GRASS_COL ) return Tile.waterTopTile;
		if(tiles[x + y * width] == WATER_COL && tiles[x + (y+1) * width] == GRASS_COL ){
			Tile.flip = 3;
			return Tile.waterTopTile;
		}
		Tile.flip = 0;
		
		if(tiles[x + y * width] == WATERCORNER2_COL && tiles[(x+1) + (y-1) * width] == GRASS_COL ) return Tile.waterCorner2Tile;
		if(tiles[x + y * width] == WATERCORNER2_COL && tiles[(x-1) + (y-1) * width] == GRASS_COL ){
			Tile.flip = 1;
			return Tile.waterCorner2Tile;
		}
		Tile.flip = 0;
		if(tiles[x + y * width] == WATERCORNER2_COL && tiles[(x+1) + (y+1) * width] == GRASS_COL ){
			Tile.flip = 2;
			return Tile.waterCorner2Tile;
		}
		Tile.flip = 0;
		if(tiles[x + y * width] == WATERCORNER2_COL && tiles[(x-1) + (y+1) * width] == GRASS_COL ){
			Tile.flip = 3;
			return Tile.waterCorner2Tile;
		}
		Tile.flip = 0;
		//WATER finish
		
		if(tiles[x + y * width] == TREETOP_COL) return Tile.treetopTile;
		//if (tiles[x + y * width] == 0xFF000000) return Tile.caveTile;
		if (tiles[x + y * width] == WALLTILE_COL) return Tile.wallTile;
		//if (tiles[x + y * width] == HEAL_COL) return Tile.healTile;
		if(tiles[x + y * width] == 0xFF2D2D2D) return Tile.entrTile;
		return Tile.transTile;
	}

}
