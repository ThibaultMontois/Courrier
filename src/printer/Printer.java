package printer;

import letter.Letter;

/**
 * Defines a Printer.
 * 
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public interface Printer {

	public void printSendLetter(Letter<?> letter);

	public void printCredit(String name, int amount, int bankAccount);

	public void printDebit(String name, int amount, int bankAccount);

	public void printDoAction(Letter<?> letter);
}
