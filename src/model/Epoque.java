package model;

import java.util.ArrayList;

public class Epoque {
	


	////////////////////////////// VARIABLES //////////////////////////////////

	private int nb_ship;
	private String name;
	private ArrayList<Bateau> ships;
	
	
    ///////////////////////////// CONSTRUCTEUR ////////////////////////////////

	public Epoque(){
		//vide
	}
	
	public Epoque (String name){
		this.name = name;
		nb_ship = 0;
		ships = new ArrayList<Bateau>();
	}
	
	public void addShip(Bateau b){
		if(!ships.contains(b)){
			ships.add(b);
			nb_ship++;
		}
		
	}
	
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
