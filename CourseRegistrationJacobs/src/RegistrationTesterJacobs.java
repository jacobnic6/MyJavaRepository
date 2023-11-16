import model.Classroom;

/**  
* Nicholas Jacobs - ndjacobs2  
* CIS171 <11232>
* Oct 27, 2023  
*/
public class RegistrationTesterJacobs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Classroom compSciLab = new Classroom("8", "17", "Ankeny", "Computer Lab", 20);
		Classroom bioLab = new Classroom("3", "28a", "Carroll", "Science Lab", 22);
		Classroom litRoom = new Classroom("Betts", "12", "Urban", "Classroom", 18);

		System.out.println(compSciLab.toString("compSciLab"));
		System.out.println(bioLab.toString("bioLab"));
		System.out.println(litRoom.toString("litRoom"));

	}

}
