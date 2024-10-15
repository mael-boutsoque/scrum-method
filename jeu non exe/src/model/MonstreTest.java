package model;

public class MonstreTest extends Entity{
	MonstreTest(int x,int y,int width,int height){
		super(x,y,width,height);
		   image_path = "model\\images\\OuroudjSama.png";
	        this.load_image();
	}
	
	public void evolve(Entities entities) {
		
		this.move(-1,0,entities);
		
	}
		
}
