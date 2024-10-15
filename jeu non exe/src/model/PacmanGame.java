package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
	public void evolve(Cmd commande , Entities entities) {
		//System.out.println("("+String.valueOf(entities.get_player().get_x())+","+String.valueOf(entities.get_player().get_y())+")");
		//System.out.println("Execute "+commande);

		switch (commande) {
			case IDLE:
				break;
			case UP:
				entities.player_move(0,-entities.get_player().get_speed(),entities);
				break;
			case DOWN:
				entities.player_move(0,entities.get_player().get_speed(),entities);
				break;
			case LEFT:
				entities.player_move(-entities.get_player().get_speed(),0,entities);
				break;
			case RIGHT:
				entities.player_move(entities.get_player().get_speed(),0,entities);
				break;
		}

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
