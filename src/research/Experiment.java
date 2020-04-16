package research;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Experiment {

	public static void main(String[] args) {

		int num = 1234;
		int[] numList = {1,2,3,4,5};
		
		List<Integer> number = new ArrayList<>();
		number.add(15);
		number.add(42);
		number.add(100);
		number.add(2);
		number.add(5);
		
		System.out.println(number);
		
		number.forEach(x -> System.out.print((x*=x)+" "));
		
		int[] numArray = Integer.toString(num).chars().map(c -> c ).toArray();
		System.out.println();
		
		seeArray(numArray);
		foreach(number);
		
		Arrays.stream(numList).map(n -> n - n).forEach(n -> System.out.print(n + " " ));
		
	}
	
	public static void foreach(List<Integer> list) {
		for(int i = 0; i < list.size(); i++) {
			list.get(i);
			//list.set(i, element);
		}
		System.out.println("\n"+ list);
	}
		
		public static void seeArray(int[] num) {
			for(int element : num)
				System.out.print(element + " ");
		}

}
