import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {

  public static void main(String[] args) throws FileNotFoundException {

    for (int i = 0; i <= 7; i++) {
      System.out.println(DaysOfWeek.FRIDAY);
    }
    BufferedReader bufferedReader = new BufferedReader(new FileReader("src/lorem.txt"));
    List<String> stringList = new ArrayList<String>();

    try {
      String line = bufferedReader.readLine();

      while (line != null && (!line.isEmpty())) {
        StringBuilder sbLine = new StringBuilder().append(line).append(System.getProperty("line.separator"));
        stringList.add(sbLine.toString());
        line = bufferedReader.readLine();
      }

      bufferedReader.close();
      Collections.sort(stringList, String.CASE_INSENSITIVE_ORDER);
      Collections.reverse(stringList);
      writeFileOut(stringList);
    }
    catch (IOException e) {
      e.printStackTrace();
    }

    System.out.println("Well done!");
  }

  private static void writeFileOut(List<String> stringList) {
    FileWriter fileWriter = null;
    BufferedWriter bufferedWriter = null;
    try {
      fileWriter = new FileWriter("SortedJavaBadgeOutputFile.txt");

      bufferedWriter = new BufferedWriter(fileWriter);
      for (int i = 0; i < stringList.size(); i++) {
        try {
          bufferedWriter.write(stringList.get(i));
        }
        catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    finally {
      try {
        if (bufferedWriter != null) {
          bufferedWriter.close();
        }
        if (fileWriter != null) {
          fileWriter.close();
        }
      }
      catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}