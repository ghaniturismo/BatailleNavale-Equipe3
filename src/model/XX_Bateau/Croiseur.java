/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.XX_Bateau;

import model.Bateau;

/**
 *
 * @author karim
 */
public class Croiseur extends Bateau {

	public static final int TAILLE = 4;
	
	public Croiseur() {
		super("Croiseur", TAILLE);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Bateau copy() {
		
		Croiseur clone = new Croiseur();
	    clone.setX(this.getX());
	    clone.setY(this.getY());
	    clone.setVertical(this.isVertical());
	    if(!this.getCases().isEmpty())
	    	clone.setCases();
	    
	    return clone;
	}
    
}
