package projectTetris;

import java.util.Random;

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

	public class RunTetris extends Application {
		int block = 40;
		int width = block*10;
		int height = block*20;
		
		int x = 0;
		int y = 0;
		
		//creating the canvas
		Canvas canvas = new Canvas(width, height);
		//getting graphics of the canvas aka getting shapes
		GraphicsContext gc = canvas.getGraphicsContext2D();
		Random random = new Random();
		//creating block object
		Blocks tetromino = new Blocks();
		
		@Override
		public void start(Stage stage) {
			

			//Create the Pane
			Pane root = new Pane();

			//add canvas
			root.getChildren().add(canvas);
			
			final long startNanoTime = System.nanoTime();
			
			//animation tool
			new AnimationTimer() {
				
				public void handle(long currentNanoTime) {
					double t = (currentNanoTime - startNanoTime)/100000000;
					x = width/2;
					y = (int)(t*block);
					//int i = 0;
					gc.setFill(Color.WHITE);
					gc.fillRect(0, 0, width, height);
					
					getGrid();
					//gc.drawImage(image, x, y);
					
					//tetromino.getTetromino(x, y);
					getO(width/2, height/2);

				}
			}.start();
			
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("testing");
			stage.show();
		}

		//Creation of Grid
		public void getGrid() {
			for(int i = 0; i <= height; i += block)
				gc.strokeLine(0, 0+i, width, 0+i);
			for(int i = 0; i <= width; i += block)
				gc.strokeLine(0+i, 0, 0+i, height);
		}
		
		public void getO(int x, int y) {
			gc.setFill(Color.YELLOW);
			getBlock(x-block, y-block);
			getBlock(x, y-block);
			getBlock(x-block, y);
			getBlock(x, y);
		}
		
		public void getBlock(int x, int y){
			gc.fillRect(x, y, block, block);
			gc.strokeRect(x+5, y+5, block-10, block-10);
			gc.strokeRect(x, y, block, block);
		}

	    //launch
		public static void main(String[] args) {
			launch(args);
		}
	}
