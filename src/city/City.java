package city;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import letter.Letter;

/**
 * Defines a City.
 * 
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class City {

	private String name;
	private List<Inhabitant> inhabitants = new ArrayList<Inhabitant>();
	private List<Letter<?>> postbox = new LinkedList<Letter<?>>();

	/**
	 * Constructs a City with given name.
	 * 
	 * @param name
	 *            the City's name
	 */
	public City(String name) {
		this.name = name;
	}

	/**
	 * Constructs a City with given name and <code>numberOfInhabitants</code>
	 * Inhabitants.
	 * 
	 * @param name
	 *            the City's name
	 * @param numberOfInhabitants
	 *            the number of Inhabitants
	 */
	public City(String name, int numberOfInhabitants) {
		this(name);
		for (int i = 0; i < numberOfInhabitants; i++) {
			this.inhabitants.add(new Inhabitant(i + 1, this));
		}
	}

	public String getName() {
		return this.name;
	}

	public List<Inhabitant> getInhabitants() {
		return this.inhabitants;
	}

	public List<Letter<?>> getPostBox() {
		return this.postbox;
	}

	/**
	 * Adds a Letter in the postbox.
	 * 
	 * @param letter
	 *            the Letter to add
	 */
	public void sendLetter(Letter<?> letter) {
		String tmp = letter.getCost() < 2 ? " euro" : " euros";
		System.out.println("-> " + letter.getSender().getName() + " mails "
				+ letter.toString() + " to " + letter.getReceiver().getName()
				+ " for a cost of " + letter.getCost() + tmp);
		this.postbox.add(letter);
		letter.getSender().debit(letter.getCost());
	}

	/**
	 * Distributes all the postbox's Letter.
	 */
	public void distributeLetters() {
		List<Letter<?>> bag = new LinkedList<Letter<?>>(this.postbox);
		this.postbox.clear();
		for (Letter<?> letter : bag)
			letter.doAction();
	}
}
