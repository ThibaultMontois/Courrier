package test.content;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import content.MoneyContent;

/**
 * Defines tests for MoneyContent class.
 * 
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class MoneyContentTest implements ContentTest {

	private MoneyContent moneyContent;

	@Before
	public void createContent() {
		this.moneyContent = new MoneyContent(10);
	}

	@Test
	public void testGetAmount() {
		assertSame(10, this.moneyContent.getAmount());
	}

	@Test
	public void testToString() {
		assertEquals("a money content (10)", this.moneyContent.toString());
	}
}
