package test.letter;

import letter.Letter;
import letter.SimpleLetter;

/**
 * Defines tests for {@link letter.LetterDecorator} classes.
 * 
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public abstract class LetterDecoratorTest extends LetterTest<Letter<?>> {

	protected Letter<?> content;

	@Override
	protected void reallyCreateLetter() {
		this.content = new SimpleLetter(this.sender, this.receiver, "TextTest");
	}
}
