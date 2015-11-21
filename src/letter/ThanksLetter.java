package letter;

import city.Inhabitant;

/**
 * Defines a ThanksLetter.
 * 
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class ThanksLetter extends SimpleLetter {

	/**
	 * Constructs a ThanksLetter with given sender, receiver and text.
	 * 
	 * @param sender
	 *            the ThanksLetter's sender
	 * @param receiver
	 *            the ThanksLetter's receiver
	 * @param text
	 *            the ThanksLetter's text
	 */
	public ThanksLetter(Inhabitant sender, Inhabitant receiver, String text) {
		super(sender, receiver, "thanks for " + text);
	}

	public String toString() {
		return "a thanks letter which is " + super.toString();
	}
}
