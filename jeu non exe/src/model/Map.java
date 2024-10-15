package model;

public class Map extends Entity {
    Map(int x,int y,int width,int height){
        super(x,y,width,height);
        this.is_colidable = false;
        image_path = "model\\images\\map.png";
        load_image();
    }
}
