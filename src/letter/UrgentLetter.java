package letter;

import main.Mail;
import city.Inhabitant;
import printer.Printer;

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
	public UrgentLetter(Inhabitant sender, Inhabitant receiver,
			Printer printer, Letter<?> letter) {
		super(sender, receiver, printer, letter);
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
