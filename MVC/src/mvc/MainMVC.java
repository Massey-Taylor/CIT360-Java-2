package mvc;

import mvc.Controller;

public class MainMVC {

    public static void main(String[] args) {
        View view = new View();
        Model model = new Model();

        Controller myController = new Controller(view, model);
    }
}

