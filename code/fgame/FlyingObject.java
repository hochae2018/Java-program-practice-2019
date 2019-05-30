package fgame;

import java.awt.image.BufferedImage;
//import day16.*;

public abstract class FlyingObject {
	protected int score;
	protected int x;
	protected int y;
	protected int w;
	protected int h;
	protected double ySpeed;
	protected int life = 1;
	BufferedImage image;
	//
	protected int i = 0;
	public FlyingObject() {
		
	}
	//
	public FlyingObject(int w,int h){
		this.w =w;
		this.h =h;
		this.y = -h;
		x = (int)(Math.random()*(480-w));
		ySpeed = (int)(Math.random()*1)+6;
	}
	//
	public FlyingObject(int w,int h,int x,int y){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		ySpeed = 1;
	}
	// abstraction
	public abstract void move();
	// get image
	public BufferedImage getImg(){
		//
		return this.image;
	}
	//
	public boolean Duang(FlyingObject b){
		double x1;
		double x2;
		double y1;
		double y2;
		x1 =x -b.w;
		x2 =x+w;
		y1 =y+h;
		y2 =y-b.h;
		return (b.x>x1&&b.x<x2)&&(b.y<y1&&b.y>y2);
	}
	public boolean isLife(){
		return life>0;
	}
	public boolean goDead(){
		life=0;
		return life<=0;
	}
	public void hit(){
		if(isLife()){
			life--;
		}
		if(life==0){
			//
			i = 0; //
		}
	}
	//
	public boolean isDelete(){
		return life==0;
	}
	
	@Override
	public String toString() {
		return "FlyingObject [x=" + x + ", y=" + y + ", w=" + w + ", h=" + h + ", ySpeed=" + ySpeed + ", image=" + image
				+ "]";
	}
	public FlyingObject[] shootBullets() {
		return null;
	}
	public void move(String x) {
		y +=8;
	}
	
}