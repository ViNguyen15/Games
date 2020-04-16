package janken;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import java.util.Random;

/**
 * 
 * @author FluffyWin
 * 
 * Rock Paper Scissor game made in GUI using JavaFX
 *
 */
public class GUIjanken extends Application {
	Random random = new Random();
	GridPane gp = new GridPane();
	BorderPane bp = new BorderPane();
	HBox xAxis = new HBox();
	Label cpuLB = new Label("Computer");
	Label playerLB = new Label("Player");
	Button rBtn = new Button("Rock");
	Button pBtn = new Button("Paper");
	Button sBtn = new Button("Scissor");
	TextField winTF = new TextField("Ready to play?");
	TextField cpuTF = new TextField("Computer uses");
	Scene scene;
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("Janken");
		
		//Button Action
		rBtn.setOnAction(e->rock());
		pBtn.setOnAction(e->paper());
		sBtn.setOnAction(e->scissor());
		
		//column size
        ColumnConstraints c1 = new ColumnConstraints();
        c1.setPercentWidth(33);
        ColumnConstraints c2 = new ColumnConstraints();
        c2.setPercentWidth(33);
        ColumnConstraints c3 = new ColumnConstraints();
        c3.setPercentWidth(33);
        gp.getColumnConstraints().addAll(c1,c2,c3);
        
        //row size
        RowConstraints r1 = new RowConstraints();
        r1.setPercentHeight(20);
        RowConstraints r2 = new RowConstraints();
        r2.setPercentHeight(20);
        RowConstraints r3 = new RowConstraints();
        r3.setPercentHeight(20);
        RowConstraints r4 = new RowConstraints();
        r4.setPercentHeight(20);
        RowConstraints r5 = new RowConstraints();
        r5.setPercentHeight(20);
        gp.getRowConstraints().addAll(r1,r2,r3,r4,r5);
		
		//adding things into grid (whats added, which column, which row, width, height)
		gp.add(cpuLB, 1, 0, 3, 1);
		gp.add(cpuTF, 0, 1, 3, 1);
		gp.add(winTF, 0, 2, 3, 1);
		gp.add(rBtn, 0, 3, 1, 1);
		gp.add(pBtn, 1, 3, 1, 1);
		gp.add(sBtn, 2, 3, 1, 1);
		gp.add(playerLB, 1, 4, 3, 1);

		//giving gaps
		gp.setHgap(10);
		gp.setVgap(10);
		
		//setting up the layout and showing it
		scene = new Scene(gp, 400, 300);
		stage.setScene(scene);
		stage.show();
	}
	
	//methods for janken
	void rock() {getJudge("rock");}
	void paper() {getJudge("paper");}
	void scissor() {getJudge("scissor");}
	
	//determining factor for results
	void getJudge(String choice) {
		String cpu = getComputer();
		if(choice.equals(cpu)) {
			winTF.setText("It's a Draw");
			cpuTF.setText("Computer uses " + cpu);
	}else if(choice.equals("rock")&& cpu.equals("paper") ||
		    choice.equals("paper")&& cpu.equals("scissor")||
		    choice.equals("scissor")&& cpu.equals("rock")) {
			winTF.setText("You Lost!");
			cpuTF.setText("Computer uses " + cpu);
		}else {
			winTF.setText("You Won!");
			cpuTF.setText("Computer uses " + cpu);
		}
	}
	
	//determining results for cpu
	String getComputer() {
		String cpuMove = "";
		int cpu = random.nextInt(3);
		
		if(cpu == 0)
			cpuMove = "rock";
		if(cpu == 1)
			cpuMove = "paper";
		if(cpu == 2)
			cpuMove = "scissor";
		
		return cpuMove;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}