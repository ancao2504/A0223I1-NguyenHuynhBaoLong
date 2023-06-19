package ss4_OOP.Bai_tap;

import java.util.Date;


public class StopWatch {
    Date startTime ;
    Date endTime ;
    public StopWatch() {
    }

    public void start () {
         this.startTime = new Date();
    }
    public void end () {
         this.endTime = new Date();
    }
    public long getElapsedTime() {
        long elapsedMilliseconds = endTime.getTime() - startTime.getTime();
        return elapsedMilliseconds;
    }
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i <=100000; i++) {
            if (i % 100000==1 ) {
                stopWatch.end();
                break;
            }
        }
        System.out.println( stopWatch.getElapsedTime());
    }

}
