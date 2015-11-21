package letter;

import main.Mail;

/**
 * Defines an UrgentLetter.
 * 
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class UrgentLetter extends LetterDecorator {

	/**
	 * Constructs an UrgentLetter with given Letter.
	 * 
	 * @param letter
	 *            the UrgentLetter's content
	 */
	public UrgentLetter(Letter<?> letter) {
		super(letter);
		this.cost *= Mail.MULTCOST;
	}

	/**
	 * Called by <code>doAction</code> method.
	 */
	@Override
	protected void reallyDoAction() {
		this.content.reallyDoAction();
	}

	public String toString() {
		return "an urgent letter whose content is " + this.content.toString();
	}
}
