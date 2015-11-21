package letter;

import main.Mail;
import city.Inhabitant;
import content.MoneyContent;

/**
 * Defines a <code>PromissoryNote</code>.
 * 
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class PromissoryNote extends Letter<MoneyContent> {

	protected int factor;

	/**
	 * Constructs a <code>PromissoryNote</code> with given {@link #sender
	 * sender}, {@link #receiver receiver} and {@link MoneyContent#amount
	 * amount}.
	 * 
	 * @param sender
	 *            the <code>PromissoryNote</code>'s {@link #sender sender}
	 * @param receiver
	 *            the <code>PromissoryNote</code>'s {@link #receiver receiver}
	 * @param amount
	 *            the <code>PromissoryNote</code>'s {@link MoneyContent#amount
	 *            amount}
	 */
	public PromissoryNote(Inhabitant sender, Inhabitant receiver, int amount) {
		super(sender, receiver);
		this.content = new MoneyContent(amount);
		this.factor = Mail.PNFACTOR;
	}

	/**
	 * This kind of {@link Letter letter}'s {@link #cost cost} is increased by
	 * {@link #factor} percent of the {@link MoneyContent money content}'s
	 * [@link MoneyContent#amount amount}.
	 */
	public int getCost() {
		return this.cost + (this.content.getAmount() * this.factor) / 100;
	}

	/**
	 * Called by {@link #doAction() doAction} method.
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
