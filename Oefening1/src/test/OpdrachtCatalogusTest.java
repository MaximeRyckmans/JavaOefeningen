package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import model.Meerkeuze;
import model.Opdracht;
import model.OpdrachtCatalogus;

import org.junit.Before;
import org.junit.Test;

public class OpdrachtCatalogusTest {

	OpdrachtCatalogus catalogus;
	List<Opdracht>opdrachten = new ArrayList<Opdracht>();
	
	@Before
	public void setUp() throws Exception 
	{
		catalogus = new OpdrachtCatalogus();
	}
	@Test
	public void testGetOpdrachten() {
		catalogus.setOpdrachten(opdrachten);
		assertEquals(opdrachten, catalogus.getOpdrachten());
	}

	@Test
	public void testSetOpdrachten() {
		Opdracht e = new Meerkeuze();
		opdrachten.add(e);
		catalogus.setOpdrachten(opdrachten);
		assertNotNull(catalogus.getOpdrachten());
	}

	@Test
	public void testAddOpdrachtToList() {
		
	}

	@Test
	public void testRemoveOpdrachtFromList() {
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
	public void testHashCode() {
		fail("Not yet implemented");
	}

	@Test
	public void testEquals() {
		fail("Not yet implemented");
	}

	@Test
	public void testClone() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
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
	}

}
