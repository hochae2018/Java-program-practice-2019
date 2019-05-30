package fgame;

import java.awt.image.BufferedImage;
//import day16.*;

public class Bullet extends FlyingObject {
	static BufferedImage img;
	public Bullet(){

	}
	/*public Bullet(BufferedImage image){
		super(8,14,150,124);
		this.image = image;
	}*/
	public Bullet(int x,int y, double speed){
		super(8,14, x, y);
		this.image = Bullet.img;
		life = 1;
		ySpeed = speed;
	}
	@Override
	public void move() {
		y += ySpeed * 8;
	}
//	public void move(String x) {
//		y +=12;
//	}
}
