import static java.lang.System.out;
import java.util.*; // Scanner

class OperationerMedNaturligaHeltalGivnaSomTeckenstrangar
{
	public static void main (String[] args)
	{
		out.println ( "OPERATIONER MED NATURLIGA HELTAL GIVNA SOM TECKENSTRÄNGAR" );

		String strang = "997 1111523";

		Scanner in = new Scanner (strang);

		String strTal1 = in.next();
		String strTal2 = in.next();

		Tal tal1 = new Tal (strTal1);
		Tal tal2 = new Tal (strTal2);

		//String svar = tal1.add(tal2);

		//out.println(tal1);
		//out.println(tal2);
		//out.println(svar);

		tal1.addAndPrint(tal2);
	}
}