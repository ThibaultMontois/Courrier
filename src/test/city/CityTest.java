package test.city;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import city.City;
import city.Inhabitant;
import letter.Letter;
import letter.SimpleLetter;
import printer.Printer;

import test.mock.MockPrinter;

/**
 * Defines tests for City class.
 * 
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class CityTest {

	protected int numberOfInhabitants;
	protected Printer printer;
	protected City city;

	@Before
	public void createCity() {
		this.numberOfInhabitants = 10;
		this.printer = new MockPrinter();
		this.city = new City("CityTest", this.printer, this.numberOfInhabitants);
		assertNotNull(this.printer);
		assertNotNull(this.city);
	}

	@Test
	public void testGetName() {
		assertEquals("CityTest", this.city.getName());
	}

	@Test
	public void testGetInhabitants() {
		assertNotNull(this.city.getInhabitants());
		assertSame(this.numberOfInhabitants, this.city.getInhabitants().size());
	}

	@Test
	public void testGetPostbox() {
		assertNotNull(this.city.getPostbox());
		assertTrue(this.city.getPostbox().isEmpty());
	}

	@Test
	public void testSendLetter() {
		Inhabitant ih1 = this.city.getInhabitants().get(4);
		Inhabitant ih2 = this.city.getInhabitants().get(2);
		Letter<?> letter = new SimpleLetter(ih1, ih2, this.printer, "bla bla");
		this.city.sendLetter(letter);
		assertSame(1, this.city.getPostbox().size());
		assertEquals(letter, this.city.getPostbox().get(0));
	}

	@Test
	public void testDistributeLetters() {
		Inhabitant ih1 = this.city.getInhabitants().get(4);
		Inhabitant ih2 = this.city.getInhabitants().get(2);
		Letter<?> letter = new SimpleLetter(ih1, ih2, this.printer, "bla bla");
		this.city.sendLetter(letter);
		this.city.distributeLetters();
		assertSame(0, this.city.getPostbox().size());
	}
}
