package defaultpackage;

import java.util.*;

public class Sets {
	
	public static void main(String[] args){
	
		HashSet numbers = new HashSet();
			numbers.add("1");
			numbers.add("2");
			numbers.add("4");
			numbers.add("3");
			numbers.add("5");
			numbers.add("6");
			System.out.println(numbers);
			
			System.out.println(numbers.contains("1"));
			
		LinkedHashSet lastName = new LinkedHashSet();
			lastName.add("M");
			lastName.add("A");
			lastName.add("S");
			lastName.add("S");
			lastName.add("E");
			lastName.add("Y");
			System.out.println(lastName);
			
		lastName.remove("Y");
		System.out.println(lastName);
		
		Iterator iterator = lastName.iterator();
		while(iterator.hasNext()){
			String name = (String) iterator.next();
			System.out.println(name);
		}
		
		TreeSet myTree = new TreeSet(numbers);
		System.out.println(myTree);
		
	}
	

}

