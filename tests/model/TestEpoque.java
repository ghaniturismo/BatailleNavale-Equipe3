package model;




import static org.junit.Assert.*;

import java.util.ArrayList;
import model.Epoque;
import org.junit.Before;
import org.junit.Test;
import model.XVI_Bateau.Fregate;
import model.Bateau;

public class TestEpoque {

	private Epoque epoque;
	private Bateau fregate;
	
	@Before
	public void setUp() throws Exception {
		epoque = new Epoque("New Epoque");
		fregate = new Fregate();
	}
	
	
	@Test
	public void testConstructorName() {
		assertTrue(epoque.getName().equals("New Epoque"));
	}
	
	@Test
	public void testConstructorNbShip() {
		assertTrue(epoque.getNbShip() == 0);
	}

	@Test
	public void testConstructorShips() {
		assertTrue(epoque.getShips() != null);
	}
	
	@Test
	public void testAddShip() {
		epoque.addShip(fregate);
		ArrayList<Bateau> bateaux = epoque.getShips();
		assertTrue(bateaux.contains(fregate));
	}
	
}
