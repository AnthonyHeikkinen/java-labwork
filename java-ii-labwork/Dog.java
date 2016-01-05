class Dog implements AnimalInterface {
	String breed;
	int weight;

	public Dog (String breed, int weight){
		this.breed = breed;
		this.weight = weight;
	}

	public void eat(){
		System.out.println("The dog eats meat");
	}

	public void sleep(int amount){
		System.out.println ("The dog walks to its' doghouse and "
						+	"sleeps for " + amount + "hours" );
	}

	public int getWeight(){
		return weight;
	}

	public void bark (String manner){
		System.out.println( "The dog barks " + manner + ".");
	}
}