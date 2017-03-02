package defaultpackage;

import java.util.*;

public class arrayList {
	
	public static void main(String[] args) {
		
	List<String> myTeam = new ArrayList<>();
	/* can contain duplicate elements */
	
	myTeam.add("Preston");
	myTeam.add("Taylor");
	myTeam.add("Tyler");
	myTeam.add("Joel");
	myTeam.add("Jesus Christ");
	myTeam.add("Holy Ghost");
	myTeam.add("Steve");
	myTeam.add("Steve");
	
	System.out.println("\nTeam 5: ");
	
	for(int i = 0; i < myTeam.size(); i++) {
		System.out.println(myTeam.get(i));
	}
	
	myTeam.remove("Steve");
	System.out.println("\nTeam 5: ");
	
	for(int i = 0; i < myTeam.size(); i++) {
		System.out.println(myTeam.get(i));
	}
	
	myTeam.remove("Steve");
	myTeam.add("Heavenly Father");
	System.out.println("\nTeam 5: ");
	
	for(int i = 0; i < myTeam.size(); i++) {
		System.out.println(myTeam.get(i));
	}
	
	}
	
}