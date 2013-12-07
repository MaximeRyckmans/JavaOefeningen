package test;

import static org.junit.Assert.*;
import model.Opdracht;
import model.OpdrachtCategorie;

import org.junit.Before;
import org.junit.Test;

public class OpdrachtTest {
	private Opdracht opdracht;
	
	@Before
	public void setUp()
	{
		opdracht = new Opdracht("Hoe lang is een Chinees?", "10 meter", 5, "Geen 11 meter", 120, OpdrachtCategorie.algemeneKennis) {
			
			@Override
			public boolean isJuisteAntwoord(String antwoord) {
				// TODO Auto-generated method stub
				return false;
			}
		};
	}

	/*@Test
	public void testOpdracht() {
		fail("Not yet implemented");
	}*/

	@Test
	public void testOpdrachtStringStringIntStringInt() {
		assertEquals("Hoe lang is een Chinees?", opdracht.getVraag());
		assertEquals("10 meter", opdracht.getAntwoord());
		assertEquals(5, opdracht.getMaxAantalPogingen());
		assertEquals("Geen 11 meter", opdracht.getAntwoordHint());
		assertEquals(120, opdracht.getmaxAntwoordTijd());
	}

	@Test
	public void testGetVraag() {
		assertEquals("Hoe lang is een Chinees?", opdracht.getVraag());
	}

	@Test
	public void testSetVraag() {
		opdracht.setVraag("Hoeveel landen telt Europa?");
		assertEquals("Hoeveel landen telt Europa?", opdracht.getVraag());
	}

	/*@Test
	public void testToString() {
		fail("Not yet implemented");
	}

	@Test
	public void testEqualsOpdracht() {
		fail("Not yet implemented");
	}*/

	@Test
	public void testGetAntwoord() {
		assertEquals("10 meter", opdracht.getAntwoord());
	}

	@Test
	public void testSetAntwoord() {
		opdracht.setAntwoord("45");
		assertEquals("45", opdracht.getAntwoord());
	}

	@Test
	public void testGetMaxAantalPogingen() {
		assertEquals(5, opdracht.getMaxAantalPogingen());
	}

	@Test
	public void testSetMaxAantalPogingen() {
		opdracht.setMaxAantalPogingen(85);
		assertEquals(85, opdracht.getMaxAantalPogingen());
	}

	@Test
	public void testGetAntwoordHint() {
		assertEquals("Geen 11 meter", opdracht.getAntwoordHint());
	}

	@Test
	public void testSetAntwoordHint() {
		opdracht.setAntwoordHint("Zo oud als de meester");
		assertEquals("Zo oud als de meester", opdracht.getAntwoordHint());
	}

	@Test
	public void testGetmaxAntwoordTijd() {
		assertEquals(120, opdracht.getmaxAntwoordTijd());
	}

	@Test
	public void testSetmaxAntwoordTijd() {
		opdracht.setmaxAntwoordTijd(60);
		assertEquals(60, opdracht.getmaxAntwoordTijd());
	}

	/*@Test
	public void testIsJuisteAntwoord() {
		fail("Not yet implemented");
	}

	@Test
	public void testObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetClass() {
		fail("Not yet implemented");
	}

	@Test
	public void testEqualsObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testClone() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString1() {
		fail("Not yet implemented");
	}

	@Test
	public void testNotify() {
		fail("Not yet implemented");
	}

	@Test
	public void testNotifyAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testWaitLong() {
		fail("Not yet implemented");
	}

	@Test
	public void testWaitLongInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testWait() {
		fail("Not yet implemented");
	}

	@Test
	public void testFinalize() {
		fail("Not yet implemented");
	}*/

}
