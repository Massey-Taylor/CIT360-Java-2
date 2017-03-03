package defaultpackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AppController {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        AnimalNoiseController noiseController = new AnimalNoiseController();

        try {
            System.out.println("Welcome to the portal of animal noises!");
            System.out.println("Animals make some weird noises.  Which one do you want to sound out?");
            System.out.println("1 for cow, 2 for duck and 3 for a majestic platypus.");

            int animalNumber = Integer.parseInt(read.readLine());
            noiseController.put(animalNumber);
        }
        catch (Exception e){
            System.out.println("Type in 1, 2 or 3...  NOW!!");
            int animalNumber = Integer.parseInt(read.readLine());
            noiseController.put(animalNumber);
        }
    }
}
