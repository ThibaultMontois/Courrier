package content;

/**
 * Defines a <code>MoneyContent</code>.
 * 
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class MoneyContent implements Content {

	protected int amount;

	/**
	 * Constructs a <code>MoneyContent</code> with given {@link #amount}.
	 * 
	 * @param amount
	 *            the <code>MoneyContent</code>'s {@link #amount}
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
