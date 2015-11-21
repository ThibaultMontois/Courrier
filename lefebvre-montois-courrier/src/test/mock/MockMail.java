package test.mock;

import main.Mail;

/**
 * Defines a {@link main.Mail}'s Mock.
 * 
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class MockMail extends Mail {

	/**
	 * {@inheritDoc}
	 */
	public MockMail(int maxLetters, int maxAmount) {
		super(maxLetters, maxAmount);
	}

	/**
	 * Runs the {@link main.Mail} program and checks if no exception is raised
	 * during the execution.
	 * 
	 * @param cityName
	 *            the {@link city.City city}'s {@link city.City#name name}
	 * @param inhabitants
	 *            the number of {@link city.Inhabitant inhabitants}
	 * @param days
	 *            the number of days that {@link letter.Letter letters} will be
	 *            sent
	 * 
	 * @return <code>true</code> if no exception is raised during the to program
	 *         execution, else <code>false</code>
	 */
	public boolean mockRun(String cityName, int inhabitants, int days) {
		try {
			this.run(cityName, inhabitants, days);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
