import java.util.ArrayList;
import java.util.Collections;

import com.sun.media.jfxmedia.logging.Logger;

import com.sun.javafx.binding.StringFormatter;

/**
 * Created by venifonua on 8/23/17.
 */
public class CharacterMemory {

  public static void main(String[] args){

    ArrayList<String> arrayList = new ArrayList<String>();
    String letterA = "A";
    int count = 0;
    boolean isRunning = true;
    while(isRunning) {
      try {
        count ++;
        arrayList.add(letterA);
      }
      catch (OutOfMemoryError e) {
        isRunning = false;
        System.out.println(count);
        System.out.println(String.format("Run out of memory at count=%s message=%s, eString=%s", Integer.toString(count), e.getMessage(), e.toString()));

      }
    }
  }
}
