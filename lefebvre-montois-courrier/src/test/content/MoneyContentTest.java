package test.content;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import content.MoneyContent;

/**
 * Defines tests for {@link content.MoneyContent} class.
 * 
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class MoneyContentTest implements ContentTest {

	protected int amount;
	protected MoneyContent moneyContent;

	@Before
	public void createMoneyContent() {
		this.amount = 100;
		this.moneyContent = new MoneyContent(this.amount);
	}

	@Test
	public void testGetAmount() {
		assertSame(this.amount, this.moneyContent.getAmount());
	}

	@Test
	public void testToString() {
		assertEquals("a money content (" + this.amount + ")",
				this.moneyContent.toString());
	}
}
