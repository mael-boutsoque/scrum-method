package model;

public class Map extends Entity {
    Map(int x,int y){
        super(x,y);
        height = 1000;
        width = 1000;
        image_path = "src\\model\\images\\map.png";
        load_image();
    }
}
