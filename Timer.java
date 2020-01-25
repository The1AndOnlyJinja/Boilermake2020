import java.util.*;

public class Timer {
    long start_time;
    long end_time;
    long length;
    Calendar cal = Calendar.getInstance();
    public Timer() {
      start_time = 0;
      end_time = 0;
      length = 0;
    }
    public void start() {
      cal = Calendar.getInstance();
      this.start_time = cal.getTimeInMillis();
    }
    public void end() {
      cal = Calendar.getInstance();
      this.end_time = cal.getTimeInMillis();
      this.length = end_time - start_time;
    }
    public long get_time() {
      cal = Calendar.getInstance();
      return cal.getTimeInMillis() - this.start_time;
    }
    public static void main(String args[]) {
      Timer tim = new Timer();
      tim.start();
      Scanner s = new Scanner(System.in);
      String whatever = s.next();
      tim.end();
      System.out.printf("length: " + tim.length + "\n");
    }
}
