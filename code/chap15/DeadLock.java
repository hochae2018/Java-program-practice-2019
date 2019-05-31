
package chap15;

/**
 * DeadLock
 */
public class DeadLock {

    public static Object foo = new Object();
    public static Object bar = new Object();
    
    public static void main(String args[]) {
        ThreadDemo1 T1 = new ThreadDemo1();
        ThreadDemo2 T2 = new ThreadDemo2();
        T1.start();
        T2.start();
    }
    
    private static class ThreadDemo1 extends Thread {
        public void run() {
            synchronized (foo) {
                System.out.println("Thread 1: Holding foo ...");
                
                try { 
                    Thread.sleep(10); 
                } catch (InterruptedException e) {}
                System.out.println("Thread 1: Waiting for bar ...");
                
                synchronized (bar) {
                    System.out.println("Thread 1: Holding foo & bar ...");
                }
            }
        }
    }
    private static class ThreadDemo2 extends Thread {
        public void run() {
            synchronized (bar) {
                System.out.println("Thread 2: Holding bar ...");
                
                try { 
                    Thread.sleep(10); 
                } catch (InterruptedException e) {}                
                System.out.println("Thread 2: Waiting for foo ...");
                
                synchronized (foo) {
                    System.out.println("Thread 2: Holding foo & bar ...");
                }
            }
        }
    } 
}
 