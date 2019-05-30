package fgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

//import day16.*;


public class Shijie extends JPanel{
	private int state=READY;
	private static final int READY =-1;
	private static final int START =1;
	private static final int PAUSE =2;
	private static final int GAME_OVER =3;
	private static int SCORE = 0;
	private FlyingObject a;
	private int nums =-1 ;
	private Bullet b;
	private int record = 0;
	private int i = 0;
	private Sky sky;
	private Hero hero;
	private Bigplane eneBig;
	private Bigplane[] eneBigs;

	private Bullet[] bullets;
	private int ji =1;
	//Airplane,Bee
	private FlyingObject[] enemys;
	private static BufferedImage startImg;
	private static BufferedImage pauseImg;
	private static BufferedImage gameoverImg;
	private static BufferedImage bgImg;
	private static BufferedImage[] heroImgs;
	private static BufferedImage[] heroExps;
	private static BufferedImage bulletImg;
	private static BufferedImage airplaneImg;
	private static BufferedImage[] airplaneImgs;
	private static BufferedImage bigplaneImg;
	private static BufferedImage[] bigplaneImgs;
	private static BufferedImage beeImg;
	private static BufferedImage[] beeImgs;

	static {
		beeImg =loadImage("bee.png");
		beeImgs=new BufferedImage[4];
		for(int i=0; i<beeImgs.length; i++) {
			beeImgs[i]=loadImage("bee_ember"+i+".png");
		}
		bigplaneImg =loadImage("bigplane.png");
		bigplaneImgs = new BufferedImage[4];
		for(int i = 0;i<bigplaneImgs.length;i++){
			bigplaneImgs[i] =loadImage("bigplane_ember"+i+".png");
		}
		bgImg = loadImage("background.png");
		heroImgs=new BufferedImage[2];
		for(int i=0; i<heroImgs.length; i++) {
			heroImgs[i]=loadImage("hero"+i+".png");
		}
		heroExps=new BufferedImage[4];
		for(int i=0; i<heroExps.length; i++) {
			heroExps[i]=loadImage("hero_ember"+i+".png");
		}
		bulletImg = loadImage("bullet.png");
		airplaneImg = loadImage("airplane.png");
		airplaneImgs = new BufferedImage[4];
		for(int i=0; i<airplaneImgs.length; i++) {
			airplaneImgs[i]=loadImage("airplane_ember"+i+".png");
		}
		Bullet.img = bulletImg;
		Bigplane.img = bigplaneImg;
		Bigplane.bigplaneImgs = bigplaneImgs;
		//
		Hero.heroExps = heroExps;
		Airplane.airplaneImgs = airplaneImgs;
		Bee.beeImgs = beeImgs;
		startImg = loadImage("start.png");
		pauseImg = loadImage("pause.png");
		gameoverImg = loadImage("gameover.png");
	}

