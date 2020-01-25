import javax.sound.sampled.*;
import java.io.*;
 
/**
 * A sample program is to demonstrate how to record sound in Java
 * author: www.codejava.net
 */
public class JavaSoundRecorder {
    // record duration, in milliseconds
    static final long RECORD_TIME = 30000;  // 1/2 minute
 
    // path of the wav file
    String file_path = "noise/"; //Textbox input + /
    File wavFile = new File(file_path);
    boolean recording = false;
 
    // format of audio file
    AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE;
 
    // the line from which audio data is captured
    TargetDataLine line;
     JavaSoundRecorder(String file_name) {
        this.wavFile = new File(file_name);
        if (wavFile.exists()) {
            //Ask if they want to override
        }
     }
     JavaSoundRecorder() {
        //
     }
 
    /**
     * Defines an audio format
     */
    AudioFormat getAudioFormat() {
        float sampleRate = 16000;
        int sampleSizeInBits = 8;
        int channels = 2;
        boolean signed = true;
        boolean bigEndian = true;
        AudioFormat format = new AudioFormat(sampleRate, sampleSizeInBits,
                                             channels, signed, bigEndian);
        return format;
    }
 
    /**
     * Captures the sound and record into a WAV file
     */
    void start() {
        try {
            AudioFormat format = getAudioFormat();
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
 
            // checks if system supports the data line
            if (!AudioSystem.isLineSupported(info)) {
                System.out.println("Line not supported");
                System.exit(0);
            }
            line = (TargetDataLine) AudioSystem.getLine(info);
            line.open(format);
            line.start();   // start capturing
 
            System.out.println("Start capturing...");
 
            AudioInputStream ais = new AudioInputStream(line);
 
            System.out.println("Start recording...");
 
            // start recording
            AudioSystem.write(ais, fileType, wavFile);
 
        } catch (LineUnavailableException ex) {
            ex.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
 
    /**
     * Closes the target data line to finish capturing and recording
     */
    void finish() {
        line.stop();
        line.close();
        System.out.println("Finished");
    }
    boolean get_state() {
      System.out.println("Checking state");
      return this.recording;
    }
 
    /**
     * Entry to run the program
     */
    public void record() {
//        final JavaSoundRecorder recorder = new JavaSoundRecorder();
 
        // creates a new thread that waits for a specified
        // of time before stopping
        recording = true;
        Thread stopper = new Thread(new Runnable() {
            public void run() {
            while (get_state()) {
                try {
                    Thread.sleep(500);
                    System.out.println("Still going\n");
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
              finish();
          }
        });
 
        stopper.start();
 
        // start recording
        this.start();
    }
    public void stop_record() {
      this.recording = false;
    }
}
