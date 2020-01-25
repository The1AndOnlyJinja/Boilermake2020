import javax.sound.sampled.*;
import java.io.*;
.
/**
 * A sample program is to demonstrate how to record sound in Java
 * author: www.codejava.net
 */
public class JavaSoundRecorder {
    // record duration, in milliseconds
    static final long RECORD_TIME = 30000;  // 1/2 minute
.
    // path of the wav file
    String file_path = "noise/"; //Textbox input + /
    File wavFile = new File(file_path);
    boolean recording = false;
.
    // format of audio file
    AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE;
.
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
.
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
:set nonumber                                                 1,7           Top
