import model.Blanket;
import model.ElectricBlanket;

/**
 * Nicholas Jacobs - ndjacobs2 CIS171 <11232> Nov 30, 2023
 */
public class BlanketTesterJacobs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Blanket blanketOne = new Blanket("king", "gold", "cashmere");
		Blanket blanketTwo = new ElectricBlanket("king", "red", "cashmere", 5, true);

		Blanket blanketThree = new Blanket("twin", "black", "wool");
		Blanket blanketFour = new ElectricBlanket("queen", "multi-colored", "cotton", 1, false);
		
		// tests that our exception is thrown when the user inputs incorrect information
				// Blanket badBlanket = new Blanket("twwin", "red", "wool");
		
		//commented out to use our ArrayList in the Blanket class so we can more efficiently add the blankets
//		ArrayList<Blanket> blanketArray = new ArrayList<Blanket>();
//		blanketArray.add(blanketOne);
//		blanketArray.add(blanketTwo);
//		blanketArray.add(blanketThree);
//		blanketArray.add(blanketFour);
//
//		for (Blanket blanket : blanketArray) {
//			if (blanket.getPrice() < 100) {
//				System.out.println(blanket.featureReport());
//			}
//		}
		System.out.println(blanketFour.getLessthan(100));;

		

	}

}
