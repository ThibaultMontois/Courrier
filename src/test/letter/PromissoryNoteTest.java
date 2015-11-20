package test.letter;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.Mail;
import content.MoneyContent;
import letter.PromissoryNote;

/**
 * Defines tests for PromissoryNote class.
 * 
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class PromissoryNoteTest extends LetterTest<MoneyContent> {

	protected int amount;

	@Override
	protected void reallyCreateLetter() {
		this.amount = 100;
		this.letter = new PromissoryNote(this.sender, this.receiver,
				this.amount);
	}

	@Test
	public void testGetCost() {
		assertSame(Mail.COST + this.amount * Mail.FACTOR / 100,
				this.letter.getCost());
	}

	@Override
	protected void testReallyDoAction() {
		int amountS = this.sender.getBankAccount();
		int amountR = this.receiver.getBankAccount();
		this.letter.doAction();
		assertEquals(amountS - this.amount, this.sender.getBankAccount());
		assertEquals(amountR + this.amount - Mail.COST,
				this.receiver.getBankAccount());
	}

	@Test
	public void testToString() {
		assertEquals("a promissory note letter "
				+ "whose content is a money content (" + this.amount + ")",
				this.letter.toString());
	}
}
