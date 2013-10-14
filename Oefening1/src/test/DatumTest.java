package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import utils.Datum;

public class DatumTest {
	private Datum datum, datum_1;
	
	@Before
	public void setUp() throws Exception{
		datum = new Datum();
		datum_1 = new Datum(1, 3, 2013);		
	}

	@Test
	public void testDatumIntIntInt() {
				
		assertEquals(1, datum_1.getDag());
		assertEquals (3, datum_1.getMaand());
		assertEquals (2013, datum_1.getJaar());
	}

	@Test
	public void testSetDag() {
		datum.setDag(1);
		
		assertEquals(1, datum.getDag());
	}

	@Test
	public void testSetMaand() {
		datum.setMaand(5);
		
		assertEquals (5, datum.getMaand());
	}

	@Test
	public void testSetJaar() {
		datum.setJaar(1950);
		
		assertEquals(1950, datum.getJaar());
	}
	
	@Test
	public void testSetDatum() throws Exception{
		assertTrue(datum.setDatum(1, 5, 2000));
	}
	
	@Test
	public void testGetDatumInAmerikaansFormaat(){
		assertEquals("2013/03/1" ,datum_1.getDatumInAmerikaansFormaat());
	}
	
	@Test
	public void testGetDatumInEuropeesFormaat(){
		assertEquals("01/03/2013" ,datum_1.getDatumInEuropeesFormaat());
	}
	
	/*@Test (expected = Exception.class)
	public void testSetDatumIllegalArgument() {
			datum.setDatum(32, -12, 2000);
	}*/
	

}
