package letter;

import main.Mail;

/**
 * Defines a <code>RegisteredLetter</code>.
 * 
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class RegisteredLetter extends LetterDecorator {

	/**
	 * Constructs a <code>RegisteredLetter</code> with given {@link Letter
	 * letter}.
	 * 
	 * @param letter
	 *            the <code>RegisteredLetter</code>'s {@link #content content}
	 */
	public RegisteredLetter(Letter<?> letter) {
		super(letter);
		this.cost += Mail.ADDCOST;
	}

	/**
	 * Called by {@link #doAction() doAction} method.
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
