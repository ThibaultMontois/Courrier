package test.main;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import main.Mail;

import test.mock.MockMail;

/**
 * Defines tests for the main class Mail.
 * 
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class MailTest {

	protected Mail mail;
	protected ByteArrayOutputStream outContent;

	@Before
	public void createMail() {
		this.mail = new MockMail(20, 100);
		assertNotNull(this.mail);
	}

	@Before
	public void setUpStream() {
		this.outContent = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(this.outContent);
		System.setOut(printStream);
		assertNotNull(this.outContent);
		assertNotNull(printStream);
	}

	@Test
	public void testRun() {
		assertTrue(((MockMail) this.mail).mockRun("CityTest", 100, 6));
	}

	@After
	public void cleanUpStream() {
		System.setOut(null);
	}
}
