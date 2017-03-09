package mvc;

public class Model {

    boolean isPalindrome;

    public Model(){

    }

    public void isPal(String pal){
        isPalindrome = pal.equals(new StringBuilder(pal).reverse().toString());
    }

    public boolean isPalindrome() {
        return isPalindrome;
    }

}
