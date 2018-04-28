package model;

/**
 * Interface IA_Strategy
 * definit les fonctions des strategies
 */
public interface IA_Strategy {

	public abstract String getName();
	public abstract void shoot(World worldPlayer);
	
}
