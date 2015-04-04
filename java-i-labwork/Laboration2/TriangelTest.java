// TriangelTest.java
/****************************
*							*
*  Author Anthony Heikkinen *
*							*
****************************/

/***************************************************************
En klass för att testa de statiska metoderna i klassen Triangel.
****************************************************************/

class TriangelTest
{
	public static void main (String[] args)
	{
		long startTime = System.currentTimeMillis();
		// Triangelns sidor
		double a = 10;
		double b = 10.5;
		double c = 14.5;

		System.out.println ( "OPERATIONER MED TRIANGLAR" +
								"\n===============================" );
		System.out.println ( "a = " + a + ", b = " + b + ", c = " + c + "\n");

		boolean giltligTriangel = Triangel.giltligTriangel (a, b , c);
		System.out.println ( "Är det en giltlig triangel? " + giltligTriangel + "\n");
		if ( giltligTriangel == true)
		{
			// Semiperimeter
			double s = Triangel.semiperimetern (a, b, c);

			// Vinklar
			double av = Triangel.vinkel ( a, b, c);
			double bv = Triangel.vinkel ( b, a, c);
			double cv = Triangel.vinkel ( c, a, b);
			System.out.println ( "VINKLAR I TRIANGELN" );
			System.out.println ( "Alfa: " + Math.toDegrees (av) );
			System.out.println ( "Beta: " + Math.toDegrees (bv) );
			System.out.println ( "Gamma: " + Math.toDegrees (cv) );

			// Höjder
			double ah = Triangel.hojdFranSida(a, a, b, c);
			double bh = Triangel.hojdFranSida(b, a, b, c);
			double ch = Triangel.hojdFranSida(c, a, b, c);
			System.out.println ( "\nHÖJDER I TRIANGELN" );
			System.out.println ( "ah: " + ah);
			System.out.println ( "bh: " + bh);
			System.out.println ( "ch:  " + ch);
			System.out.println ( "" );

			// Bisektriser
			double bisA = Triangel.bisektris( b, c, av );
			double bisB = Triangel.bisektris( a, c, bv );
			double bisC = Triangel.bisektris( b, a, cv );
			System.out.println ( "BISEKTRISER I TRIANGELN" );
			System.out.println ( "Va: " + bisA);
			System.out.println ( "Vb: " + bisB);
			System.out.println ( "Vc: " + bisC);

			System.out.println ( "\nÖVRIG DATA" );
			System.out.println ( "Area:\t\t" + Triangel.area( a, ah ) + " a.e." );
			System.out.println ( "Omkrets:\t" + Triangel.omkrets (a, b, c) + " l.e." );
			System.out.println ( "Semiperimetern: " + s + " l.e." );

			System.out.println ( "" );
			double omSkCirRadie = Triangel.omskrivnaCirkelnsRadie(a , b , c);
			System.out.println ( "Omskrivna cirkelns radie = " + omSkCirRadie );

			double inSkCirRadie = Triangel.inskrivnaCirkelnsRadie(a , b , c);
			System.out.println ( "Inskrivna cirkelns radie = " + inSkCirRadie );

		}

		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("\nRuntime: " + totalTime + " ms");

	}
}