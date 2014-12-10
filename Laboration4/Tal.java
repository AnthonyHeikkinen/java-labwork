class Tal
{
	//INSTANCE VARIABLE
	String strTal;

	// CONSTRUCTOR
	Tal (String str)
	{
		strTal = str;
	}

	// METHODS

	//  Converts String to int Array
	int[] stringToIntArray ()
	{

		char [] charArrayTal = this.strTal.toCharArray();

		int[] intArrayTal = new int[charArrayTal.length];

		// Fill the intArray with numbers.
		for ( int i = 0; i < charArrayTal.length; i++ )
		{
			intArrayTal[i] = (int) charArrayTal[i] - 48;
		}

		return intArrayTal;
	}

	// Change size of the intArray to a desired size.
	public static int[] changeIntArraySize ( int[] originalArrayTal, int desiredLength )
	{
		int[] changedArrayTal = new int[desiredLength];
		int differenceLength = desiredLength - originalArrayTal.length;

		for ( int i = desiredLength-1; i >= differenceLength; i--)
		{

			changedArrayTal[i] = originalArrayTal[i-differenceLength];

		}

		return changedArrayTal;
	}

	// Addition of Tal this and secondTal
	String add ( Tal secondTal )
	{
		int[] tal1 = this.stringToIntArray();
		int[] tal2 = secondTal.stringToIntArray();

		// Make intArrays same length
		if ( tal1.length < tal2.length){
			tal1 = changeIntArraySize(tal1 ,tal2.length);
		} else {
			tal2 = changeIntArraySize(tal2 ,tal1.length);
		}


		int carry = 0;
		int remainder = 0;

		StringBuilder svar = new StringBuilder ();

		for ( int i = tal1.length-1; i >= 0; i-- )
		{
			int sum = tal1[i] + tal2[i] + carry;
			carry = sum / 10;
			remainder = sum % 10;
			svar.insert(0,remainder);
		}
		if (carry != 0 )
		svar.insert(0,carry);
		return svar.toString();
	}

	// Subtraction of Tal this and secondTal
	String sub ( Tal secondTal )
	{
		int[] tal1 = this.stringToIntArray();
		int[] tal2 = secondTal.stringToIntArray();

		// Make intArrays same length
		if ( tal1.length < tal2.length){
			tal1 = changeIntArraySize(tal1 ,tal2.length);
		} else {
			tal2 = changeIntArraySize(tal2 ,tal1.length);
		}

		boolean negative = false;
		if ( tal1[0] > tal2[0] )
		{
			int talTemp [] = null;
			talTemp = tal1;
			tal1 = tal2;
			tal2 = talTemp;
			negative = true;
		}


		int borrowed = 0;
		int remainder = 0;

		StringBuilder svar = new StringBuilder ();
		for ( int i = tal1.length-1; i >= 0; i-- )
		{

			int differens = 0;
			if  ( (tal1[i])-differens >= tal2[i] )
			{
				differens = tal1[i] - tal2[i] - borrowed;
				borrowed = 0;
			} else {
				differens = 10 + tal1[i] - tal2[i] - borrowed;
				borrowed = 1;
			}
			if ( i != 0 )
			{
				svar.insert(0,differens);
			} else { }
		}
		if (negative)
		{
			svar.insert(0, "-");
		}
		return svar.toString();
	}

	// Call add() and format and print
	public void addAndPrint ( Tal tal2 )
	{
		String svar = add(tal2);
		int len = svar.length()+2;
		String understryk = "";
		for ( int i = 0; i < len; i++)
		{
			understryk += "-";
		}

		System.out.printf("\n%"+len+"s \n%"+len+"s\n%"+len+"s \n%"+len+"s\n\n", this.strTal, "+"+tal2.strTal, understryk, svar);
	}

	// Call sub() and formt and print
	public void subAndPrint ( Tal tal2 )
		{
			String svar = sub(tal2);
			int len = svar.length()+2;
			String understryk = "";
			for ( int i = 0; i < len; i++)
			{
				understryk += "-";
			}

			System.out.printf("\n%"+len+"s \n%"+len+"s\n%"+len+"s \n%"+len+"s\n\n", this.strTal, "-"+tal2.strTal, understryk, svar);
	}

	// Override toString method from inheritance
	public String toString ()
	{
		return this.strTal;
	}

}