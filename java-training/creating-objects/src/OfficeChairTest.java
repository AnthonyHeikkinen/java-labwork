
public class OfficeChairTest {

	public static void main (String args[]){
		OfficeChair nwton = new OfficeChair (5, 46, "soft");
		nwton.printStates();
		
		System.out.println("\n");
		
		nwton.lower(10);
		nwton.printStates();
		
		System.out.println("\n");
		
		OfficeChair morten = new MioOfficeChair (7, 52, "very soft", "blueish cotton");
		morten.printStates();
		
		
		//morten.setMaterial("Black leather");
	}
}
