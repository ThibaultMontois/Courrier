package test.letter;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.Mail;
import letter.UrgentLetter;

/**
 * Defines tests for UrgentLetter class.
 * 
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class UrgentLetterTest extends LetterDecoratorTest {

	@Override
	protected void reallyCreateLetter() {
		super.reallyCreateLetter();
		this.letter = new UrgentLetter(this.sender, this.receiver,
				this.printer, this.content);
	}

	@Test
	public void testGetCost() {
		assertSame(Mail.COST * Mail.MULTCOST, this.letter.getCost());
	}

	@Override
	protected void testReallyDoAction() {
		this.letter.doAction();
	}

	@Test
	public void testToString() {
		assertEquals(
				"an urgent letter whose content is " + this.content.toString(),
				this.letter.toString());
	}
}
