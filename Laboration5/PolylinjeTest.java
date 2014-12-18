class PolylinjeTest
{
	public static void main (String[] args)
	{
		Punkt[] pArr = new Punkt[5];
		pArr[0] = new Punkt ("A", 1, 2);
		pArr[1] = new Punkt ("B", 3, 1);
		pArr[2] = new Punkt ("C", 5, 7);
		pArr[3] = new Punkt ("D", 6, 5);
		pArr[4] = new Punkt ("E", 8, 3);
		Polylinje pl = new Polylinje (pArr);

		Punkt p = new Punkt ("B1", 4, 3 );
		System.out.println ( pl );
		System.out.println (pl.langd());

		System.out.println (" Efter tillagd ");
		pl.laggTillFramfor( p, "C");
		System.out.println (pl);
	}
}