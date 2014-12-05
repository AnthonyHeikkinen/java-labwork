//TemperaturMatningar.java
import java.util.*; // Scanner, Locale
import java.lang.*; // Math


/*********************
Obligatorisk uppgift 1
 TemperaturM�tningar
*********************/



class TemperaturMatningar
{
	public static void main (String[] args)
	{
		Scanner in = new Scanner (System.in);
		System.out.println ("TEMPERATURER");

		// Mata in m�tperioden, antal veckor som skall m�tas
		int    antalVeckor = 0;

		while ( antalVeckor <= 0 )
		{
			System.out.print ( "Mata in m�tperiod (antal veckor): " );
			antalVeckor = in.nextInt ();
		}


		// Antal m�tningar per vecka
		int    antalMatningarPerVecka = 0;

		while ( antalMatningarPerVecka <= 0 )
		{
			System.out.print ( "Mata in antal m�tningar per vecka: " );
			antalMatningarPerVecka = in.nextInt ();
		}

		System.out.println ( antalMatningarPerVecka + " m�tningar i "
			+ antalVeckor + " veckor. (" + antalMatningarPerVecka*antalVeckor + " m�tningar)" );


		// Skapa plats �t temperaturer
		double[][]    t = new double[antalVeckor+1][antalMatningarPerVecka+1];
		// Skapa plats f�r minT, maxT och medelT
		double[]    minT = new double[antalVeckor+1];
		double[]    maxT = new double[antalVeckor+1];
		double[]    sumT = new double[antalVeckor+1];
		double[]    medelT = new double[antalVeckor+1];



		// Mata in m�tv�rden f�r varje vecka
		for ( int vecka = 1; vecka <= antalVeckor; vecka++)
		{
			System.out.println ( "\nM�tv�rden vecka " + vecka );
			for (int matning = 1; matning <= antalMatningarPerVecka; matning++)
			{
				System.out.print ( "Mata in m�tv�rde " + matning + ": ");
				t[vecka][matning] = in.nextDouble();


			}


			sumT[vecka] = t[vecka][1];
			minT[vecka] = t[vecka][1];
			maxT[vecka] = t[vecka][1];
			// Ber�kna minT, maxT denna vecka
			for (int matning = 1; matning < antalMatningarPerVecka; matning++)
			{

				if ( minT[vecka] > t[vecka][matning+1] )
					minT[vecka] = t[vecka][matning+1];

				if ( maxT[vecka] < t[vecka][matning+1] )
					maxT[vecka] = t[vecka][matning+1];

				sumT[vecka] = sumT[vecka] + t[vecka][matning+1];
			}
			// Ber�kna medelT
			medelT[vecka] = sumT[vecka] / antalMatningarPerVecka;

			System.out.println ( "minT = " + minT[vecka] +
							   ", maxT = " + maxT[vecka] +
							   ", sumT = " + sumT[vecka] +
							 ", medelT = " + medelT[vecka] + "\n" );
		}


		double    minTemp = minT[1];
		double    maxTemp = maxT[1];
		double    sumTemp = sumT[1];

		// Ber�kna periodens minTemp, maxTemp, sumTemp, medelTemp
		for (int vecka = 1; vecka < antalVeckor; vecka++)
		{

			if( minTemp > minT[vecka+1] )
				minTemp = minT[vecka+1];

			if( maxTemp < maxT[vecka+1] )
				maxTemp = maxT[vecka+1];

			sumTemp = sumTemp + sumT[vecka+1];
		}
		double    medelTemp = sumTemp / (antalVeckor*antalMatningarPerVecka);

		System.out.println ( "\nPERIODENS M�TV�RDEN\n" +
						   "minTemp = " + minTemp +
						   ", maxTemp = " + maxTemp +
						   ", sumTemp = " + sumTemp +
						 ", medelTemp = " + medelTemp );






	}
}

/* REFLEKTION REDOVISNING
Bengt Koren var den jag redovisade till,
vi fick ett fel i ber�kningarna eftersom jag hade satt
begynelse maxTemp till minT[1], och om maxTemperaturen
finns i f�rsta veckan s� kommer det inte med i ber�kningarna
f�rutsatt att minT vecka 1 inte �r st�rre �n maxT i de �vriga veckorna

Jag �ndrade maxTemp = maxT[1] s� fick jag r�tt v�rden.
Bengt rekommenderad att man inte hoppar �ver det f�rsta indexet i vektorerna
dels f�r att det �kar att man skapar en bugg i programmet samt dels f�r att
programmet kr�ver mera minne f�r att k�ra.
*/
