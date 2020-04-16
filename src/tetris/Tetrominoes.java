package tetris;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Tetrominoes{
	
	public static int block = 40;
	int width = block*10;
	int height = block*20;
	
	//creating the canvas
	Canvas canvas = new Canvas(width, height);
	//geting graphics of the canvas aka getting shapes
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
