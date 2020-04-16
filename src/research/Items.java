package research;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Items {

	public static void main(String[] args) {
		Items i = new Items();
		Scanner input = new Scanner(System.in);
		List<String> list = new ArrayList<>();
		
		
		String battleCry = "ladle";
		System.out.println(i.items(battleCry));
		
		while(input.hasNext()) {
			System.out.println("Enter something");
			String words = input.nextLine();
			
			if(words.equals("break"))
				break;
			list.add(words);
		}
		
		System.out.println("here is the list that you entered");
		for(String elements:list)
			System.out.println(elements);
		
	}
	
	public String items(String... items) {
		if(items.length==0)
			return "";
		
		return items[0];
	}
}
