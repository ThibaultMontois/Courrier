package letter;

import city.Inhabitant;
import content.TextContent;

/**
 * Defines a SimpleLetter.
 * 
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class SimpleLetter extends Letter<TextContent> {

	/**
	 * Constructs a SimpleLetter with given sender, receiver and text.
	 * 
	 * @param sender
	 *            the SimpleLetter's sender
	 * @param receiver
	 *            the SimpleLetter's receiver
	 * @param text
	 *            the SimpleLetter's text
	 */
	public SimpleLetter(Inhabitant sender, Inhabitant receiver, String text) {
		super(sender, receiver);
		this.content = new TextContent(text);
	}

	/**
	 * Called by <code>doAction</code> method.
	 */
	@Override
	protected String reallyDoAction() {
		return "";
	}

	public String toString() {
		return "a simple letter whose content is " + this.content.toString();
	}
}
