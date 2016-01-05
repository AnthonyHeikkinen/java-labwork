class Rabbit implements AnimalInterface{

	private int weight;
	private int kittens;

	public Rabbit (int weight, int numberOfKittens){
		this.weight = weight;
		kittens = numberOfKittens;
	}

	public void eat(){
		System.out.println("The rabbit eats carrots");
	}

	public void sleep (int amount){
		System.out.println("The rabbit goes down into " +
						"it's hole and sleeps for " +
							amount + " hours." );
	}

	public int getWeight(){
		return weight;
	}

	public void jump(){
		System.out.println ("The bunny jumps");
	}
}
