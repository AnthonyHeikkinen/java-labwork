// DenKortasteVagen.java
/****************************
*							*
*  Author Anthony Heikkinen *
*							*
****************************/


/*

En specialistklass som utf�r ber�kningar med l�ngder mellan stationer.
Bland annat den kortaste v�gen

*/

class DenKortasteVagen
{
	public static int[] kortasteVagenIndex ( double[] a, double[][] b, double[] c )
	{
		// S�tt f�rsta v�gen till kortaste v�gen
		int   ki = 0;
		int   kj = 0;
		double kortasteVagen = a[ki] + b[ki][kj] + c[kj];

		// Yttre loop
		for ( int i = 0; i < a.length; i++)
		{
			// Inre loop
			for ( int j = 0; j < b[i].length; j++ )
			{
				double   aktuellaVagen = a[i] + b[i][j] + c[j];

				if ( aktuellaVagen < kortasteVagen )
				{
					ki = i;
					kj = j;
					kortasteVagen = a[i] + b[i][j] + c[j];
				}
			}
		}

		// Efter k�rning f�s resultatet
		int[]   kortasteVagenIndex = {ki, kj};

		return kortasteVagenIndex;
	}

	public static double kortasteVagenDistans ( double a[], double b[][], double c[] )
	{
		int[]   kortasteVagenIndex = kortasteVagenIndex(a, b, c);
		double  kortasteVagenDistans = a[kortasteVagenIndex[0]] + b[kortasteVagenIndex[0]][kortasteVagenIndex[1]]
									+ c[kortasteVagenIndex[1]];
		return kortasteVagenDistans;
	}


}
