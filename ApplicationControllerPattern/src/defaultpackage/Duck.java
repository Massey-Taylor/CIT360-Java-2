package defaultpackage;

public class Duck implements Handler{
	 @Override
	 public void execute(int animalNumber) {
	     System.out.println("The duck says 'quack quack.'.");
	 }
}
