package model;



import static org.junit.Assert.*;
import model.BateauFactory;
import model.Epoque;

import org.junit.Before;
import org.junit.Test;

import model.*;


public class TestGame {

	private Game g;
	private World wp;
	private Epoque ep;
	private IA_Strategy strat;
	private BateauFactory bf;
	
	@Before
	public void setUp() throws Exception {
		g = new Game();
		ep = new Siecle_XVI();
		strat = new Intelligent();
		bf = new BateauFactory();
		ep.addShip(bf.getBateau("Brick"));
		ep.addShip(bf.getBateau("Galeasse"));
		ep.addShip(bf.getBateau("Fregate"));
		ep.addShip(bf.getBateau("Galion"));
		ep.addShip(bf.getBateau("NavireDeLigne"));
	}
	
	
	@Test
	public void testGameFinished() {
		g.newGame(ep, strat, 0);
		assertTrue(g.gameFinished());
	}

}
