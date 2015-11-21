package letter;

import content.TextContent;
import city.Inhabitant;

/**
 * Defines a <code>ThanksLetter</code>.
 * 
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class ThanksLetter extends SimpleLetter {

	/**
	 * Constructs a <code>ThanksLetter</code> with given {@link #sender sender},
	 * {@link #receiver receiver} and {@link TextContent#text text}.
	 * 
	 * @param sender
	 *            the <code>ThanksLetter</code>'s {@link #sender sender}
	 * @param receiver
	 *            the <code>ThanksLetter</code>'s {@link #receiver receiver}
	 * @param text
	 *            the <code>ThanksLetter</code>'s {@link TextContent#text text}
	 */
	public ThanksLetter(Inhabitant sender, Inhabitant receiver, String text) {
		super(sender, receiver, "thanks for " + text);
	}

	public String toString() {
		return "a thanks letter which is " + super.toString();
	}
}
