import java.util.Objects;

/**  
* Nicholas Jacobs - ndjacobs2  
* CIS171 <11232>
* Nov 3, 2023  
*/
public class GymMembership extends Card{
	private String cardNumber;
	/**
	 * @param cardNumber
	 */
	public GymMembership(String name, String cardNumber) {
		super(name);
		this.cardNumber = cardNumber;
	}

	/**
	 * 
	 */
	public GymMembership() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String format() {
		return super.format() + ", Card Number: " + cardNumber;
	}

	/**
	 * @return the cardNumber
	 */
	public String getCardNumber() {
		return cardNumber;
	}

	/**
	 * @param cardNumber the cardNumber to set
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		GymMembership other = (GymMembership) obj;
		return Objects.equals(cardNumber, other.cardNumber);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cardNumber);
		return result;
	}
	
}
