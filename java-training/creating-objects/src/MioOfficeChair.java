public class MioOfficeChair extends OfficeChair{
	private String material = "NOT SET";
	
	MioOfficeChair (int wheels, int height, String firmness, String material){
		super(wheels, height, firmness);
		this.material = material;
	}
	
	void setMaterial (String material){
		this.material = material;
	}
	
	public void printStates (){
		super.printStates();
		StringBuilder state = new StringBuilder("\nThe material is: ");
		state.append(material);
		System.out.println(state);
		
	}
	
}
