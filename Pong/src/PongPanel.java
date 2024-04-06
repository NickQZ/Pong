   import java.awt.Color;
   import java.awt.event.ActionEvent;
   import java.awt.event.ActionListener;
   import java.awt.event.KeyEvent;
   import java.awt.event.KeyListener;
   import javax.swing.JPanel;
   import javax.swing.Timer;
   import java.awt.Graphics;
   import java.awt.Graphics2D;

   public class PongPanel extends JPanel implements ActionListener, KeyListener {
	   
	   //Set Background of JPanel Black
	   private final static Color BACKGROUND_COLOUR = Color.BLACK;
	   //Import Timer
	   private final static int TIMER_DELAY = 5;

	   public PongPanel() {
		   
		   //Set Background to Background_Colour
	       setBackground(BACKGROUND_COLOUR);
	       
	       //Set Timer start
	       Timer timer = new Timer(TIMER_DELAY, this);
	       timer.start();
	       
	       update();
	   }

      @Override
      public void keyPressed(KeyEvent event) {

      }

      @Override
      public void keyReleased(KeyEvent event) {

      }

      @Override
      public void keyTyped(KeyEvent event) {

      }

      @Override
      public void actionPerformed(ActionEvent event) {

      }
      
      public void update() {
    	  
      }
      //Draws graphics on JPanel
      @Override
      public void paintComponent(Graphics g) {
          super.paintComponent(g);
          g.setColor(Color.WHITE);
          g.fillRect(20, 20, 100, 100);
       }
   }

  