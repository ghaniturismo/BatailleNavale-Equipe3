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
public class SousMarin extends Bateau {

	public static final int TAILLE = 3;
	
	public SousMarin() {
		super("Sous-Marin", TAILLE);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Bateau copy() {
		
		SousMarin clone = new SousMarin();
		clone.setForce(this.getForce());
		clone.setRobustesse(this.getRobustesse());
		clone.setNbProjectile(this.getNbProjectile());
	    clone.setX(this.getX());
	    clone.setY(this.getY());
	    clone.setVertical(this.isVertical());
	    if(!this.getCases().isEmpty())
	    	clone.setCases();
	    
	    return clone;
	}
    
}
