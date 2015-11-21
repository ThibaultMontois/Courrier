package test.letter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import content.TextContent;
import letter.SimpleLetter;

/**
 * Defines tests for SimpleLetter classes.
 * 
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class SimpleLetterTest extends LetterTest<TextContent> {

	protected String text = "TextTest";

	@Override
	protected void reallyCreateLetter() {
		this.letter = new SimpleLetter(this.sender, this.receiver,
				this.printer, this.text);
	}

	@Override
	protected void testReallyDoAction() {
		this.letter.doAction();
	}

	@Test
	public void testToString() {
		assertEquals("a simple letter whose content is a text content ("
				+ this.text + ")", this.letter.toString());
	}
}
