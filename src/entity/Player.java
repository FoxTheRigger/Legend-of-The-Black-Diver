package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{

	GamePanel gp;
	KeyHandler keyH;
	public final int screenX;
	public final int screenY;
	public int hasKey = 0;
	
	public Player(GamePanel gp, KeyHandler keyH) {
		
		this.gp = gp;
		this.keyH = keyH;
		
		screenX = gp.screenWidth/2 - (gp.tileSize/2);
		screenY = gp.screenHeight/2 - (gp.tileSize/2);
		
		
		solidArea = new Rectangle();
		solidArea.x = 8;
		solidArea.y = 16;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.width = 32;
		solidArea.height = 32;
		
		
		setDefaultValues();
		getPlayerImage();
	}
	
	public void setDefaultValues() {
		
		worldX = 200;
		worldY = 245;
		speed =  4;
		direction = "down";
	}
	
	public void getPlayerImage() {
		
		try {
			
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/selim_up.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/selim_up1.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/selim_down.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/selim_down1.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/selim_left.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/selim_left1.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/selim_right1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/selim_right2.png"));
			
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		
		if(keyH.upPressed == true || keyH.downPressed == true ||
				keyH.leftPressed == true || keyH.rightPressed == true) {
			if(keyH.upPressed == true) {
				direction = "up";
			}
			else if(keyH.downPressed == true) {
				direction = "down";
			}
			else if(keyH.leftPressed == true) {
				direction = "left";
			}
			else if(keyH.rightPressed == true) {
				direction = "right";
			}
			// CHECK TILE COLLISiON
			collisionOn = false;
			gp.cC.checkTile(this);
			
			// CHECK OBJECT COLLISION
			int objectIndex = gp.cC.checkObject(this, true);
			pickUpObject(objectIndex);
			// IF COLLISON IS FALSE, THE PLAYER CAN MOVE 
			if(collisionOn == false) {
				
				switch(direction) {
				case "up":
					worldY -= speed;
					break;
				case "down":
					worldY += speed;
					break;
				case "left":
					worldX -= speed;
					break;
				case "right":
					worldX += speed;
					break;
				}
			}
			
			spriteCounter++;
			if(spriteCounter > 10) {
				if(spriteNum == 1) {
					spriteNum = 2;
				}
				else if(spriteNum == 2) {
					spriteNum = 1;
				
				}
				spriteCounter = 0;
			}
		}
		
	}
	
	public void pickUpObject(int i) {
		
		if(i != 999) {
			
			String objectName = gp.obj[i].name;
			
			switch(objectName) {
			case "Key":
				gp.playSE(1);
				hasKey++;
				gp.obj[i] = null;
				System.out.println("Key: " + hasKey);
				gp.ui.showMessage("You picked up a KEY!");
				break;
			case "Door":
				gp.playSE(3);
				if(hasKey > 0) {
					gp.obj[i] = null;
					hasKey--;
					gp.ui.showMessage("You opened the door!");
				} 
				else {
					gp.ui.showMessage("You need a key!");
				}
				
				System.out.println("Key: " + hasKey);
				break;
			case "Chest":
				gp.ui.gameFinished = true;
				gp.stopMusic();
				gp.playSE(4);
				break;
			case "Boots":
				gp.playSE(2);
				speed += 2;
				gp.obj[i] = null;
				gp.ui.showMessage("You feel faster");
				break;
			case "Dragon":
				gp.playSE(5);
				gp.ui.showMessage("I AM A SIMPLE DRAGON...head.");
				break;
			}
		}
	}
	
	public void draw(Graphics2D g2) {
		
		BufferedImage image  = null;
		
		switch(direction) {
		case  "up":
			if(spriteNum == 1) {
				image = up1;
			}
			if(spriteNum == 2) {
				image = up2;
			}
			break;
		case "down":
			if(spriteNum == 1) {
				image = down1;
			}
			if(spriteNum == 2) {
				image = down2;
			}
			break;
		case "left":
			if(spriteNum == 1) {
				image = left1;
			}
			if(spriteNum == 2) {
				image = left2;
			}
			break;
		case "right":
			if(spriteNum == 1) {
				image = right1;
			}
			if(spriteNum == 2) {
				image = right2;
			}
			break;
		}
		g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
		
	}
}
