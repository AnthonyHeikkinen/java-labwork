import java.util.*; // Scanner
import static java.lang.System.out; //
class RaknaMedStrangar
{
	public static void main (String[] args)
	{
		String strTal = "01 1090";
		Scanner in = new Scanner(strTal);
		String tal1 = in.next();
		String tal2 = in.next();

		String summa = addition ( tal1, tal2 );

		visa(tal1, tal2, summa, "+");


	}

	public static String addition ( String tal1, String tal2 )
	{
		StringBuilder svar = new StringBuilder ();

		// Högsta index
		int tal1in = tal1.length() - 1;
		int tal2in = tal2.length() - 1;

		int siffra1 = 0;
		int siffra2 = 0;
		int minnessiffra = 0;
		int rest = 0;



		while ( tal1in >= 0 && tal2in >= 0 )
		{
			siffra1 = tal1.charAt(tal1in)-48;
			siffra2 = tal2.charAt(tal2in)-48;
			rest = (minnessiffra + siffra1 + siffra2) % 10;
			minnessiffra = (minnessiffra + siffra1 + siffra2) / 10;

			svar.insert(0, rest);
			tal1in--;
			tal2in--;
		}

		while ( tal1in >= 0 )
		{
			siffra1 = tal1.charAt(tal1in)-48;
			rest = (minnessiffra + siffra1) % 10;
			minnessiffra = (minnessiffra + siffra1) / 10;

			svar.insert(0, rest);
			tal1in--;
		}

		while ( tal2in >= 0 )
		{
			siffra2 = tal2.charAt(tal2in)-48;
			rest = (minnessiffra + siffra2) % 10;
			minnessiffra = (minnessiffra + siffra2) / 10;

			svar.insert(0, rest);
			tal2in--;
		}

		if (minnessiffra == 1)
		{
			svar.insert(0, minnessiffra);
			minnessiffra = 0;
		}

		return svar.toString();
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