package defaultpackage;

public class Cow implements Handler {
 @Override
 public void execute(int animalNumber) {
     System.out.println("The cow goes 'MOOOOOOOOOOO!!'.");
 }
}