	public static BufferedImage loadImage(String name) {
		BufferedImage img;
		img=null;
		try {
			img=ImageIO.read(Shijie.class
					.getClassLoader()
					.getResource(
					"fgame/picture/"+name));
					//name));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}

	public void paint(Graphics g) {
		g.drawImage(sky.image, (int)sky.x, (int)sky.y, null);
		g.drawImage(sky.image, (int)sky.x, (int)sky.yy, null);
		g.drawImage(hero.getImg(), (int)hero.x, (int)hero.y, null);
		for(int i = 0; i<bullets.length;i++){
			g.drawImage(bullets[i].image, (int)bullets[i].x,(int)bullets[i].y,null);
		}
		for(int i=0;i<enemys.length;i++){
			g.drawImage(enemys[i].getImg(), (int)enemys[i].x,(int)enemys[i].y,null);
		}
		//
		for(int i=0;i<eneBigs.length;i++){
			g.drawImage(eneBigs[i].getImg(), (int)eneBigs[i].x,(int)eneBigs[i].y,null);
		}
		g.setColor(Color.blue);
		g.drawString("your score: "+ SCORE, 50, 50);
		g.drawString("your life: "+ hero.life, 50, 70);
		switch(state){
		case READY:
			g.drawImage(startImg, 0,0, null);
			break;
		case PAUSE:
			g.drawImage(pauseImg, 0,0, null);
			break;
		case GAME_OVER:
			g.drawImage(gameoverImg, 0,0, null);
			break;
		}
	}
	public void action() {
		sky = new Sky(bgImg);
		MouseAction ma = new MouseAction();
		//
		addMouseListener(ma);
		addMouseMotionListener(ma);
		hero = new Hero(heroImgs[0]);
		//
		bullets = new Bullet[0];
		enemys = new FlyingObject[0];
		//
		eneBigs = new Bigplane[0];
		//eneBig.eneBullets;
		Timer timer = new Timer();
		Mytask task = new Mytask();
		timer.schedule(task, 0,50);
	}
	//
	public void fire(){

		if(i%10==0) {
			//
			Bullet[] bs = hero.shootBullets();

			//
			bullets = Arrays.copyOf(bullets, bullets.length+bs.length);
			//
			System.arraycopy(bs, 0, bullets, bullets.length-bs.length, bs.length);
		}

		//
		for(int j=0; j<eneBigs.length; j++) {
			if(i%10==0) {
				Bullet[] bs = eneBigs[j].shootBullets();
				if (bs == null)
					continue;
				bullets = Arrays.copyOf(bullets, bullets.length + bs.length);
				//
				System.arraycopy(bs, 0, bullets, bullets.length - bs.length, bs.length);
			}
		}
	}

	//
	//
	public void creatPlane(){
		if(i%20==0){
			int born = (int)(Math.random()*6);
			if(born==3){
				a = new Bee(beeImg);
			}else{
				a = new Airplane(airplaneImg);
			}
			enemys = Arrays.copyOf(enemys, enemys.length+1);
			//
			enemys[enemys.length-1] = a;
			}
			//
	}
	//
	public boolean creatBig(){
		//
		if(record%100==0){
			eneBig = new Bigplane(bigplaneImg);
			ji++;
			nums++;
			eneBigs = Arrays.copyOf(eneBigs, eneBigs.length+1);
			eneBigs[eneBigs.length-1] = eneBig;
			System.out.println(nums);
			System.out.println(eneBigs.length);
			}
			return true;
		}
	//
	//
	int ii;
	int j;
	public void duangDuang(Hero h){
		FlyingObject obj;
		Bigplane big;
		for(ii=0;ii<bullets.length;ii++){
			//
			//
			Bullet bullet = bullets[ii];
			for(j=0;j<enemys.length;j++){
				 obj = enemys[j];
				if(obj.isLife()&&bullet.Duang(obj)){
					obj.hit();
					if(obj.life==0){
						obj.goDead();
						countScore(obj);
						break;
					}
					bullet.goDead();
					break;
				}
			}
			for(int i = 0;i<eneBigs.length;i++){
				big = eneBigs[i];
				if(big.isLife()&&bullet.Duang(big)){
					big.hit();
					if(big.life ==0){
						big.goDead();
						countScore(big);
						break;
					}
					bullet.goDead();
					break;
				}
			}
		}
		for(int x =0; x<enemys.length;x++){
				obj = enemys[x];
			if(obj.isLife()&&h.Duang(obj)){
				h.hit();
				if(h.life==0){
					h.goDead();
				}
				obj.goDead();
				break;
			}
		}
		for(int y = 0;y<eneBigs.length;y++){
			big = eneBigs[y];
			if(big.isLife()&&hero.Duang(big)){
				h.hit();
				if(h.life==0){
					h.goDead();
				}
				big.goDead();
				break;
			}
		}
		for(int y = 0;y<bullets.length;y++){
			if (bullets[y] == null)
				continue;
			if(hero.Duang(bullets[y])){
				h.hit();
				if(h.life==0){
					h.goDead();
				}
				bullets[y].goDead();
				break;
			}
		}
	}
	public void moveObject(){
		for(int i = 0;i<enemys.length;i++){
			enemys[i].move();
		}
		for(int i = 0;i<bullets.length;i++){
			//
			bullets[i].move();
		}
		for(int i = 0;i<eneBigs.length;i++ ){
			eneBigs[i].move();
		}

	}

	public void removeObject(){
		FlyingObject[] arr = new FlyingObject[enemys.length];
		int index=0;
		for(int i = 0;i<enemys.length;i++){
			if (!enemys[i].isDelete()){
					arr[index++] = enemys[i];
			}
		}
		//
		enemys = Arrays.copyOf(arr,index);
	}
	public void removeBullet(){
		Bullet[] arr = new Bullet[bullets.length];
		int index = 0;
		for(int j = 0;j<bullets.length;j++){
			if(bullets[j] != null && bullets[j].isLife()){
				arr[index++] = bullets[j];
			}
		}
		bullets = Arrays.copyOf(arr, index);
	}
	public boolean removeHero(){
		if(hero.isDelete()){
			return true;
		}else{
			return false;
		}
	}
	//

	public void countScore(FlyingObject obj){
		System.out.println("a");
		if(obj.isLife()){
			return;
		}
		//
		if(obj instanceof Enemy){
			//
			Enemy e =(Enemy)obj;
			SCORE+= e.getScore();
			System.out.println("b");
		}
		if(obj instanceof Bee){
			Bee b = (Bee)obj;
			hero.add(b);
		}
	}
	public void checkOver(){
		if(removeHero()){
			state = GAME_OVER;
		}
	}
	public void checkOut(FlyingObject obj,FlyingObject bullet){
		for(int i =0;i<enemys.length;i++){
			obj = enemys[i];
			if(obj.y>720&&obj.isLife()){
				obj = null;
			}
		}
		for(int i =0;i<bullets.length;i++){
			bullet = bullets[i];
			if(bullet.y<-20&&bullet.isLife()){
				bullet = null;
			}
		}

	}
	public static void main(String[] args) {
		//
		//JFrame frame = new JFrame("飞机大战");
		JFrame frame = new JFrame("test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(480, 700);
		frame.setLocationRelativeTo(null);
		//
		Shijie world = new Shijie();
		world.action();//
		frame.add(world);
		frame.setVisible(true);
	}

	class Mytask extends TimerTask{
		public void run(){
			if(state == START) {
				i++;
				record++;
				sky.move();
				moveObject();
				fire();
				creatBig();
				creatPlane();
				duangDuang(hero);
				removeObject();
				removeBullet();
				removeHero();
				//removeEneb();
				checkOver();
				checkOut(a,b);
				repaint();
			}
		}
	}

	class MouseAction extends MouseAdapter{
		//
		public void mouseExited(MouseEvent e) {
			//
			switch (state) {
			case START:
				state = PAUSE;
			}
		}
		public void mouseEntered(MouseEvent e) {
			switch (state) {
			case PAUSE:
				state = START;
			}
		}
		public void mouseClicked(MouseEvent e) {
			switch (state) {
			//
			case READY:
				state = START;
				break;
			case GAME_OVER:
				hero = new Hero(heroImgs[0]);
				bullets = new Bullet[0];
				enemys = new FlyingObject[0];
				SCORE = 0;
				state = READY;
				break;
			}
		}
		public void mouseMoved(MouseEvent e){
			switch(state) {
			case START:
				int x = e.getX();
				int y = e.getY();
				hero.move(x, y);
			}
		}

	}

}//world






