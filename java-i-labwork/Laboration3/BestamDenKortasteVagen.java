
//BestamDenKortasteVagen.java
/****************************
*							*
*  Author Anthony Heikkinen *
*							*
****************************/


/****************************************************************



PROBLEM
Det finns i ett trafiksystem fyra zoner, Z1, Z2, Z3 och Z4.
Vi ska hitta kortaste v�gen fr�n Z1 till Z4.

I Z1 finns startpunkten X och i Z4 finns slutpunkt Y.
I Z2 och Z3 finns ett antal mellanstationer.
I Z2 finns mellanstationerna U1...Um d�r m �r ett positivt heltal.
I Z3 finns mellanstationerna V1...Vn d�r n �r ett positivt heltal.

Fr�n startpunkten (X) g�r direkta v�gar till varje mellanstation i Z2.
Fr�n varje mellanstation i Z2 g�r det direkta v�gar till varje mellanstation i Z3.
Fr�n varje mellanstation i Z3 g�r det direkta v�gar till Y.

Genom vilka mellanstationer g�r den kortaste v�gen?


ALGORITM

	F�RVILLKOR
	Antal mellanstationer samt alla l�ngderna a, b, c. ( v�g = a + b + c )

	EFTERVILLKOR
	Kortaste v�gen (a+b+c) samt genom vilka mellanstationer

	STEG I ALGORITMEN
	1. Kortaste v�gen = F�rsta v�gen
	2. J�mf�r kortaste v�gen med alla v�gar
	3. Om aktuella v�gen �r kortare �n kortaste v�gen,
	   s�tt kortaste v�gen till aktuella v�gen samt notera mellanstationer.

		PSEUDOKOD

		a[m]    = l�ngder z1-z2
		b[m][n] = l�ngder z2-z3
		c[n]    = l�ngder z3-z4

		kortasteVagen = forstaVagen
		indexI = 0
		indexJ = 0
		for (i = 0, i < a.l�ngd, i++)
		{
			for (j = 0, i < a[i].l�ngd, i++)
			{
				aktuellaVagen = a[i] + b[i][j] + c[j]
				if ( aktuellaVagen > kortasteVagen )
				{
					indexI = i
					indexJ = j
					kortasteVagen = aktuellaVagen
				}
			}
		}


*****************************************************************/

// Imports
import java.util.*; // Scanner
import static java.lang.System.out;

class BestamDenKortasteVagen
{
	public static void main (String[] args)
	{
		Scanner in = new Scanner (System.in);

		out.println ( "BEST�M DEN KORTASTE V�GEN" +
					  "\n=========================\n" );

		out.print ( "Mata in antalet stationer i ZON 2: " );
		int   antalStationerZ2 = in.nextInt ();
		double[]   avstandX_Z2 = new double[antalStationerZ2];

		out.print ( "Mata in antalet stationer i ZON 3: " );
		int   antalStationerZ3 = in.nextInt ();
		double[][]   avstandZ2_Z3 = new double[antalStationerZ2][antalStationerZ3];
		double[]   avstandZ3_Y = new double[antalStationerZ3];

		// Mata in avst�nd Z1-Z2
		out.println ( "Mata in avst�nd fr�n" );
		for ( int i = 0; i < antalStationerZ2; i++ )
		{
			out.print ( "X -> Station U" + (i+1)+ ": " );
			avstandX_Z2[i] = in.nextDouble();

			// Mata in avst�nd Z2-Z3
			for ( int   j = 0; j < antalStationerZ3; j++ )
			{
				out.print ( "\tU" + (i+1) + " -> Station V" + (j+1) + ": ");
				avstandZ2_Z3[i][j] = in.nextDouble();
			}
		}
		// Mata in avst�nd Z3-Z4
		for ( int i = 0; i < antalStationerZ3; i++ )
		{
			out.print( "V" + (i+1) + " -> Y: " );
			avstandZ3_Y[i] = in.nextDouble();
		}

		// anropa kortasteVagen metoden
		int[]   kortasteVagenIndex = DenKortasteVagen.kortasteVagenIndex (avstandX_Z2, avstandZ2_Z3, avstandZ3_Y);
		double   kortasteVagenDistans = DenKortasteVagen.kortasteVagenDistans (avstandX_Z2, avstandZ2_Z3, avstandZ3_Y);

		// Presentera
		out.println ( "Kortaste v�gen g�r genom U" + (kortasteVagenIndex[0]+1) +
						" och  V" + (kortasteVagenIndex[1]+1) + ".  Str�ckan �r " + kortasteVagenDistans);

	}
}