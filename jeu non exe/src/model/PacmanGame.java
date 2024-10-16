package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


import engine.Cmd;
import engine.Game;

/**
 * @author Horatiu Cirstea, Vincent Thomas
 *
 *         Version avec personnage qui peut se deplacer. A completer dans les
 *         versions suivantes.
 * 
 */
public class PacmanGame implements Game {

	/**
	 * constructeur avec fichier source pour le help
	 * 
	 */
	public PacmanGame(String source) {
		BufferedReader helpReader;
		try {
			helpReader = new BufferedReader(new FileReader(source));
			String ligne;
			while ((ligne = helpReader.readLine()) != null) {
				System.out.println(ligne);
			}
			helpReader.close();
		} catch (IOException e) {
			System.out.println("Help not available");
		}
	}

	/**
	 * faire evoluer le jeu suite a une commande
	 * 
	 * @param commande
	 */
	@Override
	public void evolve(ArrayList<Cmd> commandes , Entities entities) {
		//System.out.println("("+String.valueOf(entities.get_player().get_x())+","+String.valueOf(entities.get_player().get_y())+")");
		//System.out.println("Execute "+commande);


		//deplacement joueur
		System.out.println(commandes.toString());
		int x=0,y=0;
		Cmd commande = Cmd.IDLE;
		for(int i=0;i<commandes.size();i++){
			commande = commandes.get(i);

			switch (commande) {
				case IDLE:
					break;
				case UP:
					y += -1;
					break;
				case DOWN:
					y += 1;
					break;
				case LEFT:
					x += -1;
					break;
				case RIGHT:
					x += 1;
					break;
			}
		}

		int speed = entities.get_player().get_speed();
		if (entities.get_player().can_move(x*speed, y*speed, entities)){entities.player_move(x*speed, y*speed, entities);}

		// show entities hitbox if collision to debug
		for(int j=0;j<entities.size();j++){
			entities.get_by_id(j).show_hitbox = false;
		}
		for(int i=0;i<entities.size();i++){
			if(entities.get_by_id(i).colidable() && entities.get_player().colide(entities.get_by_id(i))){
				entities.get_by_id(i).show_hitbox = true ;
			}
		}
		entities.get_player().show_hitbox = false;
		
		//fait évoluer les entitiés
		for(int i =0;i<entities.size();i++) {
			entities.get_by_id(i).evolve(entities);
		}
	}

	/**
	 * verifier si le jeu est fini
	 */
	@Override
	public boolean isFinished() {
		// le jeu n'est jamais fini
		return false;
	}

}
