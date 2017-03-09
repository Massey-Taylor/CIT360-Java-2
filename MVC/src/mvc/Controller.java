package mvc;

public class Controller {

    public Controller(View view, Model model) {

        model.isPal(view.getUserString());

        if(model.isPalindrome()){
            view.isPalindrome();
        }else{
            view.notPalindrome();
        }

    }

}
