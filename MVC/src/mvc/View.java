package mvc;

import java.util.Scanner;

public class View {
    Scanner input = new Scanner(System.in);
    String inputUser;

    public View() {
        System.out.println("Enter in a word to check to see if it's a Palindrome.");
        inputUser = input.nextLine();
    }

    public String getInputUser() {
        return inputUser;
    }


    public void isPal(){
        System.out.println("mmhmmm. You entered in a Palindrome.");
    }

    public void notPal(){
        System.out.println("Nooooooope. You have not entered in a Palindrome.");
    }

}
