package model;


import static org.junit.Assert.*;

import model.World;
import model.strategy.IntelligentStrategy;

import org.junit.Before;
import org.junit.Test;

import model.Case;


public class TestIntelligent {

	private IntelligentStrategy in;
	private World wp;
	private Case c;
	
	@Before
	public void setUp() throws Exception {
		in = new IntelligentStrategy();
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
