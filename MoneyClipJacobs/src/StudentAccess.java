import java.time.LocalDate;
import java.util.Objects;

/**  
* Nicholas Jacobs - ndjacobs2  
* CIS171 <11232>
* Nov 3, 2023  
*/
public class StudentAccess extends Card{
	private String studentNumber;
	private LocalDate expirationDate;
	/**
	 * @param studentNumber
	 * @param expirationDate
	 */
	public StudentAccess(String name, String studentNumber, LocalDate expirationDate) {
		super(name);
		this.studentNumber = studentNumber;
		this.expirationDate = expirationDate;
	}
	/**
	 * 
	 */
	public StudentAccess() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String format() {
		return super.format() + ", Student Number: " + studentNumber + ", Expiration Date: " + expirationDate;
	}
	@Override
	public boolean isExpired() 
	{
		// TODO Auto-generated method stub
		LocalDate currentDate = LocalDate.now();
		LocalDate accessCardExpiredDate = this.getExpirationDate();
		if(accessCardExpiredDate.isBefore(currentDate))
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	/**
	 * @return the studentNumber
	 */
	public String getStudentNumber() {
		return studentNumber;
	}
	/**
	 * @param studentNumber the studentNumber to set
	 */
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	/**
	 * @return the expirationDate
	 */
	public LocalDate getExpirationDate() {
		return expirationDate;
	}
	/**
	 * @param expirationDate the expirationDate to set
	 */
	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentAccess other = (StudentAccess) obj;
		return Objects.equals(expirationDate, other.expirationDate)
				&& Objects.equals(studentNumber, other.studentNumber);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(expirationDate, studentNumber);
		return result;
	}
	
}
