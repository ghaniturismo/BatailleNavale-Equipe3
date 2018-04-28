package model;

import java.util.ArrayList;

/**
 * Classe Intelligent 
 * gere la strategie 'Intelligent'
 */
public class Intelligent implements IA_Strategy{
	
    ////////////////////////////// VARIABLES //////////////////////////////////
	
	private final String name = "Intelligent";
	
    ///////////////////////////// CONSTRUCTEUR ////////////////////////////////
	/**
	 * Constructeur sans parametre
	 */
	public Intelligent(){
		
	}
	
	/**
	 * Methode shootCase
	 * teste si le bateau est touche
	 * @param shoot la case a tester
	 * @param worldPlayer la carte du joueur
	 */
	public void shootCase(Case shoot, World worldPlayer){
		if(worldPlayer.shipHit(shoot.getX(), shoot.getY(), true)) {
			shoot.hit();
			worldPlayer.updateShip(shoot);
		}
		
		worldPlayer.addShoot(shoot);
		
	}
	

	/**
	 * Methode shoot
	 * effectue un tir
	 * @param worldPlayer la carte du joueur
	 */
	public void shoot(World worldPlayer) {
		
		if(isHit(worldPlayer.getShoots())){
			ArrayList<Case> hits = getHits(worldPlayer.getShoots());
			
			for(int i=0; i<hits.size(); i++) {
				if(!worldPlayer.getShipAt(hits.get(i)).isDead()){
					int x1 = hits.get(i).getX()-1;
					int y1 = hits.get(i).getY()-1;
					int x2 = hits.get(i).getX()+1;
					int y2 = hits.get(i).getY()+1;
					
					if (!worldPlayer.caseTaken(x1, hits.get(i).getY()) && x1 >= 1) {
						Case shoot = new Case(x1, hits.get(i).getY());
						shootCase(shoot, worldPlayer);
						return;
					}
					else {
						if(!worldPlayer.caseTaken(x2, hits.get(i).getY()) && x2 <= worldPlayer.getNbRows()){
							Case shoot = new Case(x2, hits.get(i).getY());
							shootCase(shoot, worldPlayer);
							return;
						}
						else{ 
							if(!worldPlayer.caseTaken(hits.get(i).getX(), y1) && y1 >= 1){
								Case shoot = new Case(hits.get(i).getX(), y1);
								shootCase(shoot, worldPlayer);
								return;
							}
							else{
								if(!worldPlayer.caseTaken(hits.get(i).getX(), y2) && y2 <= worldPlayer.getNbCols()){
									Case shoot = new Case(hits.get(i).getX(), y2);
									shootCase(shoot, worldPlayer);
									return;
								}
							}
						}
					}
				}
			}
		}
		
		boolean tir = false;
		
		while (!tir) {
			int x = 1 + (int) (Math.random() * worldPlayer.getNbRows());
			int y = 1 + (int) (Math.random() * worldPlayer.getNbCols());

			if (!worldPlayer.caseTaken(x, y)) {
				Case shoot = new Case(x, y);
				shootCase(shoot, worldPlayer);
				
				tir = true;
			}
		}
		
	}
	
	
	/**
	 * Methode getHits
	 * liste les cases touchees
	 * @param list la liste des cases du jeu
	 * @return la liste des cases touchees 
	 */
	private ArrayList<Case> getHits(ArrayList<Case> list) {
		ArrayList<Case> hits = new ArrayList<Case>();
		for(int i = 0; i < list.size(); i++){
			if(list.get(i).isHit())
				hits.add(list.get(i));
		}
		return hits;
	}

	/**
	 * Methode isHit
	 * @param list la liste (getShoots -> size=1) des cases
	 * @return true si la case est touchee
	 * 		   false sinon
	 */
	public boolean isHit(ArrayList<Case> list){
		for(int i=0; i<list.size(); i++){
			if(list.get(i).isHit())
				return true;
		}
		return false;
	}
	
	public String getName() {
		return name;
		
	}

}
