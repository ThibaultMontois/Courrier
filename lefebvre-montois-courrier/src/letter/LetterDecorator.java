package letter;

/**
 * Defines a <code>LetterDecorator</code>.
 * 
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public abstract class LetterDecorator extends Letter<Letter<?>> {

	/**
	 * Constructs a <code>LetterDecorator</code> with given {@link Letter
	 * letter}.
	 * 
	 * @param letter
	 *            the <code>LetterDecorator</code>'s {@link #content content}
	 */
	public LetterDecorator(Letter<?> letter) {
		super(letter.getSender(), letter.getReceiver());
		this.content = letter;
	}
}
