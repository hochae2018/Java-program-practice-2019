package fgame;

import java.awt.image.BufferedImage;
//import day16.*;

public class Bee extends FlyingObject{
	//
	public static BufferedImage[] beeImgs;
	
	int xSpeed = (int)(Math.random()*10);
	public Bee(BufferedImage image){
		super(60,50);
		this.image = image;
		life = 1;
	}

	@Override
	public void move() {
		y+=ySpeed;
		x+=xSpeed;
	}
	//ֻ
	//
	public int award(){
		int per = (int)(Math.random()*10);
		if(per<4){
			return 1;
		}else{
			return 0;
		}
	}
	public BufferedImage getImg(){
		if(isLife()){
			return image;
		}else{
			if(i<beeImgs.length){
				BufferedImage image = beeImgs[i++];
				return image;
			}
			else{
				return null;
			}
		}
	}
	public boolean isDelete(){
		return life==0&&i==beeImgs.length;
	}
}
