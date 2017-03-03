package defaultpackage;

import java.util.HashMap;

public class AnimalNoiseController {
    public static HashMap<Integer, Handler> noises = new HashMap<Integer, Handler>();

    public static void put(int animalNumber){
    	noises.put(1, new Cow());
    	noises.put(2, new Duck());
    	noises.put(3, new Platypus());

        Handler handler = noises.get(animalNumber);
        handler.execute(animalNumber);
    }
}
