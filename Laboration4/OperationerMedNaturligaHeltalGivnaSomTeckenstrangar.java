import static java.lang.System.out;
import java.util.*; // Scanner

class OperationerMedNaturligaHeltalGivnaSomTeckenstrangar
{
	public static void main (String[] args)
	{
		out.println ( "OPERATIONER MED NATURLIGA HELTAL GIVNA SOM TECKENSTRÄNGAR" );

		String strang = "9999 9111";

		Scanner in = new Scanner (strang);

		String strTal1 = in.next();
		String strTal2 = in.next();

		Tal tal1 = new Tal (strTal1);
		Tal tal2 = new Tal (strTal2);

		tal1.addAndPrint(tal2);
		out.println ();
		tal1.subAndPrint(tal2);
	}
}