
//BestamDenKortasteVagen.java
/****************************
*							*
*  Author Anthony Heikkinen *
*							*
****************************/


/****************************************************************



PROBLEM
Det finns i ett trafiksystem fyra zoner, Z1, Z2, Z3 och Z4.
Vi ska hitta kortaste vägen från Z1 till Z4.

I Z1 finns startpunkten X och i Z4 finns slutpunkt Y.
I Z2 och Z3 finns ett antal mellanstationer.
I Z2 finns mellanstationerna U1...Um där m är ett positivt heltal.
I Z3 finns mellanstationerna V1...Vn där n är ett positivt heltal.

Från startpunkten (X) går direkta vägar till varje mellanstation i Z2.
Från varje mellanstation i Z2 går det direkta vägar till varje mellanstation i Z3.
Från varje mellanstation i Z3 går det direkta vägar till Y.

Genom vilka mellanstationer går den kortaste vägen?


ALGORITM

	FÖRVILLKOR
	Antal mellanstationer samt alla längderna a, b, c. ( väg = a + b + c )

	EFTERVILLKOR
	Kortaste vägen (a+b+c) samt genom vilka mellanstationer

	STEG I ALGORITMEN
	1. Kortaste vägen = Första vägen
	2. Jämför kortaste vägen med alla vägar
	3. Om aktuella vägen är kortare än kortaste vägen,
	   sätt kortaste vägen till aktuella vägen samt notera mellanstationer.

		PSEUDOKOD

		a[m]    = längder z1-z2
		b[m][n] = längder z2-z3
		c[n]    = längder z3-z4

		kortasteVagen = forstaVagen
		indexI = 0
		indexJ = 0
		for (i = 0, i < a.längd, i++)
		{
			for (j = 0, i < a[i].längd, i++)
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

		out.println ( "BESTÄM DEN KORTASTE VÄGEN" +
					  "\n=========================\n" );

		out.print ( "Mata in antalet stationer i ZON 2: " );
		int   antalStationerZ2 = in.nextInt ();
		double[]   avstandX_Z2 = new double[antalStationerZ2];

		out.print ( "Mata in antalet stationer i ZON 3: " );
		int   antalStationerZ3 = in.nextInt ();
		double[][]   avstandZ2_Z3 = new double[antalStationerZ2][antalStationerZ3];
		double[]   avstandZ3_Y = new double[antalStationerZ3];

		// Mata in avstånd Z1-Z2
		out.println ( "Mata in avstånd från" );
		for ( int i = 0; i < antalStationerZ2; i++ )
		{
			out.print ( "X -> Station U" + (i+1)+ ": " );
			avstandX_Z2[i] = in.nextDouble();

			// Mata in avstånd Z2-Z3
			for ( int   j = 0; j < antalStationerZ3; j++ )
			{
				out.print ( "\tU" + (i+1) + " -> Station V" + (j+1) + ": ");
				avstandZ2_Z3[i][j] = in.nextDouble();
			}
		}
		// Mata in avstånd Z3-Z4
		for ( int i = 0; i < antalStationerZ3; i++ )
		{
			out.print( "V" + (i+1) + " -> Y: " );
			avstandZ3_Y[i] = in.nextDouble();
		}

		// anropa kortasteVagen metoden
		int[]   kortasteVagenIndex = DenKortasteVagen.kortasteVagenIndex (avstandX_Z2, avstandZ2_Z3, avstandZ3_Y);
		double   kortasteVagenDistans = DenKortasteVagen.kortasteVagenDistans (avstandX_Z2, avstandZ2_Z3, avstandZ3_Y);

		// Presentera
		out.println ( "Kortaste vägen går genom U" + (kortasteVagenIndex[0]+1) +
						" och  V" + (kortasteVagenIndex[1]+1) + ".  Sträckan är " + kortasteVagenDistans);

	}
}