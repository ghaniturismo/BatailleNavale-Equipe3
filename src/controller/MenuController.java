package controller;


import model.Epoque;
import model.Game;
import model.strategy.IA_Strategy;

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

	public Game getGame() {
		return game;
	}
	/*
	 * Pour la sauvegarde
	 */
	public void saveGame() {
		sauvegarde.DAOFactory.getInstance().getDAO_Sauvegarde().saveGame(game);
	}
	
	/*
	 * Pour la restauration de jeu
	 */
	public void loadGame() {
		sauvegarde.DAOFactory.getInstance().getDAO_Sauvegarde().loadGame(game.getProfil());
	}
	
}
