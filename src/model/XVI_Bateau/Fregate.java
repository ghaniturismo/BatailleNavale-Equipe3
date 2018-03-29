package model.XVI_Bateau;

import model.Bateau;

public class Fregate extends Bateau{

	public static final int TAILLE = 3;
	
	public Fregate() {
		super("Fregate", TAILLE);
	}
	@Override
	protected Bateau Copy() {
		
		Fregate clone = new Fregate();
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
