package model.XVI_Bateau;

import model.Bateau;

public class Galion extends Bateau{

	public static final int TAILLE = 3;
	
	public Galion() {
		super("Galion", TAILLE);
	}

	@Override
	protected Bateau Copy() {
		
		Galion clone = new Galion();
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
