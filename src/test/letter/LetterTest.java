package test.letter;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

import printer.Printer;

import main.Mail;
import city.City;
import city.Inhabitant;
import content.Content;
import letter.Letter;

import test.content.ContentTest;
import test.mock.MockPrinter;

/**
 * Defines tests for Letter classes.
 * 
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public abstract class LetterTest<C extends Content> implements ContentTest {

	protected Printer printer;
	protected City city;
	protected Inhabitant sender;
	protected Inhabitant receiver;
	protected Letter<C> letter;

	@Before
	public void createLetter() {
		this.printer = new MockPrinter();
		this.city = new City("CityTest", this.printer);
		this.sender = new Inhabitant(1, this.city, this.printer);
		this.receiver = new Inhabitant(2, this.city, this.printer);
		this.reallyCreateLetter();
		assertNotNull(this.printer);
		assertNotNull(this.city);
		assertNotNull(this.sender);
		assertNotNull(this.receiver);
		assertNotNull(this.letter);
	}

	protected abstract void reallyCreateLetter();

	@Test
	public void testGetSender() {
		assertSame(this.sender, this.letter.getSender());
	}

	@Test
	public void testGetReceiver() {
		assertSame(this.receiver, this.letter.getReceiver());
	}

	@Test
	public void testGetCost() {
		assertSame(Mail.COST, this.letter.getCost());
	}

	@Test
	public void testDoAction() {
		this.testReallyDoAction();
	}

	protected abstract void testReallyDoAction();
}
