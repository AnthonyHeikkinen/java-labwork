import java.util.*; // Scanner
import static java.lang.System.out; //
class RaknaMedStrangar
{
	public static void main (String[] args)
	{
		String strTal = "8888 799";
		Scanner in = new Scanner(strTal);
		String tal1 = in.next();
		String tal2 = in.next();

		out.println ( "SUMMABERÄKNING" );
		String summa = addition ( tal1, tal2 );
		visa(tal1, tal2, summa, "+");

		out.println ( "DIFFERENSBERÄKNING" );
		String differens = subtraktion ( tal1, tal2 );
		visa(tal1, tal2, differens, "-");




	}

	public static String addition ( String tal1, String tal2 )
	{
		StringBuilder svar = new StringBuilder ();

		// sista index
		int pos1 = tal1.length() - 1;
		int pos2 = tal2.length() - 1;

		int siffra1 = 0;
		int siffra2 = 0;
		int minnessiffra = 0;
		int rest = 0;



		while ( pos1 >= 0 && pos2 >= 0 )
		{
			siffra1 = tal1.charAt(pos1)-48;
			siffra2 = tal2.charAt(pos2)-48;
			rest = (minnessiffra + siffra1 + siffra2) % 10;
			minnessiffra = (minnessiffra + siffra1 + siffra2) / 10;

			svar.insert(0, rest);
			pos1--;
			pos2--;
		}

		while ( pos1 >= 0 )
		{
			siffra1 = tal1.charAt(pos1)-48;
			rest = (minnessiffra + siffra1) % 10;
			minnessiffra = (minnessiffra + siffra1) / 10;

			svar.insert(0, rest);
			pos1--;
		}

		while ( pos2 >= 0 )
		{
			siffra2 = tal2.charAt(pos2)-48;
			rest = (minnessiffra + siffra2) % 10;
			minnessiffra = (minnessiffra + siffra2) / 10;

			svar.insert(0, rest);
			pos2--;
		}

		if (minnessiffra == 1)
		{
			svar.insert(0, minnessiffra);
			minnessiffra = 0;
		}

		return svar.toString();
	}

	public static String subtraktion ( String tal1, String tal2 )
	{
		StringBuilder svar = new StringBuilder();

		// Sista index
		int pos1 = tal1.length() - 1;
		int pos2 = tal2.length() - 1;

		int siffra1 = 0;
		int siffra2 = 0;
		int lanesiffra = 0;
		int differens = 0;

		while ( pos1 >= 0 && pos2 >= 0 )
		{
			siffra1 = tal1.charAt(pos1) - 48;
			siffra2 = tal2.charAt(pos2) - 48;

			siffra1 = siffra1 - lanesiffra;
			if ( siffra1 < siffra2 )
			{
				siffra1 = siffra1 + 10;
				differens = siffra1 - siffra2;
				lanesiffra = 1;
			} else {
				differens = siffra1 - siffra2;
				lanesiffra = 0;
			}

			if ( (pos1 == 0 && pos2 == 0) && differens == 0 )
			{ } else
			{
				svar.insert(0, differens);
			}
			pos1--;
			pos2--;
		}

		while ( pos1 >=0 )
		{
			siffra1 = tal1.charAt(pos1) - 48;
			if ( lanesiffra == 1 )
			{
				differens = siffra1 - lanesiffra;
				lanesiffra = 0;
			} else {
				differens = siffra1;
			}
			pos1--;
			if (differens != 0)
			{
				svar.insert(0, differens);
			}
		}

		/*while ( pos2 >= 0 )
		{
			siffra2 = tal2.charAt(pos2) - 48;
		}*/



		return svar.toString();
	}

	public static void visa ( String tal1, String tal2, String resultat,String operand)
	{
		int maxLen = tal1.length() > tal2.length() ? tal1.length() : tal2.length();
		String skiljestrang = "";
		maxLen += 4;
		for (int i = 0; maxLen > i; i++)
			skiljestrang += "-";

		out.printf ( "\n%" + maxLen + "s"
					+ "\n%s%" + (maxLen-1) + "s"
					+ "\n%" + maxLen + "s"
					+ "\n%" + maxLen + "s\n\n"
					, tal1, operand, tal2, skiljestrang, resultat);
	}
}