package letter;

import content.TextContent;
import city.Inhabitant;

/**
 * Defines an <code>AknowledgmentOfReceipt</code>.
 * 
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class AknowledgmentOfReceipt extends SimpleLetter {

	/**
	 * Constructs an <code>AknowledgmentOfReceipt</code> with given
	 * {@link #sender sender}, {@link #receiver receiver} and
	 * {@link TextContent#text text}.
	 * 
	 * @param sender
	 *            the <code>AknowledgmentOfReceipt</code>'s {@link #sender
	 *            sender}
	 * @param receiver
	 *            the <code>AknowledgmentOfReceipt</code>'s {@link #receiver
	 *            receiver}
	 * @param text
	 *            the <code>AknowledgmentOfReceipt</code>'s
	 *            {@link TextContent#text text}
	 */
	public AknowledgmentOfReceipt(Inhabitant sender, Inhabitant receiver,
			String text) {
		super(sender, receiver, "aknowledgment of receipt for " + text);
	}

	public String toString() {
		return "an aknowledgment of receipt which is " + super.toString();
	}
}
