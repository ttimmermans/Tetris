package tetris.timmermans.thomas;

import java.awt.*;
import java.awt.geom.*;

public class Block extends Component {
	
	private static final int SIDE = 20; // length of a block's side
	
    private static final int GRAVITY = 3;  // effect of gravity
    
    private boolean moving = true;

    private int ballDegradation = 2;
    private Ellipse2D.Double circle;
    private Color color;
    private int xPosition;
    private int yPosition;
    private Canvas canvas;
    private int ySpeed = 20;                // initial downward speed
	
	public Block(int xPos, int yPos, Color color, int groundPos, Canvas drawingCanvas) {
		
        xPosition = xPos;
        yPosition = yPos;
        this.color = color;
        canvas = drawingCanvas;
        //blabla
		
	}
	
    /**
     * Draw this block at its current position onto the canvas.
     **/
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillRectangle(xPosition, yPosition, SIDE, SIDE);
    }
    
    /**
     * Move this ball according to its position and speed and redraw.
     **/
    public void moveDown()
    {
        // remove from canvas at the current position
        erase();
            
        // compute new position
        //ySpeed += GRAVITY;
        yPosition += ySpeed;
        //xPosition +=2;

        /*
        // check if it has hit the ground - the reverse direction
        if(yPosition >= (groundPosition - DIAMETER) && ySpeed > 0) {
            yPosition = (int)(groundPosition - DIAMETER);
            ySpeed = -ySpeed + ballDegradation; 
        }
        */

        // draw again at new position
        draw();
    }
    
    /**
     * 
     */
    public void moveLeft() {
    	erase();
    	xPosition -= SIDE;
    	draw();
    }
    
    /**
     * 
     */
    public void moveRight() {
    	erase();
    	xPosition += SIDE;
    	draw();
    }
    
    /**
     * Erase this block at its current position.
     **/
    public void erase()
    {
    	canvas.eraseRectangle(xPosition, yPosition, SIDE, SIDE);
        //canvas.eraseCircle(xPosition, yPosition, diameter);
    }
    
    /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * return the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPosition;
    }
    
    /**
     * return if this block is moving or not
     */
    public boolean moving() {
    	return moving;
    }
    
    /**
     * Set whether or not this block is moving down
     * @param b
     */
    public void setMoving(boolean b) {
    	moving = b;
    }

}
