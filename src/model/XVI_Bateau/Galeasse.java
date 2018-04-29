package model.XVI_Bateau;

import model.Bateau;

public class Galeasse extends Bateau{

	public static final int TAILLE = 2;
	
	public Galeasse() {
		super("Galeasse", TAILLE);
	}
	
	@Override
	protected Bateau copy() {
		
		Galeasse clone = new Galeasse();
	    clone.setX(this.getX());
	    clone.setY(this.getY());
	    clone.setVertical(this.isVertical());
	    if(!this.getCases().isEmpty())
	    	clone.setCases();
	    
	    return clone;
	}
}
