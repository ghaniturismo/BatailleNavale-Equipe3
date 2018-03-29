package model;

import javax.swing.ImageIcon;

import view.ImageFactory;

public class Case {
	
    ////////////////////////////// VARIABLES //////////////////////////////////
	
	private int x;
	private int y;
	private boolean hit;
	
    ///////////////////////////// CONSTRUCTEUR ////////////////////////////////
	
	public Case(int x, int y) {
		this.x = x;
		this.y = y;
		hit = false;
	}
	
	/*
	 * Position x 
	 */
	public int getX(){
		return x;
	}
	
	/*
	 * position y
	 */
	public int getY(){
		return y;
	}
	
	/*
	 * La case est touche
	 */
	public void hit() {
		hit = true;
	}
	
	/*
	 * Connaitre l'etat d'une case si elle est touche ou pas.
	 */
	public boolean isHit() {
		return hit;
	}
	
	/*R
	 * ecuperation de l'image correspond a l'etat de la case
	 */
	public ImageIcon getTexture(ImageFactory imageFactory) {
		if(hit == false)
			return imageFactory.getShoot();
		else
			return imageFactory.getExplosion();
	}
}