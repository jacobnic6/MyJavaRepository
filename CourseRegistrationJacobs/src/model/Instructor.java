package model;

public class Instructor {
	String firstName;
	String lastName;
	String email;
	
	
	public Instructor() {}
	
	public Instructor(String firstName, String lastName, String email) {
		super();
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(email);
	}
	public Instructor(String firstName, String lastName) {
		super();
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(makeEmailAddress(firstName, lastName));
	}

	public String makeEmailAddress(String firstName, String lastName) {
		String emailAddress = firstName.substring(0, 1) + lastName + "@dmacc.edu";
		return emailAddress.toLowerCase();
		
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Instructor [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	
	
}
