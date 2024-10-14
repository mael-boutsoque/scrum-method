package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import engine.GamePainter;

/**
 * @author Horatiu Cirstea, Vincent Thomas
 *
 * afficheur graphique pour le game
 * 
 */
public class PacmanPainter implements GamePainter {

	/**
	 * la taille des cases
	 */
	protected static final int WIDTH = 1920/2;
	protected static final int HEIGHT = 1080/2;

	private int x=0;
	private int y=0;
	private int i=0;
	private int id_color=0;
	private ArrayList<Color> colorList = new ArrayList<Color>();

	/**
	 * appelle constructeur parent
	 * 
	 * @param game
	 *            le jeutest a afficher
	 */
	public PacmanPainter() {
		colorList.add(Color.BLACK);
		colorList.add(Color.BLUE);
		colorList.add(Color.GREEN);
		colorList.add(Color.MAGENTA);
		colorList.add(Color.ORANGE);
		colorList.add(Color.PINK);
		colorList.add(Color.PINK);
		colorList.add(Color.YELLOW);
		this.x=20;
		this.y=20;
	}

	/**
	 * methode  redefinie de Afficheur retourne une image du jeu
	 */
	@Override
	public void draw(BufferedImage im , Entities entities) {
		if(id_color>=colorList.size()-1) id_color=0;
		else id_color += 1;

		Graphics2D crayon = (Graphics2D) im.getGraphics();
		crayon.setColor(colorList.get(id_color));
		crayon.fillOval(x,y,10,10);
		crayon.setColor(Color.BLACK);
		crayon.drawString(String.valueOf(i),10,10);
		i += 1;


		// parcour les entities pour les dessiner
		for(int i=0;i<entities.size();i++){
			Entity entitee = entities.get_by_id(i);
			crayon.drawImage(entitee.get_image(), entitee.get_x(), entitee.get_y(), entitee.get_width(), entitee.get_height(), null, null);
		}
	}

	@Override
	public int getWidth() {
		return WIDTH;
	}

	@Override
	public int getHeight() {
		return HEIGHT;
	}

	public void set_pos(int x,int y){
		this.x = x;
		this.y = y;
	}

}
