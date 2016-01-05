import javax.swing.*;		// JDialog
import java.awt.*;			// Rectangle2D
import java.awt.geom.*;
class ShapeCreator{
	public static void main( String[] args ){
		Object[] shapeOption = { new String( "Ellipse" ),
								 new String( "Rectangle" ),
								 new String( "Rectangle w round corners" )
								};
		Object	input = JOptionPane.showInputDialog(	null,
														"Choose shape to make",
														"Choice of shape",
														JOptionPane.QUESTION_MESSAGE,
														null,
														shapeOption,
														shapeOption[0]
													);
		String choice = (String) input;
		try{
		System.out.println( "You choose: " + choice );
		} catch ( Exception e ){
			System.out.println( "Bad input, program will terminate" );
			System.exit(0);
		}
		Object	inputWidth = JOptionPane.showInputDialog(null,
														"Enter the width of the " + choice + "(ex. 123.4)",
														choice + " width",
														JOptionPane.QUESTION_MESSAGE
														);
		double width = 0 ;
		try{
			width = Double.parseDouble((String) inputWidth);
		} catch ( Exception e ){
			System.out.println( "Bad input, program will terminate" );
			System.exit(0);
		}
		System.out.println( "Width: " + inputWidth );

		Object	inputHeight = JOptionPane.showInputDialog(null,
														"Enter the height of the " + choice + "(ex. 123.4)",
														choice + " height",
														JOptionPane.QUESTION_MESSAGE
														);
		double 	height = 0;
		try{
			height = Double.parseDouble((String) inputHeight);
		} catch ( Exception e ){
			System.out.println( "Bad input, program will terminate" );
			System.exit(0);
		}

		System.out.println( "Height: " + inputHeight );

		Shape shape = createShape( choice, width, height );

		ShapeDrawer drawer = new ShapeDrawer ( shape );
		JFrame frame = new JFrame( "ShapeDrawer" );
		frame.setSize( 1000, 500 );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.add( drawer );
		frame.setVisible( true );

	}

	public static Shape createShape( String choice, double width, double height ){
		switch ( choice.toLowerCase() ){
			case "ellipse":
				return new Ellipse2D.Double( 50.0, 50.0, width, height );
			case "rectangle":
				return new Rectangle2D.Double( 50.0, 50.0, width, height );
			case "rectangle w round corners" :
				return new RoundRectangle2D.Double( 50.0, 50.0, width, height, 5, 5 );
			default: return null;
		}
	}
}
