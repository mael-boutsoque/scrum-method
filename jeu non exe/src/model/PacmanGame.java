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
				entities.player_move(0,-entities.get_player().get_speed());
				break;
			case DOWN:
				entities.player_move(0,entities.get_player().get_speed());
				break;
			case LEFT:
				entities.player_move(-entities.get_player().get_speed(),0);
				break;
			case RIGHT:
				entities.player_move(entities.get_player().get_speed(),0);
				break;
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
