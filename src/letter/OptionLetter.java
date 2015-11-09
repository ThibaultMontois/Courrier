package letter;

import city.Inhabitant;
import content.Content;

/**
 * Defines an OptionLetter.
 * 
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public abstract class OptionLetter extends Letter<Content> {

	protected Letter<?> content;

	/**
	 * Constructs an OptionLetter with given sender, receiver and Letter.
	 * 
	 * @param sender
	 *            the OptionLetter's sender
	 * @param receiver
	 *            the OptionLetter's receiver
	 * @param letter
	 *            the OptionLetter's content
	 */
	public OptionLetter(Inhabitant sender, Inhabitant receiver, Letter<?> letter) {
		super(sender, receiver);
		this.content = letter;
	}

}
