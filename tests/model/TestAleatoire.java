package model;



import static org.junit.Assert.*;

import model.Aleatoire;
import model.World;

import org.junit.Before;
import org.junit.Test;

import model.Case;


public class TestAleatoire {

	private Aleatoire al;
	private World wp;
	private Case c;
	
	@Before
	public void setUp() throws Exception {
		al = new Aleatoire();
		wp = new World();
	}
	
	@Test
	public void testShoot() {
		al.shoot(wp);
		assertTrue(wp.getShoots().size()>0);
	}

	@Test
	public void testShootBounds() {
		al.shoot(wp);
		c = wp.getShoots().get(0);
		assertTrue(c.getX()>=1 && c.getX()<=wp.getNbCols() && c.getY()>=1 && c.getY()<=wp.getNbRows());
	}

}
