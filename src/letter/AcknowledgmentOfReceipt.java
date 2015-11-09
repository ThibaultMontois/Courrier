package letter;

import city.Inhabitant;
import content.TextContent;

/**
 * Defines an AcknowledgmentOfReceipt.
 * 
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class AcknowledgmentOfReceipt extends SimpleLetter {

	/**
	 * Constructs a AcknowledgmentOfReceipt with given sender, receiver and
	 * text.
	 * 
	 * @param sender
	 *            the AcknowledgmentOfReceipt's sender
	 * @param receiver
	 *            the AcknowledgmentOfReceipt's receiver
	 * @param text
	 *            the AcknowledgmentOfReceipt's text
	 */
	public AcknowledgmentOfReceipt(Inhabitant sender, Inhabitant receiver,
			String text) {
		super(sender, receiver);
		this.content = new TextContent("acknowledgment of receipt for " + text);
	}

	public String toString() {
		return "an aknowledgment of receipt which is " + super.toString();
	}

}
