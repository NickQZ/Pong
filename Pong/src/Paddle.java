import java.awt.Color;


public class Paddle extends Sprite {

	// Declare Ball Variables
	private static final int PADDLE_WIDTH = 10;
	private final static int PADDLE_HEIGHT = 100;
	private final static Color PADDLE_COLOR = Color.BLUE;
	private final static int DISTANCE_FROM_EDGE = 40;

	// Constructor with Player, Panel Height + Width
	public Paddle(Player player, int panelWidth, int panelHeight) {

		// Set Variables to Paddle values
		setwidth(PADDLE_WIDTH);
		setheight(PADDLE_HEIGHT);
		setColor(PADDLE_COLOR);

		// int = xPos
		int xPos;

		// If player = 1 then xPos = Distance from Edge
		if(player == Player.One) {

			xPos = DISTANCE_FROM_EDGE;
			// Else xPos = Panel Width - Distance from Edge - Get Width
		} else {

			xPos = panelWidth - DISTANCE_FROM_EDGE - getwidth();

		}

		// Set Initial Position to xPos to half of panel height and half get height
		setInitialPosition(xPos, panelHeight / 2 - (getheight() / 2));

		// Reset to Initial Position to re-run for Player 2
		resetToInitialPosition();

	}

}