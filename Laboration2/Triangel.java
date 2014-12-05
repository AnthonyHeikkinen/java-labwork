// Triangel.java
/****************************
*							*
*  Author Anthony Heikkinen *
*							*
****************************/

/***************************************************

Diverse statiska metoder med koppling till Trianglar.

****************************************************/

public class Triangel
{
	public static boolean giltligTriangel ( double a, double b, double c )
	{
		boolean giltligTriangel = false;
		boolean positiva = false;

		positiva = a > 0 && b > 0 && c > 0;
		if ( positiva && (a+b)-c > 0 && (b+c)-a > 0 && (c+a)-b > 0 )
			giltligTriangel = true;

		return giltligTriangel;
	}

	public static double omkrets ( double a, double b, double c )
	{
		double omkrets = a + b + c;
		return omkrets;
	}

	public static double area ( double bas, double hojd )
	{
		double    area = (bas * hojd) / 2;

		return area;
	}

	// Använder cosinus-satsen för att få vinkeln
	public static double vinkel ( double sidaSomSoks, double restSida1, double restSida2 )
	{
		double soktaVinkeln = -1;


		soktaVinkeln = (restSida1 * restSida1 + restSida2*restSida2 - sidaSomSoks*sidaSomSoks) /
		               (2*restSida1*restSida2);
		soktaVinkeln = Math.acos (soktaVinkeln);

		return soktaVinkeln;
	}

	// Beräknar halva omkretsen
	public static double semiperimetern ( double a, double b, double c )
	{
		double semiperimetern = (a + b + c )/2;
		return semiperimetern;
	}

	// Beräknar bisektris för vald sida
	public static double bisektris ( double sida2, double sida3, double vinkelnMellan )
	{
		double bis = ( 2.0 * sida2 * sida3 * Math.cos (vinkelnMellan/2)) / ( sida2 + sida3 );
		return bis;
	}

	public static double hojdFranSida ( double sidan, double a,  double b, double c)
	{
		double s = (a + b + c )/2;
		double hojdFranSidan = (2/sidan) * Math.sqrt( s * ((s-a) * (s-b) * (s-c) ) );
		return hojdFranSidan;
	}


	public static double omskrivnaCirkelnsRadie (double a,  double b, double c)
	{
		double s = (a + b + c )/2;
		double radie = (a*b*c)/(4* Math.sqrt( s *(  (s-a) * (s-b) * (s-c) ) ));
		return radie;
	}

	public static double inskrivnaCirkelnsRadie (double a,  double b, double c)
		{
			double s = (a + b + c )/2;
			double radie = Math.sqrt(((s-a) * (s-b) * (s-c))/s);
			return radie;
	}
}