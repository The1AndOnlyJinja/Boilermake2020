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
        //remove filler word from the lists
        int timeIndex = this.fillerTime.indexOf(wordTime);
        if (timeIndex == -1) {
            system.out.print("No filler word at the specified time.\n");
            return;
        } else {
            this.fillerWords.remove(timeIndex);
            this.fillerTime.remove(timeIndex);
            system.out.printf("Filler word at time " + wordTime + " removed.\n");
            return;
        }
    }
    
    public long getTimeAtIndex (int index) {
        //get the specified time at the index
        if (index >= this.fillerTime.size() || index < 0) {
            system.out.print("Index is not within list bounds.\n");
            return -1;
        } else {
            return this.fillerTime.get(index);
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
