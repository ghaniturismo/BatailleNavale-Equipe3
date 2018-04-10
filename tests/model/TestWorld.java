package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import model.XVI_Bateau.Brick;
import model.XVI_Bateau.Galeasse;


public class TestWorld {

	private World world;
	private Bateau brick;
	private Bateau galeasse;
	
	@Before
	public void setUp() throws Exception {
		world = new World();
		brick = new Brick();
		galeasse = new Galeasse();
	}
	
	@Test
	public void testGetShipAt() {
		Case c = new Case(1,1);
		brick.addCase(c);
		world.addShip(brick);
		assertTrue(world.getShipAt(c).equals(brick));
	}
	
	@Test
	public void testAddShip() {
		world.addShip(galeasse);
		assertTrue(world.getShips().contains(galeasse));
	}
	
	@Test
	public void testCaseTaken() {
		Case c = new Case(3,3);
		world.addShoot(c);
		assertTrue(world.caseTaken(c.getX(), c.getY()));
	}
	
	@Test
	public void testShipHit() {
		brick.setX(3);
		brick.setY(3);
		world.addShip(brick);
		assertTrue(world.shipHit(3, 3, false));
	}
	
}
