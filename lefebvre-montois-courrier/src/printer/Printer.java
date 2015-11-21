package printer;

import letter.Letter;

/**
 * Defines <code>Printer</code>'s methods to implement.
 * 
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public interface Printer {

	/**
	 * Prints a summary of the {@link city.City#sendLetter(Letter) sendLetter}
	 * method's call.
	 * 
	 * @param letter
	 *            the sending {@link letter.Letter letter}
	 */
	public void printSendLetter(Letter<?> letter);

	/**
	 * Prints a summary of the {@link city.Inhabitant#credit(int) credit} 
	 * method's call.
	 * 
	 * @param name
	 *            the {@link city.Inhabitant#name name} of the
	 *            {@link city.Inhabitant inhabitant} credited
	 * 
	 * @param amount
	 *            the credited <code>amount</code>
	 * 
	 * @param bankAccount
	 *            the {@link city.Inhabitant#bankAccount bankAcount} of the
	 *            {@link city.Inhabitant inhabitant} credited
	 */
	public void printCredit(String name, int amount, int bankAccount);

	/**
	 * Prints a summary of the {@link city.Inhabitant#debit(int) debit} method's
	 * call.
	 * 
	 * @param name
	 *            the {@link city.Inhabitant#name name} of the
	 *            {@link city.Inhabitant inhabitant} debited
	 * 
	 * @param amount
	 *            the debited <code>amount</code>
	 * 
	 * @param bankAccount
	 *            the {@link city.Inhabitant#bankAccount bankAcount} of the
	 *            {@link city.Inhabitant inhabitant} debited
	 */
	public void printDebit(String name, int amount, int bankAccount);

	/**
	 * Prints a summary of the {@link letter.Letter#doAction() doAction} 
	 * method's call.
	 * 
	 * @param letter
	 *            the {@link letter.Letter letter} which the action is executed
	 */
	public void printDoAction(Letter<?> letter);
}
