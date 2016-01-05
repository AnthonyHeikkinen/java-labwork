import java.util.Calendar;
class FoodItem {

	private String name;
	private Calendar expirationDate;
	private Calendar openedDate;
	private int durability;

	public FoodItem ( String name ){
		this.name = name;
	}

	public FoodItem ( String name, int durability ){
		this.name = name;
		this.durability = durability;
	}

	public void open(){
		openedDate = Calendar.getInstance();
		expirationDate = openedDate.roll(Calendar.DAY_OF_MONTH, durability );
	}
}