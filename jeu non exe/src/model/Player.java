package model;

public class Player extends Entity {

    private int speed;

    Player(int x , int y){
        super(x - 30, y - 30);
        width = 60;
        height = 60;

        //chargement image
        image_path = "model\\images\\player.png";
        this.load_image();

        // stats
        this.speed = 3;
    }

    public void move(int x,int y,Entities entities){
        entities.player_move(x, y);
    }

    public void move_relative(int x,int y){
        x -= x;
        y -= y;
        x_relative += x;
        y_relative += y;
    }

    public int get_speed() {
        return speed;
    }

}
