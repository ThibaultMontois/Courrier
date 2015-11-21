package letter;

import city.Inhabitant;
import content.TextContent;
import printer.Printer;

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
	public SimpleLetter(Inhabitant sender, Inhabitant receiver,
			Printer printer, String text) {
		super(sender, receiver, printer);
		this.content = new TextContent(text);
	}

	/**
	 * Called by <code>doAction</code> method.
	 */
	@Override
	protected void reallyDoAction() {
	}

	public String toString() {
		return "a simple letter whose content is " + this.content.toString();
	}
}
