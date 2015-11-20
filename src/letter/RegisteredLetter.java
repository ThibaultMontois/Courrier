package letter;

import main.Mail;
import city.Inhabitant;

/**
 * Defines a RegisteredLetter.
 * 
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class RegisteredLetter extends LetterDecorator {

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
	public RegisteredLetter(Inhabitant sender, Inhabitant receiver,
			Letter<?> letter) {
		super(sender, receiver, letter);
		this.cost += Mail.ADDCOST;
	}

	/**
	 * Called by <code>doAction</code> method.
	 */
	@Override
	protected String reallyDoAction() {
		String str = this.content.reallyDoAction();
		str += this.receiver.getCity().sendLetter(
				new AknowledgmentOfReceipt(this.receiver, this.sender, this
						.toString()));
		return str;
	}

	public String toString() {
		return "a registered letter whose content is "
				+ this.content.toString();
	}
}
