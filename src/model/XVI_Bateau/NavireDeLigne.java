package model.XVI_Bateau;

import model.Bateau;

public class NavireDeLigne extends Bateau{

	public static final int TAILLE = 4;
	
	public NavireDeLigne() {
		super("Navire De Ligne", TAILLE);
	}
	
	@Override
	protected Bateau copy() {
		
		NavireDeLigne clone = new NavireDeLigne();
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
