package city;

import main.Mail;
import printer.Printer;
import printer.StandardPrinter;

/**
 * Defines an <code>Inhabitant</code>.
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
	 * Constructs an <code>Inhabitant</code> with given <code>rank</code> and
	 * {@link #city}.
	 * 
	 * @param rank
	 *            the <code>Inhabitant</code>'s <code>rank</code>
	 * @param city
	 *            the <code>Inhabitant</code>'s {@link #city}
	 */
	public Inhabitant(int rank, City city) {
		this.name = "inhabitant-" + rank;
		this.city = city;
		this.bankAccount = Mail.BANKACCOUNT;
		this.printer = new StandardPrinter();
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

	public void setPrinter(Printer printer) {
		this.printer = printer;
	}

	/**
	 * Adds <code>amount</code> euro(s) to the {@link #bankAccount bank account}
	 * .
	 * 
	 * @param amount
	 *            the <code>amount</code> to add
	 */
	public void credit(int amount) {
		this.bankAccount += amount;
		this.printer.printCredit(this.name, amount, this.bankAccount);
	}

	/**
	 * Removes <code>amount</code> euro(s) from the {@link #bankAccount bank
	 * account}.
	 * 
	 * @param amount
	 *            the <code>amount</code> to remove
	 */
	public void debit(int amount) {
		this.bankAccount -= amount;
		this.printer.printDebit(this.name, amount, this.bankAccount);
	}

}
