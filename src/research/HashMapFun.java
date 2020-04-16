package research;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
public class HashMapFun {
	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		Scanner input = new Scanner(System.in);
		Random random = new Random();
		
		System.out.println("Lets play Rock Paper Scissor\n"
				+ "0 is rock\n"
				+ "1 is paper\n"
				+ "2 is scissor");
		map.put(0, "rock");
		map.put(1, "paper");
		map.put(2, "scissor");

		int player = input.nextInt();
		int cpu = random.nextInt(3);
		
		System.out.println(map.get(player));
		System.out.println(map.get(cpu));
		System.out.println("You " + getResults(player, cpu));
		
	}
	
	public static String getResults(int player, int cpu) {
		if(player == cpu)
			return "Drew";
		else if(player==0&&cpu==1||
				player==2&&cpu==0||
				player==1&&cpu==2)
			return "Lose";
		else
			return "Win";
	}
}
