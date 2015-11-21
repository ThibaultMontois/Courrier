package test.mock;

import letter.Letter;
import printer.Printer;

/**
 * Defines a {@link printer.Printer}'s Mock.
 * 
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class MockPrinter implements Printer {

	/**
	 * {@inheritDoc}
	 */
	public void printSendLetter(Letter<?> letter) {
	}

	/**
	 * {@inheritDoc}
	 */
	public void printCredit(String name, int amount, int bankAccount) {
	}

	/**
	 * {@inheritDoc}
	 */
	public void printDebit(String name, int amount, int bankAccount) {
	}

	/**
	 * {@inheritDoc}
	 */
	public void printDoAction(Letter<?> letter) {
	}
}
