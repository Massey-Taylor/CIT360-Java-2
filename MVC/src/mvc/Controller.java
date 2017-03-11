package mvc;

public class Controller {

    public Controller(View view, Model model) {

        model.isPal(view.getInputUser());

        if(model.isPal()){
            view.isPal();
        }else{
            view.notPal();
        }

    }

}
