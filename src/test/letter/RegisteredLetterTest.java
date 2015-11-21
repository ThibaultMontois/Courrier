package test.letter;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.Mail;
import letter.RegisteredLetter;

/**
 * Defines tests for RegisteredLetter class.
 * 
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class RegisteredLetterTest extends LetterDecoratorTest {

	@Override
	protected void reallyCreateLetter() {
		super.reallyCreateLetter();
		this.letter = new RegisteredLetter(this.content);
	}

	@Test
	public void testGetCost() {
		assertSame(Mail.COST + Mail.ADDCOST, this.letter.getCost());
	}

	@Override
	protected void testReallyDoAction() {
		int amountS = this.sender.getBankAccount();
		int amountR = this.receiver.getBankAccount();
		this.letter.doAction();
		assertEquals(amountS, this.sender.getBankAccount());
		assertEquals(amountR - Mail.COST, this.receiver.getBankAccount());
	}

	@Test
	public void testToString() {
		assertEquals("a registered letter " + "whose content is "
				+ this.content.toString(), this.letter.toString());
	}
}
