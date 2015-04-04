class PolylinjeTester
{
	public static void main (String[] args)
	{
		Polylinje	polylinje = null;
		Punkt		testPunkt = new Punkt ("D", 6, 5);

		//polylinje = new VPolylinje ();
		polylinje = new NPolylinje ();

		for (Punkt horn : polylinje)
			System.out.println (horn);

		polylinje.laggTillFramfor(testPunkt, "G");

	}
}