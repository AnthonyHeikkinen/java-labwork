import java.util.NoSuchElementException;
import java.util.Random;
class ValjPolylinje
{
	public static final Random	rand = new Random();
	public static final int		ANTAL_POLYLINJER = 10;

	public static void main (String[] args)
	{
		//Skapa ett antal slumpm�ssiga polylinjer
		Polylinje[] polylinjer = new Polylinje [ANTAL_POLYLINJER];

		for (int i = 0; i < ANTAL_POLYLINJER; i++)
			polylinjer[i] = slumpPolylinje();

		// Visa polylinjerna
		for (int i = 0; i < ANTAL_POLYLINJER; i++)
			System.out.println( polylinjer[i] );


		// Best�m den kortaste av de polylinjer som �r gula
		Polylinje kortasteGul = kortastePolylinjenFarg ( polylinjer, "gul" );


		// Visa den valda polylinjen
		System.out.println ( "Den kortaste gula polylinjen:" );
		System.out.println ( kortasteGul );
	}


	// Tar en vektor av Polylinjer och returnerar den kortaste polylinjen av de som har samma f�rg
	public static Polylinje kortastePolylinjenFarg ( Polylinje[] polylinjer, String farg )
	{
		int soktaPolylinjer = 0;
		boolean fargHittad = false;
		Polylinje kortaste = null;

		// Kontrollera om s�kt f�rg finns.
		for ( int i = soktaPolylinjer; !fargHittad && i < ANTAL_POLYLINJER; i++)
		{
			fargHittad = (polylinjer[i].getFarg()).equals(farg);
			if ( fargHittad )
			{
				kortaste = polylinjer[i];
				break;
			}
			soktaPolylinjer++;
		}

		if (fargHittad == true)
		{
			for (int i = soktaPolylinjer; i < ANTAL_POLYLINJER; i++)
			{
				if ( (polylinjer[i].getFarg()).equals(farg) )
				{
					kortaste = kortaste.langd() > polylinjer[i].langd() ? polylinjer[i] : kortaste ;
				}
			}
		} else {
			throw new NoSuchElementException ("F�rgen finns inte bland polylinjerna");
		}

		return kortaste;


	}

	// Returnerar en slumpgenererad punkt.
	public static Punkt slumpPunkt()
	{
		String n = "" + (char) (65 + rand.nextInt(26));
		int x = rand.nextInt(11);
		int y = rand.nextInt(11);

		return new Punkt ( n, x, y );
	}

	// Returnerar en slumpgenererad polylinje
	public static Polylinje slumpPolylinje()
	{
		// skapa en tom polylinje och l�gg till h�rn till den
		Polylinje polylinje = new Polylinje();
		int antalHorn = 2 + rand.nextInt(7);
		int antalValdaHorn = 0;
		boolean[] valdaNamn = new boolean[26];
		//ett och samma namn kan inte f�rekomma
		/*Punkt valdPunkt = null;
		char  valdChar = 0;*/
		while(antalValdaHorn < antalHorn)
		{
			Punkt nyPunkt = slumpPunkt();
			char valdChar = nyPunkt.getNamn().charAt(0);
			int nyPunktNamnIndex =  valdChar - 65;

			// Kontrollera att valt namn inte �r upptaget.
			if ( valdaNamn[nyPunktNamnIndex] == false )
			{
				polylinje.laggTill (nyPunkt);
				valdaNamn[nyPunktNamnIndex] = true;
				antalValdaHorn++;
			} else {
				continue;
			}
		}

		// s�tt f�rg
		int fargKod = rand.nextInt(3);
		String[] farg= {"bl�", "r�d", "gul"};
		polylinje.setFarg( farg[fargKod] );

		// s�tt bredd
		int bredd = rand.nextInt(4);
		polylinje.setBredd(bredd);

		return polylinje;
	}
}