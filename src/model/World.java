package model;


import java.util.ArrayList;

import model.Bateau;

public class World {

    ////////////////////////////// VARIABLES //////////////////////////////////
	
	private ArrayList<Case> cases;
	private ArrayList<Bateau> ships;

	private int nbRows, nbCols;
	private int nblives = 0;
	private int nbShip = 0;

	///////////////////////////// CONSTRUCTEUR ////////////////////////////////
	
	public World() {
		cases = new ArrayList<Case>();
		ships = new ArrayList<Bateau>();

		nbRows = 10;
		nbCols = 10;
		
	}
	
	/*
	 * Ajouter le bateau a la liste 
	 * incremente le nbre de vie par la taille du bateau 
	 */
	public void addShip(Bateau bateau) {
		if(!ships.contains(bateau)){
			ships.add(bateau);
			nblives = nblives + bateau.getSize();
			nbShip++;
		}
	}
	/*
	 * Vider les deux liste cases et ships
	 */
	public void clearWorld() {
		cases.clear();
		ships.clear();
		nblives = 0;
		nbShip = 0;
	}

	public boolean caseTaken(int x, int y) {
		
		for (Case s : cases) {
			if (s.getX() == x && s.getY() == y)
				return true;
		}

		return false;
	}

	public boolean shipHit(int x, int y, boolean game) {
		
		for (Bateau bateau : ships) {
			if (!bateau.isVertical()) {
				if(y >= bateau.getY() && y <= bateau.getY() + bateau.getSize()-1 && x == bateau.getX()) {
					if(game) nblives--;
					return true;
				}
			}
			else {
				if(x >= bateau.getX() && x <= bateau.getX() + bateau.getSize()-1 && y == bateau.getY()) {
					if(game) nblives--;
					return true;
				}
			}
		}

		return false;
	}

	/*
	 * Mise a jour des bateaux
	 */
	public void updateShip(Case shoot){
		for(int i=0; i<ships.size(); i++){
			if(ships.get(i).hasCase(shoot)){
				ships.get(i).setCaseHit(shoot);
			}
		}
	}
	
    //**** GETTER/SETTER *****//
	
	public int getNbRows() {
		return nbRows;
	}
	
	public int getNbCols() {
		return nbCols;
	}

	public ArrayList<Bateau> getShips() {
		return ships;
	}

	public ArrayList<Case> getShoots() {
		return cases;
	}

	
	public Bateau getShipAt(Case c){
		
		for(int i=0; i<ships.size(); i++){
			if(ships.get(i).hasCase(c)){
				return ships.get(i);
			}
		}
		return null;
	}
	
	
	/*
	 * return nombre de vie
	 */
	public int getNbLives() {
		return nblives;
	}

	/*
	 * Initialise le nombre de vie 
	 */
	public void setNbLives(int nb) {
		nblives = nb;
	}	
	
	/*
	 * return le nombre de Ship
	 */
	public int getNbBoats() {
		return nbShip;
	}

	public void addShoot(Case shoot) {
		cases.add(shoot);
	}
	
	/*
	 * Recuperer les cases
	 */
	public ArrayList<Case> getCases() {
		return cases;
	}
}
