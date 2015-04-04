class MinstaElementetTest
{
	public static void main (String[] args)
	{
		int[] sekvens = {16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 18, 1, 17, 19 };
		System.out.println ( "Mata in sekvens: "  + java.util.Arrays.toString(sekvens) );
		int minstaVarde = min(sekvens);
		System.out.println ( "Det minsta v�rdet �r " + minstaVarde );

		int[] sekvens2 = {16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		System.out.println ( "Mata in sekvens: "  + java.util.Arrays.toString(sekvens2) );
		int minstaVarde2 = minUppdatering(sekvens2);
		System.out.println ( "Det minsta v�rdet �r " + minstaVarde2 );
	}

	public static int minUppdatering ( int[] element ) throws IllegalArgumentException
	{
		if ( element.length == 0 )
			throw new IllegalArgumentException ("Tom samling" );

		// initiate first value as minValue
		int minValue = element[0];
		for (int pos = 1; pos < element.length; pos++ )
		{
			minValue = minValue < element[pos] ? minValue : element[pos];
		}

		return minValue;
	}

	public static int min ( int[] element ) throws IllegalArgumentException
	{
		if ( element.length == 0 )
			throw new IllegalArgumentException ( "Tom samling" );


		//h�r ihop med sp�rutskrift 2:
		//int	antalVarv = 1;

		int[]	sekvens = element;
		int		antaletPar = sekvens.length / 2;
		int		antaletOparadeElement = sekvens.length % 2;
		int		antaletTankbaraElement = antaletPar + antaletOparadeElement;
		int[]	delsekvens = new int [antaletTankbaraElement];
		int		i = 0;
		int		j = 0;

		while (antaletPar > 0) // */ OLD  while (sekvens.length > 1)
		{
			// Skilj ur en delsekvens med de t�nkbara elementen
			i = 0;
			j = 0;

			while (j < antaletPar)
			{
				delsekvens[j++] = (sekvens[i] < sekvens[i + 1]) ? sekvens[i] : sekvens [i + 1];
				i += 2;
			}

			if (antaletOparadeElement == 1)
				  delsekvens[j] = sekvens[i]; // OLD */ delsekvens[j] = sekvens[sekvens.length - 1];

			// Utg� nu ifr�n delsekvensen
			sekvens = delsekvens;
			antaletPar = antaletTankbaraElement / 2;
			antaletOparadeElement = antaletTankbaraElement % 2;
			antaletTankbaraElement = antaletPar + antaletOparadeElement;

			// Sp�rutskrift1 - f�r att f�lja sekvensen
			// System.out.println ( java.util.Arrays.toString(sekvens) );

			// Sp�rutskrift2 - f�r att avsluta loopen i f�rv�g
			// (f�r att kunna se vad som h�nder i b�rjan )
			// if (antalVarv++  == 10)
			//	System.exit(0);
		}

		// sekvens[0] �r det enda �terst�ende t�nkbara element
		// - det �r det minsta elementet
		return sekvens[0];
	}
}