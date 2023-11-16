
/**
 * Nicholas Jacobs - ndjacobs2 CIS171 <11232> Oct 27, 2023
 */
public class Address {
	private String address;
	private String address2;
	private String city;
	private String state;
	private String postalCode;

	public Address() {}

	public Address(String address, String address2, String city, String state, String postalCode) {
		setAddress(address);
		setAddress2(address2);
		setCity(city);
		setState(state);
		setPostalCode(postalCode);
	}

	public Address(String address, String city, String state, String postalCode) {
		setAddress(address);
		setCity(city);
		setState(state);
		setPostalCode(postalCode);
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the address2
	 */
	public String getAddress2() {
		return address2;
	}

	/**
	 * @param address2 the address2 to set
	 */
	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the zipCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @param zipCode the zipCode to set
	 */
	public void setPostalCode(String zipCode) {
		this.postalCode = zipCode;
	}

	public String print() {
		String addressMsg;
		if (address2 != null) {
			addressMsg = address + " " + address2 + " " + city + ", " + state + " " + postalCode;
		} else {
			addressMsg = address + " " + city + ", " + state + " " + postalCode;
		}
		return addressMsg;
	}
}
