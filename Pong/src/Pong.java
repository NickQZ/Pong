import javax.swing.JFrame;

public class Pong extends JFrame { // Open Pong Class

	//Window Title
	private final static String WINDOW_TITLE = "Pong";
	//Window Width
	private final static int WINDOW_WIDTH = 800;
	//Window Height
	private final static int WINDOW_HEIGHT = 600;

	public Pong() { // Open Pong
		//Display Window Title As "Pong"
		setTitle(WINDOW_TITLE);
		//Display Window Width: 800 & Window Height: 600
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		//Is Window Resizable?
		setResizable(false);
		//Import Code from PongPanel
		add(new PongPanel());
		//Is Window Visible?
		setVisible(true);
		//On Exit Terminate Program
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	} // Close Pong

	//When Program is Run...
	public static void main(String[] args) { // Open Main     

		//Run PongPanel.java 
		javax.swing.SwingUtilities.invokeLater(new Runnable() { // Open Excutable

			public void run() { // Open Run

				new Pong();

			} // Close Run

		});// Close Excutable
	} // Close Main
} // Close Pong Class

