package main;

import java.util.Random;

import city.City;
import city.Inhabitant;
import letter.Letter;
import letter.SimpleLetter;
import letter.PromissoryNote;
import letter.RegisteredLetter;
import letter.UrgentLetter;

/**
 * Defines the main class <code>Mail</code>.
 * 
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class Mail {

	// default Inhabitant's bank account
	public static final int BANKACCOUNT = 5000;
	// default Letter's cost
	public static final int COST = 1;
	// default PromissoryNote factor
	public static final int PNFACTOR = 1;
	// default RegisteredLetter's additional cost
	public static final int ADDCOST = 15;
	// default UrgentLetter's cost multiplier
	public static final int MULTCOST = 2;

	// the maximum number of letters sent each day
	private int maxLetters;
	// the maximum PromissoryNote's amount
	private int maxAmount;

	private Random random;

	/**
	 * Constructs a <code>Mail</code> with given {@link #maxLetters maximum
	 * letters} and {@link #maxAmount maximum amount}.
	 * 
	 * @param maxLetters
	 *            the maximum number of {@link Letter letters} sent each day
	 * @param maxAmount
	 *            the maximum {@link PromissoryNote promissory note}'s
	 *            {@link content.MoneyContent#amount amount}
	 */
	public Mail(int maxLetters, int maxAmount) {
		this.maxLetters = maxLetters;
		this.maxAmount = maxAmount;
		this.random = new Random();
	}

	public static void main(String[] args) {
		Mail mail = new Mail(20, 100);
		mail.run("Lille", 100, 6);
	}

	/**
	 * Runs the <code>Mail</code> program.
	 * 
	 * @param cityName
	 *            the {@link City city}'s {@link City#name name}
	 * @param inhabitants
	 *            the number of {@link Inhabitant inhabitants}
	 * @param days
	 *            the number of days that {@link Letter letters} will be sent
	 */
	public void run(String cityName, int inhabitants, int days) {
		System.out.println("Creating " + cityName + " city");
		System.out.println("Creating " + inhabitants + " inhabitants");
		System.out.println("Mailing letters for " + days + " days");

		City city = new City(cityName, inhabitants);
		Letter<?> letter;
		int tmp;
		int sender;
		int receiver;

		for (int k = 0; k < days || !city.getPostbox().isEmpty(); k++) {
			System.out.println("****************************************");
			System.out.println("Day " + (k + 1));

			if (k < days) {
				tmp = this.random.nextInt(this.maxLetters) + 1;
				for (int i = 0; i < tmp; i++) {
					sender = this.random.nextInt(inhabitants);
					do {
						receiver = this.random.nextInt(inhabitants);
					} while (receiver == sender);
					letter = this.randomLetter(city.getInhabitants()
							.get(sender), city.getInhabitants().get(receiver));
					city.sendLetter(letter);
				}
			}

			city.distributeLetters();
		}
	}

	// Returns a Letter
	private Letter<?> randomLetter(Inhabitant sender, Inhabitant receiver) {
		switch (this.random.nextInt(4)) {
		case 1:
			int amount = this.random.nextInt(this.maxAmount) + 1;
			return new PromissoryNote(sender, receiver, amount);
		case 2:
			return new RegisteredLetter(this.randomRegisteredLetter(sender,
					receiver));
		case 3:
			return new UrgentLetter(this.randomUrgentLetter(sender, receiver));
		default:
			return new SimpleLetter(sender, receiver, "bla bla");
		}
	}

	// Returns a Registered Letter that not contains another Registered Letter
	private Letter<?> randomRegisteredLetter(Inhabitant sender,
			Inhabitant receiver) {
		switch (this.random.nextInt(3)) {
		case 1:
			int amount = this.random.nextInt(this.maxAmount) + 1;
			return new PromissoryNote(sender, receiver, amount);
		case 2:
			return new UrgentLetter(this.randomUrgentAndRegisteredLetter(
					sender, receiver));
		default:
			return new SimpleLetter(sender, receiver, "bla bla");
		}
	}

	// Returns an Urgent Letter that not contains another Urgent Letter
	private Letter<?> randomUrgentLetter(Inhabitant sender, Inhabitant receiver) {
		switch (this.random.nextInt(3)) {
		case 1:
			int amount = this.random.nextInt(this.maxAmount) + 1;
			return new PromissoryNote(sender, receiver, amount);
		case 2:
			return new RegisteredLetter(this.randomUrgentAndRegisteredLetter(
					sender, receiver));
		default:
			return new SimpleLetter(sender, receiver, "bla bla");
		}
	}

	// Returns an Urgent and Registered Letter that not contains another Urgent
	// or Registered Letter
	private Letter<?> randomUrgentAndRegisteredLetter(Inhabitant sender,
			Inhabitant receiver) {
		switch (this.random.nextInt(2)) {
		case 1:
			int amount = this.random.nextInt(this.maxAmount) + 1;
			return new PromissoryNote(sender, receiver, amount);
		default:
			return new SimpleLetter(sender, receiver, "bla bla");
		}
	}
}
