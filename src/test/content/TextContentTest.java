package test.content;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import content.TextContent;

/**
 * Defines tests for TextContent class.
 * 
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class TextContentTest implements ContentTest {

	private TextContent textContent;

	@Before
	public void createContent() {
		this.textContent = new TextContent("TextContentTest");
	}

	@Test
	public void testGetText() {
		assertEquals("TextContentTest", this.textContent.getText());
	}

	@Test
	public void testToString() {
		assertEquals("a text content (TextContentTest)", this.textContent.toString());
	}
}
