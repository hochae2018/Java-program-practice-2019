package fgame;

import java.awt.image.BufferedImage;

public class Hero extends FlyingObject{
	protected static BufferedImage[] heroExps;
	protected int fire = 1;
	public Hero() {
		
	}
	public Hero(BufferedImage image){
		super(97,124,200,500);
		this.image = image;
		life = 3;
	}
	public void move(int x ,int y) {
		this.x =x;
		this.y = y;
	}
	@Override
	public void move() {
		
	}
	public void add(Bee b){
		if(b.award()==1){
			life++;
		}
		if(b.award()==0){
			fire =20;
		}
	}
	public Bullet[] shootBullets() {
		int x =(int)(this.x+(w/2-8/2));
		int y =(int)(this.y - 14);

		if(fire == 1){
			Bullet b = new Bullet(x, y, -1.5);
			return new Bullet[]{b};
		}else{
			fire--;
			Bullet b1 = new Bullet(x+10,y, -1.5);
			Bullet b2 = new Bullet(x-10,y, -1.5);
			return new Bullet[]{b1,b2};
		}
	}
	public BufferedImage getImg(){
		if(isLife()){
			return image;
		}else{
			if(i<heroExps.length){
				BufferedImage image=heroExps[i++];
				return image;
			}
			else{
				return null;
			}
		}
	}
	public boolean isDelete(){
		return life==0&&i==heroExps.length;
	}
}
