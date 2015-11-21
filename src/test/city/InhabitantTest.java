package test.city;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.Mail;
import city.City;
import city.Inhabitant;

import test.mock.MockPrinter;

/**
 * Defines tests for Inhabitant class.
 * 
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class InhabitantTest {

	protected City city;
	protected Inhabitant inhabitant;

	@Before
	public void createInhabitant() {
		this.city = new City("CityTest");
		this.inhabitant = new Inhabitant(1, this.city);
		this.inhabitant.setPrinter(new MockPrinter());
	}

	@Test
	public void testGetName() {
		assertEquals("inhabitant-1", this.inhabitant.getName());
	}

	@Test
	public void testGetCity() {
		assertSame(this.city, this.inhabitant.getCity());
	}

	@Test
	public void testGetBankAccount() {
		assertEquals(Mail.BANKACCOUNT, this.inhabitant.getBankAccount());
	}

	@Test
	public void testCredit() {
		int amount = this.inhabitant.getBankAccount();
		this.inhabitant.credit(10);
		assertEquals(amount + 10, this.inhabitant.getBankAccount());
	}

	@Test
	public void testDebit() {
		int amount = this.inhabitant.getBankAccount();
		this.inhabitant.debit(10);
		assertEquals(amount - 10, this.inhabitant.getBankAccount());
	}
}
