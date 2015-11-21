package city;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import letter.Letter;
import printer.Printer;
import printer.StandardPrinter;

/**
 * Defines a <code>City<c/ode>.
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
	 * Constructs a <code>City</code> with given {@link #name}.
	 * 
	 * @param name
	 *            the <code>City</code>'s {@link #name}
	 */
	public City(String name) {
		this.name = name;
		this.inhabitants = new ArrayList<Inhabitant>();
		this.postbox = new LinkedList<Letter<?>>();
		this.printer = new StandardPrinter();
	}

	/**
	 * Constructs a <code>City</code> with given {@link #name} and
	 * <code>numberOfInhabitants</code> {@link Inhabitant inhabitants}.
	 * 
	 * @param name
	 *            the <code>City</code>'s {@link #name}
	 * @param numberOfInhabitants
	 *            the number of {@link Inhabitant inhabitants}
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
	 * Adds a {@link Letter letter} in the {@link #postbox}.
	 * 
	 * @param letter
	 *            the {@link Letter letter} to add
	 */
	public void sendLetter(Letter<?> letter) {
		this.postbox.add(letter);
		this.printer.printSendLetter(letter);
		letter.getSender().debit(letter.getCost());
	}

	/**
	 * Distributes all the {@link #postbox}'s {@link Letter letters}.
	 */
	public void distributeLetters() {
		List<Letter<?>> bag = new LinkedList<Letter<?>>(this.postbox);
		this.postbox.clear();
		for (Letter<?> letter : bag)
			letter.doAction();
	}

}
