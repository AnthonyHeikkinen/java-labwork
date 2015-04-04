import java.lang.Iterable;
import java.util.Iterator;

public interface Polylinje extends Iterable<Punkt>
{
	Punkt[] getHorn ();

	String getFarg ();

	int getBredd ();

	double langd ();

	void setFarg (String farg);

	void setBredd (int bredd);

	public void laggTill (Punkt horn);

	int sokHornNamn (String hornNamn);

	void laggTillFramfor (Punkt horn, String hornNamn);

	void taBort (String hornNamn);

	Iterator<Punkt> iterator ();
}