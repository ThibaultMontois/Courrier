package test.letter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import letter.AknowledgmentOfReceipt;

/**
 * Defines tests for AknowledgmentOfReceipt class.
 * 
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class AknowledgmentOfReceiptTest extends SimpleLetterTest {

	@Override
	protected void reallyCreateLetter() {
		this.letter = new AknowledgmentOfReceipt(this.sender, this.receiver,
				this.text);
	}

	@Test
	public void testToString() {
		assertEquals("an aknowledgment of receipt "
				+ "which is a simple letter "
				+ "whose content is a text content "
				+ "(aknowledgment of receipt for " + this.text + ")",
				this.letter.toString());
	}
}
