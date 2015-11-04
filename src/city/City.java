package city;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import letter.Letter;

public class City {

	private String name;
	private List<Inhabitant> inhabitants = new ArrayList<Inhabitant>();
	private List<Letter<?>> postbox = new LinkedList<Letter<?>>();

	public City(String name) {
		this.name = name;
	}

	public City(String name, int number) {
		this(name);
		for (int i = 0; i < number; i++) {
			this.inhabitants.add(new Inhabitant(i + 1));
		}
	}

	public void sendLetter(Letter<?> letter) {
		this.postbox.add(letter);
	}

	public void distributeLetter() {
		List<Letter<?>> bag = new LinkedList<Letter<?>>(this.postbox);
		this.postbox.clear();
		for (Letter<?> letter : bag)
			letter.getReceiver().receiveLetter(letter);
	}
}
