import java.util.*; /* Iterator, Arrays, NoSuchElementException */
public class NPolylinje implements Polylinje
{

	private static class Nod
	{
		public Punkt	horn;
		public Nod		nastaNod;

		public Nod (Punkt horn)
		{
			this.horn = horn;
			nastaNod = null;
		}
	}

	private Nod 		horn;
	private String		farg = "svart";
	private int			bredd = 1; // Pixlar

	public NPolylinje ()
	{
		this.horn = null;
	}

	public NPolylinje (Punkt[] horn)
	{
		if (horn.length > 0)
		{
			Nod		nod = new Nod (new Punkt (horn[0]));
			this.horn	= nod;
			int		pos = 1;

			while (pos < horn.length)
			{
				nod.nastaNod = new Nod ( new Punkt (horn[pos++]));
			}
		}
	}

	private int length ()
	{
		int 	nodSize = 0;
		Nod 	nodPekare = horn;
		if ( nodPekare != null )
		{
			nodSize = 1;
			boolean finnsNastaNod = (nodPekare.nastaNod != null);
			// Så länge som det finns nästa noder öka storlek
			while (finnsNastaNod == true)
			{
				nodPekare = nodPekare.nastaNod;
				nodSize++;
				finnsNastaNod = (nodPekare.nastaNod != null);
			}
		} else {
			throw new java.lang.NullPointerException ("Tom nod");
		}

		return nodSize;
	}

	public Punkt[] getHorn ()
	{
		int 	nodSize = length();
		Punkt[]	hornVektor = new Punkt[nodSize];
		int		pos = 0;
		for(Iterator<Punkt> i = iterator(); i.hasNext(); )
		{
			hornVektor[pos]= i.next();
			pos++;
		}

		return hornVektor;
	}

	public String getFarg ()
	{
		return farg;
	}

	public int getBredd ()
	{
		return bredd;
	}

	public double langd ()
	{
		double langd = 0;
		Punkt foregaendeHorn = horn.horn;
		for(Iterator<Punkt> i = iterator(); i.hasNext(); )
		{
			Punkt hornItr = i.next();
			langd =+ foregaendeHorn.avstand(hornItr);
			foregaendeHorn = hornItr;
		}

		return langd;

	}

	public void setFarg (String farg)
	{
		this.farg = farg;
	}

	public void setBredd (int bredd)
	{
		this.bredd = bredd;
	}

	// Letar efter sista noden och lägger till en ny nod.
	public void laggTill (Punkt horn)
	{
		Nod		nyNod = new Nod (horn);
		Nod		nodPekare = this.horn;
		while ( nodPekare.nastaNod != null)
		{
			nodPekare = nodPekare.nastaNod;
		}
		nodPekare.nastaNod = nyNod;
	}

	public int sokHornNamn (String hornNamn)
	{
		boolean	hornHittat = false;
		int		pos = 0;
		Nod		nodPekare = this.horn;
		// Jämför namn mot sokta namnet
		for(pos = 0; nodPekare.nastaNod != null; pos++)
		{
			if ( hornNamn.equalsIgnoreCase( nodPekare.horn.getNamn()) )
			{
				hornHittat = true;
				break;
			}
			nodPekare = nodPekare.nastaNod;
		}


		// Om index är  < 0 kasta exception
		if ( hornHittat == false )
			throw new NoSuchElementException("Sökta hörnet finns inte");
		return pos;
	}

	public void laggTillFramfor (Punkt horn, String hornNamn)
	{
		Nod		nodPekare = this.horn;
		int		indexSoktaHorn = sokHornNamn (hornNamn);
		Nod		nyNod = new Nod (horn);

		for (int i = 0; i <= indexSoktaHorn; i++)
		{
			nodPekare = nodPekare.nastaNod;
		}

		nyNod.nastaNod = nodPekare.nastaNod;
		nodPekare.nastaNod = nyNod;
	}

	public void taBort (String hornNamn)
	{
		Nod		nodPekare = this.horn;
		int		indexSoktaHorn = sokHornNamn (hornNamn);
		Nod		foregaendeNod = null;

		while ( indexSoktaHorn > 0)
		{
			foregaendeNod = nodPekare;
			nodPekare = nodPekare.nastaNod;
			indexSoktaHorn--;
		}

		foregaendeNod.nastaNod = nodPekare.nastaNod;
	}

	public Iterator<Punkt> iterator ()
	{
		return new NPolylinjeIterator();
	}

	public class NPolylinjeIterator implements Iterator<Punkt>
	{
			private int current = -1;
			private Nod nodPekare = NPolylinje.this.horn;


			public NPolylinjeIterator()
			{
				if ( horn != null )
					current = 0;
			}


			public boolean hasNext ()
			{
				return current != -1;
			}

			public Punkt next () throws NoSuchElementException
			{
				if (!this.hasNext())
					throw new NoSuchElementException ("slut av iterationen");

				Punkt horn = nodPekare.horn;

				if (current >= 0 && nodPekare.nastaNod != null)
					nodPekare = nodPekare.nastaNod;
				else
					current = -1;

				return horn;
			}


	}

}