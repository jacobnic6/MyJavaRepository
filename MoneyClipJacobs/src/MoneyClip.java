
/**  
* Nicholas Jacobs - ndjacobs2  
* CIS171 <11232>
* Nov 3, 2023  
*/
public class MoneyClip {
	private Card slot1;
	private Card slot2;
	
	public MoneyClip() {
		super();
	}
	public MoneyClip(Card slot1, Card slot2) {
		this.slot1 = slot1;
		this.slot2 = slot2;
	}
	
	public void addCard(Card newCard) {
		if(slot1 == null) {
			slot1 = newCard;
		} else if(slot2 == null) {
			slot2 = newCard;
		}
	}
	
	public String displayContents() {
		return "Slot 1: " + slot1.format() + " | Slot 2: " + slot2.format();
	}
	
	
	
	/**
	 * @return the slot1
	 */
	public Card getSlot1() {
		return slot1;
	}
	/**
	 * @param slot1 the slot1 to set
	 */
	public void setSlot1(Card slot1) {
		this.slot1 = slot1;
	}
	/**
	 * @return the slot2
	 */
	public Card getSlot2() {
		return slot2;
	}
	/**
	 * @param slot2 the slot2 to set
	 */
	public void setSlot2(Card slot2) {
		this.slot2 = slot2;
	}
}
