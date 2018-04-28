package model;


import java.util.ArrayList;

import model.Bateau;


/**
 * Classe World
 * gere le monde (joueur ou IA)
 */
public class World {

    ////////////////////////////// VARIABLES //////////////////////////////////
	
	private ArrayList<Case> cases; // liste des cases
	private ArrayList<Bateau> ships; //listes des bateaux

	private int nbRows, nbCols; 
	private int nblives = 0;
	private int nbShip = 0;

	///////////////////////////// CONSTRUCTEUR ////////////////////////////////
	
	/**
	 * Constructeur par defaut
	 */
	public World() {
		cases = new ArrayList<Case>();
		ships = new ArrayList<Bateau>();

		nbRows = 10;
		nbCols = 10;
		
	}
	
	/**
	 * Methode addShip
	 * Ajouter un bateau a la liste des bateaux 
	 * incremente le nbre de vie par la taille du bateau 
	 * @param bateau le bateau a ajouter
	 */
	public void addShip(Bateau bateau) {
		if(!ships.contains(bateau)){
			ships.add(bateau);
			nblives = nblives + bateau.getSize();
			nbShip++;
		}
	}

	
	/**
	 * Methode clearWorld
	 * vide les deux listes et remets les variables a 0
	 */
	public void clearWorld() {
		cases.clear();
		ships.clear();
		nblives = 0;
		nbShip = 0;
	}

	/**
	 * Methode caseTaken
	 * verifie si une case est deja occupee ou non
	 * @param x l abscisse 
	 * @param y l ordonnee
	 * @return true si la case est prise
	 * 		   false sinon
	 */
	public boolean caseTaken(int x, int y) {
		
		for (Case s : cases) {
			if (s.getX() == x && s.getY() == y)
				return true;
		}

		return false;
	}

	/**
	 * Methode shipHit
	 * teste un bateau est touche a une position donnee
	 * @param x l abscisse a tester
	 * @param y l ordonnee a tester
	 * @param game true si le jeu est en cours
	 * @return true si la positon (x,y) touche un bateau
	 * 		   false sinon
	 */
	public boolean shipHit(int x, int y, boolean game) {
		
		for (Bateau bateau : ships) {
			//si le bateau est horizontal
			if (!bateau.isVertical()) {
				if(y >= bateau.getY() && y <= bateau.getY() + bateau.getSize()-1 && x == bateau.getX()) {
					if(game) nblives--;
					return true;
				}
			}
			//si le bateau est vertical
			else {
				if(x >= bateau.getX() && x <= bateau.getX() + bateau.getSize()-1 && y == bateau.getY()) {
					if(game) nblives--;
					return true;
				}
			}
		}

		return false;
	}


	/**
	 * Methode updateShip
	 * met a jour les bateaux
	 * @param shoot la case modifiee
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
