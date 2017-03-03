package defaultpackage;

public class Threads extends Thread {

    public static Object first = new Object();
    public static Object second = new Object();

    private String name;

    public Threads(String name) {
        this.name = name;
    }

    public void run() {

        synchronized (first) {
            System.out.println(this.name + " is awesome!");

            try{
                Thread.sleep(500);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }

            synchronized (second) {
                System.out.println(this.name + " is not very cool.");
            }
        }

        synchronized (second) {
            System.out.println(this.name+ " is not very cool.");

            try{
                Thread.sleep(500);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }

            synchronized (first) {
                System.out.println(this.name + " is awesome!");
            }
        }

    }

    public static void main(String[] args) {
        Threads printer1 = new Threads("Taylor");
        printer1.start();
        try {
            printer1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Threads printer2 = new Threads("Preston");
        printer2.start();

    }

}
