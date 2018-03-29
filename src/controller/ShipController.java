package controller;


import model.Bateau;
import model.Game;

public class ShipController {
	
    ////////////////////////////// VARIABLES //////////////////////////////////

	private Game game;

    ///////////////////////////// CONSTRUCTEUR ////////////////////////////////

	public ShipController(Game game) {
		this.game = game;
	}
	
	public void clic(Bateau bateau, int size) {
		switch(game.getEtat()) {
			case WAIT:
				game.setInfo();
				break;
			case PLACINGBOATS:
				game.setCurrentShip(bateau, size);
				break;
		default:
			break;
		}		
	}
	
	public Game getGame(){
		return game;
	}
}
