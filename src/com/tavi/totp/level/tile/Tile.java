 package com.tavi.totp.level.tile;

 import com.tavi.totp.entity.mob.Entity;
import com.tavi.totp.entity.mob.Mob;
import com.tavi.totp.entity.mob.Player;
import com.tavi.totp.graphics.Screen;
import com.tavi.totp.graphics.Sprite;
import com.tavi.totp.level.Level;

public class Tile {

	private byte id;
	public static int flip = 0;
	private Sprite sprite;
	
	
	public static final Tile[] tiles = new Tile[256];
	public static Tile grass = new GrassTile(1,flip);
	public static Tile grass2 = new Grass2Tile(7,flip);
	public static Tile grassOver = new GrassTile(7,flip);
	public static Tile waterTile = new waterTile(2,flip);
	//public static Tile waterTile_1 = new waterTile(3,flip);
	public static Tile flowerTile = new FlowerTile(4,flip);
	public static Tile rockTile = new RockTile(5,flip);
	public static Tile blackTile = new BlackTile(6,flip);
	public static Tile spawnTile = new SpawnTile(8,flip);
	public static Tile fanceTile = new FanceTile(9,flip);
	public static Tile wallTile = new WallTile_1(10,flip);
	public static Tile rockpathTile = new RockPathTile(12,flip);
	public static Tile healthTile = new HealthTile(13,flip);
	public static Tile healTile = new HealTile(14,flip);
	public static Tile vineTile = new VineTile(16,flip);
	public static Tile pathTile = new PathTile(17,flip);
	public static Tile wallTile_1 = new WallTile(18,flip);
	public static Tile wallTile_2 = new WallTile_2(19,flip);
	public static Tile doorTile = new DoorTile(20,flip);
	public static Tile transTile = new TransTile(21,flip);
	public static Tile entrTile = new EntrTile(22,flip);
	public static Tile caveTile = new CaveTile(23,flip);
	public static Tile shadowTile = new ShadowTile(24,flip);
	public static Tile treebtmTile = new TreeBtmTile(25,flip);
	public static Tile treetopTile = new TreeTopTile(25,flip);
	public static Tile holeTile = new HoleTile(26,flip);
	public static Tile dirtStairsTile = new DirtStairsTile(27,flip);
	public static Tile dirtWallTile = new DirtWallTile(28,flip);
	public static Tile dirtWallCurveTile = new DirtWallCurve(29,flip);
	public static Tile dirtWallSideTile = new DirtWallSide(30,flip);
	public static Tile caveFloorTile = new CaveFloorTile(31,flip);
	public static Tile caveOreTile = new caveOreTile(32,flip);
	public static Tile dirtCenterTile = new DirtCenterTile(33,flip);
	public static Tile dirtCornerTile = new DirtCornerTile(34,flip);
	public static Tile dirtSideTile = new DirtSideTile(35,flip);
	public static Tile dirtTopTile = new DirtTopTile(36,flip);
	public static Tile elevatedGrassTile = new ElevatedGrass(37,flip);
	public static Tile waterTopTile = new WaterTopTile(38,flip);
	public static Tile waterSideTile = new WaterSideTile(39,flip);
	public static Tile waterCornerTile = new WaterCornerTile(40,flip);
	public static Tile waterCorner2Tile = new WaterCorner2Tile(41,flip);
	public static Tile blackWallSideTile = new BlackWallSideTile(42,flip);
	public static Tile blackWallTopTile = new BlackWallTopTile(42,flip);
	public static Tile ColumnTile = new ColumnTile(43,flip);
	public static Tile BuddahTile = new BuddahTile(44,flip);
	public static Tile gravelTile = new GravelTile(45,flip);
	public static Tile gravelmoTile = new GravelmoTile(46,flip);
	
	public int x, y;
	boolean removed = false;
	
	public Tile(int id,int flip) {
		this.id= (byte)id;
		Tile.flip = flip;
		tiles[id] = this;
	}
			
	
	public void update() {
		
	}
	
	public void render(int x, int y, Screen screen) {
	
	}
	
	public byte getId(){
		return id;
	}
	
	public boolean solid(){
		return false;
		
	}
	
	public void remove(){
		removed = true;
	}
	
	public int getSpriteSize(){
		return sprite.SIZE;
	}
	
	public boolean interact(Level level, int x, int y,Player player){
		return false;
	}
	
	public void steppedOn(Level level, int xt, int yt, Mob mob) {
	}
	
	public boolean mayPass(Level level, int x, int y, Entity e) {
		return false;
	}

	public boolean swim(Level level, int x, int y, Player player) {
		return false;
	}
	
}
