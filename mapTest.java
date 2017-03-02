package defaultpackage;

import java.util.*;

public class mapTest {
	
	public static void main(String[] args){
		
		Map myGames = new LinkedHashMap();
		myGames.put("Final Fantasy X", " 6");
		myGames.put("Brigandine", " 2");
		myGames.put("Azure Dreams", " 3");
		myGames.put("Vandal Hearts", " 4");
		myGames.put("Crash Bandicoot", " 9");
		
		System.out.println(myGames);
		
		myGames.remove("Crash Bandicoot");
		System.out.println(myGames);
		myGames.put("The Last of Us", " 16");
		myGames.put("Final Fantasy X", " 3");
		
		System.out.println(myGames);
	}

}
