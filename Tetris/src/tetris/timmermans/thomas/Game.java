package tetris.timmermans.thomas;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class Game {
	
	static Canvas myCanvas;
	static ArrayList<Block> blocks = new ArrayList<>();
	
	/**
	 * Check if this block hits another block.
	 * @param thisBlock
	 * @return
	 */
	public static boolean hitsOther(Block thisBlock) {
		boolean collision = false;
		for (Block otherBlock: blocks) {
			if (thisBlock != otherBlock) {
				if ((thisBlock.getYPosition() + 20 == otherBlock.getYPosition())
						&& thisBlock.getXPosition() == otherBlock.getXPosition()) {
					collision = true;
				}
			}
		}
		return collision;
	}
	
	public static Block nextBlock() {
		Block block = new Block(randomColumn(), 20, randomColor(),
				300, myCanvas);
		block.draw();
		return block;
	}
	
	public static int randomColumn() {
		Random rnd = new Random();
		int i = rnd.nextInt(3);
		if (i == 0) {
			return 40;
		}
		else if (i == 1) {
			return 60;
		}
		else {
			return 80;
		}
	}
	
	public static Color randomColor() {
		Random rnd = new Random();
		return new Color(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
	}
	
	public static void main(String[] args) {
		myCanvas = new Canvas("Tetris", 140, 320);

		// move down
		for (int i = 0; i < 1000; i++) {
			Block block = nextBlock();
			blocks.add(block);
			while(block.moving()) {
				myCanvas.wait(150);           // small delay
				
				if (! hitsOther(block) && ! (block.getYPosition() >= myCanvas.getGroundPosition()) ) {
					block.moveDown();	
				}
				else {
					// stop once a block has hit the ground or another block
					block.setMoving(false);
				}

			}
		}
	}

}
