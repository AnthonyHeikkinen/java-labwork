package testingabstract;

public class ShapeTester {

	public static void main(String[] args){
		Shape shapes[] = new Shape[5];
		shapes[0] = new Circle();
		shapes[1] = new Rectangle();
		shapes[2] = new Rectangle();
		shapes[3] = new Circle();
		shapes[4] = new Rectangle();
		
		for (int i = 0; i < shapes.length; i++) {
			divider();
			System.out.println(shapes[i].area());
			System.out.println(shapes[i].draw());
		}
		
		divider();
	}
	
	public static void divider () {
		System.out.println(
		"\n================================\n");
	}
}
