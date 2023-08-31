package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Dragon extends SuperObject {
	public OBJ_Dragon() {
		
		name = "Dragon";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/dragontotem.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
