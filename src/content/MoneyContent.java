package content;

/**
 * Defines a MoneyContent.
 * 
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class MoneyContent implements Content {

	protected int amount;

	/**
	 * Constructs a MoneyContent with given amount.
	 * 
	 * @param amount
	 *            the Content's amount
	 */
	public MoneyContent(int amount) {
		this.amount = amount;
	}

	public int getAmount() {
		return this.amount;
	}

	public String toString() {
		return "a money content (" + this.amount + ")";
	}
}
