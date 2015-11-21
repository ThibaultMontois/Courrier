package letter;

import main.Mail;

/**
 * Defines a RegisteredLetter.
 * 
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class RegisteredLetter extends LetterDecorator {

	/**
	 * Constructs an RegisteredLetter with given Letter.
	 * 
	 * @param letter
	 *            the RegisteredLetter's content
	 */
	public RegisteredLetter(Letter<?> letter) {
		super(letter);
		this.cost += Mail.ADDCOST;
	}

	/**
	 * Called by <code>doAction</code> method.
	 */
	@Override
	protected void reallyDoAction() {
		this.content.reallyDoAction();
		this.receiver.getCity().sendLetter(
				new AknowledgmentOfReceipt(this.receiver, this.sender, this
						.toString()));
	}

	public String toString() {
		return "a registered letter whose content is "
				+ this.content.toString();
	}
}
