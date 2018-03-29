package model;


import model.XVI_Bateau.*;
import model.XX_Bateau.*;



public class BateauFactory {
	
    ////////////////////////////// VARIABLES //////////////////////////////////
	
	private Brick brick = new Brick();
	private Fregate fregate = new Fregate();
	private Galeasse galeasse = new Galeasse();
	private Galion galion = new Galion();
	private NavireDeLigne navireDeLigne = new NavireDeLigne();
	
	private ContreTorpilleur contreTorpilleur = new ContreTorpilleur();
	private Croiseur croiseur = new Croiseur();
	private PorteAvion porteAvion = new PorteAvion();
	private SousMarin sousMarin = new SousMarin();
	private Torpilleur torpilleur = new Torpilleur();
	
	/*
	 * return le bateau en lui donnant son nom
	 */
	public Bateau getBateau(String nom){
		
		switch(nom){
		
			/*
			 * XX_Bateau
			 */
			case "ContreTorpilleur" : return contreTorpilleur;
			case "Croiseur" : return croiseur;
			case "PorteAvion" : return porteAvion; 
			case "SousMarin" : return sousMarin;
			case "Torpieur" : return torpilleur;
			
			/*
			 * XVI_Bateau
			 */
			case "Brick" : return brick;
			case "Fregate" : return fregate;
			case "Galeasse" : return galeasse;
			case "Galion" : return galion;
			case "NavireDeLigne" : return navireDeLigne;
			
			default : return null;
		
		}
	}
	
	
}