package letter;

import main.Mail;
import city.Inhabitant;
import content.Content;
import printer.Printer;
import printer.StandardPrinter;

/**
 * Defines a Letter.
 * 
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public abstract class Letter<C extends Content> implements Content {

	protected Inhabitant sender;
	protected Inhabitant receiver;
	protected int cost;
	protected Printer printer;
	protected C content;

	/**
	 * Constructs a Letter with given sender and receiver.
	 * 
	 * @param sender
	 *            the Letter's sender
	 * @param receiver
	 *            the Letter'receiver
	 */
	public Letter(Inhabitant sender, Inhabitant receiver) {
		this.sender = sender;
		this.receiver = receiver;
		this.cost = Mail.COST;
		this.printer = new StandardPrinter();
	}

	public Inhabitant getSender() {
		return this.sender;
	}

	public Inhabitant getReceiver() {
		return this.receiver;
	}

	public int getCost() {
		return this.cost;
	}

	public void setPrinter(Printer printer) {
		this.printer = printer;
	}

	/**
	 * Executes the Letter's action.
	 * 
	 * This method calls <code>reallyDoAction</code> method that must be
	 * implemented
	 */
	public void doAction() {
		this.printer.printDoAction(this);
		this.reallyDoAction();
	}

	/**
	 * Called by <code>doAction</code> method.
	 */
	protected abstract void reallyDoAction();
}
