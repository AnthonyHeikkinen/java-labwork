package variables;
/*
 * Oracle Variables Exercise
 */
public class FieldTest {
	
	public static void main (String args[]){
		
		byte firstByte = 120;
		short firstShort = 32023;
		int firstInt = 240343;
		
		long firstLong = 239142394393L;
		float firstFloat = 2.33423f;
		double firstDouble = 2.3423423542;
		
		boolean firstBoolean = true;
		char firstChar = '!';
		
		/* POOR FIELD NAMES AND VALUES
		byte 2ndByte = 101;			// starts with a number
		short secondShort = 43000;// out of bounds, can not convert from int to short
		int #örjan = 10;  		// starts with a invalid character
		/**/
		
		//testPrintout();
		/*String testingStr; 			// Only declared
		System.out.println (testingStr);*/ // will not compile, uninitialized
		
	}
	
	/*public static void testPrintout (){
		int localVariable;					// Only declared, to pass compilation
											// It has to be initialized
		System.out.println (localVariable);
	}*/
}
