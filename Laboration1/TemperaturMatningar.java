//TemperaturMatningar.java
import java.util.*; // Scanner, Locale
import java.lang.*; // Math


/*********************
Obligatorisk uppgift 1
 TemperaturMätningar
*********************/



class TemperaturMatningar
{
	public static void main (String[] args)
	{
		Scanner in = new Scanner (System.in);
		System.out.println ("TEMPERATURER");

		// Mata in mätperioden, antal veckor som skall mätas
		int    antalVeckor = 0;

		while ( antalVeckor <= 0 )
		{
			System.out.print ( "Mata in mätperiod (antal veckor): " );
			antalVeckor = in.nextInt ();
		}


		// Antal mätningar per vecka
		int    antalMatningarPerVecka = 0;

		while ( antalMatningarPerVecka <= 0 )
		{
			System.out.print ( "Mata in antal mätningar per vecka: " );
			antalMatningarPerVecka = in.nextInt ();
		}

		System.out.println ( antalMatningarPerVecka + " mätningar i "
			+ antalVeckor + " veckor. (" + antalMatningarPerVecka*antalVeckor + " mätningar)" );


		// Skapa plats åt temperaturer
		double[][]    t = new double[antalVeckor+1][antalMatningarPerVecka+1];
		// Skapa plats för minT, maxT och medelT
		double[]    minT = new double[antalVeckor+1];
		double[]    maxT = new double[antalVeckor+1];
		double[]    sumT = new double[antalVeckor+1];
		double[]    medelT = new double[antalVeckor+1];



		// Mata in mätvärden för varje vecka
		for ( int vecka = 1; vecka <= antalVeckor; vecka++)
		{
			System.out.println ( "\nMätvärden vecka " + vecka );
			for (int matning = 1; matning <= antalMatningarPerVecka; matning++)
			{
				System.out.print ( "Mata in mätvärde " + matning + ": ");
				t[vecka][matning] = in.nextDouble();


			}


			sumT[vecka] = t[vecka][1];
			minT[vecka] = t[vecka][1];
			maxT[vecka] = t[vecka][1];
			// Beräkna minT, maxT denna vecka
			for (int matning = 1; matning < antalMatningarPerVecka; matning++)
			{

				if ( minT[vecka] > t[vecka][matning+1] )
					minT[vecka] = t[vecka][matning+1];

				if ( maxT[vecka] < t[vecka][matning+1] )
					maxT[vecka] = t[vecka][matning+1];

				sumT[vecka] = sumT[vecka] + t[vecka][matning+1];
			}
			// Beräkna medelT
			medelT[vecka] = sumT[vecka] / antalMatningarPerVecka;

			System.out.println ( "minT = " + minT[vecka] +
							   ", maxT = " + maxT[vecka] +
							   ", sumT = " + sumT[vecka] +
							 ", medelT = " + medelT[vecka] + "\n" );
		}


		double    minTemp = minT[1];
		double    maxTemp = maxT[1];
		double    sumTemp = sumT[1];

		// Beräkna periodens minTemp, maxTemp, sumTemp, medelTemp
		for (int vecka = 1; vecka < antalVeckor; vecka++)
		{

			if( minTemp > minT[vecka+1] )
				minTemp = minT[vecka+1];

			if( maxTemp < maxT[vecka+1] )
				maxTemp = maxT[vecka+1];

			sumTemp = sumTemp + sumT[vecka+1];
		}
		double    medelTemp = sumTemp / (antalVeckor*antalMatningarPerVecka);

		System.out.println ( "\nPERIODENS MÄTVÄRDEN\n" +
						   "minTemp = " + minTemp +
						   ", maxTemp = " + maxTemp +
						   ", sumTemp = " + sumTemp +
						 ", medelTemp = " + medelTemp );






	}
}

/* REFLEKTION REDOVISNING
Bengt Koren var den jag redovisade till,
vi fick ett fel i beräkningarna eftersom jag hade satt
begynelse maxTemp till minT[1], och om maxTemperaturen
finns i första veckan så kommer det inte med i beräkningarna
förutsatt att minT vecka 1 inte är större än maxT i de övriga veckorna

Jag ändrade maxTemp = maxT[1] så fick jag rätt värden.
Bengt rekommenderad att man inte hoppar över det första indexet i vektorerna
dels för att det ökar att man skapar en bugg i programmet samt dels för att
programmet kräver mera minne för att köra.
*/
