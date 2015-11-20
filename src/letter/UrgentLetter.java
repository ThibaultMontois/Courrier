package letter;

import city.Inhabitant;

/**
 * Defines an UrgentLetter.
 * 
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class UrgentLetter extends LetterDecorator {

	/**
	 * Constructs an UrgentLetter with given sender, receiver and Letter.
	 * 
	 * @param sender
	 *            the UrgentLetter's sender
	 * @param receiver
	 *            the UrgentLetter's receiver
	 * @param letter
	 *            the UrgentLetter's content
	 */
	public UrgentLetter(Inhabitant sender, Inhabitant receiver, Letter<?> letter) {
		super(sender, receiver, letter);
		this.cost *= 2;
	}

	/**
	 * Called by <code>doAction</code> method.
	 */
	@Override
	protected String reallyDoAction() {
		return this.content.reallyDoAction();
	}

	public String toString() {
		return "an urgent letter whose content is " + this.content.toString();
	}
}
