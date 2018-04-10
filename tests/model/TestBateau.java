package model;



import static org.junit.Assert.*;

import org.junit.Test;


import org.junit.Before;
import model.XVI_Bateau.*;

import model.Bateau;

import model.Case;


public class TestBateau {
	
	private Bateau brick;
	private Fregate dead;
	private Fregate alive;
	
	@Before
	public void setUp() throws Exception {
		dead = new Fregate();
		for(int i=1; i<dead.getSize(); i++){
			Case c = new Case(1,i);
			c.hit();
			dead.addCase(c);
		}
		alive = new Fregate();
		for(int i=1; i<alive.getSize(); i++){
			Case c = new Case(i,1);
			alive.addCase(c);
		}
	}
	
	@Test
	public void testConstructorType() {
		brick = new Brick();
		assertTrue(brick.getType().equals("Brick"));
	}
	
	@Test
	public void testConstructorSize() {
		brick = new Brick();
		assertTrue(brick.getSize() == 1);
	}

	@Test
	public void testDeadisDead() {
		assertFalse(alive.isDead());
	}

	@Test
	public void testAliveisDead() {
		assertTrue(dead.isDead());
	}
	
	@Test
	public void testSetCaseHit() {
		Case c = new Case(1,1);
		alive.setCaseHit(c);
		Case hit = null;
		for(Case ca : alive.getCases()){
			if(ca.getX() == 1 && ca.getY() == 1){
				hit = ca;
				break;
			}
		}
		assertTrue(hit.isHit());
	}
	

	@Test
	public void testAddCase() {
		brick = new Brick();
		Case c = new Case(1,1);
		brick.addCase(c);
		assertTrue(brick.getCases().contains(c));
	}
	
}
