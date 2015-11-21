package city;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import letter.Letter;
import printer.Printer;
import printer.StandardPrinter;

/**
 * Defines a City.
 * 
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class City {

	protected String name;
	protected List<Inhabitant> inhabitants;
	protected List<Letter<?>> postbox;
	protected Printer printer;

	/**
	 * Constructs a City with given name.
	 * 
	 * @param name
	 *            the City's name
	 */
	public City(String name) {
		this.name = name;
		this.inhabitants = new ArrayList<Inhabitant>();
		this.postbox = new LinkedList<Letter<?>>();
		this.printer = new StandardPrinter();
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

	public List<Letter<?>> getPostbox() {
		return this.postbox;
	}

	public void setPrinter(Printer printer) {
		this.printer = printer;
	}

	/**
	 * Adds a Letter in the postbox.
	 * 
	 * @param letter
	 *            the Letter to add
	 */
	public void sendLetter(Letter<?> letter) {
		this.postbox.add(letter);
		this.printer.printSendLetter(letter);
		letter.getSender().debit(letter.getCost());
	}

	/**
	 * Distributes all the postbox's Letters.
	 */
	public void distributeLetters() {
		List<Letter<?>> bag = new LinkedList<Letter<?>>(this.postbox);
		this.postbox.clear();
		for (Letter<?> letter : bag)
			letter.doAction();
	}
}
