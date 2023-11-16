import java.util.Objects;

/**  
* Nicholas Jacobs - ndjacobs2  
* CIS171 <11232>
* Nov 3, 2023  
*/
public class Card {
	private String name;
	
	public Card() {
		
	}
	public Card(String name) {
		this.name = name;
	}
	//generate getters and setters
	 //generate toString( )
	
	 //Create these Helper methods
	 public boolean isExpired(){
	 return false;
	 }
	 public String format() {
	 return "Card holder: " + name;
	 }
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return Objects.equals(name, other.name);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Card [name=" + name + "]";
	}
}
