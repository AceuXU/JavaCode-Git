import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class timer {
    public static void main(String[] args) {


        // timer  = A facility for threads to schedule tasks for future execution in a background thread.
        // TimerTask = A task that can be scheduled for one-time or repeated execution by a timer.

        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            int counter = 10;
            @Override
            public void run() {
                if (counter > 0){
                    System.out.println(counter + " Seconds " );
                    counter--;
                } else {
                    System.out.println("Happy new year");
                    timer.cancel();
                }

//                System.out.println("Task is complete");

            }

        };

        Calendar date = Calendar.getInstance();
        date.set(Calendar.YEAR, 2023);
        date.set(Calendar.MONTH,Calendar.JULY);
        date.set(Calendar.DAY_OF_MONTH, 23);
        date.set(Calendar.HOUR_OF_DAY, 19);
        date.set(Calendar.MINUTE, 34);
        date.set(Calendar.SECOND, 50);
        date.set(Calendar.MILLISECOND,0);

//        timer.schedule(task, 0);
//        timer.schedule(task, date.getTime());
//        timer.scheduleAtFixedRate(task, 0, 1000); // to get result immediately
        timer.scheduleAtFixedRate(task, date.getTime(), 1000); // to get output at specific time


    }
}
