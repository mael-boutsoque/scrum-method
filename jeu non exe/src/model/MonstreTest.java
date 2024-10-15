package model;

public class MonstreTest extends Entity{
	MonstreTest(int x,int y){
		super(x,y);
		   image_path = "model\\images\\OuroudjSama.png";
	        this.load_image();
	        this.load_hitbox();
	}
	
	public void evolve(Entities entities) {
		
		this.move(-1,0,entities);
		
	}
		
}
