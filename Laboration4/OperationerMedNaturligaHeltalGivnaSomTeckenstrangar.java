import static java.lang.System.out;
import java.util.*; // Scanner

class OperationerMedNaturligaHeltalGivnaSomTeckenstrangar
{
	public static void main (String[] args)
	{
		out.println ( "OPERATIONER MED NATURLIGA HELTAL GIVNA SOM TECKENSTRÄNGAR" );

		String strang = "1997 145";

		Scanner in = new Scanner (strang);

		String strTal1 = in.next();
		String strTal2 = in.next();

		Tal tal1 = new Tal (strTal1);
		Tal tal2 = new Tal (strTal2);

		Tal svar = tal1.add(tal2);
	}
}