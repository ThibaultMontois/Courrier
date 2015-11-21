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
	protected Letter<?> letter;

	@Before
	public void createCity() {
		this.numberOfInhabitants = 10;
		this.city = new City("CityTest", this.numberOfInhabitants);
		this.city.setPrinter(new MockPrinter());
		for (Inhabitant inhabitant : this.city.getInhabitants())
			inhabitant.setPrinter(new MockPrinter());
		this.letter = new SimpleLetter(this.city.getInhabitants().get(4),
				this.city.getInhabitants().get(2), "bla bla");
		this.letter.setPrinter(new MockPrinter());
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
		this.city.sendLetter(this.letter);
		assertSame(1, this.city.getPostbox().size());
		assertEquals(this.letter, this.city.getPostbox().get(0));
	}

	@Test
	public void testDistributeLetters() {
		this.city.sendLetter(this.letter);
		this.city.distributeLetters();
		assertSame(0, this.city.getPostbox().size());
	}
}
