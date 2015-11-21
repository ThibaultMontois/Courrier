package letter;

/**
 * Defines an LetterDecorator.
 * 
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public abstract class LetterDecorator extends Letter<Letter<?>> {

	/**
	 * Constructs an LetterDecorator with given Letter.
	 * 
	 * @param letter
	 *            the LetterDecorator's content
	 */
	public LetterDecorator(Letter<?> letter) {
		super(letter.getSender(), letter.getReceiver());
		this.content = letter;
	}
}
