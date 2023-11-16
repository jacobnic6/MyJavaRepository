import java.util.Objects;

/**  
* Nicholas Jacobs - ndjacobs2  
* CIS171 <11232>
* Nov 3, 2023  
*/
public class EmployeeBadge extends Card{
	private String badgeNumber;

	
	
	/**
	 * @param badgeNumber
	 */
	public EmployeeBadge(String name, String badgeNumber) {
		super(name);
		this.badgeNumber = badgeNumber;
	}

	/**
	 * 
	 */
	public EmployeeBadge() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String format() {
		return super.format() + ", Badge Number: " + badgeNumber;
	}

	/**
	 * @return the badgeNumber
	 */
	public String getBadgeNumber() {
		return badgeNumber;
	}

	/**
	 * @param badgeNumber the badgeNumber to set
	 */
	public void setBadgeNumber(String badgeNumber) {
		this.badgeNumber = badgeNumber;
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeBadge other = (EmployeeBadge) obj;
		return Objects.equals(badgeNumber, other.badgeNumber);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(badgeNumber);
		return result;
	}
	
	
}
