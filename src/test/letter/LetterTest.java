package test.letter;

import org.junit.Test;

import test.content.ContentTest;
import content.Content;

/**
 * Defines tests for Letter classes.
 * 
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public abstract class LetterTest<C extends Content> implements ContentTest {

	@Test
	public void testGetSender() {

	}

	@Test
	public void testGetReceiver() {

	}

	@Test
	public void testGetCost() {

	}
}
