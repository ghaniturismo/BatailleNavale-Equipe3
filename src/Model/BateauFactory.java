package Model;


import Model.XVI_Bateau.*;
import Model.XX_Bateau.*;



public class BateauFactory {

	
	public Bateau getBateau(String nom){
		switch(nom){
			//XX_Bateau
			case "ContreTorpieur" : return new ContreTorpilleur();	
			case "Croiseur" : return new Croiseur();
			case "PorteAvion" : return new PorteAvion(); 
			case "SousMarin" : return new SousMarin();
			case "Torpieur" : return new Torpilleur();
			//XVI_Bateau
			case "Brick" : return new Brick();
			case "Fregate" : return new Fregate();
			case "Galeasse" : return new Galeasse();
			case "Galion" : return new Galion();
			case "NavireDeLigne" : return new NavireDeLigne();
			
			default : return null;
		}
	}
	
	
}