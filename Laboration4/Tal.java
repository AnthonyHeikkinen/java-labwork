class Tal
{
	// Instansvariabler
	//StringBuilder sbTal;
	String strTal;
	char[] charArrTal;
	int[]    intArrTal;

	public Tal (String str)
	{
		//sbTal = str;
		strTal = str;
		charArrTal = str.toCharArray();
		intArrTal = new int[charArrTal.length];
		for (int i = 0; i < charArrTal.length; i++)
		{
			// Omvandla från char till int
			intArrTal[i] = (int) charArrTal[i]- 48;
		}
	}

/*	public Tal add ( Tal b )
	{

		int length = this.intArrTal.length() > b.intArrTal.length ? this.intArrTal.length : b.intArrTal.length();
		if ( this.talArrInt.length != length )
		{
			Tal temp = new Tal("0");
			temp.talArrInt = this.talArrInt;
			this.talArrInt = new int[length];



		}
	}
*/
}