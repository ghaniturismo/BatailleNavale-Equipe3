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
public class Torpilleur extends Bateau {
	
	public static final int TAILLE = 2;
	
	public Torpilleur() {
		super("Torpilleur", TAILLE);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Bateau copy() {
		
		Torpilleur clone = new Torpilleur();
	    clone.setX(this.getX());
	    clone.setY(this.getY());
	    clone.setVertical(this.isVertical());
	    if(!this.getCases().isEmpty())
	    	clone.setCases();
	    
	    return clone;
	}
    
}
