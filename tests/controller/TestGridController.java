package controller;

import static org.junit.Assert.*;
import model.Game;
import model.Game.Etat;

import org.junit.Before;
import org.junit.Test;

public class TestGridController {

	private Game game;
	private GridController gc;
	
	@Before
	public void setUp() throws Exception {
		game = new Game();
		gc = new GridController(game);
	}
	
	@Test
	public void testClicWait() {
		game.setEtat(Etat.WAIT);
		gc.clic(1, 1);
		assertTrue(game.getInfo().equals("En attente du lancement d'une partie"));
	}
	
}
