import java.util.*;

public class FillerStats {

    LinkedList<String> fillerWords;
    LinkedList<long> fillerTime;

    public FillerStats() {
        fillerWords = new LinkedList<String>();
        fillerTime = new LinkedList<String>();
    }
    
    public void fillerSaid (String word, long time) {
        //call when the filler word was said
        this.fillerWords.add(word);
        this.fillerTime.add(time);
    }
    
    public void removeFiller (long wordTime) {
        int timeIndex = this.fillerTime.indexOf(wordTime);
        if (timeIndex == -1) {
            system.out.print("No filler word at the specified time.");
            return;
        } else {
            this.fillerWords.remove(timeIndex);
            this.fillerTime.remove(timeIndex);
            system.out.printf("Filler word at time " + wordTime + " removed.");
            return;
        }
    }
    
    public void printFillers() {
        //call after a recording session is done
        
        String firstWord = this.fillerWords.peekFirst();
        if (firstWord == NULL) {
            system.out.print("Good job! No filler words were said.\n");
            return;
        } else {
            int counter = 0;
            while (firstWord != NULL) {
                counter++;
                String saidF = this.fillerWords.removeFirst();
                long timeSaid = this.fillerTime.removeFirst();
                
                system.out.printf("You said " + saidF + " at time " + timeSaid + ".\n");
                firstWord = this.fillerWords.peekFirst();
            }
            if (counter == 1) {
                system.out.print("That's a total of 1 filler word, so close...\n");
            } else {
                system.out.printf("That's a total of " + counter + " filler words...\n");
            }
            return;
        }
    }
}
