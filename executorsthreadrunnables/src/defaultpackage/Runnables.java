package defaultpackage;


public class Runnables implements Runnable {

    // Creates 2 Objects
    public static Object first = new Object();
    public static Object second = new Object();

    private String name;

    public Runnables(String name) {
        this.name = name;
    }

    @Override
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
                System.out.println(this.name + " is not very cool!");
            }
        }

        synchronized (second) {
            System.out.println(this.name + " is not very cool!");

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
        Runnables printer1 = new Runnables("Taylor");
        Thread thread1 = new Thread(printer1);
        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Runnables printer2 = new Runnables("Preston");
        Thread thread2 = new Thread(printer2);
        thread2.start();
    }

}