package model;

import java.util.ArrayList;

public class Entities {
    private ArrayList<Entity> liste;

    public Entities(){
        liste = new ArrayList<Entity>() ;
        liste.add(new Map(0,0,1920*2,1080*2));
        liste.add(new Entity(0,0,100,100));
        liste.add(new Entity(300, 300,100,70));
        liste.add(new MonstreTest(700,300,110,110));
        liste.add(new MonstreTest(500,0,20,20));
        liste.add(new Player( 1920/4 , 1080/4));
    }

    public Entity get_by_id(int id){
        return liste.get(id);
    }

    public int size(){
        return liste.size();
    }

    public Entity get_player(){
        return liste.get(this.size()-1);
    }

    public void player_move(int x,int y,Entities entities){
        for(int i=0;i<this.size();i++){
            this.get_by_id(i).move_relative(-x, -y,entities);
        }
    }
}
