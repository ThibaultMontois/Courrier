package test.letter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import letter.ThanksLetter;

/**
 * Defines tests for {@link letter.ThanksLetter} class.
 * 
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class ThanksLetterTest extends SimpleLetterTest {

	@Override
	protected void reallyCreateLetter() {
		this.letter = new ThanksLetter(this.sender, this.receiver, this.text);
	}

	@Test
	public void testToString() {
		assertEquals("a thanks letter which is a simple letter "
				+ "whose content is a text content (thanks for " + this.text
				+ ")", this.letter.toString());
	}
}
