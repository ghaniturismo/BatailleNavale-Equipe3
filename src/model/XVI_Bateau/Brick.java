package model.XVI_Bateau;

import model.Bateau;

public class Brick extends Bateau{

	public static final int TAILLE = 1;
	
	public Brick() {
		super("Brick", TAILLE);
	}

	@Override
	protected Bateau copy() {
		
	    Brick clone = new Brick();
	    clone.setX(this.getX());
	    clone.setY(this.getY());
	    clone.setVertical(this.isVertical());
	    if(!this.getCases().isEmpty())
	    	clone.setCases();
	    
	    return clone;
	}

}
