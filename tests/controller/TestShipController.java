package controller;

import static org.junit.Assert.*;

import model.Game;
import model.Game.Etat;
import model.XVI_Bateau.Brick;

import org.junit.Before;
import org.junit.Test;

public class TestShipController {

	private Game game;
	private ShipController gc;
	
	@Before
	public void setUp() throws Exception {
		game = new Game();
		gc = new ShipController(game);
	}
	
	@Test
	public void testClicWait() {
		game.setEtat(Etat.WAIT);
		gc.clic(new Brick(), 1);
		assertTrue(game.getInfo().equals("En attente du lancement d'une partie"));
	}
}
