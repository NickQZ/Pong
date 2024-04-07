import java.awt.Color;

// Connects Ball Class to Sprite Class
public class Ball extends Sprite {
	
	// Set Ball Width + Height to 25
	private static final int BALL_WIDTH = 25;
	private static final int BALL_HEIGHT = 25;
	// Set Ball color to White
	private static final Color BALL_COLOUR = Color.white;
	
	// Adjust Ball to center of screen
	public Ball(int panelWidth, int panelHeight) {
		setwidth(BALL_WIDTH);
		setheight(BALL_HEIGHT);
		setColor(BALL_COLOUR);
		// Set Position to half the width and height of the Panel
		setInitialPosition(panelWidth / 2 - (getwidth() / 2), panelHeight / 2 - (getheight() / 2 ));
		resetToInitialPosition();
	}
	
}
