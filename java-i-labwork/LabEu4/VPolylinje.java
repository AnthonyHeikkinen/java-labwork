/******************************************

VPolylinje - Vektor Polylinje,
Ett polylinje objekt vars hörn lagras i en vektor

******************************************/

import java.util.*; /* Iterator, Arrays, NoSuchElementException */

class VPolylinje implements Polylinje
{
	private Punkt[]		horn;
	private String 		farg = "svart";
	private int 		bredd = 1;

	// Konstruktorer
	public VPolylinje ()
	{
		this.horn = new Punkt[0];
	}

	public VPolylinje (Punkt[] horn)
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

	// Kopierar vektorn this.horn och returnerar referensen till kopian
	public Punkt[] getHorn ()
	{
		Punkt[] kopieradeHorn = new Punkt[horn.length];
		for (int i = 0; i < horn.length; i++)
			kopieradeHorn[i] = horn[i];

		return kopieradeHorn;
	}

	// Returnerar Polylinjens färg
	public String getFarg ()
	{
		return farg;
	}

	// Returnerar Polylinjens bredd
	public int getBredd ()
	{
		return bredd;
	}

	// Sätter Polylinjens färg
	public void setFarg ( String farg )
	{
		this.farg = farg;
	}

	// Sätter Polylinjens bredd
	public void setBredd ( int bredd )
	{
		this.bredd = bredd;
	}

	// Beräknar polylinjens totala längd.
	public double langd ()
	{
		double langd = 0;
		for(int i = 0; i < horn.length-1; i++ )
			langd += horn[i].avstand(horn[i+1]);

		return langd;
	}

	// Lägget till ett hörn i slutet av vektorn this.horn
	public void laggTill ( Punkt horn )
	{
		Punkt[] nyHorn = new Punkt[this.horn.length + 1];
		int		i = 0;
		for (i = 0; i < this.horn.length; i++)
			nyHorn[i] = this.horn[i];

		nyHorn[i] = new Punkt (horn);
		this.horn = nyHorn;
	}

	// Söker igenom this objektets horn vektor, returnerar index ifall lika påträffas annars kastas exception
	public int sokHornNamn (String hornNamn)
	{
		// Init med -1, ifall inget hittas return -1
		int soktaHornetIndex = -1;

		// Jämför namn mot sokta namnet
		for (int i = 0; i < horn.length; i++)
		{
			if ( hornNamn.equalsIgnoreCase( horn[i].getNamn()) )
			{
				soktaHornetIndex = i;
				break;
			}
		}

		// Om index är  < 0 kasta exception
		if ( soktaHornetIndex == -1 )
			throw new NoSuchElementException("Sökta hörnet finns inte");
		return soktaHornetIndex;
	}

	// Lägger till ett hörn framför valda hörnet.
	public void laggTillFramfor (Punkt horn, String hornNamn)
	{
		Punkt[] nyHorn = new Punkt [this.horn.length + 1];
		// Om hornNamn inte finns i vektorn this.horn kastas exception
		int 	soktaIndex = sokHornNamn(hornNamn);

		int		i = 0;
		boolean hasInserted = false;
		while ( !hasInserted )
		{
			if ( i == soktaIndex )
			{
				hasInserted = true;
				break;
			}
			nyHorn[i] = this.horn[i];
			i++;
		}
		nyHorn[i] = new Punkt (horn);
		while ( hasInserted && i < this.horn.length )
		{
			nyHorn[i+1] = this.horn[i];
			i++;
		}

		this.horn = nyHorn;

	}

	// Tar bort specificerat hörn.
	public void taBort (String hornNamn)
	{
		Punkt[] nyHorn = new Punkt [this.horn.length - 1];
		// Om hornNamn inte hittas i vektorn this.horn kastas exception
		int soktaIndex = sokHornNamn(hornNamn);
		int i = 0;
		boolean hasRemoved = false;

		while (!hasRemoved)
		{
			if( i == soktaIndex )
			{
				hasRemoved = true;
				break;
			}
			nyHorn[i] = this.horn[i];
			i++;
		}

		while (hasRemoved && i < nyHorn.length)
		{
			nyHorn[i] = this.horn[i+1];
			i++;
		}

		this.horn = nyHorn;
	}

	public Iterator<Punkt> iterator()
	{
		return Arrays.asList(horn).iterator();
	}

}
