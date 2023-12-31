package main;

import object.OBJ_Boots;
import object.OBJ_Chest;
import object.OBJ_Door;
import object.OBJ_Dragon;
import object.OBJ_Key;

public class AssetSetter {

	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setObject() {
		
		gp.obj[0] = new OBJ_Key();
		gp.obj[0].worldX = 24 * gp.tileSize;
		gp.obj[0].worldY = 6 * gp.tileSize;
		
		gp.obj[1] = new OBJ_Key();
		gp.obj[1].worldX = 9 * gp.tileSize;
		gp.obj[1].worldY = 30 * gp.tileSize;
		
		gp.obj[2] = new OBJ_Key();
		gp.obj[2].worldX = 36 * gp.tileSize;
		gp.obj[2].worldY = 7 * gp.tileSize;
		
		gp.obj[3] = new OBJ_Door();
		gp.obj[3].worldX = 22 * gp.tileSize;
		gp.obj[3].worldY = 23 * gp.tileSize;
		
		gp.obj[4] = new OBJ_Door();
		gp.obj[4].worldX = 19 * gp.tileSize;
		gp.obj[4].worldY = 6 * gp.tileSize;
		
		gp.obj[5] = new OBJ_Door();
		gp.obj[5].worldX = 38 * gp.tileSize;
		gp.obj[5].worldY = 7 * gp.tileSize;
		
		gp.obj[6] = new OBJ_Chest();
		gp.obj[6].worldX = 21 * gp.tileSize;
		gp.obj[6].worldY = 36 * gp.tileSize;
		
		gp.obj[7] = new OBJ_Boots();
		gp.obj[7].worldX = 29 * gp.tileSize;
		gp.obj[7].worldY = 20 * gp.tileSize;
	
		gp.obj[8] = new OBJ_Dragon();
		gp.obj[8].worldX = 5 * gp.tileSize;
		gp.obj[8].worldY = 15 * gp.tileSize;
	}
}
