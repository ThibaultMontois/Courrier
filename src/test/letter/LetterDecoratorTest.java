package test.letter;

import static org.junit.Assert.assertNotNull;

import letter.Letter;
import letter.SimpleLetter;

/**
 * Defines tests for OptionLetter classes.
 * 
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public abstract class LetterDecoratorTest extends LetterTest<Letter<?>> {

	protected Letter<?> content;

	@Override
	protected void reallyCreateLetter() {
		this.content = new SimpleLetter(this.sender, this.receiver,
				this.printer, "TextTest");
		assertNotNull(this.content);
	}
}
