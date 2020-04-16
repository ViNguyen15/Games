package research;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Keyboard extends Application {

	@Override
	public void start(Stage stage) {
	Canvas canvas = new Canvas(400,400);
	GraphicsContext gc = canvas.getGraphicsContext2D();
	
	gc.fillRect(100, 100, 200, 200);
	
	Pane root = new Pane();
	Scene scene = new Scene(root);
	root.getChildren().add(canvas);
	stage.setScene(scene);
	stage.setTitle("testing");
	stage.show();
	}
	
	
	public static void main(String[] args) {
		Game game = new Game();
		game.getClass();
		launch(args);
	}
	
	
    private EventHandler<KeyEvent> keyPressed = new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent event) {
            // start movement according to key pressed
            switch (event.getCode()) {
                case LEFT:
                    System.out.println("left");
                    break;
                case RIGHT:
                    System.out.println("right");
                    break;
                default:
                	System.out.println("testing");
                	break;
            }
        }
    };
}
