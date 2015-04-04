import static java.lang.System.out;
public class personTest
{
	public static void main (String args[])
	{
		Person[] tidab = new Person[10];
		tidab[0] = new Person ("19820423-5634");
		tidab[0].setFirstName("Carl Anthony");
		tidab[0].setLastName("Heikkinen");
		tidab[0].setGender("Male");
		
		Address tAddr = new Address();
		tAddr.setStreetName ("Anderstorpsvagen");
		tAddr.setStreetNumber("4");
		tAddr.setArea		("Solna");
		tAddr.setAreaCode	(17151);
		tAddr.setCountry 	("Sweden");
		
		tidab[0].setAddress ( new Address (tAddr) );
		
		out.println (tidab[0]) ;
		
	}	
}
