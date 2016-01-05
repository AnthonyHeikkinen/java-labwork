import javax.swing.*;		// JDialog
import java.awt.*;			// Rectangle2D
import java.awt.geom.*;
import java.util.*;			// Random

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
class ShapeFactory{
	private String  choice;

	public ShapeFactory(){
		choice = chooseShape();
	}
	public ShapeFactory( String choice ){
		this.choice = choice;
	}

	public String chooseShape(){
		JDialog dialog = new JDialog();
		dialog.setTitle( "Choose shape" );
		dialog.setModal( true );
		dialog.setDefaultCloseOperation( JDialog.DISPOSE_ON_CLOSE );
		dialog.setSize ( 550, 100 );
		dialog.setLocation( 100, 100 );

		JLabel	message = new JLabel ( "Choose the shape you want to draw" );
		JButton	btn1	= new JButton( "Great quote" );
		JButton	btn2	= new JButton( "Line" );
		JButton	btn3	= new JButton( "Ellipse" );
		JButton	btn4	= new JButton( "Rectangle" );
		JButton	btn5	= new JButton( "Smiley" );

		btn1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
                System.out.println("You clicked the button");
            }
        });


		JPanel choices	= new JPanel();
		choices.add( btn1 );
		choices.add( btn2 );
		choices.add( btn3 );
		choices.add( btn4 );
		choices.add( btn5 );

		dialog.add( message, "North" );
		dialog.add( choices );
		dialog.setVisible( true );

		return "";
	}

	public Shape createShape( String shapetype ){
		switch ( shapetype.toLowerCase() ){
			case "line" :
				return createLine2D();
			case "ellipse" :
				return createEllipse2D();
			case "rectangle" :
				return createRectangle2D();
			case "smiley" :
				return createSmiley2D();
			case "great quote":
				return createGreatQuote2D();
			default :  return null;
		}
	}
	public Double genRanDouble(){
		Random r = new Random();
		double d = 1.0 + r.nextDouble() * 100.0;
		return d;
	}

	public Shape createLine2D(){
		return null;
	}

	public Shape createEllipse2D(){
		return null;
	}

	public Shape createRectangle2D(){
		return null;
	}

	public Shape createSmiley2D(){
		return null;
	}

	public Shape createGreatQuote2D(){
		return null;
	}

}
