/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ganesan
 */
public class AlarmClock {

    private final Scheduler scheduler = new Scheduler();
    private final SimpleDateFormat dateFormat =
            new SimpleDateFormat("dd MMM yyyy HH:mm:ss.SSS");
    private final int hourOfDay,  minute,  second;

    public AlarmClock(int hourOfDay, int minute, int second) {
        this.hourOfDay = hourOfDay;
        this.minute = minute;
        this.second = second;
    }

    public void start() {
        scheduler.schedule(new SchedulerTask() {

            public void run() {
                soundAlarm();
           }
            private void soundAlarm() {
                System.out.println("Wake up! " +
                        "It's " + dateFormat.format(new Date()));
            // Start a new thread to sound an alarm...
            }
        }, new DailyIterator(hourOfDay, minute, second));
    }




    
    public static void main(String[] args) {
        AlarmClock alarmClock = new AlarmClock(11, 12, 0);
        alarmClock.start();
    }
}

