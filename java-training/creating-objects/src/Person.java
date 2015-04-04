/*
 * Person object
 * The person object contains information such as:
 * socialid, gender, firstname, lastname, address.
 * 
 */
public class Person {
	/*
	 * Instance variables
	 */
	private String socialId;
	private String gender;
	private String firstName;
	private String lastName;
	Address address;
	
	/*
	 * Constructors
	 */
	public Person (){}
	
	public Person (	String socialId )
	{ this.socialId = socialId; }
	
	
	/*
	 * Mutators
	 */
	public void setSocialId (String socId)
	{
		
	}
	
	public void setFirstName(String firstName)
	{ this.firstName = firstName; }
	
	public void setLastName (String lastName)
	{ this.lastName = lastName; }
	
	public void setGender (String gender)
	{ this.gender = gender; }
	
	public void setAddress ( Address address )
	{ this.address = address; }
	
	/*
	 * Accessors, Inspectors
	 */
	public String getSocialId() { return socialId; }
	public String getFirstName() { return firstName; }	
	public String getLastName() { return lastName; }	
	public String getGender() { return gender; }
	
	/*
	 * Converter
	 */
	public String toString ()
	{
		String output	= socialId + ", " + gender + "\n"
						+ lastName + ", " + firstName + "\n\n"
						+ firstName + " " + lastName + "\n" + address.toString();
		return output;					 	
	}
}
