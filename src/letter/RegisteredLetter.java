package letter;

import city.Inhabitant;

/**
 * Defines a RegisteredLetter.
 * 
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class RegisteredLetter extends OptionLetter {

	/**
	 * Constructs an RegisteredLetter with given sender, receiver and Letter.
	 * 
	 * @param sender
	 *            the RegisteredLetter's sender
	 * @param receiver
	 *            the RegisteredLetter's receiver
	 * @param letter
	 *            the RegisteredLetter's content
	 */
	public RegisteredLetter(Inhabitant sender, Inhabitant receiver, Letter<?> letter) {
		super(sender, receiver, letter);
		this.cost += 15;
	}

	/**
	 * Called by <code>doAction</code> method.
	 */
	@Override
	protected void reallyDoAction() {
		this.content.reallyDoAction();
		this.receiver.getCity().sendLetter(
				new AcknowledgmentOfReceipt(this.receiver, this.sender, this
						.toString()));
	}

	public String toString() {
		return "a registered letter whose content is "
				+ this.content.toString();
	}
}
