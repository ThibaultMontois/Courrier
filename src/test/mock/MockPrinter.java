package test.mock;

import letter.Letter;
import printer.Printer;

/**
 * Defines a Printer's Mock.
 * 
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class MockPrinter implements Printer {

	public void printSendLetter(Letter<?> letter) {
	}

	public void printCredit(String name, int amount, int bankAccount) {
	}

	public void printDebit(String name, int amount, int bankAccount) {
	}

	public void printDoAction(Letter<?> letter) {
	}
}
