package letter;

import city.Inhabitant;
import content.MoneyContent;

/**
 * Defines a PromissoryNote.
 * 
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class PromissoryNote extends Letter<MoneyContent> {

	protected int factor = 1;

	/**
	 * Constructs a PromissoryNote with given sender, receiver and amount.
	 * 
	 * @param sender
	 *            the PromissoryNote's sender
	 * @param receiver
	 *            the PromissoryNote's receiver
	 * @param amount
	 *            the PromissoryNote's amount
	 */
	public PromissoryNote(Inhabitant sender, Inhabitant receiver, int amount) {
		super(sender, receiver, amount);
	}
	
	protected MoneyContent createContent(Object content) {
		return new MoneyContent((Integer) content);
	}
	
	/**
	 * This kind of Letter cost is increased by <code>factor</code> percent of
	 * the Content's amount.
	 */
	public int getCost() {
		return this.cost + (this.content.getAmount() * this.factor) / 100;
	}

	/**
	 * Called by <code>doAction</code> method.
	 */
	@Override
	protected void reallyDoAction() {
		this.sender.debit(this.content.getAmount());
		this.receiver.credit(this.content.getAmount());
		this.receiver.getCity().sendLetter(
				new ThanksLetter(this.receiver, this.sender, this.toString()));
	}

	public String toString() {
		return "a promissory note letter whose content is "
				+ this.content.toString();
	}
}
