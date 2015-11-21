package test.printer;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import city.City;
import city.Inhabitant;
import letter.Letter;
import letter.SimpleLetter;
import letter.UrgentLetter;
import printer.Printer;
import printer.StandardPrinter;

/**
 * Defines tests for StandardPrinter class.
 * 
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class StandardPrinterTest implements PrinterTest {

	protected Printer printer;
	protected Letter<?> letter;
	protected Letter<?> urgentLetter;
	protected ByteArrayOutputStream outContent;

	@Before
	public void createPrinterAndLetters() {
		this.printer = new StandardPrinter();
		City city = new City("CityTest", this.printer);
		Inhabitant sender = new Inhabitant(1, city, this.printer);
		Inhabitant receiver = new Inhabitant(2, city, this.printer);
		this.letter = new SimpleLetter(sender, receiver, this.printer,
				"TextTest");
		this.urgentLetter = new UrgentLetter(sender, receiver, this.printer,
				this.letter);
		assertNotNull(this.printer);
		assertNotNull(city);
		assertNotNull(sender);
		assertNotNull(receiver);
		assertNotNull(this.letter);
		assertNotNull(this.urgentLetter);
	}

	@Before
	public void setUpStream() {
		this.outContent = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(this.outContent);
		System.setOut(printStream);
		assertNotNull(this.outContent);
		assertNotNull(printStream);
	}

	@Test
	public void testPrintSendLetter() {
		this.printer.printSendLetter(this.letter);
		this.printer.printSendLetter(this.urgentLetter);
		assertEquals("-> inhabitant-1 mails a simple letter "
				+ "whose content is a text content (TextTest) "
				+ "to inhabitant-2 for a cost of 1 euro\n"
				+ "-> inhabitant-1 mails an urgent letter "
				+ "whose content is a simple letter "
				+ "whose content is a text content (TextTest) "
				+ "to inhabitant-2 for a cost of 2 euros\n",
				this.outContent.toString());
	}

	@Test
	public void testPrintCredit() {
		this.printer.printCredit("Timoleon", 100, 5100);
		this.printer.printCredit("Timoleon", 1, 1);
		assertEquals("   + Timoleon account is credited with 100 euros; "
				+ "its balance is now 5100 euros\n"
				+ "   + Timoleon account is credited with 1 euro; "
				+ "its balance is now 1 euro\n", this.outContent.toString());
	}

	@Test
	public void testPrintDebit() {
		this.printer.printDebit("Timoleon", 100, 4900);
		this.printer.printDebit("Timoleon", 1, 1);
		assertEquals("   - 100 euros are debited from Timoleon account "
				+ "whose balance is now 4900 euros\n"
				+ "   - 1 euro are debited from Timoleon account "
				+ "whose balance is now 1 euro\n", this.outContent.toString());
	}

	@Test
	public void testPrintDoAction() {
		this.printer.printDoAction(this.letter);
		assertEquals("<- inhabitant-2 receives a simple letter "
				+ "whose content is a text content (TextTest) "
				+ "from inhabitant-1\n", this.outContent.toString());
	}

	@After
	public void cleanUpStream() {
		System.setOut(null);
	}
}
