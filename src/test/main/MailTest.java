package test.main;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import test.mock.MockMail;

/**
 * Defines tests for the main class Mail.
 * 
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class MailTest {

	protected MockMail mail;
	protected ByteArrayOutputStream outContent;

	@Before
	public void createMail() {
		this.mail = new MockMail(20, 100);
	}

	@Before
	public void setUpStream() {
		this.outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(this.outContent));
	}

	@Test
	public void testRun() {
		assertTrue(this.mail.mockRun("CityTest", 100, 6));
	}

	@After
	public void cleanUpStream() {
		System.setOut(null);
	}
}
