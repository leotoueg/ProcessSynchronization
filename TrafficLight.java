public class TrafficLight extends Thread{

  public static Semaphore eastbound = new Semaphore(0,true);
  public static Semaphore westbound = new Semaphore(0,true);

  private static int T = 200;
  private static int Q = 100;
  public void run(){
    for (int c = 0; c<10;c++){ // 10 traffic light cycles

      // eastbound turns green for time T
      Synch.timeSim.threadStart();
      eastbound.release(); // make the light green
      System.out.println("TRAFFIC LIGHT: Eastbound is Green! \n" ) ;
      Synch.mutex.release();
      Synch.timeSim.doSleep(T);
      eastbound.acquire(); // make the light red
      System.out.println("TRAFFIC LIGHT: Red stop!  \n");
      Synch.mutex.release();
      Synch.timeSim.doSleep(Q); // traffic light turn red for time Q
      Synch.timeSim.threadEnd();

      // westbound turns green for time T
      Synch.timeSim.threadStart();
      westbound.release(); // make the light green
      System.out.println("TRAFFIC LIGHT: Westbound is Green!  \n");
      Synch.mutex.release();
      Synch.timeSim.doSleep(T);
      westbound.acquire(); // make the light red
      System.out.println("TRAFFIC LIGHT: Red stop!  \n");
      Synch.mutex.release();
      Synch.timeSim.doSleep(Q); // traffic light turn red for time Q
      Synch.timeSim.threadEnd();
    }
  }
}
