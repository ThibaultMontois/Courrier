package city;

import main.Mail;
import letter.Letter;
import printer.Printer;

/**
 * Defines an Inhabitant.
 * 
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class Inhabitant {

	protected String name;
	protected City city;
	protected int bankAccount;
	protected Printer printer;

	/**
	 * Constructs an Inhabitant with given rank and City.
	 * 
	 * @param rank
	 *            the Inhabitant's rank
	 * @param city
	 *            the Inhabitant's City
	 */
	public Inhabitant(int rank, City city, Printer printer) {
		this.name = "inhabitant-" + rank;
		this.city = city;
		this.bankAccount = Mail.BANKACCOUNT;
		this.printer = printer;
	}

	public String getName() {
		return this.name;
	}

	public City getCity() {
		return this.city;
	}

	public int getBankAccount() {
		return this.bankAccount;
	}

	/**
	 * Adds <code>amount</code> euro(s) to the bank account.
	 * 
	 * @param amount
	 *            the amount to add
	 */
	public void credit(int amount) {
		this.bankAccount += amount;
		this.printer.printCredit(this.name, amount, this.bankAccount);
	}

	/**
	 * Removes <code>amount</code> euro(s) from the bank account.
	 * 
	 * @param amount
	 *            the amount to remove
	 */
	public void debit(int amount) {
		this.bankAccount -= amount;
		this.printer.printDebit(this.name, amount, this.bankAccount);
	}

	public void receiveLetter(Letter<?> letter) {
		letter.doAction();
	}
}
