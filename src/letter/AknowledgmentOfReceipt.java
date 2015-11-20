package letter;

import city.Inhabitant;

/**
 * Defines an AknowledgmentOfReceipt.
 * 
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class AknowledgmentOfReceipt extends SimpleLetter {

	/**
	 * Constructs a AknowledgmentOfReceipt with given sender, receiver and
	 * text.
	 * 
	 * @param sender
	 *            the AknowledgmentOfReceipt's sender
	 * @param receiver
	 *            the AknowledgmentOfReceipt's receiver
	 * @param text
	 *            the AknowledgmentOfReceipt's text
	 */
	public AknowledgmentOfReceipt(Inhabitant sender, Inhabitant receiver, String text) {
		super(sender, receiver, "aknowledgment of receipt for " + text);
	}

	public String toString() {
		return "an aknowledgment of receipt which is " + super.toString();
	}
}
