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

	public double getBankAccount() {
		return this.bankAccount;
	}

	/**
	 * Adds <code>amount</code> euro(s) to the bank account.
	 * 
	 * @param amount
	 *            the amount to add
	 */
	public void credit(int amount) {
		String tmp = amount < 2 ? " euro" : " euros";
		System.out.print("   + " + this.name + " account is credited with "
				+ amount + tmp);
		this.bankAccount += amount;
		tmp = this.bankAccount < 2 ? " euro" : " euros";
		System.out.println("; its balance is now " + this.bankAccount + tmp);

	}

	/**
	 * Removes <code>amount</code> euro(s) from the bank account.
	 * 
	 * @param amount
	 *            the amount to remove
	 */
	public void debit(int amount) {
		String tmp = amount < 2 ? " euro" : " euros";
		System.out.print("   - " + amount + tmp + " are debited from "
				+ this.name + " account ");
		this.bankAccount -= amount;
		tmp = this.bankAccount < 2 ? " euro" : " euros";
		System.out.println("whose balance is now " + this.bankAccount + tmp);
	}

	public void receiveLetter(Letter<?> letter) {
		letter.doAction();
	}
}
