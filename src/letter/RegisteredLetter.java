package letter;

import main.Mail;
import city.Inhabitant;
import printer.Printer;

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
			Printer printer, Letter<?> letter) {
		super(sender, receiver, printer, letter);
		this.cost += Mail.ADDCOST;
	}

	/**
	 * Called by <code>doAction</code> method.
	 */
	@Override
	protected void reallyDoAction() {
		this.content.reallyDoAction();
		this.receiver.getCity().sendLetter(
				new AknowledgmentOfReceipt(this.receiver, this.sender,
						this.printer, this.toString()));
	}

	public String toString() {
		return "a registered letter whose content is "
				+ this.content.toString();
	}
}
