import java.awt.Color;
import java.awt.Rectangle;

public class Sprite { // Open Sprite Class
	
	// Set x & Y Position
	private int xPosition, yPosition;
	//Set X & Y Velocity
	private int xVelocity, yVelocity;
	//Set Height Width
	private int width,height;
	//Set Panel Colour
	private Color colour;
	// Set Panel Width
	private int panelWidth;
	//Start Position X
	private int initialXPosition;
	//Start Position Y
	private int initialYPosition;
	

// Getter Methods
public int getxPosition() { return xPosition; }
public int getyPosition() { return yPosition; }
public int getxVelocity() { return xVelocity; }
public int getyVelocity() { return yVelocity; }
public int getwidth() { return width; }
public int getheight() { return height; }
public Color getColour() { return colour;}



// Keeping Sprite within the Boundary of the Screen
public int getXPosition () { return xPosition; }
public int getYPosition () { return yPosition; }
public int getpanelWidth () { return panelWidth; }



// Setter Methods
public void setxPosition(int xPosition) { this.xPosition = xPosition; }
public void setyPosition(int yPosition) { this.yPosition = yPosition; }
public void setxVelocity (int xVelocity) { this.xVelocity = xVelocity; }
public void setyVelocity (int yVelocity) { this.yVelocity = yVelocity; }
public void setwidth(int width) { this.width = width; }
public void setheight(int height) { this.height = height; }
public void setColor(Color colour) { this.colour = colour; }

// Set Initial Start Positions
public void setInitialXPosition(int initialX, int initialY) {initialXPosition = initialX; initialYPosition = initialY; } 

// Set Initial Start Positions
public void resetToInitialPosition() {
	setxPosition(initialXPosition);
	setyPosition(initialYPosition);
}


//Keeping Sprite within the Boundary of the Screen
public void setXPosition(int newX) { xPosition = newX; }
public void setYPosition(int newY) { yPosition = newY; } 
public void setpanelWidth(int panelWidth) { this.panelWidth = panelWidth; }

//Keeping Sprite within the Boundary of the Screen
public void setXPosition(int newX, int panelWidth) {
	xPosition = newX;
	if (xPosition < 0) {
		xPosition = 0;
		
	} else if (xPosition + width > panelWidth) {
		xPosition = panelWidth - width;
	}
}

public void setYPosition(int newY, int panelHeight) {

    yPosition = newY;
    if(yPosition < 0) {
        yPosition = 0;

    } else if(yPosition + height > panelHeight) {
        yPosition = panelHeight - height;

    }
}

// Import Rectangle
public Rectangle getRectangle() { // Open Rectangle 
       return new Rectangle(getxPosition(), getyPosition(), getwidth(), getheight());
       
   } // Close Rectangle


}// Close Sprite Class