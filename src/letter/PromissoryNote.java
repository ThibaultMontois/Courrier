package letter;

import main.Mail;
import city.Inhabitant;
import content.MoneyContent;

/**
 * Defines a PromissoryNote.
 * 
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class PromissoryNote extends Letter<MoneyContent> {

	protected int factor;

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
		super(sender, receiver);
		this.content = new MoneyContent(amount);
		this.factor = Mail.FACTOR;
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
	protected String reallyDoAction() {
		String str = this.sender.debit(this.content.getAmount());
		str += this.receiver.credit(this.content.getAmount());
		str += this.receiver.getCity().sendLetter(
				new ThanksLetter(this.receiver, this.sender, this.toString()));
		return str;
	}

	public String toString() {
		return "a promissory note letter whose content is "
				+ this.content.toString();
	}
}
