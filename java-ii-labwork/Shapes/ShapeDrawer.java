import javax.swing.*;		// JPanel
import java.awt.*;
import java.awt.geom.*;

class ShapeDrawer extends JPanel{

	private Shape shape;

	public ShapeDrawer ( Shape input ){
		shape = input;
	}

	public void paintComponent( Graphics gr ){
		super.paintComponent( gr );
		setBackground(Color.WHITE);
		Graphics2D g = (Graphics2D) gr;

		g.draw (shape);
	}
}