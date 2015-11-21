package letter;

import city.Inhabitant;
import content.TextContent;

/**
 * Defines a <code>SimpleLetter</code>.
 * 
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class SimpleLetter extends Letter<TextContent> {

	/**
	 * Constructs a <code>SimpleLetter</code> with given {@link #sender sender},
	 * {@link #receiver receiver} and {@link TextContent#text text}.
	 * 
	 * @param sender
	 *            the <code>SimpleLetter</code>'s {@link #sender sender}
	 * @param receiver
	 *            the <code>SimpleLetter</code>'s {@link #receiver receiver}
	 * @param text
	 *            the <code>SimpleLetter</code>'s {@link TextContent#text text}
	 */
	public SimpleLetter(Inhabitant sender, Inhabitant receiver, String text) {
		super(sender, receiver);
		this.content = new TextContent(text);
	}

	/**
	 * Called by {@link #doAction() doAction} method.
	 */
	@Override
	protected void reallyDoAction() {
	}

	public String toString() {
		return "a simple letter whose content is " + this.content.toString();
	}
}
