package model.strategy;

import model.Case;
import model.World;

/**
 * Classe Aleatoire
 * gere la stratégie aleatoire de l IA
 *
 */
public class AleatoireStrategy implements IA_Strategy {

    ////////////////////////////// VARIABLES //////////////////////////////////

	private final String name = "Aleatoire";

    ///////////////////////////// CONSTRUCTEUR ////////////////////////////////

	
	public AleatoireStrategy(){
		//vide
	}

	/**
	 * Methode shoot
	 * effectue un tir dans le jeu
	 */
	public void shoot(World worldPlayer) {
		
		boolean tir = false;
		while (!tir) {
			int x = 1 + (int) (Math.random() * worldPlayer.getNbRows());
			int y = 1 + (int) (Math.random() * worldPlayer.getNbCols());

			if (!worldPlayer.caseTaken(x, y)) {
				Case shoot = new Case(x, y);

				if(worldPlayer.shipHit(x, y, true)) {
					shoot.hit();
				}
				
				worldPlayer.addShoot(shoot);
				tir = true;
			}
		}
	}
	
	public String getName() {
		return name;		
	}
	
}
