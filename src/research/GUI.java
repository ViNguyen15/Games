package research;

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

	public class GUI extends Application {
		int block = 40;
		int width = block*10;
		int height = block*20;
		
		int[] list = new int[100];
		int moveLeft, moveRight;
		int x = width/2;
		int y = 0;
		
		//creating the canvas
		Canvas canvas = new Canvas(width, height);
		//geting graphics of the canvas aka getting shapes
		GraphicsContext gc = canvas.getGraphicsContext2D();
		Random random = new Random();
		
		@Override
		public void start(Stage stage) {
			
			for(int i = 0; i< list.length; i++) {
				list[i]= random.nextInt(7);
			}
			//Create the Pane
			Pane root = new Pane();

			//add canvas
			root.getChildren().add(canvas);
			
			final long startNanoTime = System.nanoTime();
			
			//animation tool
			new AnimationTimer() {
				
				public void handle(long currentNanoTime) {
					double t = (currentNanoTime - startNanoTime)/100000000;
					x=x;
					y = (int)(t*block);
					int i = 0;
					gc.setFill(Color.WHITE);
					gc.fillRect(0, 0, width, height);
					
					getGrid();
					//gc.drawImage(image, x, y);
					
					getTetromino(i,x,y);
					//stopping when hitting the ground
					while (y >= height) {
						y -= height;
						getTetromino(list[++i], x, y);
					}
					
					// register event handlers to Canvas
					canvas.setFocusTraversable(true);
					canvas.setOnKeyPressed(keyPressed);
					canvas.setOnKeyReleased(keyReleased);
					//System.out.println(y);
					//System.out.println(++i);
				}
			}.start();
			
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("testing");
			stage.show();
		}
		public int[] getRandomList() {
			int num = random.nextInt(7);
			int[] list = new int[100000];
			for(int i = 0; i < list.length; i++)
				list[i] = num;
			return list;
		}
		
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
		
		public void getTetromino(int num, int x, int y) {
			switch(num) {
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
		//key pressed		
	    private EventHandler<KeyEvent> keyPressed = new EventHandler<KeyEvent>() {
	        @Override
	        public void handle(KeyEvent event) {
	            // start movement according to key pressed
	            switch (event.getCode()) {
	            
	                case LEFT:
	                    moveLeft = -block;
	                    System.out.println("left");
	                    //test of movement
	                    x -= block;
	                    break;
	                    
	                case RIGHT:
	                    moveRight = block;
	                    System.out.println("right");
	                    //test of movement
	                    if(x>=width-block)
	                    	x=width-block;
	                    	else
	                    x += block;
	                    break;
	                    
	                default:
	                	System.out.println("testing");
	                	break;
	            }
	        }
	    };
	    //key released
	    private EventHandler<KeyEvent> keyReleased = new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent event) {
            // start movement according to key pressed
            switch (event.getCode()) {
                case LEFT:
                    moveLeft = 0;
                    System.out.println("notLeft");
                    break;
                case RIGHT:
                    moveRight = 0;
                    System.out.println("notRight");
                    break;
                default:
                	System.out.println("testing");
                	break;
            }
        }
    };
	    
		public static void main(String[] args) {
			launch(args);
		}
	}
