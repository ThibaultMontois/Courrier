package content;

/**
 * Defines a <code>TextContent</code>.
 * 
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class TextContent implements Content {

	protected String text;

	/**
	 * Constructs a <code>TextContent</code> with given {@link #text} .
	 * 
	 * @param text
	 *            the <code>TextContent</code>'s {@link #text}
	 */
	public TextContent(String text) {
		this.text = text;
	}

	public String getText() {
		return this.text;
	}

	public String toString() {
		return "a text content (" + this.text + ")";
	}

}
