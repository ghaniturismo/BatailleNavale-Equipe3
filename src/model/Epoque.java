package model;

import java.util.ArrayList;

/**
 * Classe Epoque
 * gere l epoque du jeu
 */
public class Epoque {
	


	////////////////////////////// VARIABLES //////////////////////////////////

	private int nb_ship; //nombre de bateaux
	private String name; //nom de l epoque
	private ArrayList<Bateau> ships; //liste des bateau de l epoque
	
	
    ///////////////////////////// CONSTRUCTEUR ////////////////////////////////
	public Epoque() {
		
	}
	
	
	/**
	 * Constructeur avec l epoque donnee
	 * @param name le nom de l eqoque
	 */
	public Epoque (String name){
		this.name = name;
		nb_ship = 0;
		ships = new ArrayList<Bateau>();
	}
	
	
	/**
	 * Methode addShip
	 * ajoute un bateau a une epoque
	 * @param b le bateau a ajouter
	 */
	public void addShip(Bateau b){
		if(!ships.contains(b)){
			ships.add(b);
			nb_ship++;
		}
		
	}
	
	
	///GETTERS AND SETTERS
	public ArrayList<Bateau> getShips(){
		return ships;
	}
	
	public void setShips(ArrayList<Bateau> ships) {
		this.ships = ships;
	}
	/*
	 * return le nom de l'epoque
	 */
	public String getName(){
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*
	 * return le nombre de bateau.
	 */
	public int getNbShip(){
		return nb_ship;
	}
	
}
