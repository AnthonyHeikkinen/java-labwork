class Polylinje
{
	private Punkt[]		horn;
	private String 		farg = "svart";
	private int 		bredd = 1;

	public Polylinje ()
	{
		this.horn = new Punkt[0];
	}

	public Polylinje (Punkt[] horn)
	{
		this.horn = new Punkt[horn.length];
		for ( int i = 0; i < horn.length; i++ )
			this.horn[i] = new Punkt (horn[i]);
	}

	public String toString()
	{
		String str = "[{";
		for ( int i = 0; i < horn.length; i++ )
			str = str + horn[i] + " ";
		str += "}, " + farg + ", " + bredd + "]" ;

		return str;
	}


	public Punkt[] getHorn ()
	{
		Punkt[] kopieradeHorn = new Punkt[horn.length];
		for (int i = 0; i < horn.length; i++)
			kopieradeHorn[i] = horn[i];

		return kopieradeHorn;
	}


	public String getFarg ()
	{
		return farg;
	}


	public int getBredd ()
	{
		return bredd;
	}


	public void setFarg ( String farg )
	{
		this.farg = farg;
	}


	public void setBredd ( int bredd )
	{
		this.bredd = bredd;
	}


	public double langd ()
	{
		double langd = 0;
		for(int i = 0; i < horn.length-1; i++ )
			langd += horn[i].avstand(horn[i+1]);

		return langd;
	}


	public void laggTill ( Punkt horn )
	{
		Punkt[] nyHorn = new Punkt[this.horn.length + 1];
		int		i = 0;
		for (i = 0; i < this.horn.length; i++)
			nyHorn[i] = this.horn[i];

		nyHorn[i] = new Punkt (horn);
		this.horn = nyHorn;
	}


	/*public void laggTillFramfor (Punkt horn, String hornNamn)
	{
		Punkt[] nyHorn = new Punkt [this.horn.length + 1];

	}

	public int sokHorn (String hornNamn)
	{

	}*/

/*
	public void taBort (String hornNamn)
	{

	}
*/
}


