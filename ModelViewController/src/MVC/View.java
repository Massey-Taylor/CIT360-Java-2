package MVC;

public class View {

    public View(Model model) {
        print1();
    }

    public void print1() {
        System.out.print("Tell me.  How many slaps on the face should I give to the person sitting next to you? \nType \"exit\" if you want to give them a kiss.\n");
    }

    public void print2() {
        System.out.print("Tell me once more!  How many slaps on the face should I give to the person sitting next to you? \nType \"exit\" if you would rather give them a cookie.\n");
    }

    public void printNum(int num) {
        System.out.println(num + " slaps have been given." + "\n");
    }

}
