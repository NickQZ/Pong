import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;  

public class PongPanel extends JPanel implements ActionListener, KeyListener {

	// Color of Background
	private final static Color BACKGROUND_COLOUR = Color.BLACK;
	// Ball Movement speed
	private final static int BALL_MOVEMENT_SPEED = 3;       
	// Start Timer
	private final static int TIMER_DELAY = 5;
	// Game State 
	GameState gameState = GameState.INITIALISING;
	// Call Ball object
	Ball ball;
	// Create Paddles
	Paddle paddle1, paddle2;

	// Pong Game Panel
	public PongPanel() {
		// Allow the panel to receive key events
		setFocusable(true); 
		// Add key listener to the panel
		addKeyListener(this); 

		setBackground(BACKGROUND_COLOUR);

		Timer timer = new Timer(TIMER_DELAY,this);

		timer.start();

	}      
	// Objects in game panel
	public void createObjects() {

		ball = new Ball(getWidth(), getHeight());

		paddle1 = new Paddle(Player.One, getWidth(), getHeight());

		paddle2 = new Paddle(Player.Two, getWidth(), getHeight());

	}       

	// Move ball object 
	private void moveObject(Sprite obj) {
		obj.setXPosition(obj.getXPosition() + obj.getxVelocity(), getWidth());
		obj.setYPosition(obj.getYPosition() + obj.getyVelocity(), getWidth());
	}


	private void checkWallBounce() {

		if(ball.getXPosition() <= 0) {
			// Hit left side of screen
			ball.setxVelocity(-ball.getxVelocity());
			resetBall();

		} else if(ball.getXPosition() >= getWidth() - ball.getwidth()) {
			// Hit right side of screen
			ball.setxVelocity(-ball.getxVelocity());
			resetBall();
		}

		if(ball.getYPosition() <= 0 || ball.getYPosition() >= getHeight() - ball.getheight()) {
			// Hit top or bottom of screen
			ball.setyVelocity(-ball.getxVelocity());

		}

	}

	private void resetBall() {
		ball.resetToInitialPosition();
	}


	// Update game state
	private void update() {

		switch(gameState) {

		case INITIALISING: {

			createObjects();

			gameState = GameState.PLAYING;
			ball.setxVelocity(BALL_MOVEMENT_SPEED);
			ball.setyVelocity(BALL_MOVEMENT_SPEED);
			break;

		}

		case PLAYING: {
			moveObject(paddle1);
			moveObject(paddle2);
			moveObject(ball);
			checkWallBounce();
			break;

		}

		case GAMEOVER: {
			break;

		}

		}

	}
	// Paint Dotted Lines in center of Screen
	private void paintDottedLine(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
		g2d.setStroke(dashed);
		g2d.setPaint(Color.RED);
		g2d.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight());
		g2d.dispose();
	}
	// Paint Sprite objects
	private void paintSprite(Graphics g, Sprite sprite) {
		g.setColor(sprite.getColour());
		g.fillRect(sprite.getxPosition(), sprite.getyPosition(), sprite.getwidth(), sprite.getheight());

	}

	@Override
	public void keyPressed(KeyEvent event) {
		if(event.getKeyCode() == KeyEvent.VK_UP) {
			paddle2.setyVelocity(-3);
		} else if(event.getKeyCode() == KeyEvent.VK_DOWN) {
			paddle2.setyVelocity(3);
		}
		if(event.getKeyCode() == KeyEvent.VK_W) {
			paddle1.setyVelocity(-3);
		} else if (event.getKeyCode() == KeyEvent.VK_S) {
			paddle1.setyVelocity(3);
		}
	}

	@Override
	public void keyReleased(KeyEvent event) {
		if(event.getKeyCode() == KeyEvent.VK_UP || event.getKeyCode() == KeyEvent.VK_DOWN) {
			paddle2.setyVelocity(0);
		}
		if(event.getKeyCode() == KeyEvent.VK_W || event.getKeyCode() == KeyEvent.VK_S) {
			paddle1.setyVelocity(0);
		}
	}

	@Override

	public void keyTyped(KeyEvent event) {
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		update();
		repaint();

	}

	// Paint New frame of game state/objects moving
	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		paintDottedLine(g);

		if(gameState != GameState.INITIALISING) {

			paintSprite(g, ball);

			paintSprite(g, paddle1);

			paintSprite(g, paddle2);

		}

	}

}