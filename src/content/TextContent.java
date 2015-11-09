package content;

/**
 * Defines a TextContent.
 * 
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class TextContent implements Content {

	protected String text;

	/**
	 * Constructs a MoneyContent with given text.
	 * 
	 * @param text
	 *            the Content's text
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
