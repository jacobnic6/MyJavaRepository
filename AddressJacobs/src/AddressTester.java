
public class AddressTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Address home = new Address("123 Ringling Rd.", "Des Moines", "IA", "50131");
		Address condo = new Address("5643 Hideaway Mountain", "Apt 3C","Nashville",
				"TN", "37115");
		System.out.println(home.print());
		System.out.println(condo.print());
	}

}
