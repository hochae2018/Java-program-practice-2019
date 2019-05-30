package fgame;

import java.awt.image.BufferedImage;

public class Airplane extends FlyingObject implements Enemy {
	protected static BufferedImage[] airplaneImgs;
	public Airplane(){
		
	}
	public Airplane(BufferedImage image){
		super(49,36);
		this.image = image;
		life = 1;
	}
	@Override
	public void move() {
		y+=ySpeed;
		
	}
	@Override
	public int getScore() {
		return 56;
		
	}
	public BufferedImage getImg(){
		if(isLife()){
			return image;
		}else{
			if(i<airplaneImgs.length){
				BufferedImage image = airplaneImgs[i++];
				return image;
			}else{
				return null;
			}
		}
	}
	public boolean isDelete(){
		return life==0&&i==airplaneImgs.length;
	}
}
