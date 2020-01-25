
public class Soundtest {
    public void test() {
        JavaSoundRecorder hymns = new JavaSoundRecorder();
        EhhsistantGUI youseeat = new EhhsistantGUI();
        Thread try_this = new Thread(new Runnable() {
            public void run() {
              for (int i = 0; i < 100; i++) {
                  System.out.println("soundtest still going\n");
                  try {
                    Thread.sleep(100);
                  }
                  catch (Exception e) {

                  }
               }
               System.out.println("gonna stop now");
               hymns.stop_record();
             }
           });
     try_this.start();
     hymns.record();
     }

    public static void main(String args[]) {
      Soundtest lets_get_it = new Soundtest();
      lets_get_it.test();
    }
}
