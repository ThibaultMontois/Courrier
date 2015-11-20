package city;

import letter.Letter;

/**
 * Defines an Inhabitant.
 * 
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class Inhabitant {

	private String name;
	private City city;
	private int bankAccount = 5000;

	/**
	 * Constructs an Inhabitant with given rank and City.
	 * 
	 * @param rank
	 *            the Inhabitant's rank
	 * @param city
	 *            the Inhabitant's City
	 */
	public Inhabitant(int rank, City city) {
		this.name = "inhabitant-" + rank;
		this.city = city;
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
	public String credit(int amount) {
		String str = "   + " + this.name + " account is credited with "
				+ amount;
		str += amount < 2 ? " euro" : " euros";
		this.bankAccount += amount;
		str += "; its balance is now " + this.bankAccount;
		str += this.bankAccount < 2 ? " euro\n" : " euros\n";
		return str;
	}

	/**
	 * Removes <code>amount</code> euro(s) from the bank account.
	 * 
	 * @param amount
	 *            the amount to remove
	 */
	public String debit(int amount) {
		String str = "   - " + amount;
		str += amount < 2 ? " euro" : " euros";
		this.bankAccount -= amount;
		str += " are debited from " + this.name
				+ " account whose balance is now " + this.bankAccount;
		str += this.bankAccount < 2 ? " euro\n" : " euros\n";
		return str;
	}

	public String receiveLetter(Letter<?> letter) {
		return letter.doAction();
	}
}
