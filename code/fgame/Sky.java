package fgame;

import java.awt.image.BufferedImage;

public class Sky extends FlyingObject {
	double yy;
	public Sky(){
		
	}
	public Sky(BufferedImage image){
		super(480,852,0,0);	
		this.image = image;
		yy=-h;
	}
	//
	public void move(){
		y += ySpeed;
		yy += ySpeed;
		if(y>=h){
			y = -h;
		}
		if(yy>=h){
			yy = -h;
		}
	}
	
}
