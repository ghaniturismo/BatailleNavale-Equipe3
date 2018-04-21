package model;


import static org.junit.Assert.*;

import model.World;

import org.junit.Before;
import org.junit.Test;

import model.Intelligent;

import model.Case;


public class TestIntelligent {

	private Intelligent in;
	private World wp;
	private Case c;
	
	@Before
	public void setUp() throws Exception {
		in = new Intelligent();
		wp = new World();
	}
	
	@Test
	public void testShoot() {
		in.shoot(wp);
		assertTrue(wp.getShoots().size()>0);
	}

	@Test
	public void testShootBounds() {
		in.shoot(wp);
		c = wp.getShoots().get(0);
		assertTrue(c.getX()>=1 && c.getX()<=wp.getNbCols() && c.getY()>=1 && c.getY()<=wp.getNbRows());
	}

}
