/*
 * Address object
 * contains information crutial to addressing.
 */

public class Address {
	
	private String 	streetName;
	private String 	streetNumber;
	private String 	area;
	private int 	areaCode;
	private String	country;
	
	public Address() {}
	
	public Address (Address other)
	{
		this.streetName = other.streetName;
		this.streetNumber = other.streetNumber;
		this.area = other.area;
		this.areaCode = other.areaCode;
		this.country = other.country;
	}
	
	public void setStreetName (String streetName)
	{ this.streetName = streetName; }
	
	public void setStreetNumber (String streetNumber)
	{ this.streetNumber = streetNumber ; }
	
	public void setArea (String areaName)
	{ area = areaName; }
	
	public void setAreaCode (int areaCode)
	{ this.areaCode = areaCode; }
	
	public void setCountry (String countryName)
	{ this.country = countryName; }
	
	public String toString ()
	{
		return streetName + " " + streetNumber + "\n" +
				areaCode +  " " + area + "\n" + 
				country;
	}
	

}
