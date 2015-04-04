class PolylinjeTest
{
	public static void main (String[] args)
	{
		Punkt[] pArr = new Punkt[4];
		pArr[0] = new Punkt ("A", 1, 2);
		pArr[1] = new Punkt ("B", 3, 1);
		pArr[2] = new Punkt ("C", 5, 7);
		pArr[3] = new Punkt ("D", 6, 5);
		Polylinje pl = new Polylinje (pArr);

		Punkt p = new Punkt ("B1", 4, 3 );
		System.out.println ( pl );
		System.out.println (pl.langd());

		pl.laggTillFramfor( p, "C");
		System.out.println (" Efter tillagd ");
		System.out.println (pl);

		pl.taBort("b1");
		System.out.println ( "Efter borttagning" );
		System.out.println (pl);


		System.out.println ( "En stund med Iteratorn" );
		Polylinje.PolylinjeIterator plitr = pl.new PolylinjeIterator();

		while (plitr.finnsHorn())
		{
			//Visa aktuella Punkten
			Punkt hornet = plitr.horn();
			//stega fram.
			plitr.gaFram();
			//Skriv ut hornet
			System.out.println ( hornet );
		}
	}
}