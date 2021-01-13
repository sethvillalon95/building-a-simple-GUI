
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.File;

import javax.swing.JPanel;
import javax.swing.Timer;


public class Vis extends JPanel {
    public Color background;
    public Color stripesC;
    public Color starsC;
    public Color boxC;
    public Color ballC; 
    
    boolean show;
    int cx = 0; 
    int cy = 0;


    public Vis() {
        super();
        
        // initialize the colors 
        background = Color.RED;
        stripesC = background;
        boxC = background;
        starsC = background;
        ballC = background;
        show = false;
    }


    



    @Override
    public void paintComponent(Graphics g1) {
        Graphics2D g = (Graphics2D)g1;

        //draw blank background
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        //render visualization
//        g.setColor(Color.BLACK);
        g.drawString("Your content here", 10, 20);
        int w = getWidth(); 
		int h = getHeight(); 
		int numStripes = 13;
		int stripeHeight = h / numStripes;
		int stripeHeight1 = h / numStripes;
		int stripeWidth = w;
		int blueBoxWidth = 2*w/5;
		int blueBoxHeight = 7*stripeHeight;
		int numRows = 6;
		int numCols = 8;
		int starWidth = blueBoxWidth/numCols;
		int starHeight = blueBoxHeight/numRows;
		
	
		
		//background color 
		g.setColor(background);
		g.fillRect(0,0,w,h);
//		
		
		// remove stripes?
		for (int i = 0; i < 6; i++){
			g.setColor(stripesC);
			g.fillRect(0,stripeHeight1,stripeWidth,stripeHeight);
			stripeHeight1 += stripeHeight*2;
		}
		
		// Box 
		g.setColor(boxC);
		g.fillRect(0,0,blueBoxWidth,blueBoxHeight);
//		
//		//remove stripes?
		// Stars 
		

		int y = 0 ;
		for ( int i = 0; i < numRows; i++){
			int x = 0 ;
			for (int j = 0; j < numCols; j++){
				g.setColor(starsC);
				g.fillOval( x, y,starWidth, starHeight);
				x +=starWidth;
				
			}
			y +=starHeight;
			
		}
		if(show) {
	        g.setColor(ballC);
	        g.fillOval(cx,cy,100,100);

		}

    }


}
