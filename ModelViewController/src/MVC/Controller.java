package MVC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {

    private Model model;
    private View view;

    public Controller (Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String exit = reader.readLine().toLowerCase();
            if (exit.equals("exit")) {
                break;
            }
            int num = Integer.parseInt(exit);
            int number = num;
  
            number = model.Slaps();
            view.printNum(num);
            view.print2();
        }
    }

}
