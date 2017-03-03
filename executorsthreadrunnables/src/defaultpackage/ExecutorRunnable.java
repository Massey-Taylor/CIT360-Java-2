package defaultpackage;

public class ExecutorRunnable implements Runnable {

    private String ThreadNumber;

    public ExecutorRunnable(String ThreadNumber) {
        this.ThreadNumber = ThreadNumber;
    }

    @Override
    public void run() {
        System.out.println("The Thread name is as follows: " + Thread.currentThread().getName() + ", Thread number = " + ThreadNumber);
        getID();
    }

    private void getID() {
        try {
            Thread.sleep(500);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
