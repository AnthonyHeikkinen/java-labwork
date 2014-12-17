class Punkt
{
	// Instansvariabler
	private String namn;
	private int x;
	private int y;


	// Konstruktorer
	Punkt ()
	{
		this.namn = "Origo";
		this.x = 0;
		this.y = 0;
	}

	Punkt ( String namn, int x, int y )
	{
		this.namn = namn;
		this.x = x;
		this.y = y;
	}

	Punkt ( Punkt anotherPunkt )
	{
		this.namn	= anotherPunkt.getNamn();
		this.x 		= anotherPunkt.getX();
		this.y		= anotherPunkt.getY();
	}

	// Inspektorer
	public String getNamn()
	{
		return namn;
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	// Mutatorer
	public void setX(int x)
	{
		this.x = x;
	}

	public void setY(int y)
	{
		this.y = y;
	}


	// Kombinatorer
	public double avstand ( Punkt anotherPunkt )
	{
		double avstand = Math.sqrt(
						  (Math.pow((this.x - anotherPunkt.getX()),2)
						  +Math.pow((this.y - anotherPunkt.getY()),2))
						 );

		return avstand;
	}

	public boolean equals ( Punkt anotherPunkt )
	{
		boolean equalX =  x == anotherPunkt.getX();
		boolean equalY =  y == anotherPunkt.getY();
		return equalX && equalY;
	}




	public String toString ()
	{
		String punktStr = "(" + namn + " " + x + " " + y + ")";

		return punktStr;
	}
}
