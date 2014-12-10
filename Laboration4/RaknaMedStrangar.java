import java.util.*; // Scanner
import static java.lang.System.out; //
class RaknaMedStrangar
{
	public static void main (String[] args)
	{
		String strTal = "822 149";

		Scanner in = new Scanner(strTal);
		String tal1 = in.next();
		String tal2 = in.next();

		String summa = addition ( tal1, tal2 );
		visa(tal1, tal2, summa, "+");

	}

	public static String addition ( String tal1, String tal2 )
	{

		StringBuilder sbTal1 = new StringBuilder (tal1);
		StringBuilder sbTal2 = new StringBuilder (tal2);
		StringBuilder sbSumma  = new StringBuilder ();

		int len1 = sbTal1.length();
		int len2 = sbTal2.length();

		int maxLen = len1 > len2 ? len1 : len2;

		if ( len1 == len2 ) {}
		else if( maxLen > len1 )
		{
			for ( int i = sbTal1.length(); len1 <= maxLen; i++)
			{
				sbTal1.insert(0," ");
				len1 = sbTal1.length();
			}
		} else
		{
			for ( int i = len2; len2 <= maxLen; i++)
			{
				sbTal2.insert(0, " ");
				len2 = sbTal2.length();
			}
		}

		int carry = 0;
		for ( int i = maxLen-1; i >= 0; i--)
		{
			int siffra1 = sbTal1.charAt(i)-48;
			int siffra2 = sbTal2.charAt(i)-48;
			int summering = 0;
			if ( siffra1 == " ".charAt(0) )
			{
				summering = siffra2+carry;
			} else if (siffra2 == " ".charAt(0) )
			{
				summering = siffra1+carry;
			} else
			{
				summering = siffra1+siffra2+carry;
			}

			carry = summering / 10;
			int rest = summering % 10;
			sbSumma.insert(0, rest);
		}

		return sbSumma.toString();
	}

	public static void visa ( String tal1, String tal2, String summa,String operand)
	{
		int maxLen = tal1.length() > tal2.length() ? tal1.length() : tal2.length();
		String skiljestrang = "";
		maxLen += 4;
		for (int i = 0; maxLen > i; i++)
			skiljestrang += "-";

		out.printf ( "\n%" + maxLen + "s"
					+ "\n%s%" + (maxLen-1) + "s"
					+ "\n%" + maxLen + "s"
					+ "\n%" + maxLen + "s\n"
					, tal1, operand, tal2, skiljestrang, summa);
	}
}