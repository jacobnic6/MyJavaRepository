import java.time.LocalDate;

/**  
* Nicholas Jacobs - ndjacobs2  
* CIS171 <11232>
* Nov 3, 2023  
*/
public class MoneyClipTesterJacobs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		EmployeeBadge myEmpBadge = new EmployeeBadge("Nick", "0012345");
		StudentAccess myStudentAccess = new StudentAccess("Nick", "0098778", LocalDate.of(2026, 5, 23));
		MoneyClip myClip = new MoneyClip(myEmpBadge, myStudentAccess);

		StudentAccess yourStudentAccess = new StudentAccess("Bill", "0098445", LocalDate.of(2010, 5, 23));
		GymMembership yourGymMembership = new GymMembership("Bill", "0099654");
		MoneyClip yourClip = new MoneyClip(yourGymMembership, yourStudentAccess);
		
		StudentAccess fredStudentAccess = new StudentAccess("Bill", "0098445", LocalDate.of(2010, 5, 23));
		EmployeeBadge fredEmpBadge = new EmployeeBadge("Fred", "0245611");
		MoneyClip fredClip = new MoneyClip(fredEmpBadge, fredStudentAccess);

		System.out.println(myClip.displayContents());
		System.out.println(yourClip.displayContents());
		System.out.println(fredClip.displayContents());
		
		System.out.println("Cards are the same: " + fredStudentAccess.equals(yourStudentAccess));
		System.out.println(fredStudentAccess.getName() +"'s card is expired: "+yourStudentAccess.isExpired());
		System.out.println(myStudentAccess.getName()+"'s card is expired: "+ myStudentAccess.isExpired());

	}

}
