package printer;

import letter.Letter;

/**
 * Defines a StandardPrinter.
 * 
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class StandardPrinter implements Printer {

	public void printSendLetter(Letter<?> letter) {
		String senderName = letter.getSender().getName();
		String receiverName = letter.getReceiver().getName();
		String description = letter.toString();
		int cost = letter.getCost();
		System.out.print("-> " + senderName + " mails " + description + " to "
				+ receiverName + " for a cost of " + cost);
		System.out.println(cost < 2 ? " euro" : " euros");
	}

	public void printCredit(String name, int amount, int bankAccount) {
		System.out
				.print("   + " + name + " account is credited with " + amount);
		System.out.print(amount < 2 ? " euro" : " euros");
		System.out.print("; its balance is now " + bankAccount);
		System.out.println(bankAccount < 2 ? " euro" : " euros");
	}

	public void printDebit(String name, int amount, int bankAccount) {
		System.out.print("   - " + amount);
		System.out.print(amount < 2 ? " euro" : " euros");
		System.out.print(" are debited from " + name
				+ " account whose balance is now " + bankAccount);
		System.out.println(bankAccount < 2 ? " euro" : " euros");
	}

	public void printDoAction(Letter<?> letter) {
		String senderName = letter.getSender().getName();
		String receiverName = letter.getReceiver().getName();
		String description = letter.toString();
		System.out.println("<- " + receiverName + " receives " + description
				+ " from " + senderName);
	}
}
