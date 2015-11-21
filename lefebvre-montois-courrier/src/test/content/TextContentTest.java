package test.content;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import content.TextContent;

/**
 * Defines tests for {@link content.TextContent} class.
 * 
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class TextContentTest implements ContentTest {

	protected String text;
	protected TextContent textContent;

	@Before
	public void createMoneyContent() {
		this.text = "TextTest";
		this.textContent = new TextContent(this.text);
	}

	@Test
	public void testGetText() {
		assertEquals(this.text, this.textContent.getText());
	}

	@Test
	public void testToString() {
		assertEquals("a text content (" + this.text + ")",
				this.textContent.toString());
	}
}
