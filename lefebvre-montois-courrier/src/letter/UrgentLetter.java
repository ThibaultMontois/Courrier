package letter;

import main.Mail;

/**
 * Defines an <code>UrgentLetter</code>.
 * 
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class UrgentLetter extends LetterDecorator {

	/**
	 * Constructs an <code>UrgentLetter</code> with given {@link Letter letter}.
	 * 
	 * @param letter
	 *            the <code>UrgentLetter</code>'s {@link #content content}
	 */
	public UrgentLetter(Letter<?> letter) {
		super(letter);
		this.cost *= Mail.MULTCOST;
	}

	/**
	 * Called by {@link #doAction() doAction} method.
	 */
	@Override
	protected void reallyDoAction() {
		this.content.reallyDoAction();
	}

	public String toString() {
		return "an urgent letter whose content is " + this.content.toString();
	}
}
