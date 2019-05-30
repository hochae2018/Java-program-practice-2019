package fgame;

import java.awt.image.BufferedImage;
import java.util.Arrays;

public class Bigplane extends FlyingObject implements Enemy{
	/**
	 */
	//public Bullet[] eneBullets = new Bullet[0];
	public static BufferedImage[] bigplaneImgs;
	public static BufferedImage img;
	
	public Bigplane(){
		
	}
	public Bigplane(BufferedImage image){
		super(69,99);
		this.image = img;
		this.life = 3;
	}
	@Override
	public void move() {
		y+=5;
		
	}
	@Override
	public int getScore() {
		return 100;
		
	}
	public BufferedImage getImg(){
		if(isLife()){
			//
			return image;
		}else{
			//
			if(i<bigplaneImgs.length){
				BufferedImage image = bigplaneImgs[i++];
				return image;
			}else{
				//ֹͣ
				return null;
			}
		}
	}
	public boolean isDelete(){
		//
		return life==0&&i==bigplaneImgs.length;
	}
	public Bullet[] shootBullets(){
		 if (isDelete())
		        return null;
			int x =(int)(this.x+(w/2-8/2));
			int y =(int)(this.y + 113);
			Bullet b = new Bullet(x, y, 1.2);
			return new Bullet[]{b};
	}
	
	
}
