package controller;


import java.awt.Color;

import model.Game;
import model.Game.Etat;

public class GridController {

	////////////////////////////// VARIABLES //////////////////////////////////

	private Game game;

    ///////////////////////////// CONSTRUCTEUR ////////////////////////////////

	public GridController(Game game) {
		this.game = game;
	}

	/*
	 * Controlleur lors du clic sur les boutons de la grid
	 * en fonction de l'etat actuel du jeux
	 */
	public void clic(int ligne, int colonne) {
		switch(game.getEtat()) {
			case WAIT:			game.setInfo();	break;
			case PLACINGBOATS:	game.placeShip(ligne,colonne);	break;
			case PLAYERTURN:	game.shoot(ligne, colonne);	break;
			case COMPUTERTURN:	break;
			default:	break;
		}		
	}
	
	/*
	 * Pour transforme le bateau verticalement. 
	 */
	public void clicDroit() {
		game.setVertical();
	}
	
	/*
	 * Couleur lors du survole des placements des bateaux dans la grid
	 * 
	 * Vert : autorise, 
	 * rouge : pas possible 
	 */
	public Color mouseOver(int ligne, int colonne) {
		if(game.getEtat() == Etat.PLACINGBOATS)
			if(game.mouseOver(ligne, colonne))
				return Color.GREEN;
			else
				return Color.RED;
		else
			return new Color(0, 0, 0, 0);
	}

}
