package model.XVI_Bateau;

import model.Bateau;

public class Galeasse extends Bateau{

	public static final int TAILLE = 2;
	
	public Galeasse() {
		super("Galeasse", TAILLE);
	}
	
	@Override
	protected Bateau Copy() {
		
		Galeasse clone = new Galeasse();
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
