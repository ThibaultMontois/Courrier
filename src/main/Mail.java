package main;

import java.util.Random;

import letter.Letter;
import letter.PromissoryNote;
import letter.RegisteredLetter;
import letter.SimpleLetter;
import letter.UrgentLetter;

import city.City;
import city.Inhabitant;

/**
 * Defines the main class Mail.
 * 
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class Mail {

	private Random random = new Random();

	public static void main(String[] args) {
		Mail mail = new Mail();
		try {
			mail.run("Lille", 100, 6);
		} catch (InterruptedException e) {
			System.out.println("Thread.sleep() error");
		}
	}

	public void run(String cityName, int inhabitants, int days) throws InterruptedException {
		System.out.println("Creating Lille city");
		System.out.println("Creating 100 inhabitants");
		System.out.println("Mailing letters for 6 days");

		City city = new City(cityName, inhabitants);
		Letter<?> letter;
		int tmp;
		int sender;
		int receiver;

		for (int k = 0; k < days || !city.getPostbox().isEmpty(); k++) {
			System.out.println("****************************************");
			System.out.println("Day " + (k + 1));

			if (k < days) {
				tmp = this.random.nextInt(100) + 1;
				for (int i = 0; i < tmp; i++) {
					sender = this.random.nextInt(inhabitants);
					do {
						Thread.sleep(100);
					} while ((receiver = this.random.nextInt(inhabitants)) == sender);
					letter = this.randomLetter(city.getInhabitants()
							.get(sender), city.getInhabitants().get(receiver));
					System.out.print(city.sendLetter(letter));
				}
			}

			System.out.print(city.distributeLetters());
		}
	}

	private Letter<?> randomLetter(Inhabitant sender, Inhabitant receiver) {
		switch (this.random.nextInt(4)) {
		case 1:
			int amount = this.random.nextInt(100) + 1;
			return new PromissoryNote(sender, receiver, amount);
		case 2:
			return new RegisteredLetter(sender, receiver,
					this.randomRegisteredLetter(sender, receiver));
		case 3:
			return new UrgentLetter(sender, receiver, this.randomUrgentLetter(
					sender, receiver));
		default:
			return new SimpleLetter(sender, receiver, "bla bla");
		}
	}

	private Letter<?> randomRegisteredLetter(Inhabitant sender,
			Inhabitant receiver) {
		switch (this.random.nextInt(3)) {
		case 1:
			int amount = this.random.nextInt(100) + 1;
			return new PromissoryNote(sender, receiver, amount);
		case 2:
			return new UrgentLetter(sender, receiver,
					this.randomUrgentAndRegisteredLetter(sender, receiver));
		default:
			return new SimpleLetter(sender, receiver, "bla bla");
		}
	}

	private Letter<?> randomUrgentLetter(Inhabitant sender, Inhabitant receiver) {
		switch (this.random.nextInt(3)) {
		case 1:
			int amount = this.random.nextInt(100) + 1;
			return new PromissoryNote(sender, receiver, amount);
		case 2:
			return new RegisteredLetter(sender, receiver,
					this.randomUrgentAndRegisteredLetter(sender, receiver));
		default:
			return new SimpleLetter(sender, receiver, "bla bla");
		}
	}

	private Letter<?> randomUrgentAndRegisteredLetter(Inhabitant sender,
			Inhabitant receiver) {
		switch (this.random.nextInt(2)) {
		case 1:
			int amount = this.random.nextInt(100) + 1;
			return new PromissoryNote(sender, receiver, amount);
		default:
			return new SimpleLetter(sender, receiver, "bla bla");
		}
	}
}
