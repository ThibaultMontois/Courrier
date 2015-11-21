package test.mock;

import main.Mail;

/**
 * Defines a Mail's Mock.
 * 
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class MockMail extends Mail {

	public MockMail(int maxLetters, int maxAmount) {
		super(maxLetters, maxAmount);
	}

	public boolean mockRun(String cityName, int inhabitants, int days) {
		try {
			this.run(cityName, inhabitants, days);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
