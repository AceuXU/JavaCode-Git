public class MyThread  extends  Thread{
    public void run() {
        if (this.isDaemon()) {
            System.out.println("this thread is running");
        } else {
            System.out.println("this is a user thread that is running");

        }
    }
    }

