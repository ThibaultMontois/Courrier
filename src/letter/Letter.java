package letter;

import city.Inhabitant;
import content.Content;

/**
 * Defines a Letter.
 * 
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public abstract class Letter<C extends Content> implements Content {

	protected Inhabitant sender;
	protected Inhabitant receiver;
	protected C content;
	protected int cost = 1;

	/**
	 * Constructs a Letter with given sender and receiver.
	 * 
	 * @param sender
	 *            the Letter's sender
	 * @param receiver
	 *            the Letter'receiver
	 * @param content
	 *            the Letter's Content
	 */
	public Letter(Inhabitant sender, Inhabitant receiver, Object content) {
		this.sender = sender;
		this.receiver = receiver;
		this.content = this.createContent(content);
	}

	protected abstract C createContent(Object content);

	public Inhabitant getSender() {
		return this.sender;
	}

	public Inhabitant getReceiver() {
		return this.receiver;
	}

	public int getCost() {
		return this.cost;
	}

	/**
	 * Executes the Letter's action.
	 * 
	 * This method calls <code>reallyDoAction</code> method that must be
	 * implemented
	 */
	public void doAction() {
		System.out.println("<- " + this.receiver.getName() + " receives "
				+ this.toString() + " from " + this.sender.getName());
		this.reallyDoAction();
	}

	/**
	 * Called by <code>doAction</code> method.
	 */
	protected abstract void reallyDoAction();
}
