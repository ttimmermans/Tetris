package tetris.timmermans.thomas;

import java.awt.Color;

public class Vorm {
    
    private static final int SIDE = 50;

	public static void main(String[] args) {
		
	    int xPos = 20; // xPosition
	    int yPos = 20; // yPosition
	    
	    int innerSide = SIDE - 3;
	    
	    Color color = new Color(200, 180, 60);
		
		Canvas canvas = new Canvas("TestVorm", 220, 320);
		
		// "Lighten" color
		int r = color.getRed() + 40;
		int g = color.getGreen() + 40;
		int b = color.getBlue() + 40;
		r = r > 255 ? 255 : r;
		g = g > 255 ? 255 : g;
		b = b > 255 ? 255 : b;
		Color lighterColor = new Color(r, g, b);
		
		
		canvas.setForegroundColor(lighterColor);
		
		canvas.drawLine(xPos, yPos, xPos + SIDE, yPos);
		canvas.drawLine(xPos, yPos + 1, xPos + SIDE - 1, yPos + 1);
		
		//canvas.setForegroundColor(Color.GREEN);
		
		canvas.drawLine(xPos, yPos + 2, xPos, yPos + SIDE - 1);
		canvas.drawLine(xPos + 1, yPos + 2, xPos + 1, yPos + SIDE - 2);
		
		
		
		// "Darken" color
		r = color.getRed() - 40;
		g = color.getGreen() - 40;
		b = color.getBlue() - 40;
		r = r < 0 ? 0 : r;
		g = g < 0 ? 0 : g;
		b = b < 0 ? 0 : b;
		Color darkerColor = new Color(r, g, b);
		
		
		
		canvas.setForegroundColor(darkerColor);
		
		canvas.drawLine(xPos, yPos + SIDE, xPos + SIDE, yPos + SIDE);
		canvas.drawLine(xPos + 1, yPos + SIDE - 1, xPos + SIDE, yPos + SIDE - 1);
		
		canvas.drawLine(xPos + SIDE, yPos + SIDE - 2, xPos + SIDE, yPos + 1);
		canvas.drawLine(xPos + SIDE - 1, yPos + SIDE - 2, xPos + SIDE -1, yPos + 2);
		
		
		canvas.setForegroundColor(color);
		
		canvas.fillRectangle(xPos + 2, yPos + 2, innerSide, innerSide);

	}

}
