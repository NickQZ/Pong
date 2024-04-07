   import java.awt.Color;
   import java.awt.event.ActionEvent;
   import java.awt.event.ActionListener;
   import java.awt.event.KeyEvent;
   import java.awt.event.KeyListener;
   import javax.swing.JPanel;
   import javax.swing.Timer;
   import java.awt.Graphics;
   import java.awt.Graphics2D;
   import java.awt.Stroke;
   import java.awt.BasicStroke;
   import java.awt.BasicStroke;

   public class PongPanel extends JPanel implements ActionListener, KeyListener { // Open PongPanel Class
	   
	   //Set Background of JPanel Black
	   private final static Color BACKGROUND_COLOUR = Color.BLACK;
	   //Import Timer
	   private final static int TIMER_DELAY = 5;

	   public PongPanel() { // Open PongPanel
		   
		   //Set Background to Background_Colour
	       setBackground(BACKGROUND_COLOUR);
	       
	       //Set Timer start
	       Timer timer = new Timer(TIMER_DELAY, this);
	       timer.start();
 
	   } // Close PongPanel
	   
      //Draws Centered Dotted Line
      private void paintDottedLine(Graphics g) { // Open PaintDottedLine
    	        Graphics2D g2d = (Graphics2D) g.create();
    	        Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
    	        g2d.setStroke(dashed);
    	        g2d.setPaint(Color.WHITE);
    	        g2d.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight());
    	        g2d.dispose();
    	        
       } // Close PaintDottedLine
      
      private void paintSprite(Graphics g, Sprite sprite) {
    	     g.setColor(sprite.getColour());
    	     g.fillRect(sprite.getxPosition(), sprite.getyPosition(), sprite.getwidth(), sprite.getheight());
    	}
      
      
      @Override
      public void keyPressed(KeyEvent event) { // Open KeyPressed

      } // Close KeyPressed

      @Override
      public void keyReleased(KeyEvent event) { // Open KeyReleased

      } // Close KeyReleased

      @Override
      public void keyTyped(KeyEvent event) { // Open keyTyped

      } // Close keyTyped
      
      // Create Ball Object
        GameState gameState = GameState.INITIALISING;
        Ball ball;
              
        public void createObjects() {
               ball = new Ball(getWidth(), getHeight());
        }
        
        // Update Objects
        private void update() {
         switch(gameState) {
         case INITIALISING: {
         createObjects();
         gameState = GameState.PLAYING;
          break;
         }
          case PLAYING: {
          break;
        	            }
          case GAMEOVER: {
          break;
          }
         }
             
      } // Close Update
      
      
      @Override
      public void actionPerformed(ActionEvent event) { // Open ActionPreformed
    	  update();
    	  repaint();

      } // Close ActionPreformed
      
      //Draws graphics on JPanel
      @Override
       public void paintComponent(Graphics g) {// Open PaintComponent
    	  // Paint Dotted Line
            super.paintComponent(g);
            paintDottedLine(g);
            // Paint Ball Sprite
            if(gameState != GameState.INITIALISING) {
                paintSprite(g, ball);
            }
       }// Close PaintComponent
      
      public void gameState(ActionEvent event){
    	  
      }
     
      
      
   } // Close PongPanel Class

  