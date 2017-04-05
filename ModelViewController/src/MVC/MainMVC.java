package MVC;

import java.io.IOException;

public class MainMVC {

    public static void main(String[] args) throws IOException {
        Model model = new Model();
        View view = new View(model);
        new Controller(model, view).run();

       
    }

}