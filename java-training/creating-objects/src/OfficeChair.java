/*
 * OfficeChair class - creates OfficeChair objects
 */
public class OfficeChair implements Chair{
	private int wheels = 0;
	private int height = 0;
	private String firmness = "NOT SET";
	
	OfficeChair (int numWheels, int startHeight, String comfort){
		wheels = numWheels;
		height = startHeight;
		firmness = comfort;
	}

	void setWheels (int newValue){
		wheels = newValue;
	}
	
	void raise (int increment){
		height = height + increment;
	}

	void lower (int decrement){
		height = height - decrement;
	}
	
	public void setCushionComfort(String comfort){
		firmness = comfort;
	}
	
	public void printStates(){
		StringBuilder state = new StringBuilder ();
		state.append("The firmness of the chair: ");
		state.append(firmness);
		state.append("\nThe number of wheels: ");
		state.append(wheels);
		state.append("\nThe current height in cm is: ");
		state.append(height);
		
		System.out.print(state);		
	}
	
}
