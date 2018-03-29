package controller;


import model.Epoque;
import model.Game;
import model.IA_Strategy;

public class MenuController {
    ////////////////////////////// VARIABLES //////////////////////////////////

	private Game game;

    ///////////////////////////// CONSTRUCTEUR ////////////////////////////////

	public MenuController(Game game) {
		this.game = game;
	}

	/*
	 * Pour la partie rapide
	 */
	public void newFastGame() {
		game.newFastGame();	
	}

	/*
	 * Pour la partie personalisee
	 */
	public void newCustomizeGame(Epoque epoque, IA_Strategy ia_Strategy, int aleatory) {
		game.newGame(epoque, ia_Strategy, aleatory);
	}

	/*
	 * Getters and Setters
	 */
	
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	
}
