package chap15;

public class MyRunnable implements Runnable
{
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("top o' the stack: 1");
    }
    
    public static void main(String[] args)
    {
        Runnable threadJob = new MyRunnable();
        Thread myThread = new Thread(threadJob);
        myThread.start();
        System.out.println("back in main");
    }
}