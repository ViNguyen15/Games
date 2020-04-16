package projectTetris;

import java.util.Random;
// fx imports
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;



public class Blocks {
	//setting random
	Random random = new Random();
	int rand = 0;
	public static int block = 40;
	int width = block*10;
	int height = block*20;
	
	//getting Tetris block
	public void getTetromino(int x, int y) {
		rand = random.nextInt(7);
		System.out.println(rand);
		switch(rand) {
		case 0:
			getO(x,y);
			break;
		case 1:
			getI(x,y);
			break;
		case 2:
			getL(x,y);
			break;
		case 3:
			getJ(x,y);
			break;
		case 4:
			getS(x,y);
			break;
		case 5:
			getZ(x,y);
			break;
		case 6:
			getT(x,y);
			break;
		default:
			getBlock(x,y);
			break;
		}
	}
	
	//creating the canvas
	Canvas canvas = new Canvas(width, height);
	//getting graphics of the canvas aka getting shapes
	GraphicsContext gc = canvas.getGraphicsContext2D();
	
	public void getO(int x, int y) {
		gc.setFill(Color.YELLOW);
		getBlock(x-block, y-block);
		getBlock(x, y-block);
		getBlock(x-block, y);
		getBlock(x, y);
	}
	
	public void getI(int x, int y) {
		gc.setFill(Color.CYAN);
		getBlock(x, y-block*3);
		getBlock(x, y-block*2);
		getBlock(x, y-block);
		getBlock(x, y);
	}
	
	public void getL(int x, int y) {
		gc.setFill(Color.ORANGE);
		getBlock(x, y-block*2);
		getBlock(x, y-block);
		getBlock(x+block, y);
		getBlock(x, y);
	}
	
	public void getJ(int x, int y) {
		gc.setFill(Color.BLUE);
		getBlock(x, y-block*2);
		getBlock(x, y-block);
		getBlock(x-block, y);
		getBlock(x, y);
	}
	
	public void getS(int x, int y) {
		gc.setFill(Color.YELLOWGREEN);
		getBlock(x+block, y-block);
		getBlock(x,y-block);
		getBlock(x-block,y);
		getBlock(x,y);
	}
	
	public void getZ(int x, int y) {
		gc.setFill(Color.ORANGERED);
		getBlock(x-block,y-block);
		getBlock(x,y-block);
		getBlock(x+block,y);
		getBlock(x,y);
	}
	
	public void getT(int x, int y) {
		gc.setFill(Color.DARKVIOLET);
		getBlock(x,y-block);
		getBlock(x-block,y);
		getBlock(x+block,y);
		getBlock(x,y);
	}
	
	public void getBlock(int x, int y){
		gc.fillRect(x, y, block, block);
		gc.strokeRect(x+5, y+5, block-10, block-10);
		gc.strokeRect(x, y, block, block);
	}
	
	
	
}
